package com.example.neaplikacechat.client;

import com.example.neaplikacechat.shared.Message;

import java.io.*;
import java.net.Socket;

public class ClientApplication {



    public void writeObjectToOutputStream(OutputStream outputStream) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        Message message = new Message();
        message.setCommand("SEND_DATA");
        ///message.setData(client.jbruhava.HelloController().getTxfed);
        objectOutputStream.writeObject(message);
        objectOutputStream.flush();
        objectOutputStream.close();
    }
    public synchronized void getObjectToOutputStream(Socket socket) throws IOException, ClassNotFoundException {
        Thread thread = new Thread();
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeStringToOutputStream(OutputStream outputStream) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        outputStreamWriter.write("NEW_USER\n\n");
        outputStreamWriter.write("data");
        outputStreamWriter.flush();
        outputStreamWriter.close();
    }

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 8000);
        //writeObjectToOutputStream(socket.getOutputStream());
        // writeStringToOutputStream(socket.getOutputStream());
    }


}
