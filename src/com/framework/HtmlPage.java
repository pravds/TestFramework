package com.framework;

public class HtmlPage extends HtmlModel {

    private Browser browser;

    public HtmlPage OnBrowser(Browser browser) {
        this.browser = browser;
        return this;
    }

    protected HtmlElement rootElement() {
        return browser.getElement("html");
    }

    public String PageTitle() {
        return Child("title").text();
    }

    public void Reload() {
        browser.goTo(browser.getLocation());
    }
}
