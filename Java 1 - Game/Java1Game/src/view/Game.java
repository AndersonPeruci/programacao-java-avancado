package view;

import model.Calculate;

import java.util.Scanner;

public class Game {

    static Scanner keyboard = new Scanner(System.in);
    static int score = 0;
    static Calculate calculate;

    public static void main(String[] args) {
        Game.play();
    }

    public static void play(){
        System.out.println("1 - Easy\n2 - Medium\n3 - Hard\n4 - Very Hard\n5 - Insane\nWrite the difficulty:");
        Game.calculate = new Calculate(Game.keyboard.nextInt());

        System.out.print("What's the answer? \n" + Game.calculate.printEquation());
        if(calculate.isCorrectAnswer(Game.keyboard.nextInt())) {
            Game.score++;
            System.out.println("Correct... Congrats!!!");
            System.out.println("Score: " + Game.score);
        } else {
            System.out.println("Incorrect answer! No score");
            System.out.println("Score: " + Game.score);
        }
        System.out.println("Do you wish to continue??\n1 - Yes\n2 - No");

        if (Game.keyboard.nextInt() == 1)
            Game.play();
        else
            System.exit(0);
    }
}
