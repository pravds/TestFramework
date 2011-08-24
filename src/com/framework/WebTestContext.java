package com.framework;

import java.util.HashMap;
import java.util.Map;

public abstract class WebTestContext implements TestContext {


    private static Map<String, HtmlPage> pagesCache = new HashMap<String, HtmlPage>();

    protected Browser browser;
    protected HtmlPage currentPage;

    public void reset() {
        browser = BrowserFactory.ForWebDriver(getUrl());
    }


    /*protected <T extends HtmlPage> T launch(EntryPoint<T> content) {
        browser.goTo(content.relativeUrl());
        Class<? extends EntryPoint> aClass = content.getClass();
        T on = on(aClass);
        return on;
    }*/

    public void onScenarioFailed(ScenarioFailure failure) {
        print("[Failed]", failure);
    }

    private static void print(String description, ScenarioFailure failure) {
        System.out.println(description);
        System.out.println(failure.getDescription());
    }

    protected <T extends HtmlPage> T on(Class<T> clazz) {
        try {
            String key = clazz.getSimpleName();
            if (!pagesCache.containsKey(key)) {

                HtmlPage page = clazz.newInstance();
                page.setBrowser(browser);
                pagesCache.put(key, page);
            }

            currentPage = pagesCache.get(key);
            return (T) currentPage;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
