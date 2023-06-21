package Module1_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PBMobNoPage {
	@FindBy(xpath="(//input[@type='number'])[2]")private WebElement mobNo;
	@FindBy(xpath="(//span[contains(text(),'Sign in with')])[4]")private WebElement signWithPwd;
	
	public PBMobNoPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public void enterPBMobNoPagemobNo(String monNum)
	{
		mobNo.sendKeys(monNum);
	}
	public void clickPBMobNoPAgeSignInWithPwd()
	{
		signWithPwd.click();
	}
}
