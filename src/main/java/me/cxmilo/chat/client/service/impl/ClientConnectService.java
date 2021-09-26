package me.cxmilo.chat.client.service.impl;

import me.cxmilo.chat.client.chat.thread.ChatThread;
import me.cxmilo.chat.client.client.Client;
import me.cxmilo.chat.client.service.Service;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    @Override
    public boolean start() {
        try {
            socket = new Socket(PROXY, PORT);
        } catch (IOException e) {
            Logger.getLogger("ClientSocket").severe(e.getMessage());
            return false;
        }

        // Initialize the chat
        Client client = new Client(socket);
        client.setName(name);
        client.setChannel(channel);

        new ChatThread(client).start();
        Logger.getLogger("ClientChat").log(Level.INFO, "The chat thread has been successfully started");
        return true;
    }

    @Override
    public boolean stop() {
        try {
            socket.shutdownOutput();
            socket.shutdownInput();
            if (socket.isConnected()) {
                socket.close();
            }
        } catch (IOException e) {
            Logger.getLogger("ClientSocket").severe(e.getMessage());
            return false;
        }

        return true;
    }
}
