package me.cxmilo.chat.client.service.impl;

import me.cxmilo.chat.client.chat.thread.ChatThread;
import me.cxmilo.chat.client.client.Client;
import me.cxmilo.chat.client.service.Service;

import java.io.IOException;
import java.net.Socket;

public class ClientConnectService implements Service {

    private static final String PROXY = "127.0.0.1";
    private static final short PORT = 8000;

    private final String name;
    private final String channel;
    private Socket socket;

    public ClientConnectService(String name, String channel) {
        this.name = name;
        this.channel = channel;
    }


    // I think this could not be considered as a service, I will probably change it.
    @Override
    public boolean start() {
        try {
            socket = new Socket(PROXY, PORT);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        // Initialize the chat
        Client client = new Client(socket)
                .name(name)
                .channel(channel)
                .build();

        new Thread(new ChatThread(client)).start();
        System.out.println("Successfully started");
        return true;
    }

    @Override
    public boolean stop() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
