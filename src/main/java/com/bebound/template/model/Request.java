package com.bebound.template.model;

import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Map;

public abstract class Request {

    @SerializedName("transport")
    private String transport;

    @SerializedName("moduleId")
    private long appId;

    @SerializedName("moduleName")
    private String appName;

    @SerializedName("moduleVersion")
    private long appVersion;

    @SerializedName("operation")
    private String operationName;

    private Request() {
    }

    public abstract Map<String, Object> getParameters();

    public abstract void setParameters(Map<String, Object> parameters);

    public abstract <T> T getBodyAs(Class<T> type);

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    public long getAppId() {
        return appId;
    }

    public void setAppId(long appId) {
        this.appId = appId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public long getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(long appVersion) {
        this.appVersion = appVersion;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }

    public boolean isSmsRequest() {
        return transport.equalsIgnoreCase("sms");
    }

    public boolean isWebRequest() {
        return transport.equalsIgnoreCase("web");
    }

    public static class MapRequest extends Request {
        @SerializedName("params")
        private Map<String, Object> parameters;

        @Expose(serialize = false, deserialize = false)
        private String jsonParams;

        public Map<String, Object> getParameters() {
            return parameters;
        }

        public void setParameters(Map<String, Object> parameters) {
            this.parameters = parameters;
        }

        @Override
        public <T> T getBodyAs(Class<T> type) {
            return new GsonBuilder().create().fromJson(jsonParams, type);
        }

        public String getJsonParams() {
            return jsonParams;
        }

        public void setJsonParams(String json) {
            this.jsonParams = json;
        }
    }
}
