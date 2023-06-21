package LibraryFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;


public class Utility_Class {
	//@Pooja 
	//This method is used to get testdata from excel
	//needs to pass 2 inputs 1-rowIndex,2-colIndex
	
	public static String getTestData(int rowIndex,int colIndex) throws EncryptedDocumentException, IOException
	{
		FileInputStream file =new FileInputStream("C:\\pooja\\VelocitySoftwareTesting\\eclipseworkspace\\SeleniumMavanProject\\TestData\\POMWithDDfTestNG.xlsx");
		Sheet sh=WorkbookFactory.create(file).getSheet("DDF");
		String value = sh.getRow(rowIndex).getCell(colIndex).getStringCellValue();
		
		return value;
	}
	public static void captureScreenshot(WebDriver driver,int TCid) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\pooja\\VelocitySoftwareTesting\\eclipseworkspace\\SeleniumMavanProject\\FailedTcScreenshot\\TestCaseID"+TCid+".jpg");
		FileHandler.copy(src,dest);
	}
	public static String getPFData(String key) throws IOException {
		FileInputStream file=new FileInputStream("C:\\pooja\\VelocitySoftwareTesting\\eclipseworkspace\\SeleniumMavanProject\\PropertyFile.pro perties");
		Properties p=new Properties();
		p.load(file);
		String value=p.getProperty(key);
		return value;
	}

}
