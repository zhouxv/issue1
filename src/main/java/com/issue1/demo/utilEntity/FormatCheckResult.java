package com.issue1.demo.utilEntity;

public class FormatCheckResult {
    public boolean error;
    public String errorString;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getErrorString() {
        return errorString;
    }

    public void setErrorString(String errorString) {
        this.errorString = errorString;
    }
}
