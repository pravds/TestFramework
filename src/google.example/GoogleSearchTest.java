package google.example;

import com.framework.Action;
import org.junit.Test;

public class GoogleSearchTest extends BaseGoogleSearchWebTest<GoogleSearchSteps> {

    @Test
    public void testGoogle(){
        scenario("google testing", new Action() {
            public void execute() {
               given(new Action(){public void execute() {
                    i().amOnGoogleLandingPage();
                }});
               when(new Action() {public void execute() {
                     i().searchFor("webdriver");
                }});
               then(new Action() {public void execute() {
                    i().seeSearchResults();
                }});
            }
        });
    }

}
