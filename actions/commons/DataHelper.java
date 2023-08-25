package commons;

import com.github.javafaker.Faker;
import java.util.Locale;

public class DataHelper {
	private Locale locate = new Locale("en");
	private Faker faker = new Faker(locate);
	public static DataHelper getData()
	{
		return new DataHelper();
	}
	public String getFirstName()
	{
		return faker.address().firstName();
	}
	public String getLastname()
	{
		return faker.address().lastName();
	}
	public String getPassword()
	{
		return faker.internet().password(8, 10, true, true);
	}
	public String getEmail()
	{
		return faker.internet().emailAddress();
	}
}
