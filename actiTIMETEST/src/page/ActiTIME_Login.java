package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActiTIME_Login {
	@FindBy(id="username")
	private WebElement unTB;
	@FindBy(name="pwd")
	private WebElement pwTB;
	@FindBy(xpath="//div[.='Login ']")
	private WebElement lgBTN;
	@FindBy(xpath="//span[contains(.,'invalid')]")
	private WebElement errmsg;
	
	public ActiTIME_Login(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void setUsername(String name) {
		unTB.sendKeys(name);
	}
	public void setPassword(String name) {
		pwTB.sendKeys(name);
	}
	public void clickLogin() {
		lgBTN.click();
	}
	public String verifyErrmsg(String expectedMsg) {
		String actualMsg=errmsg.getText();
		if(actualMsg.equals(expectedMsg))
			return "pass";
		else 
			return "fail";
	}
	
	
}
