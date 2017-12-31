package com.hackx.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by 曹磊(Hackx) on 30/12/2017.
 * Email: caolei@mobike.com
 */
@Data
public class RequestMessageEntity implements Serializable {

    private static final long serialVersionUID = -302085634789608764L;

    private String requestMessage;

}
