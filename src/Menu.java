import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Calendar;
import java.util.Random;
import java.util.Scanner;


public class Menu {

    public static void main(String[] args){
        Gameboard gb = new Gameboard();
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

        boolean flag = true;

        while(flag) {
            int playerTurn = gb.getCurrentPlayer();
            System.out.printf("Player %d, it's your turn!\n", playerTurn+1);


            System.out.println("End Turn\n\n");

            //Check for end of game
            if(gb.players[playerTurn].isBankrupt()){
                flag = false;
                System.out.println("Game has ended!");
            }

            //next player
            gb.setCurrentPlayer((playerTurn+1)%4);
        }


    }

}


class MenuPanel extends JPanel{

    private JButton start, quit, credits;
    private JButton n1, n2, n3, n4, n5, n6;
    public Gameboard gb;

    public MenuPanel(Gameboard gameboard){

        gb = gameboard;

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
                BoardPanel test1 = new BoardPanel(gb);

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
    String colors[] = {"Garnet","Gold","Blue","Purple"};

    JTextArea output;
    JLabel buildings[][];
    JLabel playerPieces[][];
    JPanel playerStats[];
    JLabel playerStatLabel[][];

    private Gameboard gb;
    public BoardPanel(Gameboard gameboard){
        gb = gameboard;

        buildings = new JLabel[40][5];
        playerPieces= new JLabel[40][5];

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

                BufferedImage bPiece = scaleImage((height / 11)/4,(height / 11)/4, piece);
                playerPieces[i][j] = new JLabel(new ImageIcon(bPiece));

                if(j == 4){
                    playerPieces[i][j].setVisible(false);
                }

                playerPieces[i][j].setVisible(false);
            }
        }

        playerPieces[0][0].setVisible(true);
        playerPieces[0][1].setVisible(true);
        playerPieces[0][2].setVisible(true);
        playerPieces[0][3].setVisible(true);

        setLayout(new GridLayout(1,2));


        JPanel board, t1, t2, t3, t4;

        PlayerOptionPanel pan = new PlayerOptionPanel(gb);
        pan.setBorder(BorderFactory.createLineBorder(Color.black));

        add(pan);

        board = new JPanel();
        board.setLayout(new BorderLayout());


        JLabel dumb[] = new JLabel[44];


        ImageIcon Pieces[] = SetAllPieces();

        for(int i = 0; i < 40; i++){

            dumb[i] = new JLabel();
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

        private Gameboard gb;
        private PlayerInfoPanel playerInfo;

        private JButton[][] buttons;
        public PlayerOptionPanel(Gameboard gameboard){

            gb = gameboard;
            setLayout(new GridLayout(2,1));

            playerInfo = new PlayerInfoPanel();

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

            buttons = new JButton[4][5];

            for(int i =0 ; i < 4; i++){

                buttons[i][0] = new JButton("Roll");
                buttons[i][1] = new JButton("Trade");
                buttons[i][2] = new JButton("Build");
                buttons[i][3] = new JButton("Properties");

                buttons[i][4] = new JButton("PlaceHolder");
                buttons[i][4].setVisible(false);

                BuildHandler buildHandler = new BuildHandler();
                buttons[i][2].addActionListener(buildHandler);

                RollHandler rollHandler = new RollHandler();
                buttons[i][0].addActionListener(rollHandler);

                PropHandler propHandler = new PropHandler();
                buttons[i][3].addActionListener(propHandler);
            }

//            for(int i = 1; i < 4; i++){
//                for(int j = 0; j < 4; j++ ) {
//                    buttons[i][j].setEnabled(false);
//                 }
//
//            }


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

        private class BuildHandler implements ActionListener{
            public void actionPerformed(ActionEvent e) {
                Player player = null;
                int playNum = 0;

                if(e.getSource() == buttons[0][3]){
                    playNum = 0;
                }
                else if(e.getSource() == buttons[1][3]){
                    playNum = 1;
                }
                else if(e.getSource() == buttons[2][3]){
                    playNum = 2;
                }
                else if(e.getSource() == buttons[3][3]){
                    playNum = 3;
                }

                BuildFrame build = new BuildFrame(gb, playNum);
            }
        }


        private class RollHandler implements ActionListener{
            public void actionPerformed(ActionEvent actionEvent) {
                int temp1 = gb.getCurrentPlayer();

                gb.players[gb.getCurrentPlayer()].takeTurn(gb);

                showPlayer(gb.players[temp1].getPosition(), temp1);

                playerInfo.changeText(gb.getMessage());

//
//                for(int i =0; i < 4; i++){
//                    for(int j = 0; j < 4; j++){
//
//                        int temp2 = gb.getCurrentPlayer() + 1;
//
//                        if(temp2 > 3){
//                            temp2 = temp2 - 4;
//                        }
//
//                        if(i == temp2) {
//                            buttons[i][j].setEnabled(true);
//                        }else{
//                            buttons[i][j].setEnabled(false);
//                        }
//                    }
//                }


                for(int i = 0; i < 4; i++) {

                    playerStatLabel[i][1].setText("Total cash: " + gb.players[i].getMoney());
                    playerStatLabel[i][2].setText("Number of Properties owned: " + gb.players[i].getNumProps());
                }

            }
        }


        private class PropHandler implements ActionListener{
            public void actionPerformed(ActionEvent actionEvent) {
                Player player;
                String hurrdurr;
                if(actionEvent.getSource() == buttons[0][3]){
                    player = gb.players[0];
                }
                else if(actionEvent.getSource() == buttons[1][3]){
                    player = gb.players[1];
                }
                else if(actionEvent.getSource() == buttons[2][3]){
                    player = gb.players[2];
                }
                else if(actionEvent.getSource() == buttons[3][3]){
                    player = gb.players[3];
                }
                else{
                    player = new Player(75);
                }

                hurrdurr = player.playerProps(gb);
                PropFrame propFrame = new PropFrame(hurrdurr);
            }
        }

    }


    public void showHouse(int pos){
        if(!buildings[pos][0].isVisible()){
            buildings[pos][0].setVisible(true);
        }else{
            for(int i = 0; i < 4; i++){
                if(!buildings[pos][0].isVisible()){
                    buildings[pos][i].setVisible(true);
                    break;
                }
            }
        }
    }

    public void showPlayer(int pos, int playerNum){
        for(int i = 0; i < 40; i++){
            if(playerPieces[i][playerNum].isVisible()){
                playerPieces[i][playerNum].setVisible(false);
            }
        }

        playerPieces[pos][playerNum].setVisible(true);
    }

    class PlayerInfoPanel extends JPanel{

        public PlayerInfoPanel(){

            playerStats = new JPanel[5];
            playerStatLabel = new JLabel[4][4];

            setLayout(new GridLayout(5,1));
            JLabel test = new JLabel("Player");
            test.setBorder(BorderFactory.createLineBorder(Color.black));

            for(int i=0; i < 4;i++){
                playerStats[i] = new JPanel();
                playerStats[i].setLayout(new GridLayout(1, 4));
                playerStats[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));

                playerStatLabel[i][0] = new JLabel("Player" + (i + 1));
                playerStats[i].add(playerStatLabel[i][0]);

                playerStatLabel[i][1]=new JLabel("Total cash: " + gb.players[i].getMoney());
                playerStats[i].add(playerStatLabel[i][1]);

                playerStatLabel[i][2]=new JLabel("Number of Properties owned: " + gb.players[i].getNumProps());
                playerStats[i].add(playerStatLabel[i][2]);

                playerStatLabel[i][3]=new JLabel("Color: " + colors[i]);
                playerStats[i].add(playerStatLabel[i][3]);




                add(playerStats[i]);
            }
            output = new JTextArea();
            output.setText("Player 1 begins...");
            output.setEditable(false);
            output.setBorder(BorderFactory.createLineBorder(Color.black));

            add(output);
        }


        public void changeText(String s){
            output.setText(s);
        }

    }


}


class playerStatLabel extends JLabel{

    public playerStatLabel(Gameboard gameboard){

    }

    public void update(){

    }

}




class BuildFrame extends JFrame{
    private JFrame frame;
    private boolean buildables[];
    public BuildFrame(Gameboard board, int num){

        frame = new JFrame("Build");

        buildables = board.players[num].builder(board);

        BuildPanel build = new BuildPanel();



        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setSize( 600, 400 );
        frame.setVisible( true );
        frame.add(build);


    }

    class BuildPanel extends JPanel{
        private JPanel panel;
        private JButton props[][];

        public BuildPanel(){
            panel = new JPanel();
            panel.setLayout(new GridLayout(6,5));

            props = new JButton[6][5];

            for(int i = 0; i < 6; i++){
                for(int j = 0; j < 5; j++){
                    props[i][j] = new JButton("Property");
                    props[i][j].setVisible(false);
                    panel.add(props[i][j]);
                }
            }
//


            int counter = 0;
            for(int i = 0; i < 6; i++ ){
                for(int j = 0; j < 5; j++) {
                    if(buildables[counter]) {

                        props[i][j].setVisible(true);
                    }
                    counter++;

                }
            }

            props[0][0].setVisible(false);
            props[0][2].setVisible(false);
            props[0][4].setVisible(false);

            props[5][0].setVisible(false);
            props[5][1].setVisible(false);
            props[5][3].setVisible(false);
            props[5][4].setVisible(false);


            props[5][2].setText("Cancel");
            props[5][2].setVisible(true);

            add(panel);

        }
    }


}



class PropFrame extends JFrame{
    private JFrame frame;
    public PropFrame(String derp){
        frame = new JFrame("Props");
        PropPanel roll = new PropPanel(derp);

        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setSize( 600, 200 );
        frame.setVisible( true );
        frame.add(roll);
    }

    class PropPanel extends JPanel{

        public PropPanel(String derp){
            JPanel pPanel = new JPanel();

            JButton okay = new JButton("Okay");
            OkayHandler okayHandler = new OkayHandler();
            okay.addActionListener(okayHandler);

            JLabel propLabel = new JLabel();

            propLabel.setText(derp);

            pPanel.add(propLabel);
            pPanel.add(okay);

            add(pPanel);

        }
        class OkayHandler implements ActionListener{
            public void actionPerformed(ActionEvent actionEvent) {
                frame.dispose();
            }
        }
    }

}

class RollFrame extends JFrame{
    private Gameboard gb;
    private JFrame frame;
    public RollFrame(Gameboard gameboard){
        gb = gameboard;
        frame = new JFrame("Buy Property?");

        RollPanel roll = new RollPanel();

        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setSize( 600, 200 );
        frame.setVisible( true );
        frame.add(roll);
    }

    class RollPanel extends JPanel{
        JButton buy, sell;
        public RollPanel(){
            JPanel rPanel = new JPanel();
            buy = new JButton("Yes");
            sell = new JButton("No");
            BuyProp buyProp = new BuyProp();
            buy.addActionListener(buyProp);

            JLabel propLabel = new JLabel("This property is unowned, would you like to buy it?");
            rPanel.add(propLabel);
            rPanel.add(buy);
            rPanel.add(sell);

            add(rPanel);

        }
        private class BuyProp implements ActionListener{
            public void actionPerformed(ActionEvent actionEvent) {
                int playerNum = gb.getCurrentPlayer();
                Player player = gb.players[playerNum];
                int pos = gb.players[playerNum].getPosition();

                OwnedCell property = (OwnedCell)gb.cells[pos];


                if(player.canAfford(property.getPrice())) {
                    property.setOwner(playerNum);
                    player.setNumProps(player.getNumProps()+1);
                    if(property.getisRR()){
                        player.setRrOwned(player.getRrOwned()+1);
                    }
                    else if(property.getisUtil()){
                        player.setUtilOwned(player.getUtilOwned() + 1);
                    }
                }

                if(player.isDubs() && player.getNumDubs() == 2){
                    System.out.println("Too many doubles");
                    gb.addToMessage("Too many doubles!\n");
                    player.setPosition(10);
                    player.setNumDubs(0);
                    player.setInJail(true);
                    gb.setCurrentPlayer((gb.getCurrentPlayer() + 1) % 4);
                }
                else if(player.isDubs()){
                    player.setNumDubs(player.getNumDubs()+1);
                    gb.setCurrentPlayer((gb.getCurrentPlayer()) % 4);
                }
                else if(!player.isDubs()) {
                    player.setNumDubs(0);
                    gb.setCurrentPlayer((gb.getCurrentPlayer() + 1) % 4);
                }
                frame.dispose();
            }
        }

    }



}

class JailFrame extends JFrame{
    private Gameboard gb;
    private JFrame frame;
    JButton roll, pay;
    public JailFrame(Gameboard gameboard){
        gb = gameboard;
        frame = new JFrame("JAIL");
        JailPanel jailPan = new JailPanel();

        frame.setSize(600, 200);
        frame.setVisible(true);
        frame.add(jailPan);

    }
    class JailPanel extends JPanel{
        public JailPanel(){
            JPanel panel = new JPanel();
            roll = new JButton("Roll");
            pay = new JButton("Pay");
            PayHandler payHandler = new PayHandler();
            DubsHandler dubsHandler = new DubsHandler();

            roll.addActionListener(dubsHandler);
            pay.addActionListener(payHandler);

            JLabel jailLabel = new JLabel("You are in jail :(, what would you like to do?");

            panel.add(jailLabel);
            panel.add(roll);
            panel.add(pay);

            add(panel);
        }

        private class PayHandler implements ActionListener{
            public void actionPerformed(ActionEvent actionEvent) {
                int playerNum = gb.getCurrentPlayer();
                Player player = gb.players[playerNum];
                if (player.canAfford(50)) {

                    System.out.println("Chose to pay way out");
                    gb.addToMessage("Chose to pay way out\n");
                    player.setJailTurns(0);
                    player.setInJail(false);

                }
                gb.setCurrentPlayer((gb.getCurrentPlayer()+1)%4);
                frame.dispose();
            }
        }

        private class DubsHandler implements ActionListener{
            public void actionPerformed(ActionEvent actionEvent) {

                int playerNum = gb.getCurrentPlayer();
                Player player = gb.players[playerNum];
                System.out.println("Rolling for doubles...");
                gb.addToMessage("Rolling for doubles...\n");
                Random random = new Random();
                int die1 = random.nextInt(6) + 1;
                int die2 = random.nextInt(6) + 1;
                if (die1 == die2) {
                    System.out.println("Rolled doubles");
                    gb.addToMessage("Rolled doubles\n");

                    JailOutputFrame frame = new JailOutputFrame("Rolled doubles, you are free :D!\n");
                    player.setInJail(false);
                    player.setJailTurns(0);
                }
                else {
                    System.out.println("Did not roll doubles.");
                    gb.addToMessage("Did not roll doubles.\n");
                    JailOutputFrame frame = new JailOutputFrame("Did not roll doubles...\nstill in jail D:\n");
                    player.setJailTurns(player.getJailTurns()+1);
                }
                //after 3 turns in jail, force payment.
                if (player.getJailTurns() == 3) {
                    System.out.println("Payment forced.");
                    gb.addToMessage("Payment forced.\n");
                    JailOutputFrame frame = new JailOutputFrame("Payment forced, you are \"free\" to go...\n");
                    if (player.canAfford(50)) {
                        player.setInJail(false);
                        player.setJailTurns(0);
                    }
                }
                gb.setCurrentPlayer((gb.getCurrentPlayer()+1)%4);
                frame.dispose();
            }
        }

    }
}



class JailOutputFrame extends JFrame{
    private String output;
    public JailOutputFrame(String s){
        JFrame frame = new JFrame();
        output = s;

        JailOutputPanel pan = new JailOutputPanel();

        frame.setSize( 600, 200 );
        frame.setVisible( true );
        frame.add(pan);

    }
    class JailOutputPanel extends JPanel{
        public JailOutputPanel() {
            JPanel panel = new JPanel();
            panel.add(new JLabel(output));
            add(panel);
        }
    }
}


class APropFrame extends JFrame{
    Gameboard board;
    public APropFrame(Gameboard gb){
        board = gb;
        JFrame frame = new JFrame("APropFrame");
        APropPanel aPanel = new APropPanel();

        frame.setSize( 600, 600 );
        frame.setVisible( true );
        frame.add(aPanel);


    }
    class APropPanel extends JPanel{
        JButton buttons[];
        public APropPanel(){
            buttons = new JButton[28];


            JPanel panel = new JPanel();
            JLabel label = new JLabel("You own the following properties, which do you wish to trade?");


            panel.setLayout(new GridLayout(7,4));

            for(int i = 0; i < 28; i++){
                buttons[i] = new JButton("Test");

                panel.add(buttons[i]);
                buttons[i].setVisible(false);
            }

            JButton cancel = new JButton("Cancel");

            panel.add(cancel);

            add(label);
            add(panel);
            add(cancel);

        }

    }

}

class BPropFrame extends JFrame{
    Gameboard board;
    public BPropFrame(Gameboard gb){
        board = gb;
        JFrame frame = new JFrame("BPropFrame");
        BPropPanel aPanel = new BPropPanel();

        frame.setSize( 600, 600 );
        frame.setVisible( true );
        frame.add(aPanel);


    }
    class BPropPanel extends JPanel{
        JButton buttons[];
        public BPropPanel(){
            buttons = new JButton[28];


            JPanel panel = new JPanel();
            JLabel label = new JLabel("The other player has the following properties, which would you like?");


            panel.setLayout(new GridLayout(7,4));

            for(int i = 0; i < 28; i++){
                buttons[i] = new JButton("Test");

                panel.add(buttons[i]);
                buttons[i].setVisible(false);
            }

            JButton cancel = new JButton("Cancel");

            panel.add(cancel);

            add(label);
            add(panel);
            add(cancel);

        }

    }

}











//
//class TradeFrame extends JFrame{
//    public TradeFrame(){
//        JFrame frame = new JFrame("Roll");
//        TradePanel roll = new TradePanel();
//
//        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
//        frame.setSize( 600, 200 );
//        frame.setVisible( true );
//        frame.add(roll);
//    }
//
//    class TradePanel extends JPanel{
//        JButton buy, sell;
//
//        public TradePanel(){
//            JPanel rPanel = new JPanel();
//
//            buy = new JButton("Yes");
//            sell = new JButton("No");
//
//
//            JLabel propLabel = new JLabel("This property is unowned, would you like to buy it?");
//            rPanel.add(propLabel);
//            rPanel.add(buy);
//            rPanel.add(sell);
//
//            add(rPanel);
//
//        }
//    }
//
//}


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