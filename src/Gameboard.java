/**
 * Created by Andrew on 11/24/2015.
 */
public class Gameboard {

    final int[] BOARDCELLNUMS = {0,2,4,7,10,17,20,22,30,33,36,38};
    final int[] SPECIALCELLS = {5,12,15,25,28,35};
    public BoardCell[] cells = new BoardCell[40];
    public Player[] players = new Player[4];


    Gameboard() {
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
