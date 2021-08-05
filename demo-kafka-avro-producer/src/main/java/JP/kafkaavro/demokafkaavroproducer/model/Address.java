package JP.kafkaavro.demokafkaavroproducer.model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Address {
	
	private String zip;
	private String city;
	private String street;
	private String streetNumber;

}
