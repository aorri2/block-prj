package com.flow.flowblock.message;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Message {
    private StatusEnum status;
    private String message;
    private Object data;

    public Message() {
        this.status = StatusEnum.BAD_REQUEST;
        this.message = null;
        this.data = null;
    }

}
