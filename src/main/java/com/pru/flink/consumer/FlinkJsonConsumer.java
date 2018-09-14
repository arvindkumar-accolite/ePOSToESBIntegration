package com.pru.flink.consumer;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.common.serialization.DeserializationSchema;
import org.apache.flink.api.common.serialization.SerializationSchema;
import org.apache.flink.api.common.typeinfo.TypeInformation;
import org.apache.flink.api.java.typeutils.TypeExtractor;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer010;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaProducer011;
import org.apache.flink.util.Collector;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pru.constant.ConfigConstants;
import com.pru.model.middleware.NewBusinessModel;
import com.pru.service.ESBService;
import com.pru.service.impl.ESBServiceImpl;

/**
 * Class to read records from Kafka consumer and put those records into a file.
 *
 */
public class FlinkJsonConsumer {

	private static Properties propConfig;
	private String BOOTSTRAP_SERVER_VALUE = propConfig.getProperty(ConfigConstants.BOOTSTRAP_SERVER);
	private String ZOOKEEPER_CONNECT_VALUE = propConfig.getProperty(ConfigConstants.ZOOKEEPER_CONNECT);
	private String GROUP_ID_VALUE = propConfig.getProperty(ConfigConstants.GROUP_ID);
	private String POLICY_PROPSAL_TOPIC_VALUE = propConfig.getProperty(ConfigConstants.POLICY_PROPSAL_TOPIC);
	private String NBS_PROPSAL_TOPIC_VALUE = propConfig.getProperty(ConfigConstants.NBS_PROPSAL_TOPIC);

	static {
		propConfig = new Properties();
		InputStream input = null;
		try {

			input = new FileInputStream("./resources/config.properties");
			propConfig.load(input);
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try {
			System.out.println("in kafka reader main");
			FlinkJsonConsumer flinkJsonConsumer = new FlinkJsonConsumer();
			flinkJsonConsumer.kafkaReader();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void kafkaReader() throws Exception {
		System.out.println("insider reader");
		StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
		env.setParallelism(1);
		FlinkKafkaConsumer010<String> flinkKafkaConsumer = getFlinkKafkaConsumer010();
		DataStream<String> messageStream = env.addSource(flinkKafkaConsumer);
		FlinkKafkaProducer011<String> myProducer = new FlinkKafkaProducer011<String>(BOOTSTRAP_SERVER_VALUE,
				NBS_PROPSAL_TOPIC_VALUE, new SimpleStringSchema());
		messageStream.flatMap(new FlatMapFunction<String, NewBusinessModel>() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void flatMap(String value, Collector<NewBusinessModel> out) throws Exception {
				ESBService esbService = new ESBServiceImpl();
				out.collect(esbService.generateNBSModel(value));
			}
		}).flatMap(new FlatMapFunction<NewBusinessModel, String>() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void flatMap(NewBusinessModel value, Collector<String> out) throws Exception {

				ObjectMapper mapper = new ObjectMapper();
				out.collect(mapper.writeValueAsString(value));
				System.out.println(mapper.writeValueAsString(value));
			}
		}).addSink(myProducer);

		env.execute();

	}

	private FlinkKafkaConsumer010<String> getFlinkKafkaConsumer010() {
		Properties prop = new Properties();
		prop.setProperty(ConfigConstants.BOOTSTRAP_SERVER, BOOTSTRAP_SERVER_VALUE);
		prop.setProperty(ConfigConstants.ZOOKEEPER_CONNECT, ZOOKEEPER_CONNECT_VALUE);
		prop.setProperty(ConfigConstants.GROUP_ID, GROUP_ID_VALUE);
		FlinkKafkaConsumer010<String> flinkKafkaConsumer = new FlinkKafkaConsumer010<>(POLICY_PROPSAL_TOPIC_VALUE,
				new SimpleStringSchema(), prop);

		return flinkKafkaConsumer;

	}

	public static class SimpleStringSchema implements DeserializationSchema<String>, SerializationSchema<String> {
		private static final long serialVersionUID = 1L;

		public SimpleStringSchema() {
		}

		public String deserialize(byte[] message) {
			return new String(message);
		}

		public boolean isEndOfStream(String nextElement) {
			return false;
		}

		public byte[] serialize(String element) {
			return element.getBytes();
		}

		public TypeInformation<String> getProducedType() {
			return TypeExtractor.getForClass(String.class);
		}

	}
}
