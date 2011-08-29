package google.example;

import com.framework.WebTestContext;

public class BaseGoogleTestContext extends WebTestContext{

   @Override
   public String baseUrl() {
        return "http://www.google.co.in/";
    }

    public GoogleHomePage goToHomePage(){
        return launch(new GoogleEntryPoint(""));
    }
}
