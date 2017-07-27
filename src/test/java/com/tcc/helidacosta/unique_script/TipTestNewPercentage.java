package com.tcc.helidacosta.unique_script;

import static org.junit.Assert.*;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.tcc.helidacosta.po.MainScreenPageObject;
import com.tcc.helidacosta.po.SettingsScreenPageObject;
import com.tcc.helidacosta.support.Utils;

import io.appium.java_client.AppiumDriver;

public class TipTestNewPercentage {
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
		
		//click menu settings
		mainScreen.clickMenuSettings();

		// instancia o page object da tela de configurações
		SettingsScreenPageObject settingsScreen = new SettingsScreenPageObject(driver);

		//altera a porcentagem
		settingsScreen.clearPercentage();
		settingsScreen.fillTipPercentage("20");
		settingsScreen.clickSettingsButton();

		// volta a instanciar o page object da tela principal, para que seja possível localizar os componentes
        mainScreen = new MainScreenPageObject(driver);
		//calcula a porcentagem
		mainScreen.fillBillAmount("179.83");
		mainScreen.clickCalculateTip();
		
		//checa o resultado
		assertEquals("$35.97", mainScreen.getTipAmount());
		assertEquals("$215.80", mainScreen.getTotalAmount());
		
	}
}