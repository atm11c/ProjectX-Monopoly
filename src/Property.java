/**
 * Created by Andrew on 11/18/2015.
 */
public class Property extends OwnedCell {

    private final String[] COLORS = {"Brown", "Light Blue", "Pink", "Orange", "Red", "Yellow", "Green", "Dark Blue"};

    private String color;
    private int rent0,rent1,rent2,rent3,rent4,rent5;
    private int numHouses;
    private int rowNum;

    Property(int i){
        super(i);
        setColor(COLORS[i/5]);
        setRent0(i);
        setRent1(i);
        setRent2(i);
        setRent3(i);
        setRent4(i);
        setRent5(i);
        setNumHouses(0);
        setRowNum(getCellId()/10+1);
    }

    /**
     * Get and Set methods
     */
    public void setColor(String s){
        color = s;
    }

    public String getColor(){
        return color;
    }

    public void setRent0(int i){
        rent0 = i;
    }

    public int getRent0(){
        return rent0;
    }

    public void setRent1(int i){
        rent1 = i;
    }

    public int getRent1(){
        return rent1;
    }

    public void setRent2(int i){
        rent2 = i;
    }

    public int getRent2(){
        return rent2;
    }

    public void setRent3(int i){
        rent3 = i;
    }

    public int getRent3(){
        return rent3;
    }

    public void setRent4(int i){
        rent4 = i;
    }

    public int getRent4(){
        return rent4;
    }

    public void setRent5(int i){
        rent5 = i;
    }

    public int getRent5(){
        return rent5;
    }

    public void setNumHouses(int i){
        numHouses = i;
    }

    public int getNumHouses(){
        return numHouses;
    }

    public void setRowNum(int i){
        rowNum = i;
    }

    public int getRowNum(){
        return rowNum;
    }
}
