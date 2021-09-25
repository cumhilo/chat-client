package me.cxmilo.chat.client.client;

import java.net.Socket;

public class Client {

    private Socket socket;
    private String channel;
    private String name;

    public Client(Socket socket) {
        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Client build() {
        return this;
    }

    @Override
    public String toString() {
        return "Client{" +
                "socket=" + socket +
                ", channel='" + channel + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
