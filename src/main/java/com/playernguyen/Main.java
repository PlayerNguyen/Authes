package com.playernguyen;

import com.playernguyen.util.NumberGenerator;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {
        for (int i = 0; i < 10; i++) {
            System.out.println(NumberGenerator.generate(6));
        }
    }
}
