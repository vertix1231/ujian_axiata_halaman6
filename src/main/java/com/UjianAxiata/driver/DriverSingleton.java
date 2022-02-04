package com.UjianAxiata.driver;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;



public class DriverSingleton {
	public static DriverSingleton instance = null;
	private static WebDriver driver;

	public DriverSingleton(String driver) {
		intantiate(driver);
	}

	public WebDriver intantiate(String strategy) {
		DriverStrategy driverStrategy = DriverStrategyImplementor.chooseStrategy(strategy);
		driver = driverStrategy.setStrategy();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

	public static DriverSingleton getInstance(String driver) {
		if (instance == null) {
			instance = new DriverSingleton(driver);
		}
		return instance;
	}

	public static void closeObjectInstance() {
		instance = null;
		driver.quit();
	}

	public static WebDriver getDriver() {
		return driver;
	}
}
