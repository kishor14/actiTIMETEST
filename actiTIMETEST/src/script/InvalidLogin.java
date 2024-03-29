package script;


import org.testng.annotations.Test;

import generic.AutoUtils;
import generic.BaseTest;
import page.ActiTIME_Login;

public class InvalidLogin extends BaseTest {
	
	@Test
	public void invalidLogin() {
	ActiTIME_Login login=new ActiTIME_Login(driver);
	int rc=AutoUtils.getRowCount(INPUT_PATH, "InvalidLogin");
	System.out.println(rc);
	for(int i=1;i<=rc;i++) {
		System.out.println(i);
		String username=AutoUtils.getValue(INPUT_PATH, "InvalidLogin", i, 0);
		String password=AutoUtils.getValue(INPUT_PATH, "InvalidLogin", i, 1);
		String expectedMsg=AutoUtils.getValue(INPUT_PATH, "InvalidLogin", i, 2);
		//enter the invalid username's
		login.setUsername(username);
		//enter the invalid password
		login.setPassword(password);
		//click login button
		login.clickLogin();
		//verify the error message
		System.out.println(expectedMsg+username+password);
		System.out.println(i);
		/*String status =login.verifyErrmsg(expectedMsg);
		if(status.equals("fail"))
			Assert.fail();*/
		}
	}	
}
