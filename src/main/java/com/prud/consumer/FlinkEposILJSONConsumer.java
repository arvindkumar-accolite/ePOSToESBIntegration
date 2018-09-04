package com.prud.consumer;

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
import com.prud.constant.ConfigConstants;
import com.prud.mapper.impl.NewBusinessPopulator;
import com.prud.model.middleware.NewBusinessModel;

/**
 * Class to read records from Kafka consumer and put those records into a file.
 *
 */
public class FlinkEposILJSONConsumer {

	static Properties propConfig;

	public static void initializeProperties() {
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
			initializeProperties();

			System.out.println("in kafka reader main");

			kafkaReader();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void kafkaReader() throws Exception {
		System.out.println("insider reader");
		StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
		env.setParallelism(1);

		Properties prop = new Properties();
		prop.setProperty(ConfigConstants.BOOTSTRAP_SERVER, propConfig.getProperty(ConfigConstants.BOOTSTRAP_SERVER));
		prop.setProperty(ConfigConstants.ZOOKEEPER_CONNECT, propConfig.getProperty(ConfigConstants.ZOOKEEPER_CONNECT));
		prop.setProperty(ConfigConstants.GROUP_ID, propConfig.getProperty(ConfigConstants.GROUP_ID));
		FlinkKafkaConsumer010<String> flinkKafkaConsumer = new FlinkKafkaConsumer010<>(
				propConfig.getProperty(ConfigConstants.POLICY_PROPSAL_TOPIC), new SimpleStringSchema(), prop);

		DataStream<String> messageStream = env.addSource(flinkKafkaConsumer);
		

		FlinkKafkaProducer011<String> myProducer = new FlinkKafkaProducer011<String>(
				propConfig.getProperty(ConfigConstants.BOOTSTRAP_SERVER), // broker list
				propConfig.getProperty(ConfigConstants.NBS_PROPSAL_TOPIC), // target topic
				new SimpleStringSchema());
				
		messageStream.flatMap(new FlatMapFunction<String, NewBusinessModel>() {

			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public void flatMap(String value, Collector<NewBusinessModel> out) throws Exception {
				NewBusinessPopulator nbspop = new NewBusinessPopulator();
				out.collect(nbspop.buildNewBusiness(value));
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
				
			}
		}).addSink(myProducer);

		
		

		env.execute();

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
