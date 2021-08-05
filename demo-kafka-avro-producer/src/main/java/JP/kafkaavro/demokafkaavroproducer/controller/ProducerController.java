package JP.kafkaavro.demokafkaavroproducer.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import JP.kafkaavro.demokafkaavroproducer.model.PersonData;
import JP.kafkaavro.demokafkaavroproducer.service.KafkaProducerService;

@RestController
public class ProducerController {
	
	@Autowired
	KafkaProducerService KafkaProducerService;
	
    @PostMapping(value = "/post-kafkatopic")
	public ResponseEntity<?> postMessageToKafka(@Valid @RequestBody PersonData personData,
			BindingResult result) throws Exception {
    
    	KafkaProducerService.sendMessageToKafkaTopic(personData);
    	
		//Iresponse iResponse = itemCacheService.getData(iRequest);
		 return new ResponseEntity<PersonData>(personData, HttpStatus.OK);
    	//return null;
	}

    @GetMapping(value = "/consume-kafkatopic")
    @KafkaListener(topics ="user-tracking")
	public void consumeMessageFromKafka() throws Exception {
    
    	KafkaProducerService.consumeMessageFromTopic();
    	
		//Iresponse iResponse = itemCacheService.getData(iRequest);
		// return new ResponseEntity<String>("Messages started consuming from topic", HttpStatus.OK);
    	//return null;
	}
}
