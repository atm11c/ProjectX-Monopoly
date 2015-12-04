/**
 * Created by Andrew on 12/4/2015.
 */
public class Trade {
    private int aProperty;
    private int bProperty;
    private int aMoney;
    private int bMoney;
    private Player playerA;
    private Player playerB;

    Trade(){
        setaProperty(0);
        setbProperty(0);
        setaMoney(0);
        setbMoney(0);
        setPlayerA(new Player(75));
        setPlayerB(new Player(76));
    }

    /**
     *  Set and Get methods
     */
    public void setaProperty(int aProperty) {
        this.aProperty = aProperty;
    }

    public void setbProperty(int bProperty) {
        this.bProperty = bProperty;
    }

    public void setaMoney(int aMoney) {
        this.aMoney = aMoney;
    }

    public void setbMoney(int bMoney) {
        this.bMoney = bMoney;
    }

    public void setPlayerA(Player playerA) {
        this.playerA = playerA;
    }

    public void setPlayerB(Player playerB) {
        this.playerB = playerB;
    }

    public int getaMoney() {
        return aMoney;
    }

    public int getaProperty() {
        return aProperty;
    }

    public int getbMoney() {
        return bMoney;
    }

    public int getbProperty() {
        return bProperty;
    }

    public Player getPlayerA() {
        return playerA;
    }

    public Player getPlayerB() {
        return playerB;
    }

    public void finalize(Gameboard gb){
        //Send PlayerA's money to PlayerB
        playerA.canAfford(aMoney);
        playerB.setMoney(playerB.getMoney()+aMoney);

        //Send PlayerB's money to PlayerA
        playerB.canAfford(bMoney);
        playerA.setMoney(playerA.getMoney()+bMoney);

        //Exchange Properties
        OwnedCell cellA = (OwnedCell)gb.cells[aProperty];
        OwnedCell cellB = (OwnedCell)gb.cells[bProperty];

        cellA.setOwner(playerB.getPlayerId());
        cellB.setOwner(playerA.getPlayerId());

    }

}
