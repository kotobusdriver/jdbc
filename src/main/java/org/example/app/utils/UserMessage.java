package org.example.app.utils;

public enum UserMessage {
    INCORRECT_VALUE_MSG ("Incorrect value. Try again."),
    APP_CLOSE_MSG ("App closed."),
    INCORRECT_OPTION_MSG("Incorrect option. Try again."),
    INPUT_REQ_MSG ("Input required"),
    INCORRECT_AGE_MSG("Age should be between 18 and 100"),
    DATA_INSERT_MSG("Data inserted successfully");

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
