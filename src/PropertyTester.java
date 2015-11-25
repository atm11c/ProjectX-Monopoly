import java.util.Scanner;

/**
 * Created by Miller on 11/19/2015.
 */
public class PropertyTester {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        Gameboard gameboard = new Gameboard();


        //Initialize the players
        for(int i=0;i<gameboard.players.length;i++){
            gameboard.players[i] = new Player(i);
        }

        boolean flag = true;

        int playerTurn = 0;

        while(flag) {
            System.out.printf("Player %d, press Enter to take your turn!", playerTurn+1);
            scanner.nextLine();
            gameboard.players[playerTurn].takeTurn(gameboard);

            System.out.printf("Money: %d\n", gameboard.players[playerTurn].getMoney());

            //next player
            playerTurn+=1;
            playerTurn%=4;

            System.out.println("End Turn\n\n");
        }

    }







}
