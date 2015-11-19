/**
 * Created by Andrew on 11/18/2015.
 */
public class BoardCell {
    //The cell names
    final private String[] NAMES = {"Go", "Mediterranean Avenue", "Community Chest", "Baltic Avenue", "Income Tax",
            "Reading Railroad", "Oriental Avenue", "Chance", "Vermont Avenue", "Connecticut Avenue", "Jail",
            "St. Charles Place", "Electric Company", "States Avenue", "Virginia Avenue", "Pennsylvania Railroad",
            "St. James Place", "Community Chest", "Tennessee Avenue", "New York Avenue", "Free Parking",
            "Kentucky Avenue", "Chance", "Indiana Avenue", "Illinois Avenue", "B&O Railroad", "Atlantic Avenue",
            "Ventnor Avenue", "Water Works", "Marvin Gardens", "Go to Jail", "Pacific Avenue", "North Carolina Avenue",
            "Community Chest", "Pennsylvania Avenue", "Short Line", "Chance", "Park Place", "Luxury Tax", "Boardwalk"};

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
