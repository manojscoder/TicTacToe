package com.Projects;
import java.util.Random;
import java.util.Scanner;

public class RockPaperScissor {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char[] game = {'R','P','S'};
        System.out.println();
        System.out.println("Welcome, let's play rock paper scissors.");
        System.out.print("Enter the player name: ");
        String name = input.next();
        System.out.println(startGame(game,name,input) + " won!");
    }

    public static String startGame(char[] game,String name,Scanner input){
        Random rdm = new Random();
        System.out.print("Dear " + name + ", please enter 'R' for Rock or 'P' for Paper or 'S' for Scissors: ");
        char playerChoice = input.next().charAt(0);
        System.out.println();
        int computerChoice = rdm.nextInt(game.length);
        playerChoice = Character.toUpperCase(playerChoice);

        String player;
        String computer;

        if(playerChoice == 'R'){
            player = "Rock";
        }else if(playerChoice == 'S') {
            player = "Scissors";
        }else{
            player = "Paper";
        }

        if(computerChoice == 0){
            computer = "Rock";
        }else if(computerChoice == 2) {
            computer = "Scissors";
        }else{
            computer = "Paper";
        }


        if((playerChoice == 'R' && computerChoice == 2) || (playerChoice == 'S' && computerChoice == 1) || (playerChoice == 'P' && computerChoice == 0)){
            System.out.println("Manoj used " + player + " and opponent used " + computer + ".");
            return name;
        }
        else if((playerChoice == 'S' && computerChoice == 0) || (playerChoice == 'P' && computerChoice == 2) || (playerChoice == 'R' && computerChoice == 1)){
            System.out.println("Manoj used " + player + " and opponent used " + computer + ".");
            return "Opponent";
        }
        System.out.println("Game draw try again!");
        return startGame(game,name,input);
    }
}
