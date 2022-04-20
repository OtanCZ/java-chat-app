package com.example.neaplikacechat;

import com.example.neaplikacechat.shared.Message;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    public TextField sendTextArea;
    @FXML
    public TextArea chatArea;

    public void sendButton(ActionEvent actionEvent) {
        Message message = new Message();
        message.setCommand("SEND_DATA");
        message.setData(getSendTextArea());
        chatArea.setText(chatArea.getText() + "\n" + message.getData());
    }
    public String getSendTextArea() {
        return String.valueOf(sendTextArea.getText());
    }
    }