package Mubadala.PatientPortalAutomation.FunctionalTestCase;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import Mubadala.PatientPortalAutomation.BaseClass;
import mubadala.PatientPortalAutomation.PageObject.LoginPageObject;
import mubadala.PatientPortalAutomation.Utility.ConfigFile;

public class LoginTC extends BaseClass {
	
	private String patientEmailAddress = ConfigFile.getProperty("app.emailaddress");
	private String otp = ConfigFile.getProperty("app.otp");
	LoginPageObject loginPageObject;
	
	
	@BeforeClass
	public void setUpBrowser() {
		super.setUpBrower(browserType.CHROME);
	}
	
	@Test
	public void patientPortalLoginTC() {
		loginPageObject = LoginPageObject.getInstance(driver);
		loginPageObject.patientPortalLogin(patientEmailAddress, otp);
		Assert.assertTrue(loginPageObject.isPatientNameDisplayed(), "Patient name is not displayed");
	}
	
	@AfterClass
	public void tearDownBrowser() {
		tearDown();
	}
	
}
