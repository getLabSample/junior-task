package ru.getlab.services;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Service for correct shutting down application.
 */
public class ApplicationStopService {

    private final AtomicBoolean executionFlag;

    public ApplicationStopService() {
        this.executionFlag = new AtomicBoolean(true);
    }

    public boolean isApplicationRunning() {
        return executionFlag.get();
    }

    public void stopApplication() {
        executionFlag.set(false);
    }
}
