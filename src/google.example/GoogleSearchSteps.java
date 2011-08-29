package google.example;

import org.junit.Assert;

public class GoogleSearchSteps extends BaseGoogleTestContext {

    public void amOnGoogleLandingPage() {
        GoogleHomePage googleHomePage = goToHomePage();
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
