package LibraryFiles;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base_Class {
	WebDriver driver;
	public void initializeBrowser() throws IOException
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Utility_Class.getPFData("URL"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

}
