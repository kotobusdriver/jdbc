package org.example.app.exceptions;


import org.example.app.utils.UserMessage;

public class OptionException extends Exception {
    public OptionException(UserMessage msg) {
        super(msg.toString());
    }
}
