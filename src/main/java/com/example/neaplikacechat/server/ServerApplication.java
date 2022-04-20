package com.example.neaplikacechat.server;

import com.example.neaplikacechat.shared.Message;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerApplication {
    public static void readObjectFromInput(InputStream inputStream) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
       /* while (objectInputStream.available() < 0) {
            // aktivní čekání / busy waiting
        }*/

        Message message = (Message) objectInputStream.readObject();
        System.out.println(message);
        System.out.println(message.getCommand());
        System.out.println(message.getData());
    }

    public static void readStringFromInput(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream);

        while (scanner.hasNext()) {
            String line = scanner.next();
            System.out.println(line);
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(8000);
        Socket socket = serverSocket.accept();
        readObjectFromInput(socket.getInputStream());
        //   readStringFromInput(socket.getInputStream());
    }
}

