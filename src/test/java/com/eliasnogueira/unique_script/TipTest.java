package com.eliasnogueira.unique_script;

import static org.junit.Assert.*;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.eliasnogueira.po.MainScreenPageObject;
import com.eliasnogueira.po.SettingsScreenPageObject;
import com.eliasnogueira.support.Utils;

import io.appium.java_client.AppiumDriver;

public class TipTest {

	private AppiumDriver<?> driver;
	
	@Before
	public void setUp() throws MalformedURLException {
		driver = Utils.returnDriver(Utils.readProperty("run.platform"));
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Test
	public void testCalculateDefaultTip() {
		MainScreenPageObject mainScreen = new MainScreenPageObject(driver);
		SettingsScreenPageObject settingsScreen = new SettingsScreenPageObject(driver);
		
		//click menu settings
		mainScreen.clickMenuSettings();
		
		//altera a porcentagem
		settingsScreen.clearPercentage();
		settingsScreen.fillTipPercentage("20");
		settingsScreen.clickSettingsButton();
		
		//calcula a porcentagem
		mainScreen.fillBillAmount("100");
		mainScreen.clickCalculateTip();
		
		//checa o resultado
		assertEquals("$20.00", mainScreen.getTipAmount());
		assertEquals("$120.00", mainScreen.getTotalAmount());
		
	}

}
