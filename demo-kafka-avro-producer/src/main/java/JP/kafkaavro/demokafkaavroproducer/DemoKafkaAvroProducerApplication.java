package JP.kafkaavro.demokafkaavroproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class DemoKafkaAvroProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoKafkaAvroProducerApplication.class, args);
	}

}
