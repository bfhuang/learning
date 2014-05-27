import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import person.Person;

public class restfulClient {

	public static void main(String[] args){
		RestTemplate template = new RestTemplate();

		String url = "http://localhost:16313/restfulExample/person.html";

		HttpHeaders headers = new HttpHeaders();
		headers.add("accept", "application/json");
		HttpEntity httpEntity = new HttpEntity("", headers);
		ResponseEntity<Person> exchange = template.exchange(url, HttpMethod.GET, httpEntity, Person.class);
		Person person = exchange.getBody();
//
//		System.out.println(people.size());
//		Person person = (Person) people.get(0);
//		System.out.println(person.getFirstName());

//		Person person1 = template.getForObject(url, Person.class);
		System.out.println(person.getFirstName());


	}
}
