package JP.kafkaavro.demokafkaavroproducer.service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import JP.kafkaavro.demokafkaavroproducer.avro.AddressAvro;
import JP.kafkaavro.demokafkaavroproducer.avro.PersonAvro;
import JP.kafkaavro.demokafkaavroproducer.model.Address;
import JP.kafkaavro.demokafkaavroproducer.model.Person;
import JP.kafkaavro.demokafkaavroproducer.model.PersonData;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaProducerService {

	  @Autowired
	  private Gson gson;
	  
	public void sendMessageToKafkaTopic(PersonData personData) {
		
		List<Person> requestBody = personData.getPersonData();
		requestBody.forEach(request -> {
			Person personMapping = Person.builder().firstName(request.getFirstName()).lastName(request.getLastName()).build();
			List<Address> addressBody = request.getAddress();
			addressBody.forEach(address ->{
				Address addressMapping = Address.builder().city(address.getCity()).street(address.getStreet()).streetNumber(address.getStreetNumber()).zip(address.getZip()).build();
				publishToKafka(personMapping,addressMapping);
			});
			
		});
		
		
	}

	@SuppressWarnings("resource")
	private void publishToKafka(Person personMapping, Address addressMapping) {
		
		
	    Properties props = new Properties();
	    props.put("bootstrap.servers", "localhost:9092");
	    props.put("key.serializer", "io.confluent.kafka.serializers.KafkaAvroSerializer");
	    props.put("value.serializer", "io.confluent.kafka.serializers.KafkaAvroSerializer");
	    props.put("schema.registry.url", "http://localhost:8081");
	    
	    //Mapping to avro for serialization
	    PersonAvro key = PersonAvro.newBuilder()
	    					.setFirstName(personMapping.getFirstName())
	    					.setLastName(personMapping.getLastName()).build();
	    AddressAvro value = AddressAvro.newBuilder()
	    					.setCity(addressMapping.getCity())
	    					.setStreet(addressMapping.getStreet())
	    					.setStreetNumber(addressMapping.getStreetNumber())
	    					.setZip(addressMapping.getZip()).build();
	    
		Producer<PersonAvro, AddressAvro> producer = new KafkaProducer<>(props);
		ProducerRecord<PersonAvro, AddressAvro> producerRecord = new ProducerRecord<>("user-tracking", key, value);
        log.info("Producing to Kafka the record: " + key + ":" + value);
        try {
        	producer.send(producerRecord, (metadata, exception) -> {
                if (exception == null) {
                    log.info(
                        "Message sent to topic ->"
                            + metadata.topic()
                            + " ,parition-> "
                            + metadata.partition()
                            + " stored at offset->"
                            + metadata.offset());
                  } else {
                	  log.error(
                        "Exception while sending message to kafka topic: " + exception.getMessage());
                  }
                });
        }catch(Exception e) {
        	log.error("Exception during posting message to kafka");
        }
		
	}

	public void consumeMessageFromTopic() {
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("group.id", "user-tracking");
        props.put("key.deserializer", "io.confluent.kafka.serializers.KafkaAvroDeserializer");
        props.put("value.deserializer", "io.confluent.kafka.serializers.KafkaAvroDeserializer");
        props.put("specific.avro.reader", "true");
        props.put("schema.registry.url", "http://localhost:8081");
        
        KafkaConsumer<PersonAvro, AddressAvro> consumer = new KafkaConsumer<>(props);

        // Create a topic subscription list:
        ArrayList<String> topics = new ArrayList<String>();
        topics.add("user-tracking");
        // topics.add("myNewTopic");
        consumer.subscribe(topics);
        
        //consumer.subscribe(asList("user-tracking"));
        
        while (true) {
            ConsumerRecords<PersonAvro, AddressAvro> records = consumer.poll(Duration.ofMillis(100));
            
           
            for (ConsumerRecord<PersonAvro, AddressAvro> record : records) {
               
            	log.info("Inside consumer record for loop with key {} value {}",record.key(),record.value());
            }
        }
    }
	}

