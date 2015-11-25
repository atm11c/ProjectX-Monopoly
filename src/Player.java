import com.sun.xml.internal.bind.v2.TODO;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by Andrew on 11/23/2015.
 */
public class Player {
    private int money;
    private int utilOwned;
    private int rrOwned;
    private int playerId;
    private int position;
    private int roll;
    private boolean inJail;
    Scanner scanner = new Scanner(System.in);

    Player(int i){
        setMoney(1500);
        setRrOwned(0);
        setUtilOwned(0);
        setPlayerId(i);
        setPosition(0);
        setInJail(false);
    }

    /**
     * Set and Get methods
     */

    public void setMoney(int money) {
        if(money < 1){
            this.money = 0;
        }
        else
            this.money = money;
    }

    public void setRrOwned(int rrOwned) {
        this.rrOwned = rrOwned;
    }

    public void setUtilOwned(int utilOwned) {
        this.utilOwned = utilOwned;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

    public void setInJail(boolean inJail) {
        this.inJail = inJail;
    }

    public int getMoney() {
        return money;
    }

    public int getRrOwned() {
        return rrOwned;
    }

    public int getUtilOwned() {
        return utilOwned;
    }

    public int getPlayerId() {
        return playerId;
    }

    public int getPosition() {
        return position;
    }

    public int getRoll() {
        return roll;
    }

    public boolean isInJail() {
        return inJail;
    }

    /**
     * Method takeTurn
     * Simulates a turn taken by a player.
     *
     */
    public void takeTurn(Gameboard gb){
        int numDubs = 0;
        boolean dubs = true;
        boolean turnDone = false;
        Random random = new Random();

        while(dubs && !inJail){
            System.out.printf("Current position: %s\n", gb.cells[position].getName());
            //roll the dice
            int die1 = random.nextInt(6)+1;
            int die2 = random.nextInt(6)+1;
            setRoll(die1+die2);

            System.out.printf("You rolled a %d!\n", roll);
            //check if doubles were rolled.
            if(die1 == die2){
                System.out.println("DOUBLES");
                dubs = true;
                numDubs+=1;
                //If three doubles were rolled, go to jail...
                if(numDubs == 3){
                    System.out.println("Going to Jail for too many doubles...");
                    setPosition(10);
                    setInJail(true);
                    turnDone = true;
                    break;
                }
            }
            else
                dubs = false;

            //Move the player...
            //If player passes go, collect $200
            if(position+roll > 39) {
                System.out.println("You passed Go!");
                money += 200;
            }

            //Set the player's new Position
            position+=roll;
            position%=40;
            System.out.printf("New position: %s\n", gb.cells[position].getName());

            //Check the cell to see what happens
            checkCell(gb);

            System.out.println("End Roll\n");
        }

        //If the player is in Jail, try to roll dubs to get out.
        if(inJail && !turnDone){
            int die1 = random.nextInt(6)+1;
            int die2 = random.nextInt(6)+1;
            if(die1 == die2){
                setInJail(false);
                position+=die1+die2;
                checkCell(gb);
            }
        }

    }

    /**
     *  Method checkCell
     *  Checks to see what kind of cell the player has landed on, and calls another method
     *  to resolve that cell's effects.
     */
    private void checkCell(Gameboard gb){
        if(Gameboard.contains(gb.BOARDCELLNUMS, position)){
            effectCell(gb);
        }

        else if(Gameboard.contains(gb.SPECIALCELLS, position)){
            System.out.println("Buying RRs and Utils NYI");
        }
        else
            buyCell(gb);
    }


    /**
     *  Method effectCell
     *  If the player landed on a cell that is not buyable, then this method resolves the effects of that cell.
     */
    private void effectCell(Gameboard gb){
        switch(position){
            //Go
            case 0:
                break;
            //S. Community Chest
            case 2:
                System.out.println("Community Chest NYI");
                break;
            //Income Tax
            case 4:
                System.out.println("INCOME TAX: Lose $200");
                money-=200;
                break;
            //S. Chance
            case 7:
                System.out.println("Chance NYI");
                break;
            //Jail
            case 10:
                if(isInJail()) {
                    System.out.println("Getting out of Jail NYI");
                }
                else
                    System.out.println("Just visiting...");
                break;
            //W. Community Chest
            case 17:
                System.out.println("Community Chest NYI");
                break;
            //Free Parking
            case 20:
                break;
            //N. Chance
            case 22:
                System.out.println("Chance NYI");
                break;
            //Go to Jail
            case 30:
                System.out.println("Go to Jail!");
                setPosition(10);
                setInJail(true);
                break;
            //E. Community Chest
            case 33:
                System.out.println("Community Chest NYI");
                break;
            //E. Chance
            case 36:
                System.out.println("Chance NYI");
                break;
            //Luxury Tax
            case 38:
                System.out.println("Luxury Tax, pay $75");
                money-=75;
                break;
            //Better not...
            default:
                System.out.println("How the hell did this happen?");
        }

    }

    /**
     *  Method buyCell
     *  If the cell is a property of some sort, then buy it, pay rent, or stand there and look silly.
     */
    private void buyCell(Gameboard gb){
        //Check which player owns the cell
        Property property = (Property)gb.cells[position];

        //If nobody owns the property, prompt player to buy the property.
        if(property.getOwner() == 10){
            System.out.print("Nobody owns this property. Would you like to buy it? y/n ");
            String input = scanner.next();
            if(input.matches("y")){
                money-=property.getPrice();
                property.setOwner(playerId);
            }
        }
        //If somebody does own the property, and it's not the current player, pay up buttercup
        else if(property.getOwner() != playerId){
            //find rent value based on the number of houses the property has
            //TODO: Make it check to see if the player owns all of this color
            switch(property.getNumHouses()) {
                case 0:
                    System.out.printf("Player %d owns this. You owe them $%d.\n", property.getOwner() + 1, property.getRent0());
                    gb.players[property.getOwner()].setMoney(gb.players[property.getOwner()].getMoney() + property.getRent0());
                    money -= property.getRent0();
                    break;
                case 1:
                    System.out.printf("Player %d owns this. You owe them $%d.\n", property.getOwner() + 1, property.getRent1());
                    gb.players[property.getOwner()].setMoney(gb.players[property.getOwner()].getMoney() + property.getRent1());
                    money -= property.getRent1();
                    break;
                case 2:
                    System.out.printf("Player %d owns this. You owe them $%d.\n", property.getOwner() + 1, property.getRent2());
                    gb.players[property.getOwner()].setMoney(gb.players[property.getOwner()].getMoney() + property.getRent2());
                    money -= property.getRent2();
                    break;
                case 3:
                    System.out.printf("Player %d owns this. You owe them $%d.\n", property.getOwner() + 1, property.getRent3());
                    gb.players[property.getOwner()].setMoney(gb.players[property.getOwner()].getMoney() + property.getRent3());
                    money -= property.getRent3();
                    break;
                case 4:
                    System.out.printf("Player %d owns this. You owe them $%d.\n", property.getOwner() + 1, property.getRent4());
                    gb.players[property.getOwner()].setMoney(gb.players[property.getOwner()].getMoney() + property.getRent4());
                    money -= property.getRent4();
                    break;
                case 5:
                    System.out.printf("Player %d owns this. You owe them $%d.\n", property.getOwner() + 1, property.getRent5());
                    gb.players[property.getOwner()].setMoney(gb.players[property.getOwner()].getMoney() + property.getRent5());
                    money -= property.getRent5();
                    break;
                default:
                    System.out.println("Well this shouldnt have happened...");
            }
        }

        else
            System.out.println("You own this!");
    }


}
