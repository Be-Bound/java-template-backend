package com.bebound.template.response;

import com.google.gson.annotations.SerializedName;

public class Failure implements Response {

    @SerializedName("error")
    private String errorStatus;

    private Failure(String errorStatus) {
        this.errorStatus = errorStatus;
    }

    public String getErrorStatus() {
        return errorStatus;
    }

    public void setErrorStatus(String errorStatus) {
        this.errorStatus = errorStatus;
    }

    public static class Builder {
        private String errorStatus = "";

        public Builder withErrorStatus(String errorStatus) {
            this.errorStatus = errorStatus;
            return this;
        }

        public Failure build() {
            return new Failure(errorStatus);
        }
    }
}

