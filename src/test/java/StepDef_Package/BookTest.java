package StepDef_Package;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
//import static org.hamcrest.Matchers.equalTo;
import java.util.Arrays;
import org.apache.http.HttpStatus;
import org.junit.Test;

public class BookTest {
	
	private static String ENDPOINT_GET_BOOK_BY_ISBN = "https://demo.api-platform.com/books";
	
	
	@Test
	public void testGetByISBN() {
	     String isbn = "isbn:9789208931293";
	     
		given().
		param("q", isbn).
		when().
		get(ENDPOINT_GET_BOOK_BY_ISBN).
		then().
		statusCode(HttpStatus.SC_OK).
		body(  "@context", equalTo("/contexts/Book"),
			   "@id" ,equalTo("/books/34"),
			   "title", containsInAnyOrder((Object)Arrays.asList("Nesciunt voluptas et aut.")),
			   "description", containsInAnyOrder("Velit voluptas molestiae eum et eos fugiat voluptas voluptatem. Nostrum culpa in quod voluptatem. Dignissimos sunt atque aut. Possimus accusamus sint hic ut atque expedita."),
			   "author", containsInAnyOrder("Easter Tillman"));
	}
	
	
	

}
