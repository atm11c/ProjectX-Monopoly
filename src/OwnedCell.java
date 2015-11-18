/**
 * Created by Andrew on 11/18/2015.
 */
public class OwnedCell extends BoardCell {
    //private Player owner;
    private int price;
    private int mortgage;
    private boolean owned;

    OwnedCell(int i){
        super(i);
        setPrice(i);
        setMortgage(i);
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
