package com.framework.webdriver;

import com.framework.HtmlElement;
import com.framework.NonExistentElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

public class WebdriverHtmlElement implements HtmlElement {

    private WebElement element;

    public WebdriverHtmlElement(WebElement element) {
        this.element = element;
    }

    private WebElement RenderedRootElement() {
        return element;
    }

    public boolean visible() {
        return RenderedRootElement() != null && RenderedRootElement().isDisplayed();
    }

    public String text() {
        return element.getText();
    }

    public String value() {
        return element.getText();
    }

    public boolean exists() {
        return true;
    }

    public String source() {
        throw new NotImplementedException();
    }

    public String href() {
        return element.getAttribute("href");
    }

    public String title() {
        return element.getAttribute("title");
    }

    public boolean checked() {
        return element.getAttribute("title") != null;
    }

    public void click() {
        element.click();
    }

    public void clear() {
        element.clear();
    }

    public void type(String text) {
        element.sendKeys(text);
    }

    public void select() {
        element.click();
    }

    public void mouseOver() {
        throw new NotImplementedException();
    }

    public HtmlElement GetElement(String cssSelector) {
        List<HtmlElement> elements = GetElements(cssSelector);
        return elements.size() == 0 ? new NonExistentElement(cssSelector) : elements.get(0);
    }

    public List<HtmlElement> GetElements(String cssSelector) {
        List<WebElement> elements = element.findElements(By.cssSelector(cssSelector));
        List<HtmlElement> webdriverElements = new ArrayList<HtmlElement>();
        for (WebElement element : elements) {
            webdriverElements.add(new WebdriverHtmlElement(element));
        }
        return webdriverElements;
    }
}
