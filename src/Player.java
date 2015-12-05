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
    private int numProps;
    private int jailTurns;
    private int jailCards;
    private int numDubs;
    private boolean inJail, bankrupt,dubs;
    private boolean browns,lblues,pinks,oranges,reds,yellows,greens,dblues;
    private Scanner scanner = new Scanner(System.in);

    Player(int i){
        setMoney(1500);
        setRrOwned(0);
        setUtilOwned(0);
        setPlayerId(i);
        setPosition(0);
        setInJail(false);
        setJailTurns(0);
        setJailCards(0);
        setNumProps(0);
        setBankrupt(false);
    }

    /**
     * Set and Get methods
     */

    public void setMoney(int money) {
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

    public void setDubs(boolean dubs) {
        this.dubs = dubs;
    }

    public void setNumDubs(int numDubs) {
        this.numDubs = numDubs;
    }

    public void setInJail(boolean inJail) {
        this.inJail = inJail;
    }

    public void setBankrupt(boolean bankrupt) {
        this.bankrupt = bankrupt;
    }

    public void setJailCards(int jailCards) {
        this.jailCards = jailCards;
    }

    public void setNumProps(int numProps) {
        this.numProps = numProps;
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
    public void setJailTurns(int i){
        jailTurns = i;
    }

    //The Dream

    public int getNumDubs() {
        return numDubs;
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

    public int getNumProps() {
        return numProps;
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

    public int getJailCards() {
        return jailCards;
    }

    public int getJailTurns() {
        return jailTurns;
    }

    public boolean isInJail() {
        return inJail;
    }

    public boolean isDubs() {
        return dubs;
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

    public boolean isBankrupt() {
        return bankrupt;
    }

    /**
     *  Method canAfford
     *  Checks to see if the player can afford a transaction
     */
    public boolean canAfford(int price){
        boolean flag = true;
        if(money < price){
            setBankrupt(true);
            money = 0;
            flag = false;
        }
        else{
            money-=price;
        }

        return flag;
    }

    /**
     * Method takeTurn
     * Simulates a turn taken by a player.
     *
     */
    public void takeTurn(Gameboard gb){
        gb.setMessage("");

        //If the player is in Jail...
        if(inJail){
            if(jailCards > 0) {
                gb.addToMessage("Used a Get Out of Jail Free Card!\n");
                jailCards-=1;
                setInJail(false);
                jailTurns = 0;
                dubs = false;
                gb.setCurrentPlayer((gb.getCurrentPlayer()+1)%4);
            }
            else {
                JailFrame jailFrame = new JailFrame( gb);

                //after 3 turns in jail, force payment.
                if (jailTurns == 3) {
                    gb.addToMessage("Payment forced!\n");
                    if (canAfford(50)) {
                        setInJail(false);
                        jailTurns = 0;
                    }
                }
            }
        }
        else {
            Random random = new Random();
            int die1 = random.nextInt(6) + 1;
            int die2 = random.nextInt(6) + 1;
            setRoll(die1 + die2);


            gb.addToMessage("You rolled a " + roll + "!\n");

            //check if doubles were rolled.
            if (die1 == die2) {
                gb.addToMessage("DOUBLES\n");
                dubs = true;
                //numDubs+=1;
            } else
                dubs = false;

            //Move the player...
            //If player passes go, collect $200
            if (position + roll > 39) {
                gb.addToMessage("You Passed go!\n");
                money += 200;
            }

            //Set the player's new Position
            position += roll;
            position %= 40;
            gb.addToMessage("New position: " + gb.cells[position].getName() + "\n");
            //Check the cell to see what happens
            checkCell(gb);

            gb.addToMessage("End Roll!\n");
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
            buySpec(gb);
        }
        else
            buyCell(gb);
    }

    /**
     *  Method effectCell
     *  If the player landed on a cell that is not buyable, then this method resolves the effects of that cell.
     */
    private void effectCell(Gameboard gb){
        int derp;
        boolean chance = false;
        switch(position){
            //Go
            case 0:
                break;
            //S. Community Chest
            case 2:
                gb.addToMessage("Community Chest\n");
                derp = gb.chestCards.remove(0);
                gb.shuffleCards();
                checkChestCard(gb,derp);
                break;
            //Income Tax
            case 4:
                gb.addToMessage("INCOME TAX: Lose $200\n");
                canAfford(200);
                break;
            //S. Chance
            case 7:
                derp = gb.chanceCards.remove(0);
                gb.shuffleCards();
                chance = true;
                checkChanceCard(gb, derp);
                break;
            //Jail
            case 10:
                if(isInJail()) {
                    gb.addToMessage("Getting out of Jail NYI\n");
                }
                else
                    gb.addToMessage("Just visiting...\n");
                break;
            //W. Community Chest
            case 17:
                gb.addToMessage("Community Chest\n");
                derp = gb.chestCards.remove(0);
                gb.shuffleCards();
                checkChestCard(gb, derp);
                break;
            //Free Parking
            case 20:
                break;
            //N. Chance
            case 22:
                gb.addToMessage("Chance!\n");
                derp = gb.chanceCards.remove(0);
                gb.shuffleCards();
                chance = true;
                checkChanceCard(gb, derp);
                break;
            //Go to Jail
            case 30:
                gb.addToMessage("Go to Jail!\n");
                setPosition(10);
                setInJail(true);
                break;
            //E. Community Chest
            case 33:
                gb.addToMessage("Community Chest\n");
                derp = gb.chestCards.remove(0);
                gb.shuffleCards();
                checkChestCard(gb, derp);
                break;
            //E. Chance
            case 36:
                gb.addToMessage("Chance\n");
                derp = gb.chanceCards.remove(0);
                gb.shuffleCards();
                chance = true;
                checkChanceCard(gb, derp);
                break;
            //Luxury Tax
            case 38:
                gb.addToMessage("Luxury Tax, pay $75\n");
                canAfford(75);
                break;
        }

        if(!chance && dubs && numDubs == 2){
            gb.addToMessage("Too many doubles!\n");
            numDubs=0;
            position=10;
            setInJail(true);
            gb.setCurrentPlayer((gb.getCurrentPlayer() + 1) % 4);
            gb.gameOver();
        }
        else if(!chance && dubs){
            numDubs+=1;
            gb.setCurrentPlayer((gb.getCurrentPlayer()) % 4);
            gb.gameOver();
        }
        else if(!chance && !dubs) {
            numDubs=0;
            gb.setCurrentPlayer((gb.getCurrentPlayer() + 1) % 4);
            gb.gameOver();
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
            RollFrame rollFrame = new RollFrame(gb);
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
            }

            gb.addToMessage("Player " + (property.getOwner()+1) + " owns this. You owe them $" + rent + ".\n");
            gb.players[property.getOwner()].setMoney(gb.players[property.getOwner()].getMoney() + rent);
            canAfford(rent);
            if(dubs && numDubs == 2){
                gb.addToMessage("Too many doubles\n");
                numDubs=0;
                position=10;
                setInJail(true);
                gb.setCurrentPlayer((gb.getCurrentPlayer() + 1) % 4);
                gb.gameOver();
            }
            else if(dubs){
                numDubs+=1;
                gb.setCurrentPlayer((gb.getCurrentPlayer()) % 4);
                gb.gameOver();
            }
            else if(!dubs) {
                numDubs=0;
                gb.setCurrentPlayer((gb.getCurrentPlayer() + 1) % 4);
                gb.gameOver();
            }
        }

        else {
            gb.addToMessage("You own this!\n");
            if(dubs && numDubs == 2){
                gb.addToMessage("Too many doubles\n");
                numDubs=0;
                position=10;
                setInJail(true);
                gb.setCurrentPlayer((gb.getCurrentPlayer() + 1) % 4);
                gb.gameOver();
            }
            else if(dubs){
                numDubs+=1;
                gb.setCurrentPlayer((gb.getCurrentPlayer()) % 4);
                gb.gameOver();
            }
            else if(!dubs) {
                numDubs=0;
                gb.setCurrentPlayer((gb.getCurrentPlayer() + 1) % 4);
                gb.gameOver();
            }
        }


    }

    /**
     *  Method buySpec
     *  For when a player lands on a utility or a railroad.
     */

    public void buySpec(Gameboard gb){
        OwnedCell ownedCell = (OwnedCell)gb.cells[position];

        //If unowned, prompt user to buy
        if(ownedCell.getOwner() == 10){
            RollFrame rollFrame = new RollFrame(gb);
        }
        //If another player owns this, pay up buttercup
        else if(ownedCell.getOwner() != playerId){
            //if the cell is a railroad...
            if(ownedCell.getisRR()){
                switch(gb.players[ownedCell.getOwner()].getRrOwned()){
                    case 1:
                        gb.addToMessage("Player " + (ownedCell.getOwner()+1) + " owns this. you owe them $25.\n");
                        gb.players[ownedCell.getOwner()].setMoney(gb.players[ownedCell.getOwner()].getMoney() + 25);
                        canAfford(25);
                        break;
                    case 2:
                        gb.addToMessage("Player " + (ownedCell.getOwner() + 1) + " owns this. you owe them $50.\n");
                        gb.players[ownedCell.getOwner()].setMoney(gb.players[ownedCell.getOwner()].getMoney() + 50);
                        canAfford(50);
                        break;
                    case 3:
                        gb.addToMessage("Player " + (ownedCell.getOwner() + 1) + " owns this. you owe them $100.\n");
                        gb.players[ownedCell.getOwner()].setMoney(gb.players[ownedCell.getOwner()].getMoney() + 100);
                        canAfford(100);
                        break;
                    case 4:
                        gb.addToMessage("Player " + (ownedCell.getOwner() + 1) + " owns this. you owe them $200.\n");
                        gb.players[ownedCell.getOwner()].setMoney(gb.players[ownedCell.getOwner()].getMoney() + 200);
                        canAfford(200);
                        break;

                }
                if(dubs && numDubs == 2){
                    gb.addToMessage("Too many doubles.\n");
                    position=10;
                    numDubs=0;
                    setInJail(true);
                    gb.setCurrentPlayer((gb.getCurrentPlayer() + 1) % 4);
                    gb.gameOver();
                }
                else if(dubs){
                    numDubs+=1;
                    gb.setCurrentPlayer((gb.getCurrentPlayer()) % 4);
                    gb.gameOver();
                }
                else if(!dubs) {
                    numDubs=0;
                    gb.setCurrentPlayer((gb.getCurrentPlayer() + 1) % 4);
                    gb.gameOver();
                }
            }
            //If it's a utility
            else if(ownedCell.getisUtil()){
                Random random = new Random();
                int d1 = random.nextInt(6)+1;
                int d2 = random.nextInt(6)+1;
                int sum = d1+d2;
                if(gb.players[ownedCell.getOwner()].utilOwned == 1){
                    gb.addToMessage("You rolled a " + sum + ", you owe Player " + (ownedCell.getOwner() +1) + " $" + sum *4 + ".\n");



                    gb.players[ownedCell.getOwner()].setMoney(gb.players[ownedCell.getOwner()].getMoney() + (sum*4));
                    canAfford(sum*4);
                }
                else if(gb.players[ownedCell.getOwner()].utilOwned== 2){
                    gb.addToMessage("You rolled a " + sum + ", you owe Player " + (ownedCell.getOwner() +1) + " $" + sum *10 + ".\n");
                    gb.players[ownedCell.getOwner()].setMoney(gb.players[ownedCell.getOwner()].getMoney() + (sum*10));
                    canAfford(sum*10);
                }

                if(dubs && numDubs == 2){
                    gb.addToMessage("Too many doubles.\n");
                    position=10;
                    numDubs=0;
                    setInJail(true);
                    gb.setCurrentPlayer((gb.getCurrentPlayer() + 1) % 4);
                    gb.gameOver();
                }
                else if(dubs){
                    numDubs+=1;
                    gb.setCurrentPlayer((gb.getCurrentPlayer()) % 4);
                    gb.gameOver();
                }
                else if(!dubs) {
                    numDubs=0;
                    gb.setCurrentPlayer((gb.getCurrentPlayer() + 1) % 4);
                    gb.gameOver();
                }
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


        }
        return flag;
    }

    /**
     *  Method playerProps
     *  Prints a specific player's owned properties
     */
    public String playerProps(Gameboard gb){
        OwnedCell oc;
        String derp="";
        derp = String.format("<html>Player %d owns the following properties:<br> \n", playerId+1);
        for(int i=0;i<gb.cells.length;i++){
            if(!Gameboard.contains(gb.BOARDCELLNUMS,i)){
                oc = (OwnedCell)gb.cells[i];
                if(oc.getOwner()==playerId){
                    derp += String.format("%s <br>", oc.getName());
                }
            }
        }
        derp+="</html>";
        return derp;
    }

    /**
     *  Method builder
     *  Checks to see which properties are available for improvement.
     */
    public boolean[] builder(Gameboard gb){
        Property prop1, prop2, prop3;
        int houses;
        boolean[] valid = new boolean[30];

        //check Brown properties
        prop1 = (Property)gb.cells[1];
        prop2 = (Property)gb.cells[3];
        if(checkSet(gb, "Brown")){
            houses = smallest(prop1.getNumHouses(),prop2.getNumHouses(),10);
            if(prop1.getNumHouses() == houses && prop1.getNumHouses() < 5){
                valid[0]=true;
            }
            if(prop2.getNumHouses() == houses && prop2.getNumHouses() < 5){
                valid[1]=true;
            }
        }

        //check Light Blue properties
        prop1 = (Property)gb.cells[6];
        prop2 = (Property)gb.cells[8];
        prop3 = (Property)gb.cells[9];
        if(checkSet(gb, "Light Blue")){
            houses = smallest(prop1.getNumHouses(),prop2.getNumHouses(),prop3.getNumHouses());
            if(prop1.getNumHouses() == houses && prop1.getNumHouses() < 5){
                valid[2]=true;
            }
            if(prop2.getNumHouses() == houses && prop2.getNumHouses() < 5){
                valid[3]=true;
            }
            if(prop3.getNumHouses() == houses && prop3.getNumHouses() < 5){
                valid[4]=true;
            }
        }

        //check Pink properties
        prop1 = (Property)gb.cells[11];
        prop2 = (Property)gb.cells[13];
        prop3 = (Property)gb.cells[14];
        if(checkSet(gb, "Pink")){
            houses = smallest(prop1.getNumHouses(),prop2.getNumHouses(),prop3.getNumHouses());
            if(prop1.getNumHouses() == houses && prop1.getNumHouses() < 5){
                valid[5]=true;
            }
            if(prop2.getNumHouses() == houses && prop2.getNumHouses() < 5){
                valid[6]=true;
            }
            if(prop3.getNumHouses() == houses && prop3.getNumHouses() < 5){
                valid[7]=true;
            }
        }

        //check Orange properties
        prop1 = (Property)gb.cells[16];
        prop2 = (Property)gb.cells[18];
        prop3 = (Property)gb.cells[19];
        if(checkSet(gb, "Orange")){
            houses = smallest(prop1.getNumHouses(),prop2.getNumHouses(),prop3.getNumHouses());
            if(prop1.getNumHouses() == houses && prop1.getNumHouses() < 5){
                valid[8]=true;
            }
            if(prop2.getNumHouses() == houses && prop2.getNumHouses() < 5){
                valid[9]=true;
            }
            if(prop3.getNumHouses() == houses && prop3.getNumHouses() < 5){
                valid[10]=true;
            }
        }

        //check Red properties
        prop1 = (Property)gb.cells[21];
        prop2 = (Property)gb.cells[23];
        prop3 = (Property)gb.cells[24];
        if(checkSet(gb, "Red")){
            houses = smallest(prop1.getNumHouses(),prop2.getNumHouses(),prop3.getNumHouses());
            if(prop1.getNumHouses() == houses && prop1.getNumHouses() < 5){
                valid[11]=true;
            }
            if(prop2.getNumHouses() == houses && prop2.getNumHouses() < 5){
                valid[12]=true;
            }
            if(prop3.getNumHouses() == houses && prop3.getNumHouses() < 5){
                valid[13]=true;
            }
        }

        //check Yellow properties
        prop1 = (Property)gb.cells[26];
        prop2 = (Property)gb.cells[27];
        prop3 = (Property)gb.cells[29];
        if(checkSet(gb, "Yellow")){
            houses = smallest(prop1.getNumHouses(),prop2.getNumHouses(),prop3.getNumHouses());
            if(prop1.getNumHouses() == houses && prop1.getNumHouses() < 5){
                valid[14]=true;
            }
            if(prop2.getNumHouses() == houses && prop2.getNumHouses() < 5){
                valid[15]=true;
            }
            if(prop3.getNumHouses() == houses && prop3.getNumHouses() < 5){
                valid[16]=true;
            }
        }

        //check Green properties
        prop1 = (Property)gb.cells[31];
        prop2 = (Property)gb.cells[32];
        prop3 = (Property)gb.cells[34];
        if(checkSet(gb, "Green")){
            houses = smallest(prop1.getNumHouses(),prop2.getNumHouses(),prop3.getNumHouses());
            if(prop1.getNumHouses() == houses && prop1.getNumHouses() < 5){
                valid[17]=true;
            }
            if(prop2.getNumHouses() == houses && prop2.getNumHouses() < 5){
                valid[18]=true;
            }
            if(prop3.getNumHouses() == houses && prop3.getNumHouses() < 5){
                valid[19]=true;
            }
        }

        //check Dark Blue properties
        prop1 = (Property)gb.cells[37];
        prop2 = (Property)gb.cells[39];
        if(checkSet(gb, "Dark Blue")){
            houses = smallest(prop1.getNumHouses(),prop2.getNumHouses(),10);
            if(prop1.getNumHouses() == houses && prop1.getNumHouses() < 5){
                valid[20]=true;
            }
            if(prop2.getNumHouses() == houses && prop2.getNumHouses() < 5){
                valid[21]=true;
            }
        }

        return valid;
    }

    /**
     *  Method smallest
     *  Returns the smallest of three integers
     */
    private int smallest(int p1, int p2, int p3){
        if(p1 <= p2 && p1 <= p3){
            return p1;
        }
        else if(p2 <= p1 && p2 <= p3){
            return p2;
        }
        else
            return p3;
    }

    /**
     *  Method checkChanceCard
     *  Checks the Chance card drawn
     */
    public void checkChanceCard(Gameboard gb, int x){
        switch(x){
            case 0:
                gb.addToMessage("Advance to Go!\nCollect$200\n");
                position=0;
                money+=200;
                break;
            case 1:
                gb.addToMessage("Advance to Illinois Ave!\nCollect $200 if you pass Go!\n");
                if(position > 24){
                    money+=200;
                }
                position=24;
                buyCell(gb);
                break;
            case 2:
                gb.addToMessage("Advance to St. Charles Place\nCollect $200 if you pass Go!\n");
                if(position > 11){
                    money+=200;
                }
                position=11;
                buyCell(gb);
                break;
            case 3:
                gb.addToMessage("Advance to Nearest Utility!\n");
                if(position > 29){
                    money+=200;
                }
                if(position>12 && position>28){
                    position = 28;
                }
                else{
                    position = 12;
                }
                buySpec(gb);
                break;
            case 4:
                gb.addToMessage("Advance Token to Nearest Railroad!\n");
                if(position == 7){
                    position = 15;
                }
                else if(position == 22){
                    position = 25;
                }
                else{
                    money+=200;
                    position = 5;
                }
                buySpec(gb);
                break;
            case 5:
                gb.addToMessage("Bank pays you Divedend!\nCollect $50\n");
                money+=50;
                break;
            case 6:
                gb.addToMessage("Go Back 3 Spaces!\n");

                if(position==7) {
                    position -= 3;
                    effectCell(gb);
                }
                else if(position==22){
                    position-=3;
                    buyCell(gb);
                }
                else if(position==36){
                    position-=3;
                    effectCell(gb);
                }

                checkCell(gb);
                break;
            case 7:
                gb.addToMessage("Go to Jail!\n");
                position=10;
                setInJail(true);
                break;
            case 8:
                gb.addToMessage("General Property Repairs!\nPay $25/House and $100/Hotel\n");
                Property prop;
                int houses = 0;
                int hotels = 0;
                for(int i=0;i<gb.cells.length;i++){
                    if(!Gameboard.contains(gb.BOARDCELLNUMS,i) && !Gameboard.contains(gb.SPECIALCELLS,i)){
                        prop = (Property)gb.cells[i];
                        if(prop.getOwner() == playerId){
                            if(prop.getNumHouses() < 5){
                                houses+=prop.getNumHouses();
                            }
                            else{
                                hotels+=1;
                            }
                        }
                    }
                }
                int total = (houses * 25) + (hotels * 100);
                gb.addToMessage("Payed $" + total + " !.\n");
                canAfford(total);
                break;
            case 9:
                gb.addToMessage("Pay Poor Tax!\nPay $15!\n");
                canAfford(15);
                break;
            case 10:
                gb.addToMessage("Take a trip to the Reading Railroad!\nAdvance to Reading Railroad!\n");

                money+=200;
                position=5;
                buySpec(gb);
                break;
            case 11:
                gb.addToMessage("Take a Walk on Boardwalk!\nAdvance to Boardwalk!\n");
                position=39;
                buyCell(gb);
                break;
            case 12:
                gb.addToMessage("Elected Chairman of the Board!\nPay each player $50!\n");
                for(int i=0;i<gb.players.length;i++){
                    if(i != playerId){
                        canAfford(50);
                        gb.players[i].setMoney(gb.players[i].getMoney()+50);
                    }
                }
                break;
            case 13:
                gb.addToMessage("Get Out of Jail Free!\n");
                jailCards+=1;
                break;
            case 14:
                gb.addToMessage("Building Loan Matures!\nCollect $150\n");
                money+=150;
                break;
            case 15:
                gb.addToMessage("Advance Token to the Nearest Railroad!\n");
                if(position == 7){
                    position = 15;
                }
                else if(position == 22){
                    position = 25;
                }
                else{
                    money+=200;
                    position = 5;
                }
                buySpec(gb);
                break;



        }
    }

    /**
     *  Method checkChestCard
     *  Checks the Community Chest card drawn
     */

    public void checkChestCard(Gameboard gb,int y){
        switch (y){
            case 0:
                gb.addToMessage("Advance to Go!\nCollect $200!\n");
                position=0;
                money+=200;
                break;
            case 1:
                gb.addToMessage("Bank Error in Your Favor!\nCollect $200!\n");
                money+=200;
                break;
            case 2:
                gb.addToMessage("Doctor's Fees!\nPay $50!\n");

                canAfford(50);
                break;
            case 3:
                gb.addToMessage("Sale of Stock!\nCollect $50!\n");

                money+=50;
                break;
            case 4:
                gb.addToMessage("Get out of Jail Free!\n");

                jailCards+=1;
                break;
            case 5:
                gb.addToMessage("Go Directly to Jail!\n");

                position = 10;
                setInJail(true);
                break;
            case 6:
                gb.addToMessage("Grand Opera Opening!\nCollect $50 from every player!\n");
                for(int i=0;i<gb.players.length;i++){
                    if(i != playerId){
                        money+=50;
                        gb.players[i].canAfford(50);
                    }
                }
                break;
            case 7:
                gb.addToMessage("Holiday Fund Matures\nCollect $100!\n");
                money+=100;
                break;
            case 8:
                gb.addToMessage("Income Tax Refund!\nCollect $20!\n");
                money+=20;
                break;
            case 9:
                gb.addToMessage("Life Insurance Matures!\nCollect $100!\n");
                money+=100;
                break;
            case 10:
                gb.addToMessage("Pay Hospital Fees!\nPay $100!\n");
                canAfford(100);
                break;
            case 11:
                gb.addToMessage("Pay School Fees!\nPay $150\n");
                canAfford(150);
                break;
            case 12:
                gb.addToMessage("Receive Consultancy Fee!\nCollect $25!\n");
                money+=25;
                break;
            case 13:
                gb.addToMessage("Street Repairs!\n$40/House and $115/Hotel\n");
                Property prop;
                int houses = 0;
                int hotels = 0;
                for(int i=0;i<gb.cells.length;i++){
                    if(!Gameboard.contains(gb.BOARDCELLNUMS,i) && !Gameboard.contains(gb.SPECIALCELLS,i)){
                        prop = (Property)gb.cells[i];
                        if(prop.getOwner() == playerId){
                            if(prop.getNumHouses() < 5){
                                houses+=prop.getNumHouses();
                            }
                            else{
                                hotels+=1;
                            }
                        }
                    }
                }
                int total = (houses * 40) + (hotels * 115);
                gb.addToMessage("Payed $" + total + "!\n");
                canAfford(total);
                break;
            case 14:
                gb.addToMessage("2nd Place in Beauty Contest!\nCollect $10!\n");
                money+=10;
                break;
            case 15:
                gb.addToMessage("Collect Inheritance!\nCollect $100!\n");
                money+=100;
                break;
        }
    }

    /**
     *  Mehthod tradeable
     *  returns a boolean array to display which properties of a player are tradeable
     */
    public boolean[] tradeable(Gameboard gb){
        boolean[] valid = new boolean[28];
        OwnedCell ownedCell;
        int counter=0;
        for(int i=0;i<gb.cells.length;i++){
            if(!Gameboard.contains(gb.BOARDCELLNUMS, i)){
                ownedCell=(OwnedCell)gb.cells[i];
                if(ownedCell.getOwner()==playerId){
                    valid[counter]=true;
                }
                counter+=1;
            }
        }

        return valid;
    }

    /**
     *  Method totalUp
     *  finds the players total value of cash, properties, and houses
     */
    public int totalUp(Gameboard gb){
        int total=0;

        for(int i=0;i<gb.cells.length;i++){
            if(!Gameboard.contains(gb.BOARDCELLNUMS,i) && Gameboard.contains(gb.SPECIALCELLS,i)){
                OwnedCell oc = (OwnedCell)gb.cells[i];
                if(oc.getOwner() == playerId){
                    total+=oc.getPrice();
                }
            }
            else if(!Gameboard.contains(gb.BOARDCELLNUMS,i)){
                Property prop = (Property)gb.cells[i];
                if(prop.getOwner() == playerId){
                    total+=prop.getPrice();
                    total+=(prop.getNumHouses()*(prop.getRowNum()*50));
                }
            }
        }

        total+=money;

        return total;
    }

}
