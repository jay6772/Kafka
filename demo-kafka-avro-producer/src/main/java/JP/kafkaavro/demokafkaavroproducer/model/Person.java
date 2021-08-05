package JP.kafkaavro.demokafkaavroproducer.model;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Person {

	private String firstName;
	private String lastName;
	List<Address> address;
}
