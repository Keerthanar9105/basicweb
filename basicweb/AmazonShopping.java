package basicweb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.remote.DesiredCapabilities;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class AmazonShopping {

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
            WebElement captchaImageElement = driver.findElement(By.xpath("//*[@class=\"a-box-inner a-padding-extra-large\"]//following::img"));
            // Get the CAPTCHA image URL
            String imageUrl = captchaImageElement.getAttribute("src");

            // Download the image
            @SuppressWarnings("deprecation")
			BufferedImage captchaImage = ImageIO.read(new URL(imageUrl));

            // Save the image to a file (optional, for debugging)
            File imageFile = new File("captcha.png");
            ImageIO.write(captchaImage, "png", imageFile);
            System.out.println("check1");

            // Initialize Tesseract OCR
            Tesseract tesseract = new Tesseract();
            tesseract.setDatapath("C:\\Users\\97450\\eclipse-workspace\\UdemyAutomationLearning\\TestData"); // Update path to Tesseract data
            tesseract.setLanguage("eng"); // Set language

            // Read the CAPTCHA text
            String captchaText = tesseract.doOCR(captchaImage);
            System.out.println("CAPTCHA Text: " + captchaText);
            String Captcha = captchaText.split("below")[1].replaceAll("[^a-zA-Z0-9]","");
			System.out.println(Captcha);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TesseractException e) {
            e.printStackTrace();
        } finally {
            // Clean up
            //driver.quit();
        }
    }

		

	}


