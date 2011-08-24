package com.framework;

public class EntryPoint<THTmlPage extends HtmlPage> {

    private String relativeUrl;

    public EntryPoint(String relativeUrl) {
        this.relativeUrl = relativeUrl;
    }

    public String relativeUrl() {
        return relativeUrl;
    }
}
