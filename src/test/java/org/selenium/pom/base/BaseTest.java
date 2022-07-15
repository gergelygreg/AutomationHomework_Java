package org.selenium.pom.base;

import org.openqa.selenium.WebDriver;
import org.selenium.pom.constants.DriverType;
import org.selenium.pom.factory.DriverManagerAbstract;
import org.selenium.pom.factory.DriverManagerFactoryAbstract;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


import java.io.IOException;

public class BaseTest {
    private final ThreadLocal<DriverManagerAbstract> driverManager = new ThreadLocal<>();
    private final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    private void setDriverManager(DriverManagerAbstract driverManager){
        this.driverManager.set(driverManager);
    }

    protected DriverManagerAbstract getDriverManager(){
        return this.driverManager.get();
    }
    private void setDriver(WebDriver driver){
        this.driver.set(driver);
    }

    protected WebDriver getDriver(){
        return this.driver.get();
    }

    @Parameters("browser")
    @BeforeMethod
    public synchronized void startDriver(@Optional String browser){
        browser = System.getProperty("browser", browser);
        if(browser == null) browser = "CHROME";
       // setDriver(new DriverManagerOriginal().initializeDriver(browser));
       // setDriver(DriverManagerFactory.getManager(DriverType.valueOf(browser)).createDriver());
        setDriverManager(DriverManagerFactoryAbstract.
                getManager(DriverType.valueOf(browser)));
        setDriver(getDriverManager().getDriver());
        System.out.println("CURRENT THREAD: " + Thread.currentThread().getId() + ", " +
                "DRIVER = " + getDriver());
    }

    @Parameters("browser")
    @AfterMethod
    public synchronized void quitDriver(@Optional String browser, ITestResult result) throws InterruptedException {
        Thread.sleep(300);
        System.out.println("CURRENT THREAD: " + Thread.currentThread().getId() + ", " +
                "DRIVER = " + getDriver());
        getDriver().quit();
        getDriverManager().getDriver().quit();
    }


}
