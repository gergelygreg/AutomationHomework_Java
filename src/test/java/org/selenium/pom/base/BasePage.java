package org.selenium.pom.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.pom.utils.ConfigLoader;
import org.selenium.pom.utils.WaitUtils;

import java.time.Duration;


public class BasePage {
    protected WebDriver driver;
    protected WaitUtils waitUtil;

    public BasePage(WebDriver driver){
        this.driver = driver;
        this.waitUtil = new WaitUtils(new WebDriverWait(driver, Duration.ofMinutes(20)));
    }

    public void load(String endPoint){
      driver.get(ConfigLoader.getInstance().getBaseUrl() + endPoint);
    }


}
