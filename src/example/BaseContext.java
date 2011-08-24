package example;

import com.framework.WebTestContext;

public class BaseContext extends WebTestContext{
    public String getUrl() {
        return "http://www.google.co.in/";
    }
}
