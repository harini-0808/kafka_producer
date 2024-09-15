package kafka_producer.utils;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.log4j.PropertyConfigurator;


public class TestProducer {
	public static void main(String[] args) {
		
		String log4jConfPath = "log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);
		
		Properties props = new Properties();
		props.put("bootstrap.servers", "localhost:9092");
		props.put("key.serializer", "org.apache.kafka.common.serialization.IntegerSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		Producer<Integer,String> producer = new KafkaProducer<>(props);
		
		for(int i=0;i<20;i++) {
			ProducerRecord<Integer,String> record = new ProducerRecord<>("UST-TRIV",i,"Message "+Integer.toString(i));
			producer.send(record);
		}
		producer.close();
	}
}
