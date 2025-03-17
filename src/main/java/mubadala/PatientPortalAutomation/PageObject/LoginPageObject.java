package mubadala.PatientPortalAutomation.PageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageObject {

	WebDriver driver;
	private static LoginPageObject instance;

	public LoginPageObject(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='Email']")
	WebElement emailaddressField;

	@FindBy(xpath = "//button[@id='login-LoginButton']")
	WebElement sendOTPbutton;

	@FindBy(xpath = "//input[@id='codeBox1']")
	WebElement otp1field;

	@FindBy(xpath = "//input[@id='codeBox2']")
	WebElement otp2field;

	@FindBy(xpath = "//input[@id='codeBox3']")
	WebElement otp3field;

	@FindBy(xpath = "//input[@id='codeBox4']")
	WebElement otp4field;

	@FindBy(xpath = "//button[@id='codeBox5']")
	WebElement loginField;

	/*
	 * Assert
	 */

	@FindBy(xpath = "//h4[@title='Ashu Shaik']")
	WebElement patientName;
	
	public static LoginPageObject getInstance(WebDriver driver) {
        if (instance == null) {
            instance = new LoginPageObject(driver);
        }
        return instance;
    }

	 public void patientPortalLogin(String email, String otp) {
	        emailaddressField.sendKeys(email);
	        sendOTPbutton.click();

	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.elementToBeClickable(otp1field));
	        
	        otp1field.sendKeys(otp);
	        otp2field.sendKeys(otp);
	        otp3field.sendKeys(otp);
	        otp4field.sendKeys(otp);
	       
	        loginField.click();
	    }

	    // Method to verify if patient name is displayed
	    public boolean isPatientNameDisplayed() {
	        return patientName.isDisplayed();
	    }

}
