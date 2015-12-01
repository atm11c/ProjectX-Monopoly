import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;


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

                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
                int width = (int)screenSize.getWidth();
                int height = (int)screenSize.getHeight();


                gFrame.setSize( width, height);
                gFrame.setResizable( false );
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

        setLayout(new GridLayout(1,2));

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)screenSize.getWidth();
        int height = (int)screenSize.getHeight();

        JPanel board, t1, t2, t3, t4;

        PlayerInfoPanel pan = new PlayerInfoPanel();

        add(pan);

        board = new JPanel();
        board.setLayout(new BorderLayout());


        JLabel dumb[] = new JLabel[44];


        ImageIcon Pieces[] = SetAllPieces();

        for(int i = 0; i < 40; i++){


            if(i == 2 || i == 4  || i == 7  || i == 9 || i == 10  || i == 12  || i == 14 || i == 15
                    || i == 17 || i == 19 || i == 20 || i == 22 || i == 24 || i == 25 || i == 27
                    || i == 28 || i == 30 || i == 32 || i == 33 || i == 35 || i == 38) {
                dumb[i] = new JLabel("Property",  SwingConstants.CENTER);

            }else if(i == 6 || i == 16 || i == 26 || i == 36){
                dumb[i] = new JLabel("Train",  SwingConstants.CENTER);
            }else if(i == 3 || i == 18 || i == 34) {
                dumb[i] = new JLabel("Chest",  SwingConstants.CENTER);
            }else if(i == 8 || i == 23 || i == 37) {
                dumb[i] = new JLabel("Chance",  SwingConstants.CENTER);
            }else if(i == 5){
                dumb[i] = new JLabel("Income Tax",  SwingConstants.CENTER);
            }else if(i == 1) {
                dumb[i] = new JLabel("Go", SwingConstants.CENTER);
            }else if(i == 11){
                dumb[i] = new JLabel("Jail",  SwingConstants.CENTER);
            }else if(i == 13){
                dumb[i] = new JLabel("Electric",  SwingConstants.CENTER);
            }else if(i == 21){
                dumb[i] = new JLabel("Parking",  SwingConstants.CENTER);
            }else if(i == 29){
                dumb[i] = new JLabel("Water",  SwingConstants.CENTER);
            }else if(i == 31){
                dumb[i] = new JLabel("Go to Jail",  SwingConstants.CENTER);
            }else if(i == 39){
                dumb[i] = new JLabel("Lux Tax",  SwingConstants.CENTER);
            }else {
                dumb[i] = new JLabel("", SwingConstants.CENTER);
            }

            dumb[i].setSize((width/2)/10,(width/2)/10);
        }

//        JLabel entity1 = new JLabel();
//        entity1.setIcon(new ImageIcon(this.getClass().getResource("test.png")));

//        dumb[1].setLayout(new BorderLayout());
        for(int i = 0; i <40 ; i++){
            dumb[i].setLayout(new BorderLayout());
            dumb[i].setIcon(Pieces[i]);
//            dumb[i].add(entity1, BorderLayout.SOUTH);
        }



//        JLabel entity2 = new JLabel();
//        JLabel entity3 = new JLabel();
//        JLabel entity4 = new JLabel();
//
//
//        dumb[1].add(entity1, BorderLayout.SOUTH);


        t1 = new JPanel();
        t2 = new JPanel();

        t3 = new JPanel();
        t4 = new JPanel();

        t1.setLayout(new GridLayout(1,11));
        t1.setPreferredSize(new Dimension((width/2)/10,100));
        t2.setLayout(new GridLayout(1,11));
        t2.setPreferredSize(new Dimension((width/2)/10,100));

        t3.setLayout(new GridLayout(9,1));
        t3.setPreferredSize(new Dimension(90,(height/2)/9));
        t4.setLayout(new GridLayout(9,1));
        t4.setPreferredSize(new Dimension(90,(height/2)/9));

        for(int i = 10; i >= 0; i--){
            t1.add(dumb[i]);
        }
        for(int i = 19; i > 10; i--){
            t3.add(dumb[i]);
        }
        for(int i = 20; i < 31; i++){
            t2.add(dumb[i]);
        }
        for(int i = 31; i < 40; i++){
            t4.add(dumb[i]);
        }

        ImageIcon centerPiece = new ImageIcon( this.getClass().getResource("/Pieces/CenterPiece.png"));


        BufferedImage center = scaleImage(width/2 - 180, height - 200, centerPiece);
        JLabel pic = new JLabel(new ImageIcon(center));

        board.add(pic, BorderLayout.CENTER);
        board.add(t1, BorderLayout.SOUTH);
        board.add(t2, BorderLayout.NORTH);

        board.add(t3, BorderLayout.WEST);
        board.add(t4, BorderLayout.EAST);

        add(board);

    }

    public BufferedImage scaleImage(int w, int h, ImageIcon I) {

        BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d =  bi.createGraphics();

        g2d.drawImage(I.getImage(), 0, 0, w, h, null);

        return bi;
    }

    public ImageIcon[] SetAllPieces(){

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)screenSize.getWidth();

        ImageIcon boardSpaces[] = new ImageIcon[40];

        ImageIcon y[] = new ImageIcon[40];

        BufferedImage sizedBoardPieces[] = new BufferedImage[40];

        for(int i = 0 ; i < 40; i++){
            boardSpaces[i] = new ImageIcon(this.getClass().getResource("/Pieces/"+ (i+1) + ".png"));
            sizedBoardPieces[i] = scaleImage((width/2)/10, 100, boardSpaces[i]);
            y[i] = new ImageIcon(sizedBoardPieces[i]);
        }

        return y;

    }

}

class PlayerInfoPanel extends JPanel{

    public PlayerInfoPanel(){
        setLayout(new GridLayout(2,1));

        JButton test = new JButton("Test");
        add(test);

        JPanel options = new JPanel();
        options.setAlignmentX( Component.CENTER_ALIGNMENT );
        options.setLayout(new GridLayout(1,4));

        JPanel playerBoxes[] = new JPanel[4];
        for(int i = 0; i < 4; i++){
            playerBoxes[i] = new JPanel();
        }

        BoxLayout layout[] = new BoxLayout[4];
        for(int i = 0;i < 4; i++){
            layout[i]= new BoxLayout(playerBoxes[i], BoxLayout.Y_AXIS);
            playerBoxes[i].setLayout(layout[i]);
        }

        JPanel players[] = new JPanel[4];
        for(int i = 0; i < 4; i++){
            players[i] = new JPanel();
            players[i].setLayout(new BorderLayout());
        }

        JButton playerButtons[] = new JButton[16];
        for(int i = 0; i < 12; i+=3){
            playerButtons[i] = new JButton("Buy");
            playerButtons[i+1] = new JButton("Sell");
            playerButtons[i+2] = new JButton("Properties");

            playerButtons[i].setAlignmentX(CENTER_ALIGNMENT);
            playerButtons[i+1].setAlignmentX(CENTER_ALIGNMENT);
            playerButtons[i+2].setAlignmentX(CENTER_ALIGNMENT);
        }

        for(int i = 0, j = 0; i < 4; i++, j+=3){

            playerBoxes[i].add(playerButtons[j]);
            playerBoxes[i].add(playerButtons[j+1]);
            playerBoxes[i].add(playerButtons[j+2]);

        }

        for(int i = 0; i < 4; i++){
            players[i].add(playerBoxes[i], BorderLayout.CENTER);
            players[i].add(new JButton("Player" + i), BorderLayout.NORTH);
            options.add(players[i]);
        }

        add(options);

    }

}