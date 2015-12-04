import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Andrew on 11/24/2015.
 */
public class Gameboard {

    final int[] BOARDCELLNUMS = {0,2,4,7,10,17,20,22,30,33,36,38};
    final int[] SPECIALCELLS = {5,12,15,25,28,35};
    final int[] TRADETOCELLS = {1,3,5,6,8,9,11,12,13,14,15,16,18,19,21,23,24,25,26,27,28,29,31,32,34,35,37,39};
    public BoardCell[] cells = new BoardCell[40];
    public Player[] players = new Player[4];
    private int currentPlayer;
    private String message;


    public List<Integer> chestCards = new ArrayList<>();
    public List<Integer> chanceCards = new ArrayList<>();

    Gameboard() {

        shuffleCards();

        //Initialize the board
        for (int i = 0; i < cells.length; i++) {
            if (contains(BOARDCELLNUMS, i)) {
                cells[i] = new BoardCell(i);
            } else if (contains(SPECIALCELLS, i)) {
                cells[i] = new OwnedCell(i);
            } else
                cells[i] = new Property(i);
        }

        for(int i=0;i<players.length;i++){
            players[i] = new Player(i);
        }
        setCurrentPlayer(0);

    }

    public void setCells(BoardCell[] cells) {
        this.cells = cells;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void addToMessage(String s) {
       message = message + s;
    }
    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void shuffleCards(){
        if(chestCards.isEmpty()){
            for(int i = 0; i < 16; i++){
                chestCards.add(i);
            }
            Collections.shuffle(chestCards);
        }

        if(chanceCards.isEmpty()){
            for(int i = 0; i < 16; i++){
                chanceCards.add(i);
            }
            Collections.shuffle(chanceCards);
        }
    }

    /**
     * Method to test if an integer value is in an array
     */
    public static boolean contains(int[] arr, int key){
        boolean b = false;
        for(int i=0;i<arr.length;i++){
            if(arr[i] == key){
                b = true;
                break;
            }
        }

        return b;
    }

    /**
     *  Method showPropertyOwners
     *  Method prints all of the properties and the players that own them.
     */
    public void showPropertyOwners(){
        for(int i=0;i<cells.length;i++){
            if(!contains(BOARDCELLNUMS,i)){
                OwnedCell oc = (OwnedCell)cells[i];
                String owner;
                if(oc.getOwner() == 10){
                    owner = "Unowned";
                }
                else{
                    owner = "Player " + (oc.getOwner()+1);
                }
                System.out.printf("%s, Owner: %s\n",oc.getName() ,owner);
            }
        }
    }

}
