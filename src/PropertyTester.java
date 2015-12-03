import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

/**
 * Created by Miller on 11/19/2015.
 */
public class PropertyTester {
    public static Gameboard gb = new Gameboard();
    public static void main(String[] args){

        JFrame frame = new JFrame("Monopoly!");
        MenuPanel mPanel = new MenuPanel();

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth()/2 - frame.getWidth())/2);
        int y = (int) ((dimension.getHeight()/2 - frame.getHeight()) / 2);

        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setSize( 600, 400 );
        frame.setVisible( true );
        frame.setLocation(x, y);
        frame.add(mPanel);


        boolean flag = true;

        while(flag) {
            int playerTurn = gb.getCurrentPlayer();
            //System.out.printf("Player %d, it's your turn!\n", playerTurn+1);


            //System.out.println("End Turn\n\n");

            //Check for end of game
            if(gb.players[playerTurn].isBankrupt()){
                flag = false;
                System.out.println("Game has ended!");
            }

        }

/*
        Scanner scanner = new Scanner(System.in);

        boolean flag = true;

        int playerTurn = 0;

        while(flag) {
            System.out.printf("Player %d, it's your turn!\n", playerTurn+1);
            boolean derp = false;
            while(!derp) {
                System.out.print("r. roll dice\nt. trade with other player\nv. view my properties\nb. build\n");
                String hurrdurr = scanner.next();
                switch (hurrdurr) {
                    case "r":
                        gb.players[playerTurn].takeTurn(gb);
                        derp = true;
                        break;
                    case "t":
                        //System.out.println("Trading not yet implemented.");
                        gb.players[playerTurn].trade(gb);
                        break;
                    case "v":
                        gb.players[playerTurn].playerProps(gb);
                        break;
                    case "b":
                        gb.players[playerTurn].builder(gb);
                        break;
                    default:
                        System.out.println("That wasn't one of the options.");
                }
                System.out.printf("Money: %d\n", gb.players[playerTurn].getMoney());
            }


            System.out.println("End Turn\n\n");

            //Check for end of game
            if(gb.players[playerTurn].isBankrupt()){
                flag = false;
                System.out.println("Game has ended!");
            }

            //next player
            playerTurn+=1;
            playerTurn%=4;
        }*/

    }







}
