package com.backend.template.exception;

import com.backend.template.model.response.ResponseStatus;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Format of response returned to client
 *
 * @author xuatdd
 * @version 1.0
 * @since 2020/04/01
 */
public class ResponseMessage {

    @JsonProperty("status")
    private ResponseStatus status;

    @JsonProperty("data")
    private Object data;

    @Override
    public String toString() {
        return "{" + "status=" + status + ", data=" + data + '}';
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}