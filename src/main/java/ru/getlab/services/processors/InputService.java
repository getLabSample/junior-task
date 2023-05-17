package ru.getlab.services.processors;

public interface InputService {
    int readInt();

    String readStringWithPrompt(String prompt);
}
