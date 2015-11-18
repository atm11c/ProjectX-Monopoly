/**
 * Created by Andrew on 11/18/2015.
 */
public class Utility extends OwnedCell{

    private int rent;
    private int utilId;
    Utility(int i){
        super(i);
        setRent(i);
        setUtilId(i);
    }

    public void setRent(int i){
        rent = i;
    }

    public int getRent(){
        return rent;
    }

    public void setUtilId(int i){
        utilId = i;
    }

    public int getUtilId(){
        return utilId;
    }
}
