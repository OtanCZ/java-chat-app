package com.example.neaplikacechat;

import com.example.neaplikacechat.shared.Message;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;

import static com.example.neaplikacechat.HelloApplication.clientApplication;

public class HelloController {
    @FXML
    public TextField sendTextArea;
    @FXML
    public TextArea chatArea;
    @FXML
    public TextField nicknameArea;

    public void sendButton(ActionEvent actionEvent) throws IOException {
        Message message = new Message();
        message.setCommand("SEND_DATA");
        message.setMessage(sendTextArea.getText());
        message.setAuthor(nicknameArea.getText());
        clientApplication.writeObjectToOutputStream(message);
    }

    public TextArea getChatArea() {
        return chatArea;
    }
}