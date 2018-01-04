package com.hackx.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by 曹磊(Hackx) on 30/12/2017.
 * Email: caolei@mobike.com
 */
public class RequestMessageEntity implements Serializable {

    private static final long serialVersionUID = -302085634789608764L;

    private String requestMessage;

    public RequestMessageEntity() {
    }

    public RequestMessageEntity(String requestMessage) {
        this.requestMessage = requestMessage;
    }

    public String getRequestMessage() {
        return requestMessage;
    }

    public void setRequestMessage(String requestMessage) {
        this.requestMessage = requestMessage;
    }
}
