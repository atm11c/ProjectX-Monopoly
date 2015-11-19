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
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setSize( 600, 400 );
        frame.setVisible( true );
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
                gFrame.setSize( 1000, 1000 );
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

        JButton dumb[] = new JButton[40];
        //JLabel dumb[] =  new JLabel[40];

        ImageIcon man = new ImageIcon( this.getClass().getResource("Monopoly-artwork-detail.jpg"));
        JLabel pic = new JLabel(man);

        for(int i = 0; i < 40; i++){
            dumb[i] = new JButton("Diddle");
            //dumb[i] = new JLabel("test");
            dumb[i].setSize(100,100);
            //dumb[i].setIcon(man);
        }

        t1 = new JPanel();
        t2 = new JPanel();
        t3 = new JPanel();
        t4 = new JPanel();

        t1.setLayout(new GridLayout(1,10));
        t1.setPreferredSize(new Dimension(1000,100));
        t2.setLayout(new GridLayout(1,10));
        t2.setPreferredSize(new Dimension(1000,100));
        t3.setLayout(new GridLayout(8,1));
        t3.setPreferredSize(new Dimension(100,800));
        t4.setLayout(new GridLayout(8,1));
        t4.setPreferredSize(new Dimension(100,800));

        int counter = 0;
        for(int i = 0; i < 10; i++){

            t1.add(dumb[counter]);
            counter++;
            t2.add(dumb[counter]);
            counter++;
        }

        for(int i = 0; i < 8;i++){
            t3.add(dumb[counter]);
            counter++;
            t4.add(dumb[counter]);
            counter++;
        }

        add(t1, BorderLayout.NORTH);
        add(t2, BorderLayout.SOUTH);
        add(t3, BorderLayout.EAST);
        add(t4, BorderLayout.WEST);
        add(pic, BorderLayout.CENTER);

    }
}

