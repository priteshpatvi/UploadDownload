import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class UploadDownload {

	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/upload-download-test/index.html");
		
		//download
		driver.findElement(By.cssSelector("#downloadButton")).click();
		
		//edit excel
		
		//upload
		
		WebElement upload = driver.findElement(By.cssSelector("input[type='file']"));
		
		upload.sendKeys("C://Users//prite//Downloads//download_Data_Upload_Download.xlsx/");
		
		//Wait for success message to appears and dissappaers
		
		By toastLocator=By.cssSelector(".Toastify__toast-body div:nth-child(2)");
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(toastLocator));
		String ToastText =driver.findElement(toastLocator).getText();
		System.out.println(ToastText);
		Assert.assertEquals("Updated Excel Data Successfully.",ToastText);
		
		wait.until(ExpectedConditions.invisibilityOfElementLocated(toastLocator));
		
		
		
		
	}
	
}
