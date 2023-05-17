package ru.getlab.model;

import java.time.LocalDateTime;

public class Purchase {
    private final String id;
    private final LocalDateTime creationTime;
    private final String text;

    public Purchase(String id, LocalDateTime creationTime, String text) {
        this.id = id;
        this.creationTime = creationTime;
        this.text = text;
    }

    public Purchase copy() {
        return new Purchase(id, creationTime, text);
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public String getText() {
        return text;
    }
}
