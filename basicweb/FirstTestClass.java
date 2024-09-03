package basicweb;

//import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		//driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(1));
		driver.quit();
	}

}
