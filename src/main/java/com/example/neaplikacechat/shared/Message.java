package com.example.neaplikacechat.shared;

import java.io.Serializable;

public class Message implements Serializable {

    private String command;
    private String data;

    public Message() {
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Message{" +
                "command='" + command + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}