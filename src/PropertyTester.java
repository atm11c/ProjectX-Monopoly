/**
 * Created by Miller on 11/19/2015.
 */
public class PropertyTester {
    public static void main(String[] args){
        final int[] BOARDCELLNUMS = {0,2,4,7,10,17,20,22,30,33,36,38};
        final int[] SPECIALCELLS = {5,12,15,25,28,35};
        BoardCell[] cells = new BoardCell[40];
        OwnedCell[] oCells = new OwnedCell[40];
        Property[] properties = new Property[40];
        for(int i=0;i<cells.length;i++){
            if(contains(BOARDCELLNUMS, i)) {
                cells[i] = new BoardCell(i);
                System.out.printf("Cell: %d, Name: %s\n", cells[i].getCellId(), cells[i].getName());
            }
            else {
                cells[i] = new OwnedCell(i);
                oCells[i] = new OwnedCell(i);

                String spec = " ";
                if(contains(SPECIALCELLS,i)){
                    if(oCells[i].getisRR())
                        spec = "railroad";
                    else if(oCells[i].getisUtil())
                        spec = "utility";

                    System.out.printf("Cell: %d, Name: %s, Price: %d, Mortgage: %d Type: %s \n", cells[i].getCellId(), cells[i].getName(),
                            oCells[i].getPrice(), oCells[i].getMortgage(), spec);
                }
                else {
                    properties[i] = new Property(i);

                    System.out.printf("Cell: %d, Name: %s, Price: %d, Mortgage: %d RENT: %d,%d,%d,%d,%d,%d , RowNum: %d, Color: %s \n", cells[i].getCellId(), cells[i].getName(),
                     oCells[i].getPrice(), oCells[i].getMortgage(),properties[i].getRent0(),properties[i].getRent1(), properties[i].getRent2(),
                            properties[i].getRent3(),properties[i].getRent4(),properties[i].getRent5(), properties[i].getRowNum(), properties[i].getColor());


                }
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
