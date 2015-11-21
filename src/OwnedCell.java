/**
 * Created by Andrew on 11/18/2015.
 */
public class OwnedCell extends BoardCell {
    private final int[] PRICES = {0,60,0,60,0,200,100,0,100,120,0,140,150,140,160,200,180,0,180,200,0,220,0,220,240,200,
        260,260,150,280,0,300,300,0,320,200,0,350,0,400};

    private final int[] MORTS = {0,30,0,30,0,100,50,0,50,60,0,70,75,70,80,100,90,0,90,100,0,110,0,110,120,100,130,130,
            75,140,0,150,150,0,160,100,0,175,0,200};
    //private Player owner;
    private int price;
    private int mortgage;
    private boolean owned;

    OwnedCell(int i){
        super(i);
        setPrice(PRICES[i]);
        setMortgage(MORTS[i]);
        setOwned(false);
    }

    /**
     * Set and Get methods
     */
    public void setPrice(int i){
        price = i;
    }

    public int getPrice(){
        return price;
    }

    public void setMortgage(int i){
        mortgage = i;
    }

    public int getMortgage(){
        return mortgage;
    }

    public void setOwned(boolean b){
        owned = b;
    }

    //THE DREAM
    public boolean getOwned(){
        return owned;
    }

}
