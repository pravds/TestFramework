package com.framework;

public class HtmlFragment extends HtmlModel {

    private HtmlElement rootElement;

    protected HtmlFragment(HtmlElement element) {
        rootElement = element;
    }

    protected HtmlElement rootElement() {
        return rootElement;
    }

    public boolean isVisible() {
        return rootElement.visible();

    }
}
