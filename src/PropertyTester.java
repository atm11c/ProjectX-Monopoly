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
            System.out.printf("Player %d, it's your turn!\n", playerTurn+1);
            boolean derp = false;
            while(!derp) {
                System.out.print("r. roll dice\nt. trade with other player\nv. view my properties\n");
                String hurrdurr = scanner.next();
                switch (hurrdurr) {
                    case "r":
                        gameboard.players[playerTurn].takeTurn(gameboard);
                        derp = true;
                        break;
                    case "t":
                        //System.out.println("Trading not yet implemented.");
                        gameboard.players[playerTurn].trade(gameboard);
                        break;
                    case "v":
                        gameboard.players[playerTurn].playerProps(gameboard);
                        break;
                    default:
                        System.out.println("That wasn't one of the options.");
                }
                System.out.printf("Money: %d\n", gameboard.players[playerTurn].getMoney());
            }
            //next player
            playerTurn+=1;
            playerTurn%=4;

            System.out.println("End Turn\n\n");
        }

    }







}
