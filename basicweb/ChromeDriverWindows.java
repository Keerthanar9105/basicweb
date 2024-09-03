package basicweb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class ChromeDriverWindows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// version below 4.6.0 - this line is not required to be written every time driver path can be set in
		// the environment variable to ignore this. for v 4.6.0 and above its not required at all because of the selenium manager jar readily available
		//System.setProperty("webdriver.chrome.driver",
				//"C:\\Users\\97450\\eclipse-workspace\\Drivers\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String baseURL = "https://www.google.com";
		driver.get(baseURL);
	}

}
