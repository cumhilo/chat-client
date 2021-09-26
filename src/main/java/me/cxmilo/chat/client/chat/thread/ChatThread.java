package me.cxmilo.chat.client.chat.thread;

import me.cxmilo.chat.client.chat.ChatClient;
import me.cxmilo.chat.client.client.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ChatThread extends Thread {

    private final Client client;

    public ChatThread(Client client) {
        this.client = client;
    }

    @Override
    public void run() {
        ChatClient chat = new ChatClient(client);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (client.getSocket().isConnected()) {
            try {
                chat.sendMessage(reader.readLine());
            } catch (IOException e) {
                Logger.getLogger("ClientChat").severe(e.getMessage());
            }
        }

        Logger.getLogger("ClientChat").log(Level.INFO, "ChatThread has been finalized");
    }
}
