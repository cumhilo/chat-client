package me.cxmilo.chat.client.chat;

import me.cxmilo.chat.client.client.Client;
import me.cxmilo.chat.client.encrypt.EncryptMessage;

import java.io.IOException;
import java.util.Objects;

public class ChatClient {

    private final Client client;

    public ChatClient(Client client) {
        this.client = client;
    }

    /**
     * Send a message to the SocketServer from the client socket
     *
     * @param message the message that would be sent
     */
    public void sendMessage(String message) {
        Objects.requireNonNull(client.getChannel(), "Invalid channel, please set a valid channel.");

        String line = String.format("%s;[%s] > %s\n", client.getChannel(), client.getName(), message);

        try {
            client.getSocket().getOutputStream().write(EncryptMessage.toBase64(line));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Unused
    /*public void readMessage(Client client) {
        Objects.requireNonNull(client.getChannel(), "Invalid channel, please set a valid channel.");

        String result = "";

        try {
            result += (char) client.getSocket().getInputStream().read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (client.getChannel().equals(result.split(";")[0])) {
            System.out.println();
        }
    }*/
}
