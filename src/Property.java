/**
 * Created by Andrew on 11/18/2015.
 */
public class Property extends OwnedCell {

    private final String[] COLORS = {"Brown", "Light Blue", "Pink", "Orange", "Red", "Yellow", "Green", "Dark Blue"};
    private final int[] RENT0 = {0,2,0,4,0,0,6,0,6,8,0,10,0,10,12,0,14,0,14,16,0,18,0,18,20,0,22,22,0,24,
            0,26,26,0,28,0,0,35,0,50};
    private final int[] RENT1 = {0,10,0,20,0,0,30,0,30,40,0,50,0,50,60,0,70,0,70,80,0,90,0,90,100,0,110,110,0,120,0,
            0,130,130,0,150,0,0,175,0,200};
    private final int[] RENT2 = {0,30,0,60,0,0,90,0,90,100,0,150,0,150,180,0,200,0,200,220,0,250,0,250,300,0,330,330,0,360,
            0,390,390,0,450,0,0,500,0,600};
    private final int[] RENT3 = {0,90,0,180,0,0,270,0,270,300,0,450,0,450,500,0,550,0,550,600,0,700,0,700,750,0,800,800,0,850,
            0,900,900,0,1000,0,0,1100,0,1400};
    private final int[] RENT4 = {0,160,0,320,0,0,400,0,400,450,0,625,0,625,700,0,750,0,750,800,0,875,0,875,925,0,975,975,0,1025,
            0,1100,1100,0,1200,0,0,1300,0,1700};
    private final int[] RENT5 = {0,250,0,450,0,0,550,0,550,600,0,750,0,750,900,0,950,0,950,1000,0,1050,0,1050,1100,0,1150,1150,0,1200,
            0,1275,1275,0,1400,0,0,1500,0,2000};

    private String color;
    private int rent0,rent1,rent2,rent3,rent4,rent5;
    private int numHouses;
    private int rowNum;

    Property(int i){
        super(i);
        setColor(COLORS[i/5]);
        setRent0(RENT0[i]);
        setRent1(RENT1[i]);
        setRent2(RENT2[i]);
        setRent3(RENT3[i]);
        setRent4(RENT4[i]);
        setRent5(RENT5[i]);
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
