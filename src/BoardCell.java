/**
 * Created by Andrew on 11/18/2015.
 */
public class BoardCell {
    private int cellId;
    private String name;

    BoardCell(int i){
        setCellId(i);
        setName("hurr");
    }

    /**
     * Set and Get methods
     */
    public void setCellId(int i){
        cellId = i;
    }

    public int getCellId(){
        return cellId;
    }

    public void setName(String s){
        name = s;
    }

    public String getName(){
        return name;
    }

}
