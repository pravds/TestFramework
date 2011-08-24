package com.framework;

import java.util.List;

public abstract class HtmlModel {

    protected abstract HtmlElement rootElement();

    public boolean isShown() {
        return rootElement().exists() && rootElement().visible();
    }

    protected HtmlElement Child(String cssSelector) {
        return rootElement().GetElement(cssSelector);
    }

    protected List<HtmlElement> Children(String cssSelector) {
        return rootElement().GetElements(cssSelector);
    }
}
