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
    private boolean browns,lblues,pinks,oranges,reds,yellows,greens,dblues;
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

    public void setBrowns(Gameboard gb){
        OwnedCell prop1, prop2;
        prop1 = (OwnedCell) gb.cells[1];
        prop2 = (OwnedCell) gb.cells[3];
        browns = prop1.getOwner() == playerId && prop2.getOwner() == playerId;
    }

    public void setLblues(Gameboard gb){
        OwnedCell prop1,prop2,prop3;
        prop1 = (OwnedCell) gb.cells[6];
        prop2 = (OwnedCell) gb.cells[8];
        prop3 = (OwnedCell) gb.cells[9];
        lblues = prop1.getOwner() == playerId && prop2.getOwner() == playerId && prop3.getOwner() == playerId;

    }

    public void setPinks(Gameboard gb){
        OwnedCell prop1,prop2,prop3;
        prop1 = (OwnedCell) gb.cells[11];
        prop2 = (OwnedCell) gb.cells[13];
        prop3 = (OwnedCell) gb.cells[14];
        pinks = prop1.getOwner() == playerId && prop2.getOwner() == playerId && prop3.getOwner() == playerId;
    }

    public void setOranges(Gameboard gb){
        OwnedCell prop1,prop2,prop3;
        prop1 = (OwnedCell) gb.cells[16];
        prop2 = (OwnedCell) gb.cells[18];
        prop3 = (OwnedCell) gb.cells[19];
        oranges = prop1.getOwner() == playerId && prop2.getOwner() == playerId && prop3.getOwner() == playerId;
    }

    public void setReds(Gameboard gb) {
        OwnedCell prop1,prop2,prop3;
        prop1 = (OwnedCell) gb.cells[21];
        prop2 = (OwnedCell) gb.cells[23];
        prop3 = (OwnedCell) gb.cells[24];
        reds = prop1.getOwner() == playerId && prop2.getOwner() == playerId && prop3.getOwner() == playerId;
    }

    public void setYellows(Gameboard gb) {
        OwnedCell prop1,prop2,prop3;
        prop1 = (OwnedCell) gb.cells[26];
        prop2 = (OwnedCell) gb.cells[27];
        prop3 = (OwnedCell) gb.cells[29];
        yellows = prop1.getOwner() == playerId && prop2.getOwner() == playerId && prop3.getOwner() == playerId;
    }

    public void setGreens(Gameboard gb) {
        OwnedCell prop1,prop2,prop3;
        prop1 = (OwnedCell) gb.cells[31];
        prop2 = (OwnedCell) gb.cells[32];
        prop3 = (OwnedCell) gb.cells[34];
        greens = prop1.getOwner() == playerId && prop2.getOwner() == playerId && prop3.getOwner() == playerId;
    }

    public void setDblues(Gameboard gb) {
        OwnedCell prop1, prop2;
        prop1 = (OwnedCell) gb.cells[37];
        prop2 = (OwnedCell) gb.cells[39];
        dblues = prop1.getOwner() == playerId && prop2.getOwner() == playerId;
    }

    //The Dream
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

    public boolean isBrowns() {
        return browns;
    }

    public boolean isLblues() {
        return lblues;
    }

    public boolean isPinks() {
        return pinks;
    }

    public boolean isOranges() {
        return oranges;
    }

    public boolean isReds() {
        return reds;
    }

    public boolean isYellows() {
        return yellows;
    }

    public boolean isGreens() {
        return greens;
    }

    public boolean isDblues() {
        return dblues;
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
        //TODO: Add option to pay way out of jail, then force payment after 3 turns.
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
            effectCell();
        }

        else if(Gameboard.contains(gb.SPECIALCELLS, position)){
            buySpec(gb);
        }
        else
            buyCell(gb);
    }


    /**
     *  Method effectCell
     *  If the player landed on a cell that is not buyable, then this method resolves the effects of that cell.
     */
    private void effectCell(){
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
            //TODO Community Chests
            case 17:
                System.out.println("Community Chest NYI");
                break;
            //Free Parking
            case 20:
                break;
            //N. Chance
            case 22:
                //TODO Chance cards
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
     *  If the cell is a property, then buy it, pay rent, or stand there and look silly.
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
            int rent=0;
            switch(property.getNumHouses()) {
                case 0:
                    //If player owns all colors of a set, and the lot is unimproved, rent is doubled.
                    if(checkSet(gb,property.getColor()))
                        rent = property.getRent0()*2;
                    else
                        rent = property.getRent0();

                    break;
                case 1:
                    rent = property.getRent1();
                    break;
                case 2:
                    rent = property.getRent2();
                    break;
                case 3:
                    rent = property.getRent3();
                    break;
                case 4:
                    rent = property.getRent4();
                    break;
                case 5:
                    rent = property.getRent5();
                    break;
                default:
                    System.out.println("Well this shouldnt have happened...");
            }
            System.out.printf("Player %d owns this. You owe them $%d.\n", property.getOwner() + 1, rent);
            gb.players[property.getOwner()].setMoney(gb.players[property.getOwner()].getMoney() + rent);
            money-=rent;
        }

        else
            System.out.println("You own this!");
    }

    /**
     *  Method buySpec
     *  For when a player lands on a utility or a railroad.
     */

    public void buySpec(Gameboard gb){
        OwnedCell ownedCell = (OwnedCell)gb.cells[position];

        //If unowned, prompt user to buy
        if(ownedCell.getOwner() == 10){
            System.out.print("Would you like to buy this property? y/n ");
            String input = scanner.next();

            if(input.matches("y")){
                money-=ownedCell.getPrice();
                ownedCell.setOwner(playerId);

                //Increase the number of railroads or utilities owned
                if(ownedCell.getisRR()){
                    rrOwned+=1;
                }
                else if(ownedCell.getisUtil()){
                    utilOwned+=1;
                }
                else
                    System.out.println("Wait how did you...?");
            }
        }
        //If another player owns this, pay up buttercup
        else if(ownedCell.getOwner() != playerId){
            //if the cell is a railroad...
            if(ownedCell.getisRR()){
                switch(gb.players[ownedCell.getOwner()].getRrOwned()){
                    case 1:
                        System.out.printf("Player %d owns this. You owe them $25.\n", ownedCell.getOwner() + 1);
                        gb.players[ownedCell.getOwner()].setMoney(gb.players[ownedCell.getOwner()].getMoney() + 25);
                        money -= 25;
                        break;
                    case 2:
                        System.out.printf("Player %d owns this. You owe them $50.\n", ownedCell.getOwner() + 1);
                        gb.players[ownedCell.getOwner()].setMoney(gb.players[ownedCell.getOwner()].getMoney() + 50);
                        money -= 50;
                        break;
                    case 3:
                        System.out.printf("Player %d owns this. You owe them $100.\n", ownedCell.getOwner() + 1);
                        gb.players[ownedCell.getOwner()].setMoney(gb.players[ownedCell.getOwner()].getMoney() + 100);
                        money -= 100;
                        break;
                    case 4:
                        System.out.printf("Player %d owns this. You owe them $200.\n", ownedCell.getOwner() + 1);
                        gb.players[ownedCell.getOwner()].setMoney(gb.players[ownedCell.getOwner()].getMoney() + 200);
                        money -= 200;
                        break;
                    default:
                        System.out.println("You broke it. Good job.");

                }
            }
            //If it's a utility
            else if(ownedCell.getisUtil()){
                Random random = new Random();
                int d1 = random.nextInt(6)+1;
                int d2 = random.nextInt(6)+1;
                int sum = d1+d2;
                if(gb.players[ownedCell.getOwner()].utilOwned == 1){
                    System.out.printf("You rolled a %d, you owe Player %d $%d.\n", sum, ownedCell.getOwner() + 1, sum * 4);
                    gb.players[ownedCell.getOwner()].setMoney(gb.players[ownedCell.getOwner()].getMoney() + (sum*4));
                    money -= sum*4;
                }
                else if(gb.players[ownedCell.getOwner()].utilOwned== 2){
                    System.out.printf("You rolled a %d, you owe Player %d $%d.\n", sum, ownedCell.getOwner()+1, sum*10);
                    gb.players[ownedCell.getOwner()].setMoney(gb.players[ownedCell.getOwner()].getMoney() + (sum*10));
                    money -= sum*10;
                }
                else
                    System.out.println("Way to go. It broke.");
            }
        }
    }

    /**
     *  Method checkSet
     *  Checks to see if the player owns all of the properties of one set color and sets a flag accordingly.
     */
    public boolean checkSet(Gameboard gb, String color){
        boolean flag = false;
        switch(color) {
            case "Brown":
                setBrowns(gb);
                flag = isBrowns();
                break;
            case "Light Blue":
                setLblues(gb);
                flag = isLblues();
                break;
            case "Pink":
                setPinks(gb);
                flag = isPinks();
                break;
            case "Orange":
                setOranges(gb);
                flag = isOranges();
                break;
            case "Red":
                setReds(gb);
                flag = isReds();
                break;
            case "Yellow":
                setYellows(gb);
                flag = isYellows();
                break;
            case "Green":
                setGreens(gb);
                flag = isGreens();
                break;
            case "Dark Blue":
                setDblues(gb);
                flag = isDblues();
                break;
            default:
                System.out.println("You mispelled something somewhere pal");

        }
        return flag;
    }

    /**
     *  Method playerProps
     *  Prints a specific player's owned properties
     */
    public void playerProps(Gameboard gb){
        OwnedCell oc;
        System.out.printf("Player %d owns the following properties: \n", playerId+1);
        for(int i=0;i<gb.cells.length;i++){
            if(!Gameboard.contains(gb.BOARDCELLNUMS,i)){
                oc = (OwnedCell)gb.cells[i];
                if(oc.getOwner()==playerId){
                    System.out.printf("%d, %s\n", oc.getCellId(), oc.getName());
                }
            }
        }
    }

    /**
     *  Method trade
     *  Starts a trade between two players.
     */
    //TODO: Add and subtract from the number of utilities and railroads owned
    //TODO: Ensure that players cannot trade properties they do not own.
    public void trade(Gameboard gb){
        System.out.print("Which player do you want to trade with?");
        int trader = scanner.nextInt();
        trader-=1;

        //Print current players stuff
        System.out.printf("Player %d has $%d\n", playerId+1, money);
        playerProps(gb);

        //Print other players stuff
        System.out.printf("Player %d has $%d\n", trader+1, gb.players[trader].getMoney());
        gb.players[trader].playerProps(gb);

        //Ask what the trading player wants.
        System.out.print("What property do you want?(Enter -1 for none)");
        int rProp = scanner.nextInt();
        System.out.print("How much money do you want from this trade?");
        int rCash = scanner.nextInt();

        //Ask what the trading player will offer.
        System.out.print("What property will you give?(Enter -1 for none)");
        int sProp = scanner.nextInt();
        System.out.print("How much money will you pay for this trade?");
        int sCash = scanner.nextInt();

        //Confirm trade
        System.out.printf("Player %d, do you want trade %s and $%d for %s and $%d? y/n ", trader+1,
                gb.cells[rProp].getName(), rCash, gb.cells[sProp].getName(), sCash);
        String in = scanner.next();
        if(in.matches("y")){
            money+=rCash;
            money-=sCash;
            gb.players[trader].setMoney(gb.players[trader].getMoney()+sCash);
            gb.players[trader].setMoney(gb.players[trader].getMoney()-rCash);

            OwnedCell oc = (OwnedCell)gb.cells[rProp];
            oc.setOwner(playerId);
            oc = (OwnedCell)gb.cells[sProp];
            oc.setOwner(trader);
        }
        else{
            System.out.printf("Player %d declined the trade.\n", trader+1);
        }
    }


}
