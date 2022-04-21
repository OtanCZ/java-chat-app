package com.example.neaplikacechat.client;

import com.example.neaplikacechat.HelloController;
import com.example.neaplikacechat.shared.Message;
import java.io.*;
import java.net.Socket;


public class ClientApplication extends Thread{
    private Socket socket;
    private HelloController helloController;

    public ClientApplication(HelloController helloController) throws IOException {
        this.socket = new Socket("localhost", 8000);
        this.helloController = helloController;
    }

    public void writeObjectToOutputStream(Message message) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
        objectOutputStream.writeObject(message);
        objectOutputStream.flush();
    }

    public void writeStringToOutputStream(OutputStream outputStream) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        outputStreamWriter.write("NEW_USER\n\n");
        outputStreamWriter.write("data");
        outputStreamWriter.flush();
    }

    public void readObjectFromStream(InputStream stream) throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(stream);
        Message message = (Message) objectInputStream.readObject();
        System.out.println("Client received: " + message.toString());
        helloController.getChatArea().appendText(message.getAuthor() + ": " +message.getMessage() + "\n");
    }

    public void startClient() throws IOException {
        run();
    }
    @Override
    public void run() {
        try {
            while (!socket.isClosed()) {
                readObjectFromStream(socket.getInputStream());
            }
            System.out.println("Thread " + this.getName() + " closed");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
