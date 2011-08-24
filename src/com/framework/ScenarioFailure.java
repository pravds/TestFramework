package com.framework;

public class ScenarioFailure {

    public ScenarioFailure(String description, int attempt, Exception exception) {
        this.description = description;
        this.exception = exception;
        this.attempt = attempt;
        retry = false;
    }

    private String description;
    private Exception exception;
    private int attempt;
    private boolean retry;

    public String getDescription() {
        return description;
    }

    public Exception getException() {
        return exception;
    }

    public int getAttempt() {
        return attempt;
    }

    public boolean isRetry() {
        return retry;
    }
}
