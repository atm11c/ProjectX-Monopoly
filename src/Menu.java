import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.nio.Buffer;

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


//class BoardPanel extends JPanel{
//
//    public BoardPanel(){
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        int width = (int)screenSize.getWidth()/2 -100;
//        int height = (int)screenSize.getHeight()-100;
//
//
//
//
//        ImageIcon man = new ImageIcon( this.getClass().getResource("Board.jpg"));
//
//        BufferedImage img = new test().scaleImage(width, height, man);
//
//        ImageIcon i = new ImageIcon(img);
//
//        JLabel pic = new JLabel(i);
//
//        add(pic);
//
//
//    }
//    public class test {
//        public BufferedImage scaleImage(int w, int h, ImageIcon I) {
//
//
//            BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
//            Graphics2D g2d = (Graphics2D) bi.createGraphics();
//
//            g2d.drawImage(I.getImage(), 0, 0, w, h, null);
//
//            return bi;
//        }
//    }
//
//}















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
        //JLabel dumb[] =  new JLabel[40];

        ImageIcon Pieces[] = new ImageIcon[40];

        Pieces = SetAllPieces(Pieces);


        for(int i = 0; i < 41; i++){


            if(i == 2 || i == 4  || i == 7  || i == 9 || i == 10  || i == 12  || i == 14 || i == 15
                    || i == 17 || i == 19 || i == 20 || i == 22 || i == 24 || i == 25 || i == 27
                    || i == 28 || i == 30 || i == 32 || i == 33 || i == 35 || i == 38 || i == 40) {
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

//
//                ImageIcon Go = new ImageIcon(this.getClass().getResource("Go.png"));
//                BufferedImage img = scaleImage((width/2)/10, 100, Go);
//                ImageIcon newGo = new ImageIcon(img);
//
//
//                dumb[i].setIcon(newGo);
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
        for(int i = 1; i <41 ; i++){
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

        ImageIcon centerPiece = new ImageIcon( this.getClass().getResource("/Pieces/CenterPiece.png"));


        BufferedImage center = scaleImage(width/2 - 180, height - 200, centerPiece);
        JLabel pic = new JLabel(new ImageIcon(center));

        board.add(pic, BorderLayout.CENTER);
        board.add(t1, BorderLayout.SOUTH);
        board.add(t2, BorderLayout.NORTH);

        board.add(t3, BorderLayout.WEST);
        board.add(t4, BorderLayout.EAST);

        add(board);

        //add(pic, BorderLayout.CENTER);

    }

    public BufferedImage scaleImage(int w, int h, ImageIcon I) {

        BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();

        g2d.drawImage(I.getImage(), 0, 0, w, h, null);

        return bi;
    }

    public ImageIcon[] SetAllPieces(ImageIcon x[]){

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int)screenSize.getWidth();
        int height = (int)screenSize.getHeight();

        ImageIcon y[] = new ImageIcon[41];

        ImageIcon p1 = new ImageIcon(this.getClass().getResource("/Pieces/Go.png"));
        ImageIcon p2 = new ImageIcon(this.getClass().getResource("/Pieces/MedAve.png"));
        ImageIcon p3 = new ImageIcon(this.getClass().getResource("/Pieces/3.png"));
        ImageIcon p4 = new ImageIcon(this.getClass().getResource("/Pieces/4.png"));
        ImageIcon p5 = new ImageIcon(this.getClass().getResource("/Pieces/5.png"));
        ImageIcon p6 = new ImageIcon(this.getClass().getResource("/Pieces/6.png"));
        ImageIcon p7 = new ImageIcon(this.getClass().getResource("/Pieces/7.png"));
        ImageIcon p8 = new ImageIcon(this.getClass().getResource("/Pieces/8.png"));
        ImageIcon p9 = new ImageIcon(this.getClass().getResource("/Pieces/9.png"));
        ImageIcon p10 = new ImageIcon(this.getClass().getResource("/Pieces/10.png"));

        ImageIcon p11 = new ImageIcon(this.getClass().getResource("/Pieces/11.png"));
        ImageIcon p12 = new ImageIcon(this.getClass().getResource("/Pieces/12.png"));
        ImageIcon p13 = new ImageIcon(this.getClass().getResource("/Pieces/13.png"));
        ImageIcon p14 = new ImageIcon(this.getClass().getResource("/Pieces/14.png"));
        ImageIcon p15 = new ImageIcon(this.getClass().getResource("/Pieces/15.png"));
        ImageIcon p16 = new ImageIcon(this.getClass().getResource("/Pieces/16.png"));
        ImageIcon p17 = new ImageIcon(this.getClass().getResource("/Pieces/17.png"));
        ImageIcon p18 = new ImageIcon(this.getClass().getResource("/Pieces/18.png"));
        ImageIcon p19 = new ImageIcon(this.getClass().getResource("/Pieces/19.png"));
        ImageIcon p20 = new ImageIcon(this.getClass().getResource("/Pieces/20.png"));

        ImageIcon p21 = new ImageIcon(this.getClass().getResource("/Pieces/21.png"));
        ImageIcon p22 = new ImageIcon(this.getClass().getResource("/Pieces/22.png"));
        ImageIcon p23 = new ImageIcon(this.getClass().getResource("/Pieces/23.png"));
        ImageIcon p24 = new ImageIcon(this.getClass().getResource("/Pieces/24.png"));
        ImageIcon p25 = new ImageIcon(this.getClass().getResource("/Pieces/25.png"));
        ImageIcon p26 = new ImageIcon(this.getClass().getResource("/Pieces/26.png"));
        ImageIcon p27 = new ImageIcon(this.getClass().getResource("/Pieces/27.png"));
        ImageIcon p28 = new ImageIcon(this.getClass().getResource("/Pieces/28.png"));
        ImageIcon p29 = new ImageIcon(this.getClass().getResource("/Pieces/29.png"));
        ImageIcon p30 = new ImageIcon(this.getClass().getResource("/Pieces/30.png"));

        ImageIcon p31 = new ImageIcon(this.getClass().getResource("/Pieces/31.png"));
        ImageIcon p32 = new ImageIcon(this.getClass().getResource("/Pieces/32.png"));
        ImageIcon p33 = new ImageIcon(this.getClass().getResource("/Pieces/33.png"));
        ImageIcon p34 = new ImageIcon(this.getClass().getResource("/Pieces/34.png"));
        ImageIcon p35 = new ImageIcon(this.getClass().getResource("/Pieces/35.png"));
        ImageIcon p36 = new ImageIcon(this.getClass().getResource("/Pieces/36.png"));
        ImageIcon p37 = new ImageIcon(this.getClass().getResource("/Pieces/37.png"));
        ImageIcon p38 = new ImageIcon(this.getClass().getResource("/Pieces/38.png"));
        ImageIcon p39 = new ImageIcon(this.getClass().getResource("/Pieces/39.png"));
        ImageIcon p40 = new ImageIcon(this.getClass().getResource("/Pieces/40.png"));

        BufferedImage img1 = scaleImage((width/2)/10, 100, p1);
        BufferedImage img2 = scaleImage((width/2)/10, 100, p2);
        BufferedImage img3 = scaleImage((width/2)/10, 100, p3);
        BufferedImage img4 = scaleImage((width/2)/10, 100, p4);
        BufferedImage img5 = scaleImage((width/2)/10, 100, p5);
        BufferedImage img6 = scaleImage((width/2)/10, 100, p6);
        BufferedImage img7 = scaleImage((width/2)/10, 100, p7);
        BufferedImage img8 = scaleImage((width/2)/10, 100, p8);
        BufferedImage img9 = scaleImage((width/2)/10, 100, p9);
        BufferedImage img10 = scaleImage((width/2)/10, 100, p10);

        BufferedImage img11 = scaleImage((width/2)/10, 100, p11);
        BufferedImage img12 = scaleImage((width/2)/10, 100, p12);
        BufferedImage img13 = scaleImage((width/2)/10, 100, p13);
        BufferedImage img14 = scaleImage((width/2)/10, 100, p14);
        BufferedImage img15 = scaleImage((width/2)/10, 100, p15);
        BufferedImage img16 = scaleImage((width/2)/10, 100, p16);
        BufferedImage img17 = scaleImage((width/2)/10, 100, p17);
        BufferedImage img18 = scaleImage((width/2)/10, 100, p18);
        BufferedImage img19 = scaleImage((width/2)/10, 100, p19);
        BufferedImage img20 = scaleImage((width/2)/10, 100, p20);

        BufferedImage img21 = scaleImage((width/2)/10, 100, p21);
        BufferedImage img22 = scaleImage((width/2)/10, 100, p22);
        BufferedImage img23 = scaleImage((width/2)/10, 100, p23);
        BufferedImage img24 = scaleImage((width/2)/10, 100, p24);
        BufferedImage img25 = scaleImage((width/2)/10, 100, p25);
        BufferedImage img26 = scaleImage((width/2)/10, 100, p26);
        BufferedImage img27 = scaleImage((width/2)/10, 100, p27);
        BufferedImage img28 = scaleImage((width/2)/10, 100, p28);
        BufferedImage img29 = scaleImage((width/2)/10, 100, p29);
        BufferedImage img30 = scaleImage((width/2)/10, 100, p30);

        BufferedImage img31 = scaleImage((width/2)/10, 100, p31);
        BufferedImage img32 = scaleImage((width/2)/10, 100, p32);
        BufferedImage img33 = scaleImage((width/2)/10, 100, p33);
        BufferedImage img34 = scaleImage((width/2)/10, 100, p34);
        BufferedImage img35 = scaleImage((width/2)/10, 100, p35);
        BufferedImage img36 = scaleImage((width/2)/10, 100, p36);
        BufferedImage img37 = scaleImage((width/2)/10, 100, p37);
        BufferedImage img38 = scaleImage((width/2)/10, 100, p38);
        BufferedImage img39 = scaleImage((width/2)/10, 100, p39);
        BufferedImage img40 = scaleImage((width/2)/10, 100, p40);


        y[1] = new ImageIcon(img1);
        y[2] = new ImageIcon(img2);
        y[3] = new ImageIcon(img3);
        y[4] = new ImageIcon(img4);
        y[5] = new ImageIcon(img5);
        y[6] = new ImageIcon(img6);
        y[7] = new ImageIcon(img7);
        y[8] = new ImageIcon(img8);
        y[9] = new ImageIcon(img9);
        y[10] = new ImageIcon(img10);

        y[11] = new ImageIcon(img11);
        y[12] = new ImageIcon(img12);
        y[13] = new ImageIcon(img13);
        y[14] = new ImageIcon(img14);
        y[15] = new ImageIcon(img15);
        y[16] = new ImageIcon(img16);
        y[17] = new ImageIcon(img17);
        y[18] = new ImageIcon(img18);
        y[19] = new ImageIcon(img19);
        y[20] = new ImageIcon(img20);

        y[21] = new ImageIcon(img21);
        y[22] = new ImageIcon(img22);
        y[23] = new ImageIcon(img23);
        y[24] = new ImageIcon(img24);
        y[25] = new ImageIcon(img25);
        y[26] = new ImageIcon(img26);
        y[27] = new ImageIcon(img27);
        y[28] = new ImageIcon(img28);
        y[29] = new ImageIcon(img29);
        y[30] = new ImageIcon(img30);

        y[31] = new ImageIcon(img31);
        y[32] = new ImageIcon(img32);
        y[33] = new ImageIcon(img33);
        y[34] = new ImageIcon(img34);
        y[35] = new ImageIcon(img35);
        y[36] = new ImageIcon(img36);
        y[37] = new ImageIcon(img37);
        y[38] = new ImageIcon(img38);
        y[39] = new ImageIcon(img39);
        y[40] = new ImageIcon(img40);


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


        JPanel boxTest1 = new JPanel();
        JPanel boxTest2 = new JPanel();
        JPanel boxTest3 = new JPanel();
        JPanel boxTest4 = new JPanel();
        //boxTest.setAlignmentX( Component.CENTER_ALIGNMENT );

        BoxLayout layout1 = new BoxLayout(boxTest1, BoxLayout.Y_AXIS);
        BoxLayout layout2 = new BoxLayout(boxTest2, BoxLayout.Y_AXIS);
        BoxLayout layout3 = new BoxLayout(boxTest3, BoxLayout.Y_AXIS);
        BoxLayout layout4 = new BoxLayout(boxTest4, BoxLayout.Y_AXIS);

        boxTest1.setLayout(layout1);
        boxTest2.setLayout(layout2);
        boxTest3.setLayout(layout3);
        boxTest4.setLayout(layout4);


        JPanel player1 = new JPanel();
        JPanel player2 = new JPanel();
        JPanel player3 = new JPanel();
        JPanel player4 = new JPanel();

        player1.setLayout(new BorderLayout());
        player2.setLayout(new BorderLayout());
        player3.setLayout(new BorderLayout());
        player4.setLayout(new BorderLayout());

        JButton t1, t2, t3, t4;
        JButton t5, t6, t7, t8;
        JButton t9, t10, t11, t12;
        JButton t13, t14, t15, t16;

        //Player1
        /***********************************************************************/
        t1 = new JButton("test1");
        t1.setAlignmentX(CENTER_ALIGNMENT);
        t2 = new JButton("test2");
        t2.setAlignmentX(CENTER_ALIGNMENT);
        t3 = new JButton("test3");
        t3.setAlignmentX(CENTER_ALIGNMENT);
        t4 = new JButton("test4");
        t4.setAlignmentX(CENTER_ALIGNMENT);

        boxTest1.add(t1);
        boxTest1.add(t2);
        boxTest1.add(t3);
        boxTest1.add(t4);
        /***********************************************************************/

        //Player2
        /***********************************************************************/
        t5 = new JButton("test5");
        t5.setAlignmentX(CENTER_ALIGNMENT);
        t6 = new JButton("test6");
        t6.setAlignmentX(CENTER_ALIGNMENT);
        t7 = new JButton("test7");
        t7.setAlignmentX(CENTER_ALIGNMENT);
        t8 = new JButton("test8");
        t8.setAlignmentX(CENTER_ALIGNMENT);

        boxTest2.add(t5);
        boxTest2.add(t6);
        boxTest2.add(t7);
        boxTest2.add(t8);
        /***********************************************************************/

        //Player3
        /***********************************************************************/
        t9 = new JButton("test9");
        t9.setAlignmentX(CENTER_ALIGNMENT);
        t10 = new JButton("test10");
        t10.setAlignmentX(CENTER_ALIGNMENT);
        t11 = new JButton("test11");
        t11.setAlignmentX(CENTER_ALIGNMENT);
        t12 = new JButton("test12");
        t12.setAlignmentX(CENTER_ALIGNMENT);

        boxTest3.add(t9);
        boxTest3.add(t10);
        boxTest3.add(t11);
        boxTest3.add(t12);
        /***********************************************************************/

        //Player4
        /***********************************************************************/
        t13 = new JButton("test13");
        t13.setAlignmentX(CENTER_ALIGNMENT);
        t14 = new JButton("test14");
        t14.setAlignmentX(CENTER_ALIGNMENT);
        t15 = new JButton("test15");
        t15.setAlignmentX(CENTER_ALIGNMENT);
        t16 = new JButton("test16");
        t16.setAlignmentX(CENTER_ALIGNMENT);

        boxTest4.add(t13);
        boxTest4.add(t14);
        boxTest4.add(t15);
        boxTest4.add(t16);
        /***********************************************************************/
        //add(boxTest);







        player1.add(boxTest1, BorderLayout.CENTER);
        player1.add(new JButton("Player1"), BorderLayout.NORTH);
        player1.add(new JButton("sadsad"), BorderLayout.SOUTH);
        options.add(player1);

        player2.add(boxTest2, BorderLayout.CENTER);
        player2.add(new JButton("Player2"), BorderLayout.NORTH);
        player2.add(new JButton("sadsad"), BorderLayout.SOUTH);
        options.add(player2);

        player3.add(boxTest3, BorderLayout.CENTER);
        player3.add(new JButton("Player3"), BorderLayout.NORTH);
        player3.add(new JButton("sadsad"), BorderLayout.SOUTH);
        options.add(player3);

        player4.add(boxTest4, BorderLayout.CENTER);
        player4.add(new JButton("Player4"), BorderLayout.NORTH);
        player4.add(new JButton("sadsad"), BorderLayout.SOUTH);
        options.add(player4);

        add(options);



        //each column will need buttons and which player that column is

    }

}






