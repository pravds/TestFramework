package com.framework;

import com.framework.webdriver.WebdriverBrowser;

public class BrowserFactory {

    private static Browser webDriverBrowser;

    public static Browser ForWebDriver(String portalUrl) {
        if (webDriverBrowser instanceof WebdriverBrowser) {
            return webDriverBrowser;
        }
        if (webDriverBrowser != null) {
            webDriverBrowser.quit();
        }

        webDriverBrowser = new WebdriverBrowser(portalUrl);
        return webDriverBrowser;
    }
}
