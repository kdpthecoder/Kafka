import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import kafka.consumer.Consumer;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.ConsumerIterator;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;

/**
 * 
 * @author cloudera
 * @description This is a very basic example of a Consumer that consumes messages
				from a single broker with no explicit partitioning of messages within the topic
 * @version 1.0
 */

public class KafkaConsumerHL {
	private final ConsumerConnector consumer;
	private final String topic;

	public KafkaConsumerHL(String zookeeper, String groupId, String topic) {
		consumer = Consumer.createJavaConsumerConnector(createConsumerConfig(
				zookeeper, groupId));
		this.topic = topic;
	}

	private static ConsumerConfig createConsumerConfig(String zookeeper,
			String groupId) {
		Properties props = new Properties();
		props.put("zookeeper.connect", zookeeper);
		props.put("group.id", groupId);
		
		props.put("zookeeper.session.timeout.ms", "500");
		props.put("zookeeper.sync.time.ms", "250");
		props.put("auto.commit.interval.ms", "1000");
		return new ConsumerConfig(props);
	}

	public void testConsumer() {
		Map<String, Integer> topicMap = new HashMap<String, Integer>();
		// Define single thread for topic
		topicMap.put(topic, new Integer(1));
		Map<String, List<KafkaStream<byte[], byte[]>>> consumerStreamsMap = consumer.createMessageStreams(topicMap);
		List<KafkaStream<byte[], byte[]>> streamList = consumerStreamsMap.get(topic);

		for (final KafkaStream<byte[], byte[]> stream : streamList) {
			ConsumerIterator<byte[], byte[]> consumerIterator = stream.iterator();
			while (consumerIterator.hasNext())
				System.out.println("Message from Single Topic :: "
						+ new String(consumerIterator.next().message()));
		}
		if (consumer != null)
			consumer.shutdown();
	}

	public static void main(String[] args) {
		String zooKeeper = args[0];
		String groupId = args[1];
		String topic = args[2];
		KafkaConsumerHL simpleHLConsumer = new KafkaConsumerHL(zooKeeper,
				groupId, topic);
		simpleHLConsumer.testConsumer();
	}
}