package com.sd.client.view.validators;

public class ValidationResponse {
    String title;
    String header;
    String content;
    boolean error;

    public ValidationResponse(String title, String header, String content) {
        this.title = title;
        this.header = header;
        this.content = content;
        this.error = true;
    }
    public ValidationResponse() {
        this.title = null;
        this.header = null;
        this.content = null;
        this.error = false;
    }
    public ValidationResponse(String content) {
        this.title = null;
        this.header = null;
        this.content = content;
        this.error = false;
    }
    public ValidationResponse(String content,boolean error) {
        this.title = null;
        this.header = null;
        this.content = content;
        this.error = error;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
