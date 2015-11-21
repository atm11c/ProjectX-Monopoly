/**
 * Created by Miller on 11/19/2015.
 */
public class PropertyTester {
    public static void main(String[] args){
        final int[] BOARDCELLNUMS = {0,2,4,7,10,17,20,22,30,33,36,38};
        BoardCell[] cells = new BoardCell[40];
        OwnedCell[] oCells = new OwnedCell[40];

        for(int i=0;i<cells.length;i++){
            if(contains(BOARDCELLNUMS, i)) {
                cells[i] = new BoardCell(i);
                System.out.printf("Cell: %d, Name: %s\n", cells[i].getCellId(), cells[i].getName());
            }
            else {
                cells[i] = new OwnedCell(i);
                oCells[i] = new OwnedCell(i);
                System.out.printf("Cell: %d, Name: %s, Price: %d, Mortgage: %d \n", cells[i].getCellId(), cells[i].getName(),
                        oCells[i].getPrice(), oCells[i].getMortgage());
            }
        }


    }

    /**
     *Method to test if an integer value is in an array
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

}
