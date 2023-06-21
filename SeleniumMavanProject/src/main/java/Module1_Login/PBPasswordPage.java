package Module1_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PBPasswordPage {
	@FindBy(xpath="//input[@name='password']")private WebElement pwd;
	@FindBy(xpath="//span[text()='Sign in']")private WebElement signIn;
	public PBPasswordPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void enterPBPasswordPagePwd(String password)
	{
		pwd.sendKeys(password);
	}
	public void clickPBPasswordPageSignIn()
	{
		signIn.click();
	}

}
