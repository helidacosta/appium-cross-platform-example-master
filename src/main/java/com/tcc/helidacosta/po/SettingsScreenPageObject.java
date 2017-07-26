package com.tcc.helidacosta.po;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SettingsScreenPageObject {

	@AndroidFindBy(id = "org.traeg.fastip:id/tipPercentageEditText")
	//@iOSFindBy(xpath = "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeButton[1]")
	@FindBy(id = "fillPerc")
	MobileElement fillPercentage;
	
	@AndroidFindBy(id = "org.traeg.fastip:id/saveSettingsButton")
	//@iOSFindBy(xpath = "//XCUIElementTypeApplication[1]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther[1]/XCUIElementTypeButton[1]")
	@FindBy(id = "setButton")
	MobileElement settingsButton;
	
	public SettingsScreenPageObject(AppiumDriver<?> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void clickSettingsButton() {
		settingsButton.click();
	}
	public void fillTipPercentage(String percentage) {
		fillPercentage.sendKeys(percentage);
	}
	
	public String getfillPercentage() {
		return fillPercentage.getText();
	}	
	
	public void clearPercentage() {
		fillPercentage.clear();
	}
}
