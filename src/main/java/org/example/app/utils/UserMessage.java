package org.example.app.utils;

public enum UserMessage {
    INCORRECT_VALUE_MSG ("Incorrect value. Try again."),
    APP_CLOSE_MSG ("App closed.");

    private final String msg;
    UserMessage(String msg){
        this.msg = msg;
    }

    public String getMsg(){
        return msg;
    }

    @Override
    public String toString() {
        return msg;
    }
}
