package com.Projects;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Create 3 * 3 matrix
        char[][] board = new char[3][3];

        //Fill the board with ' '
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                board[i][j] = ' ';
            }
        }

        //When game ends Game == true
        boolean Game = false;

        // X or O character
        char player;

        //Collecting 2 players name
        System.out.println("Enter two players name: ");
        System.out.print("Player 1 name: ");
        String p1 = scan.next();
        System.out.print("Player 2 name: ");
        String p2 = scan.next();

        // Plater1 will start the game
        String play = p1;
        System.out.println();

        // Player1 is X and player2 is O
        System.out.println("Game started 'X' is for " + p1 + " and 'O' is for " + p2);

        while(!Game){
            //Printing board
            printBorad(board);
            System.out.println();

            //Input from the player
            System.out.print("Player " + play +" enter the move: ");
            int row = scan.nextInt();
            int col = scan.nextInt();

            //Checking the invalid move
            if(row > 2 || col > 2 || row < 0 || col < 0 || board[row][col] != ' '){
                System.out.println("Invalid move try again");
            }

            //Checking whether Game over or not
            else {
                if(play.equals(p1)){
                    player = 'X';
                }
                else{
                    player = 'O';
                }
                board[row][col] = player;

                //Checking whether game draw or not
                if(Draw(board)){
                    System.out.println();
                    System.out.println("Gave draw!");
                    Game = true;
                }

                //Checking whether game over or not
                else if (hasWon(board, player)) {
                    Game = true;
                    System.out.println();

                    System.out.println(play + " won game over.");
                    printBorad(board);
                }

                // If game is not over next player will continue
                else {
                    play = player == 'X' ? p2 : p1;
                }
            }
        }

    }

    //Method for checking game draw or not
    public static boolean Draw(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == ' '){
                    return false;
                }
            }
        }
        return true;
    }

    //Method for printing the board
    public static void printBorad(char[][] board){
        System.out.println("    0     1     2");
        for(int i = 0; i < board.length; i++){
            System.out.print(i);
            for(int j = 0; j < board[i].length; j++){
                System.out.print(" [ " + board[i][j] + " ]");
            }
            System.out.println();
        }
    }

    //Method for checking whether player won or not
    public static boolean hasWon(char[][] board,char player){

        // Check all the rows and columns
        for(int i = 0; i < board.length; i++){
            if(board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
            if(board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }

        // Check both the diagonal
        int n = 0;
        // Diagonal 1
        if(board[n][n] == player &&  board[n + 1][n + 1] == player && board[n + 2][n + 2] == player){
            return true;
        }
        // Diagonal 2
        return board[n][n + 2] == player && board[n + 1][n + 1] == player && board[n + 2][n] == player;
    }
}
