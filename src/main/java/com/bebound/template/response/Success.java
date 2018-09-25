package com.bebound.template.response;

import java.util.HashMap;
import java.util.Map;

public class Success implements Response {

    public static class MapSuccess extends Success {
        private Map<String, Object> params;

        private MapSuccess(Map<String, Object> params) {
            this.params = params;
        }

        public Map<String, Object> getParams() {
            return params;
        }

        public void setParams(Map<String, Object> params) {
            this.params = params;
        }
    }

    public static class Builder {

        private Map<String, Object> params = new HashMap<>();

        public Builder withParameter(String name, Object value) {
            this.params.put(name, value);
            return this;
        }
        public Success build() {
            return new MapSuccess(params);
        }
    }
}
