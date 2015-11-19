/**
 * Created by Miller on 11/19/2015.
 */
public class PropertyTester {
    public static void main(String[] args){
        final int[] BOARDCELLNUMS = {0,2,4,7,10,17,20,22,30,33,36,38};
        BoardCell[] cells = new BoardCell[40];

        for(int i=0;i<cells.length;i++){
            if(contains(BOARDCELLNUMS, i)) {
                cells[i] = new BoardCell(i);
                System.out.printf("%d, %s\n", cells[i].getCellId(), cells[i].getName());
            }
            else
                cells[i] = new BoardCell(39);
        }


    }

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
