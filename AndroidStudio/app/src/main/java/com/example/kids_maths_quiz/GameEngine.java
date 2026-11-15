package com.example.kids_maths_quiz;

import java.util.Random;

public class GameEngine {

    Random rand = new Random();

    public int correctAns;
    public String question;

    public void genQuestion() {

        int a = rand.nextInt(12) + 1;
        int b = rand.nextInt(12) + 1;
        int operator = rand.nextInt(4);

        switch(operator) {

            case 0:
                correctAns = a + b;
                question = a + " + " + b;
                break;

            case 1:
                if(a < b) {
                    int temp = a;
                    a = b;
                    b = temp;
                }
                correctAns = a - b;
                question = a + " - " + b;
                break;

            case 2:
                correctAns = a * b;
                question = a + " * " + b;
                break;

            case 3:
                correctAns = a / b;
                question = a + " ÷ " + b;
                break;

        }

    }
}
