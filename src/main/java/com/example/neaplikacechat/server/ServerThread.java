package com.example.neaplikacechat.server;

import com.example.neaplikacechat.shared.Message;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerThread extends Thread {
    public static List<Socket> socketList = new ArrayList<>();
    private Socket socket;

    public ServerThread(Socket socket) throws IOException {
        this.socket = socket;
    }

    @Override
    public void run() {
        while (socket.isConnected() || !socket.isClosed()) {
            synchronized (socketList) {
                    try {
                        System.out.println(socket.toString());
                        if(socketList.indexOf(socket) == -1) {
                            socketList.add(socket);
                        }

                        for (int i = 0; i < socketList.size(); i++) {
                            if(socketList.get(i).isClosed() || !socketList.get(i).isConnected()){
                                socketList.remove(i);
                                i--;
                            }
                        }

                        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                        Message message = (Message) objectInputStream.readObject();

                        for (Socket s : socketList) {
                            if(s.isConnected()){
                                try {
                                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(s.getOutputStream());
                                    objectOutputStream.writeObject(message);
                                    objectOutputStream.flush();
                                } catch (IOException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                        }
                        } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
}
