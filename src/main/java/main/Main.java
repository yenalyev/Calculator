package main;

import console.Reader;
import run.Runner;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String input = "";
        try {
            input = Reader.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(Runner.run(input));
    }
}
