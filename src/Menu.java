import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

/**
 * Created by Timothy on 11/19/2015.
 */


public class Menu {

    public static void main(String[] args){
        JFrame frame = new JFrame("Monopoly!");
        MenuPanel mPanel = new MenuPanel();

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


class MenuPanel extends JPanel{

    private JButton start, quit, credits;
    private JButton n1, n2, n3, n4, n5, n6;
    private BufferedImage bi = null;

    public MenuPanel(){

        JPanel derp = new JPanel();

        n1 = new JButton("");
        n2 = new JButton("");
        n3 = new JButton("");
        n4 = new JButton("");
        n5 = new JButton("");
        n6 = new JButton("");

        n1.setVisible(false);
        n2.setVisible(false);
        n3.setVisible(false);
        n4.setVisible(false);
        n5.setVisible(false);
        n6.setVisible(false);


        start = new JButton("Start");
        quit = new JButton("Quit");
        credits = new JButton("Credits");

        GridLayout gLayout = new GridLayout(3,3);
        setLayout(gLayout);
        derp.setLayout(gLayout);


        //ImageIcon man = new ImageIcon( this.getClass().getResource("Monopoly-artwork-detail.jpg"));
        ImageIcon man = new ImageIcon( this.getClass().getResource("monopoly-man.png"));
        JLabel pic = new JLabel(man);

        add(pic);

        derp.add(n1);
        derp.add(start);
        derp.add(n2);

        derp.add(n3);
        derp.add(credits);
        derp.add(n4);

        derp.add(n5);
        derp.add(quit);
        derp.add(n6);

        Box box = Box.createVerticalBox();
        box.add(derp);

        add(box, BorderLayout.CENTER);

        ButtonHandler bHandler = new ButtonHandler();
        start.addActionListener(bHandler);
        credits.addActionListener(bHandler);
        quit.addActionListener(bHandler);
    }

    private class ButtonHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            if(event.getSource() == start){
                JFrame gFrame = new JFrame("Game Board");
                BoardPanel test1 = new BoardPanel();

                gFrame.setSize( 1100, 1100 );
                gFrame.setResizable(false);
                gFrame.setVisible( true );
                gFrame.add(test1);

            }
            if(event.getSource() == quit){
                System.exit(1);
            }
            if(event.getSource() == credits){
                String cred = "Prepare for a ruuuudddeee Diddling";

                ImageIcon diddle = new ImageIcon( this.getClass().getResource("Monopoly-artwork-detail.jpg"));
                JLabel dPic = new JLabel(diddle);

                JOptionPane.showMessageDialog(null, cred);
                JOptionPane.showMessageDialog(null, dPic, cred, JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

}

class BoardPanel extends JPanel
{
    public BoardPanel(){

        setLayout(new BorderLayout());
        JPanel t1, t2, t3, t4;

        JButton dumb[] = new JButton[44];
        //JLabel dumb[] =  new JLabel[40];

        ImageIcon man = new ImageIcon( this.getClass().getResource("Monopoly-artwork-detail.jpg"));
        JLabel pic = new JLabel(man);

        for(int i = 0; i < 44; i++){


            if(i == 2 || i == 4  || i == 7  || i == 9 || i == 10  || i == 12  || i == 14 || i == 15
                      || i == 17 || i == 19 || i == 20 || i == 22 || i == 24 || i == 25 || i == 27
                      || i == 28 || i == 30 || i == 32 || i == 33 || i == 35 || i == 38 || i == 40) {
                dumb[i] = new JButton("Property");
            }else if(i == 6 || i == 16 || i == 26 || i == 36){
                dumb[i] = new JButton("Train");
            }else if(i == 3 || i == 18 || i == 34) {
                dumb[i] = new JButton("Chest");
            }else if(i == 8 || i == 23 || i == 37) {
                dumb[i] = new JButton("Chance");
            }else if(i == 5){
                dumb[i] = new JButton("Income Tax");
            }else if(i == 1) {
                dumb[i] = new JButton("Go");
            }else if(i == 11){
                dumb[i] = new JButton("Jail");
            }else if(i == 13){
                dumb[i] = new JButton("Electric");
            }else if(i == 21){
                dumb[i] = new JButton("Parking");
            }else if(i == 29){
                dumb[i] = new JButton("Water");
            }else if(i == 31){
                dumb[i] = new JButton("Go to Jail");
            }else if(i == 39){
                dumb[i] = new JButton("Lux Tax");
            }else {
                dumb[i] = new JButton("");
            }

            dumb[i].setSize(100,100);
        }

        t1 = new JPanel();
        t2 = new JPanel();

        t3 = new JPanel();
        t4 = new JPanel();

        t1.setLayout(new GridLayout(1,11));
        t1.setPreferredSize(new Dimension(1100,100));
        t2.setLayout(new GridLayout(1,11));
        t2.setPreferredSize(new Dimension(1100,100));

        t3.setLayout(new GridLayout(9,1));
        t3.setPreferredSize(new Dimension(100,900));
        t4.setLayout(new GridLayout(9,1));
        t4.setPreferredSize(new Dimension(100,900));

        for(int i = 11; i > 0; i--){
            t1.add(dumb[i]);
        }
        for(int i = 21; i >11; i--){
            t3.add(dumb[i]);
        }
        for(int i = 21; i < 32; i++){
            t2.add(dumb[i]);
        }
        for(int i = 32; i < 41; i++){
            t4.add(dumb[i]);
        }

        add(t1, BorderLayout.SOUTH);
        add(t2, BorderLayout.NORTH);

        add(t3, BorderLayout.WEST);
        add(t4, BorderLayout.EAST);

        add(pic, BorderLayout.CENTER);

    }
}

