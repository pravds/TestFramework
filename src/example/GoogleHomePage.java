package example;

import com.framework.HtmlElement;
import com.framework.HtmlPage;

public class GoogleHomePage extends HtmlPage{

    public boolean searchBarVisible() {
        return searchBar().visible();
    }

    private HtmlElement searchBar() {
        return Child("#lst-ib");
    }

    public void typeSearchKeyword(String searchString) {
        searchBar().type(searchString);
    }

    public void submit() {
       Child(".lsb").click();
    }
}
