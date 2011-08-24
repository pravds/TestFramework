package com.framework;


public interface Browser {

    void quit();

    void writeDebugInformationTo(String path);

    void goTo(String url);

    void goBack();

    String getLocation();

    void switchToOtherWindow();

    void closeCurrentWindow();

    boolean isNewWindowOpen();

    HtmlElement getElement(String cssSelector);
}
