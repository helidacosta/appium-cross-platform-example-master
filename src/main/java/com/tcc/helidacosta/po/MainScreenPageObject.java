package com.tcc.helidacosta.po;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.WithTimeout;
import io.appium.java_client.pagefactory.iOSFindBy;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class MainScreenPageObject {

	@AndroidFindBy(id = "org.traeg.fastip:id/billAmtEditText")
	@iOSFindBy(xpath = "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeTextField[1]")
	@FindBy(id = "billAmount")
    @WithTimeout(time = 10, unit = TimeUnit.SECONDS)
	MobileElement billAmount;
	
	@AndroidFindBy(id = "org.traeg.fastip:id/calcTipButton")
	@iOSFindBy(accessibility = "Calculate Tip")
	@FindBy(id = "calcTip")
	MobileElement calculateTip;
	
	@AndroidFindBy(id = "org.traeg.fastip:id/tipPctTextView")
	MobileElement tipPercentage;
	
	@AndroidFindBy(id = "org.traeg.fastip:id/menu_settings")
	//@iOSFindBy(xpath = "//XCUIElementTypeApplication[@name=\"FasTip\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeButton")
    @iOSFindBy(id = "Settings")
	@FindBy(id = "menuSet")
    @WithTimeout(time = 10, unit = TimeUnit.SECONDS)
	MobileElement menuSettings;
	
	@AndroidFindBy(id = "org.traeg.fastip:id/tipAmtTextView")
	@iOSFindBy(xpath = "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeStaticText[2]")
	@FindBy(id = "tipAmount")
	@WithTimeout(time = 10, unit = TimeUnit.SECONDS)
	MobileElement tipAmount;
	
	@AndroidFindBy(id = "org.traeg.fastip:id/totalAmtTextView")
	@iOSFindBy(xpath = "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeStaticText[4]")
	@FindBy(id = "totalAmount")
	@WithTimeout(time = 10, unit = TimeUnit.SECONDS)
	MobileElement totalAmount;
	
	public MainScreenPageObject(AppiumDriver<?> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void fillBillAmount(String amount) {
		billAmount.sendKeys(amount);
	}
	
	public String getBillamount() {
		return billAmount.getText();
	}
	
	public void clickMenuSettings() {
		menuSettings.click();
	}
			
	public void clickCalculateTip() {
		calculateTip.click();
	}
	
	public String getTipPercentage() {
		return tipPercentage.getText();
	}
	
	public String getTipAmount() {
		return tipAmount.getText();
	}
	
	public String getTotalAmount() {
		return totalAmount.getText();
	}
	
}