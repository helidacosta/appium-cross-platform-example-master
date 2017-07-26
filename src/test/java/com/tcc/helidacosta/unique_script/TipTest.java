package com.tcc.helidacosta.unique_script;

import static org.junit.Assert.*;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.tcc.helidacosta.po.MainScreenPageObject;
import com.tcc.helidacosta.support.Utils;

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
				
		//calcula a porcentagem
		mainScreen.fillBillAmount("158.20");
		mainScreen.clickCalculateTip();
		
		//checa o resultado
		assertEquals("$23.73", mainScreen.getTipAmount());
		assertEquals("$181.93", mainScreen.getTotalAmount());
		
	}

}
