package example;

import com.framework.HtmlPage;

public class GoogleSearchResultsPage extends HtmlPage{


    public boolean searchResultsVisible() {
        return Child("#rso").visible();
    }
}
