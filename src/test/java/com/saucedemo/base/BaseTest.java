package com.saucedemo.base;

import com.saucedemo.driverfactory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;
    @BeforeMethod
    public void Setup() {driver = new DriverFactory().initDriver();}
    @AfterMethod
    public void TearDown() {driver.quit();}
}
