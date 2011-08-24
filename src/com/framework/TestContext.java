package com.framework;

public interface TestContext {

    void reset();

    void onScenarioFailed(ScenarioFailure context);

    String getUrl();
}
