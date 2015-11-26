/**
 * Created by Andrew on 11/18/2015.
 */
public class BoardCell {
    //The cell names
    final private String[] NAMES = {"Go", "Mediterranean Avenue", "S. Community Chest", "Baltic Avenue", "Income Tax",
            "Reading Railroad", "Oriental Avenue", "S. Chance", "Vermont Avenue", "Connecticut Avenue", "Jail",
            "St. Charles Place", "Electric Company", "States Avenue", "Virginia Avenue", "Pennsylvania Railroad",
            "St. James Place", "W. Community Chest", "Tennessee Avenue", "New York Avenue", "Free Parking",
            "Kentucky Avenue", "N. Chance", "Indiana Avenue", "Illinois Avenue", "B&O Railroad", "Atlantic Avenue",
            "Ventnor Avenue", "Water Works", "Marvin Gardens", "Go to Jail", "Pacific Avenue", "North Carolina Avenue",
            "E. Community Chest", "Pennsylvania Avenue", "Short Line", "E. Chance", "Park Place", "Luxury Tax", "Boardwalk"};

    private int cellId;
    private String name;

    BoardCell(int i){
        setCellId(i);
        setName(NAMES[i]);
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
