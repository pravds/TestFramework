package example;

import org.junit.Assert;

public class SampleSteps extends BaseContext{

    public void amOnGoogleLandingPage() {
        browser.goTo("");
        GoogleHomePage googleHomePage = on(GoogleHomePage.class);
        Assert.assertTrue(googleHomePage.searchBarVisible());
    }

    public void searchFor(String searchString) {
        on(GoogleHomePage.class).typeSearchKeyword(searchString);
        on(GoogleHomePage.class).submit();
    }

    public void seeSearchResults() {
        Assert.assertTrue(on(GoogleSearchResultsPage.class).searchResultsVisible());
    }
}
