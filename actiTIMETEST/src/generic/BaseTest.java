package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

public abstract class BaseTest implements IAutoConst {
	protected WebDriver driver;
	static {
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		System.setProperty(GECKO_KEY,GECKO_VALUE);
	}
	@BeforeMethod(alwaysRun=true)
	public void openApp() {
		long ITO=Long.parseLong(AutoUtils.getProperty(CONFIG_PATH, "ITO"));
		String URL=AutoUtils.getProperty(CONFIG_PATH, "URL");

		driver=new ChromeDriver();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);
	}
	@AfterMethod(alwaysRun=true)
	public void closeApp(ITestResult testresult){
		String methodname = testresult.getName();
		int status = testresult.getStatus();
		if(status==2)
			AutoUtils.getPhoto(driver, SCREENSHOTS_PATH+methodname);
		driver.quit();
	}
	
}



