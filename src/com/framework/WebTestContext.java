package com.framework;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.Map;

public abstract class WebTestContext {


    private static Map<String, HtmlPage> pagesCache = new HashMap<String, HtmlPage>();

    protected Browser browser;
    protected HtmlPage currentPage;
    protected abstract String baseUrl();

    public void reset() {
        browser = BrowserFactory.ForWebDriver(baseUrl());
    }


    protected <T extends HtmlPage> T launch(EntryPoint<T> content) {
        try {
            browser.goTo(content.relativeUrl());
            Class aClass = (Class) ((ParameterizedType) content.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
            return (T) on(aClass);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

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
