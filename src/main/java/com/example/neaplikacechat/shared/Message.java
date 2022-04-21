package com.example.neaplikacechat.shared;

import java.io.Serializable;

public class Message implements Serializable {

    private String command;
    private String author;
    private String message;

    public Message() {
    }

    public Message(String command, String author, String message) {
        this.command = command;
        this.author = author;
        this.message = message;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Message{" +
                "command='" + command + '\'' +
                ", author='" + author + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
