package basicweb;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.remote.DesiredCapabilities;
import net.sourceforge.tess4j.Tesseract;
//import net.sourceforge.tess4j.TesseractException;

//import javax.imageio.ImageIO;
//import java.awt.image.BufferedImage;
import java.io.File;
//import java.io.IOException;
//import java.net.URL;

public class Dummy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Initialize WebDriver
		WebDriver driver = new ChromeDriver();
		String baseURL = "https://www.amazon.com/";

		try {
			// Navigate to the page containing CAPTCHA
			driver.get(baseURL);
			driver.manage().window().maximize();
			System.out.println(driver.getTitle());

			// Locate the CAPTCHA image element
			WebElement imageelement = driver
					.findElement(By.xpath("//*[@class=\"a-box-inner a-padding-extra-large\"]//following::img"));
			File src = imageelement.getScreenshotAs(OutputType.FILE);

			String path = "C:\\Users\\97450\\eclipse-workspace\\UdemyAutomationLearning\\captchaimages\\captcha.png";

			FileHandler.copy(src, new File(path));

			Thread.sleep(2000);
			Tesseract image = new Tesseract();

			String str = image.doOCR(new File(path));

			System.out.println("image ocr done");
			System.out.println(str);
			
			String Captcha = str.split("below")[1].replaceAll("[^a-zA-Z0-9]", "");
			System.out.println(Captcha);
			
			//driver.findElement(By.id("captchacharacters")).sendKeys(Captcha);
			driver.manage().window().minimize();
		} catch (Exception e) {
			System.out.println("exception caught: " + e.getMessage());
		}
	}

}
