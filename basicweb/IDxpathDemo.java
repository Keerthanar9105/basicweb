package basicweb;

//import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class IDxpathDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		String baseURL = "https://www.amazon.com/";
		
		
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseURL);
		driver.manage().window().maximize();
		
		//driver.findElement(By.id("user-name")).sendKeys("standard_user");
		//driver.findElement(By.id("password")).sendKeys("secret_sauce");
		//driver.findElement(By.id("login-button")).click();
		
	}

}
