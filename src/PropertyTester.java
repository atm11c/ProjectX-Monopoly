import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

/**
 * Created by Miller on 11/19/2015.
 */
public class PropertyTester {
    public static Gameboard gb = new Gameboard();
    public static void main(String[] args){

        JFrame frame = new JFrame("Monopoly!");
        MenuPanel mPanel = new MenuPanel(gb);

        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth()/2 - frame.getWidth())/2);
        int y = (int) ((dimension.getHeight()/2 - frame.getHeight()) / 2);

        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setSize( 600, 400 );
        frame.setVisible( true );
        frame.setLocation(x, y);
        frame.add(mPanel);
    }
}
