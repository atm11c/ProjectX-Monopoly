import java.util.Random;

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

    public void takeTurn(Gameboard gb){
        int numDubs = 0;
        boolean dubs = true;
        Random random = new Random();


        while(dubs){
            System.out.printf("Current position: %s\n", gb.cells[getPosition()].getName());
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
                if(numDubs == 3){
                    System.out.println("Going to Jail for too many doubles...");
                    setPosition(10);
                    setInJail(true);
                    break;
                }
            }
            else
                dubs = false;

            //Move the player...
            setPosition((getPosition()+roll)%40);
            System.out.printf("New position: %s\n", gb.cells[getPosition()].getName());

            //Check the cell to see what happens
            checkCell(gb, getPosition());
        }


    }

    private void checkCell(Gameboard gb, int position){
        if(gb.contains(gb.BOARDCELLNUMS, position)){
            System.out.println("Effect cells NYI");
        }

        else if(gb.contains(gb.SPECIALCELLS, position)){
            System.out.println("Utils and RRs NYI");
        }

        else {
            System.out.println("Buying NYI");
        }
    }
}
