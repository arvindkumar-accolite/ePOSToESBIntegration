package com.prud.constant;

public class ConfigConstants {
	public static final String GROUP_ID = "group.id";
	public static final String POLICY_PROPSAL_TOPIC = "policy.proposal.topic";
	public static final String NBS_PROPSAL_TOPIC = "newBusiness.proposal.topic";
	public static final String COMPRESSION_TYPE = "compression.type";
	public static final String BOOTSTRAP_SERVER = "bootstrap.servers";
	public static final String ZOOKEEPER_CONNECT = "zookeeper.connect";
	public static final String SNAPPY = "snappy";
	public static final String KEY_DESERIALIZER = "key.deserializer";
	public static final String VALUE_DESERIALIZER = "value.deserializer";
	public static final String KEY_DESERIALIZER_VALUE = "org.apache.kafka.common.serialization.StringDeserializer";
	public static final String VALUE_DESERIALIZER_VALUE = "org.apache.kafka.common.serialization.ByteArrayDeserializer";

	public static final String ENABLE_AUTO_COMMMIT = "enable.auto.commit";
	public static final String FETCH_MESSAGE_BYTES = "fetch.message.max.bytes";
	public static final String AUTO_COMMIT_INTERVAL = "auto.commit.interval.ms";
	public static final String SESSION_TIMEOUT = "session.timeout.ms";
	public static final String NBS_MAPPING_PROPERTIES = "./resources/epos-to-newbusiness-mapping.properties";

}