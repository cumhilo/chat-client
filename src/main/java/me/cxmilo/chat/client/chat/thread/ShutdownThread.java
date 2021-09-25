package me.cxmilo.chat.client.chat.thread;

import me.cxmilo.chat.client.ChatController;

public class ShutdownThread extends Thread {

    @Override
    public void run() {
        // test
        System.out.println("Shutting down the JVM");
        ChatController.getConnection().stop();
    }
}
