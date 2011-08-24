package com.framework.webdriver;

import com.framework.Browser;
import com.framework.HtmlElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class WebdriverBrowser implements Browser {

    private URL baseUrl;

    private WebDriver driver;

    public WebdriverBrowser(String url) {
        try {
            baseUrl = new URL(url);
            driver = new FirefoxDriver();
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public void goTo(String url) {

        try {
            URL uri;
            uri = new URL(baseUrl, url);
            driver.navigate().to(uri);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public HtmlElement getElement(String selector) {
        return new WebdriverHtmlElement(driver.findElement(By.cssSelector(selector)));
    }

    public void quit() {
        driver.quit();
    }

    public void writeDebugInformationTo(String path) {
        System.out.println(path);
    }

    public void goBack() {
        driver.navigate().back();
    }

    public String getLocation() {
        return driver.getCurrentUrl();
    }

    public boolean isNewWindowOpen() {
        return driver.getWindowHandles().size() > 1;
    }

    public void switchToOtherWindow() {
        String currentWindowHandle = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            if (currentWindowHandle != handle) {
                driver.switchTo().window(handle);
                return;
            }
        }
    }

    public void closeCurrentWindow() {
        if (driver.getWindowHandles().size() > 1) {
            driver.close();
            driver.switchTo().window(driver.getWindowHandles().toArray(new String[]{})[0]);
        }
    }

    protected void finalize() {
        try {
            quit();
        } finally {
        }
    }
}
