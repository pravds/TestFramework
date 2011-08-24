package com.framework;

import java.util.List;

public interface HtmlElement {

    boolean visible();

    String text();

    String value();

    boolean exists();

    String source();

    String href();

    String title();

    boolean checked();

    void click();

    void clear();

    void type(String text);

    void select();

    void mouseOver();

    HtmlElement GetElement(String cssSelector);

    List<HtmlElement> GetElements(String cssSelector);
}
