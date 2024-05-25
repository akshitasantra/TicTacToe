import java.util.*;
public class TicTacToe
{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[][] cry = new String[3][3];
        boolean playing = true;
        System.out.println("What symbol do you want to use first: X or O");
        String letter = scan.next();
        boolean X = false;
        int timer = 9;
        if(letter.equals("X")){
            X = true;
        }
        for(int x = 0; x < cry.length; x++){
            for(int y = 0; y < cry[x].length; y++){
                cry[x][y] = " ";
            }
        }
        while(playing){
            if(timer == 0){
                System.out.println("tied");
                break;
            }
            printBoardNum(cry);
            if(X){
                cry = makeMove(cry, "X");
                printBoard(cry);
                if(checkWinner(cry, "X")){
                    playing = false;
                    System.out.println("X won");
                }
            }
            else{
                cry = makeMove(cry, "O");
                printBoard(cry);
                if(checkWinner(cry, "O")){
                    playing = false;
                    System.out.println("O won");
                }
            }
            X = !X;
            timer--;
        }
    }

    public static void printBoard(String[][] cry){
        for(int x = 0; x < cry.length; x++){
            for(int y = 0; y < cry[x].length; y++){
                if(y < 2){
                    System.out.print(cry[x][y] + "|");
                }
                else{
                    System.out.print(cry[x][y]);
                }
            }
            System.out.println();
            if(x<2){
                System.out.println("-----");
            }
        }
        System.out.println();
    }

    public static void printBoardNum(String[][] cry){
        int i = 1;
        for(int x = 0; x < cry.length; x++){
            for(int y = 0; y < cry[x].length; y++){
                if(y < 2){
                    System.out.print(i + "|");
                    i++;
                }
                else{
                    System.out.print(i);
                    i++;
                }
            }
            System.out.println();
            if(x<2){
                System.out.println("-----");
            }
        }
        System.out.println();
    }

    public static String[][] makeMove(String[][] cry, String letter){
        Scanner scan = new Scanner(System.in);
        System.out.println("what spot do u want");
        int pancakes = scan.nextInt();  
        if(pancakes%3 == 0){
            if(cry[(pancakes/3)-1][2].equals(" ")){
                cry[(pancakes/3)-1][2] = letter;
            }
            else{
                System.out.println("that cell is already occupied- she's taken. she's not single mate. move on");
                makeMove(cry, letter);                
            }
        }
        else{
            if(cry[pancakes/3][(pancakes%3) - 1].equals(" ")){
                cry[pancakes/3][(pancakes%3) - 1] = letter;
            }
            else{
                System.out.println("that cell is already occupied- she's taken. she's not single mate. move on");
                makeMove(cry, letter);
            }
        }
        return cry;
    }

    public static boolean checkWinner(String[][] b, String s){
        if(b[0][0].equals(s) && b[0][1].equals(s) && b[0][2].equals(s) ||
        b[1][0].equals(s) && b[1][1].equals(s) && b[1][2].equals(s) ||
        b[2][0].equals(s) && b[2][1].equals(s) && b[2][2].equals(s) ||
        b[0][0].equals(s) && b[1][0].equals(s) && b[2][0].equals(s) ||
        b[0][1].equals(s) && b[1][1].equals(s) && b[2][1].equals(s) ||
        b[0][2].equals(s) && b[1][2].equals(s) && b[2][2].equals(s) ||
        b[0][0].equals(s) && b[1][1].equals(s) && b[2][2].equals(s) ||
        b[0][2].equals(s) && b[1][1].equals(s) && b[2][0].equals(s)) {
            return true;
        }
        else {
            return false;
        }
    }
}
