/**
 * Created by Andrew on 11/18/2015.
 */
public class Railroad extends OwnedCell {

    private int rent;
    private int rrId;

    Railroad(int i){
        super(i);
        setRent(i);
        setRrId(i);
    }

    public void setRent(int i){
        rent = i;
    }

    public int getRent(){
        return rent;
    }

    public void setRrId(int i){
        rrId = i;
    }

    public int getRrId(){
        return rrId;
    }
}
