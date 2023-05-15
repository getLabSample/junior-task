package ru.getlab.services;

import ru.getlab.services.processors.InputService;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class IOServiceStreams implements IOService {

    private final PrintStream output;
    private final Scanner input;

    public IOServiceStreams(PrintStream outputStream, InputStream inputStream) {
        this.output = outputStream;
        this.input = new Scanner(inputStream);
    }

    @Override
    public int readInt() {
        return Integer.parseInt(input.nextLine());
    }

    @Override
    public void outputString(String s) {
        output.println(s);
    }
}
