package com.lewis.security.brower.support;

/**
 * Created by Administrator on 2017/9/19.
 */
public class SimpleResponse {

    private Object content;

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public SimpleResponse(Object content) {

        this.content = content;
    }
}
