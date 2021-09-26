package me.cxmilo.chat.client.chat.thread;

import me.cxmilo.chat.client.ChatController;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ShutdownThread extends Thread {

    @Override
    public void run() {
        Logger.getLogger("ClientChat").log(Level.INFO, "Shutting down the JVM");
        ChatController.getConnection().stop();
    }
}
