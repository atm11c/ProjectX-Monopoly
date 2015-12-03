import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Scanner;


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
                String cred = "PlaceHolder";

                ImageIcon placeHolder = new ImageIcon( this.getClass().getResource("Monopoly-artwork-detail.jpg"));
                JLabel dPic = new JLabel(placeHolder);

                JOptionPane.showMessageDialog(null, cred);
                JOptionPane.showMessageDialog(null, dPic, cred, JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }

}

class BoardPanel extends JPanel
{

    private Gameboard board = new Gameboard();
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int)screenSize.getWidth();
    int height = (int)screenSize.getHeight();


    public BoardPanel(){

        JLabel buildings[][] = new JLabel[40][5];
        JLabel playerPieces[][]= new JLabel[40][5];


        for(int i = 0; i < 40; i++){
            for(int j =0; j < 5; j++){


                if(j < 4){
                    ImageIcon house = new ImageIcon(this.getClass().getResource("house.png"));
                    BufferedImage bHouse = null;

                    if((i >= 11 && i < 20) || (i >=31 && i < 40)) {
                        bHouse = scaleImage((width / 11) / 8, (height / 11) / 8, house);
                    }
                    if((i >= 0 && i < 11) || (i >= 20 && i < 31) ) {
                        bHouse = scaleImage((width / 11) / 8, (height / 11) / 8, house);
                    }



                    if(i >= 0 && i <11) {
                        buildings[i][j] = new JLabel(new ImageIcon(bHouse));
                    }

                    if(i >= 11 && i <20) {
                        buildings[i][j] = new JLabel(new ImageIcon(bHouse), SwingConstants.RIGHT);
                    }

                    if(i >= 20 && i <31) {
                        buildings[i][j] = new JLabel(new ImageIcon(bHouse));
                    }

                    if(i >= 31 && i <40) {
                        buildings[i][j] = new JLabel(new ImageIcon(bHouse), SwingConstants.LEFT);
                    }
                    buildings[i][j].setVisible(false);
                }else{

                    ImageIcon hotel = new ImageIcon(this.getClass().getResource("hotel.png"));
                    BufferedImage bHotel = null;

                    if((i >= 11 && i < 20) || (i >=31 && i < 40)) {
                        bHotel = scaleImage((width / 11) / 8, (height / 11) / 8, hotel);
                    }
                    if((i >= 0 && i < 11) || (i >= 20 && i < 31) ) {
                        bHotel = scaleImage((width / 11) / 8, (height / 11) / 8, hotel);
                    }



                    if(i >= 0 && i <11) {
                        buildings[i][j] = new JLabel(new ImageIcon(bHotel));
                    }

                    if(i >= 11 && i <20) {
                        buildings[i][j] = new JLabel(new ImageIcon(bHotel), SwingConstants.RIGHT);
                    }

                    if(i >= 20 && i <31) {
                        buildings[i][j] = new JLabel(new ImageIcon(bHotel));
                    }

                    if(i >= 31 && i <40) {
                        buildings[i][j] = new JLabel(new ImageIcon(bHotel), SwingConstants.LEFT);
                    }



                    buildings[i][j].setVisible(false);

                }
            }
        }


        for(int i =0; i < 40; i++){
            for(int j = 0; j < 5;j++){
                ImageIcon piece = null;

                if(j == 0){
                    piece = new ImageIcon(this.getClass().getResource("Test1.png"));
                }else if(j == 1){
                    piece = new ImageIcon(this.getClass().getResource("Test2.png"));
                }else if(j == 2){
                    piece = new ImageIcon(this.getClass().getResource("Test3.png"));
                }else if(j == 3){
                    piece = new ImageIcon(this.getClass().getResource("Test4.png"));
                }else{
                    piece = new ImageIcon(this.getClass().getResource("Test4.png"));
                }

                BufferedImage bPiece = scaleImage(20,20, piece);
                playerPieces[i][j] = new JLabel(new ImageIcon(bPiece));

                if(j ==4)
                    playerPieces[i][j].setVisible(false);

                playerPieces[i][j].setVisible(false);
            }
        }

        setLayout(new GridLayout(1,2));


        JPanel board, t1, t2, t3, t4;

        PlayerOptionPanel pan = new PlayerOptionPanel();
        pan.setBorder(BorderFactory.createLineBorder(Color.black));

        add(pan);

        board = new JPanel();
        board.setLayout(new BorderLayout());


        JLabel dumb[] = new JLabel[44];


        ImageIcon Pieces[] = SetAllPieces();

        for(int i = 0; i < 40; i++){


            if(i == 2 || i == 4  || i == 7  || i == 9 || i == 10  || i == 12  || i == 14 || i == 15
                    || i == 17 || i == 19 || i == 20 || i == 22 || i == 24 || i == 25 || i == 27
                    || i == 28 || i == 30 || i == 32 || i == 33 || i == 35 || i == 38) {
                dumb[i] = new JLabel("",SwingConstants.CENTER);

            }else if(i == 6 || i == 16 || i == 26 || i == 36){
                dumb[i] = new JLabel("",  SwingConstants.CENTER);
            }else if(i == 3 || i == 18 || i == 34) {
                dumb[i] = new JLabel("",  SwingConstants.CENTER);
            }else if(i == 8 || i == 23 || i == 37) {
                dumb[i] = new JLabel("",  SwingConstants.CENTER);
            }else if(i == 5){
                dumb[i] = new JLabel("",  SwingConstants.CENTER);
            }else if(i == 1) {
                dumb[i] = new JLabel("", SwingConstants.CENTER);
            }else if(i == 11){
                dumb[i] = new JLabel("",  SwingConstants.CENTER);
            }else if(i == 13){
                dumb[i] = new JLabel("",  SwingConstants.CENTER);
            }else if(i == 21){
                dumb[i] = new JLabel("",  SwingConstants.CENTER);
            }else if(i == 29){
                dumb[i] = new JLabel("",  SwingConstants.CENTER);
            }else if(i == 31){
                dumb[i] = new JLabel("",  SwingConstants.CENTER);
            }else if(i == 39){
                dumb[i] = new JLabel("",  SwingConstants.CENTER);
            }else {
                dumb[i] = new JLabel("", SwingConstants.CENTER);
            }

            dumb[i].setSize((width/2)/11,(width/2)/11);
        }






        for(int i = 0; i <40 ; i++){

            if((i >= 0 && i < 11) || (i >= 20 && i < 31) ) {
                dumb[i].setLayout(new GridLayout(2,5));
            }else if((i >= 11 && i < 20) || (i >=31 && i < 40)) {
                dumb[i].setLayout(new GridLayout(5,2));
            }

            dumb[i].setIcon(Pieces[i]);

            if(i >= 0 && i < 11) {
                for (int j = 0; j < 5; j++) {
                    dumb[i].add(buildings[i][j]);
                }

                for (int j = 0; j < 5; j++) {
                    dumb[i].add(playerPieces[i][j]);
                }
            }

            if(i >= 20 && i < 31){
                for (int j = 0; j < 5; j++) {
                    dumb[i].add(playerPieces[i][j]);
                }

                for (int j = 0; j < 5; j++) {
                    dumb[i].add(buildings[i][j]);
                }

            }


            if(i >= 11 && i < 20){
                for(int j =0; j < 5; j++) {
                    dumb[i].add(playerPieces[i][j]);
                    dumb[i].add(buildings[i][j]);
                }
            }

            if(i >=31 && i < 40){
                for(int j =0; j < 5; j++) {
                    dumb[i].add(buildings[i][j]);
                    dumb[i].add(playerPieces[i][j]);
                }
            }


        }

//
//        dumb[0].add(entity1);
//        dumb[0].add(entity2);
//        dumb[0].add(entity3);
//        dumb[0].add(entity4);
//


        t1 = new JPanel();
        t2 = new JPanel();

        t3 = new JPanel();
        t4 = new JPanel();

        t1.setLayout(new GridLayout(1,11));
        t1.setPreferredSize(new Dimension((width/2)/11,height/11));
        t2.setLayout(new GridLayout(1,11));
        t2.setPreferredSize(new Dimension((width/2)/11,height/11));

        t3.setLayout(new GridLayout(9,1));
        t3.setPreferredSize(new Dimension((width/2)/11,(height)/11));
        t4.setLayout(new GridLayout(9,1));
        t4.setPreferredSize(new Dimension((width/2)/11,(height)/11));

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

        //hardcode to 720

        BufferedImage center = scaleImage(width/2 -((width / 2) / 11)*2, height -((height/11))*2 , centerPiece);
        JLabel pic = new JLabel(new ImageIcon(center));

        board.add(pic, BorderLayout.CENTER);
        board.add(t1, BorderLayout.SOUTH);
        board.add(t2, BorderLayout.NORTH);

        board.add(t3, BorderLayout.WEST);
        board.add(t4, BorderLayout.EAST);
        board.setBorder(BorderFactory.createLineBorder(Color.black));
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
        int height = (int)screenSize.getHeight();

        ImageIcon boardSpaces[] = new ImageIcon[40];

        ImageIcon y[] = new ImageIcon[40];

        BufferedImage sizedBoardPieces[] = new BufferedImage[40];

        for(int i = 0 ; i < 40; i++){
            boardSpaces[i] = new ImageIcon(this.getClass().getResource("/Pieces/" + (i+1) + ".png"));
            if((i >= 0 && i < 11) || (i >= 20 && i < 31) ){
                sizedBoardPieces[i] = scaleImage((width / 2) / 11, (height/11), boardSpaces[i]);
                y[i] = new ImageIcon(sizedBoardPieces[i]);
            }else if((i >= 11 && i < 20) || (i >=31 && i < 40)){
                sizedBoardPieces[i] = scaleImage((width / 2) / 11, (height/11), boardSpaces[i]);
                y[i] = new ImageIcon(sizedBoardPieces[i]);
            }
        }

        return y;

    }


    class PlayerOptionPanel extends JPanel{

        public PlayerOptionPanel(){
            setLayout(new GridLayout(2,1));

            PlayerInfoPanel playerInfo = new PlayerInfoPanel();

            add(playerInfo);

            JPanel options = new JPanel();
            options.setAlignmentX( Component.CENTER_ALIGNMENT );
            options.setLayout(new GridLayout(1,4));


            JPanel playerBoxes[] = new JPanel[4];
            for(int i = 0; i < 4; i++){
                playerBoxes[i] = new JPanel();
                playerBoxes[i].setLayout(new GridLayout(6,3));
                playerBoxes[i].setBorder(BorderFactory.createLineBorder(Color.black));
            }

            JPanel Holder1[][]= new JPanel[6][3];
            JPanel Holder2[][]= new JPanel[6][3];
            JPanel Holder3[][]= new JPanel[6][3];
            JPanel Holder4[][]= new JPanel[6][3];

            for(int i = 0; i < 6; i++){
                for(int j = 0; j < 3; j++){
                    Holder1[i][j] = new JPanel();
                    playerBoxes[0].add(Holder1[i][j]);

                    Holder2[i][j] = new JPanel();
                    playerBoxes[1].add(Holder2[i][j]);

                    Holder3[i][j] = new JPanel();
                    playerBoxes[2].add(Holder3[i][j]);

                    Holder4[i][j] = new JPanel();
                    playerBoxes[3].add(Holder4[i][j]);

                }
            }


            Holder1[0][1].add(new JLabel("Player 1"));
            Holder2[0][1].add(new JLabel("Player 2"));
            Holder3[0][1].add(new JLabel("Player 3"));
            Holder4[0][1].add(new JLabel("Player 4"));

            JButton buttons[][] = new JButton[4][5];

            for(int i =0 ; i < 4; i++){

                buttons[i][0] = new JButton("Roll");
                buttons[i][1] = new JButton("Buy");
                buttons[i][2] = new JButton("Build");
                buttons[i][3] = new JButton("Properties");

                buttons[i][4] = new JButton("PlaceHolder");
                buttons[i][4].setVisible(false);
            }


            for(int i = 1; i < 6; i++){
                for(int j = 0; j < 4; j++){
                    Holder1[i][1].add(buttons[0][i-1]);
                    Holder2[i][1].add(buttons[1][i-1]);
                    Holder3[i][1].add(buttons[2][i-1]);
                    Holder4[i][1].add(buttons[3][i-1]);

                }
            }

            options.add(playerBoxes[0]);
            options.add(playerBoxes[1]);
            options.add(playerBoxes[2]);
            options.add(playerBoxes[3]);
            add(options);

        }

    }

    class PlayerInfoPanel extends JPanel{

        public PlayerInfoPanel(){

            JPanel playerStats[] = new JPanel[5];

            setLayout(new GridLayout(5,1));
            JLabel test = new JLabel("Player");
            test.setBorder(BorderFactory.createLineBorder(Color.black));

            for(int i=0; i < 4;i++){
                playerStats[i] = new JPanel();
                playerStats[i].setLayout(new GridLayout(1,4));
                playerStats[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));

                playerStats[i].add(new JLabel("Player " + (i+1)));
                playerStats[i].add(new JLabel("Total cash: " + board.players[i].getMoney()));
                playerStats[i].add(new JLabel("Number of Properties: " ));
                playerStats[i].add(new JLabel("Placeholder: "));



                add(playerStats[i]);
            }
            JTextArea output = new JTextArea();
            output.setText("This is a test");
            output.setEditable(false);
            output.setBorder(BorderFactory.createLineBorder(Color.black));

            add(output);
        }

    }

}

//class PlayerOptionPanel extends JPanel{
//
//    public PlayerOptionPanel(){
//        setLayout(new GridLayout(2,1));
//
//        PlayerInfoPanel playerInfo = new PlayerInfoPanel();
//
//        add(playerInfo);
//
//        JPanel options = new JPanel();
//        options.setAlignmentX( Component.CENTER_ALIGNMENT );
//        options.setLayout(new GridLayout(1,4));
//
//        JPanel playerBoxes[] = new JPanel[4];
//        for(int i = 0; i < 4; i++){
//            playerBoxes[i] = new JPanel();
//        }
//
//        BoxLayout layout[] = new BoxLayout[4];
//        for(int i = 0;i < 4; i++){
//            layout[i]= new BoxLayout(playerBoxes[i], BoxLayout.Y_AXIS);
//            playerBoxes[i].setLayout(layout[i]);
//        }
//
//        JPanel players[] = new JPanel[4];
//        for(int i = 0; i < 4; i++){
//            players[i] = new JPanel();
//            players[i].setLayout(new BorderLayout());
//        }
//
//        JButton playerButtons[] = new JButton[16];
//        for(int i = 0; i < 16; i+=4){
//            playerButtons[i] = new JButton("Roll");
//            playerButtons[i+1] = new JButton("Buy");
//            playerButtons[i+2] = new JButton("Sell");
//            playerButtons[i+3] = new JButton("Properties");
//
//            playerButtons[i].setAlignmentX(CENTER_ALIGNMENT);
//            playerButtons[i+1].setAlignmentX(CENTER_ALIGNMENT);
//            playerButtons[i+2].setAlignmentX(CENTER_ALIGNMENT);
//            playerButtons[i+3].setAlignmentX(CENTER_ALIGNMENT);
//
//
//        }
//
//        for(int i = 0, j = 0; i < 4; i++, j+=4){
//
//            playerBoxes[i].add(playerButtons[j]);
//            playerBoxes[i].add(playerButtons[j+1]);
//            playerBoxes[i].add(playerButtons[j+2]);
//            playerBoxes[i].add(playerButtons[j+3]);
//
//        }
//
//        for(int i = 0; i < 4; i++){
//            players[i].add(playerBoxes[i], BorderLayout.CENTER);
//            players[i].add(new JButton("Player" + i), BorderLayout.NORTH);
//            options.add(players[i]);
//        }
//
//        add(options);
//
//    }
//
//}

//
//
//class PlayerInfoPanel extends JPanel{
//
//    public PlayerInfoPanel(){
//
//        JPanel playerStats[] = new JPanel[5];
//
//        setLayout(new GridLayout(5,1));
//
//        for(int i=0; i < 4;i++){
//            playerStats[i] = new JPanel();
//            playerStats[i].setLayout(new GridLayout(1,4));
//
//            playerStats[i].add(new JLabel("Player" + (i+1)));
//            playerStats[i].add(new JLabel("Total cash:"));
//            playerStats[i].add(new JLabel("Number of Properties:"));
//            playerStats[i].add(new JLabel("Placeholder:"));
//
//           add(playerStats[i]);
//        }
//        JTextArea output = new JTextArea();
//        output.setText("This is a test");
//        output.setEditable(false);
//
//        add(output);
//    }
//
//}