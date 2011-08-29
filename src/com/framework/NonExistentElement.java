package com.framework;

import java.util.List;

public class NonExistentElement implements HtmlElement {
    private String cssSelector;

    public NonExistentElement(String cssSelector) {
        this.cssSelector = cssSelector;
    }

    public boolean visible() {
        return false;
    }

    public String text() {
        return ElementDoesNotException();
    }

    private String ElementDoesNotException() throws RuntimeException {
        throw new RuntimeException(String.format("The element '%s' does not exists.", cssSelector));
    }

    public String value() {
        return ElementDoesNotException();
    }

    public boolean exists() {
        return false;
    }

    public String source() {
        return ElementDoesNotException();
    }

    public String href() {
        return ElementDoesNotException();
    }

    public String title() {
        return ElementDoesNotException();
    }

    public boolean checked() {
        ElementDoesNotException();
        return false;
    }

    public void click() {
        ElementDoesNotException();
    }

    public void clear() {
        ElementDoesNotException();
    }

    public void type(String text) {
        ElementDoesNotException();
    }

    public void select() {
        ElementDoesNotException();
    }

    public void mouseOver() {
        ElementDoesNotException();
    }

    public HtmlElement GetElement(String cssSelector) {
        ElementDoesNotException();
        return null;
    }

    public List<HtmlElement> GetElements(String cssSelector) {
        ElementDoesNotException();
        return null;
    }
}
