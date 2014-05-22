
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.ws.client.core.WebServiceTemplate;
import person.GetPersonRequest;
import person.GetPersonResponse;

public class PersonClient {

	public static void main(String[] strings) {


		ApplicationContext context = new FileSystemXmlApplicationContext("/src/resources/applicationContext.xml");
		WebServiceTemplate webServiceTemplate = (WebServiceTemplate) context.getBean("webServiceTemplate");

		GetPersonRequest request = new GetPersonRequest();
		GetPersonResponse response = new GetPersonResponse();


	}
}
