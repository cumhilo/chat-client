package me.cxmilo.chat.client.service;

public interface Service {

    /**
     * The process when the service is started
     *
     * @return if the program has been started successfully
     */
    boolean start();

    /**
     * Completion of the service is handled by this method.
     *
     * @return if the program has been successfully completed
     */
    boolean stop();
}
