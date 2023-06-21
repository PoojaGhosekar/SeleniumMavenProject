package Module1_LoginTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import LibraryFiles.Base_Class;
import LibraryFiles.Utility_Class;
import Module1_Login.PBHomePage;
import Module1_Login.PBLoginPage;
import Module1_Login.PBMobNoPage;
import Module1_Login.PBMyAccPage;
import Module1_Login.PBPasswordPage;
import Module1_Login.PBProfilePage;


public class PBLoginTest extends Base_Class {
	WebDriver driver;
	Sheet sh;
	PBLoginPage pbLogin;
	PBMobNoPage pbMobno;
	PBPasswordPage pbPwd;
	PBHomePage pbHome;
	PBMyAccPage pbMyAcc;
	PBProfilePage pbProfile;
	int TCID;
	@BeforeClass
	public void openBrowser() throws EncryptedDocumentException, IOException
	{
		
		
		initializeBrowser();
		pbLogin=new PBLoginPage(driver);
		pbMobno=new PBMobNoPage(driver);
		pbPwd=new PBPasswordPage(driver);
		pbHome=new PBHomePage(driver);
		pbMyAcc=new PBMyAccPage(driver);
		pbProfile=new PBProfilePage(driver);
	}
	@BeforeMethod
	public void loginToApp() throws InterruptedException, EncryptedDocumentException, IOException
	{
		pbLogin.clickPBLoginPageSignIn();
		Thread.sleep(1000);
		pbMobno.enterPBMobNoPagemobNo(Utility_Class.getPFData("MObNo"));
		Thread.sleep(1000);
		pbMobno.clickPBMobNoPAgeSignInWithPwd();
		Thread.sleep(1000);
		pbPwd.enterPBPasswordPagePwd(Utility_Class.getPFData("PWD"));
		Thread.sleep(1000);
		pbPwd.clickPBPasswordPageSignIn();
		Thread.sleep(1000);
		
	}
	@Test
	public void verifyFullName() throws InterruptedException, EncryptedDocumentException, IOException
	{
		TCID=101;
		pbHome.openDDOptionPBHomePagemyAcc();
		Thread.sleep(1000);
		pbMyAcc.clickPBMyAccPageMYProfile();
		Thread.sleep(1000);
		pbProfile.switchToChildWindow();
		Thread.sleep(1000);
		String actTest=pbProfile.getPBProfilePageFullName();
		String expText=Utility_Class.getTestData(0, 2);
		Assert.assertEquals(actTest, expText,"Failed: Both results are different");
		
		
	}
	@AfterMethod
	public void logoutToApp(ITestResult it) throws IOException
	{
		if(it.getStatus()==ITestResult.FAILURE)
		{
			Utility_Class.captureScreenshot(driver, TCID);
		}
	}
	@AfterClass
	public void closeBrowser() throws InterruptedException
	{
		Thread.sleep(1000);
		driver.quit();
	}

}
