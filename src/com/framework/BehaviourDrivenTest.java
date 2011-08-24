package com.framework;

import java.lang.reflect.ParameterizedType;

public abstract class BehaviourDrivenTest<TTestContext extends TestContext> {

    protected TTestContext Context;

    protected BehaviourDrivenTest() {
        try {
            Object o = ((Class) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]).newInstance();
            Context = (TTestContext) o;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected TTestContext getContext() {
        return Context;
    }

    protected void scenario(String description, Action action) {
        try {
            action.execute();
        } catch (Exception ex) {
            ScenarioFailure failure = new ScenarioFailure(description, 1, ex);
            Context.onScenarioFailed(failure);
            throw new RuntimeException(ex);
        }
    }


    public BehaviourDrivenTest<TTestContext> given(Action action) {
        return execute(action);
    }

    public BehaviourDrivenTest<TTestContext> when(Action action) {
        return execute(action);
    }

    public BehaviourDrivenTest<TTestContext> then(Action action) {
        return execute(action);
    }

    public BehaviourDrivenTest<TTestContext> and(Action action) {
        return execute(action);
    }

    private BehaviourDrivenTest<TTestContext> execute(Action action) {
        action.execute();
        return this;
    }

    public abstract void baseSetUp();

    public abstract void baseTearDown();
}
