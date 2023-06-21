package Module1_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PBHomePage {
	@FindBy(xpath="//div[text()='My Account']")private WebElement myAcc;
	WebDriver driver;
	public PBHomePage(WebDriver driver1)
	{
		PageFactory.initElements(driver, this);
		driver=driver1;
	}
	public void openDDOptionPBHomePagemyAcc()
	{
		Actions act=new Actions(driver);
		act.moveToElement(myAcc).perform();
	}

}
