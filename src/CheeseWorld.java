//K. Chun 8/2018

//*******************************************************************************
//Import Section
//Add Java libraries needed for the game
//import java.awt.Canvas;

//Graphics Libraries

import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.*;
import javax.swing.*;
import java.util.LinkedList;


/***
 * Step 0 for keyboard control - Import
 */
import java.awt.event.*;

/***
 * Step 1 for keyboard control - implements KeyListener
 */
public class CheeseWorld implements Runnable, KeyListener {

    //Variable Definition Section

    //Sets the width and height of the program window
    final int WIDTH = 1000;
    final int HEIGHT = 650;

    //Declare the variables needed for the graphics
    public JFrame frame;
    public Canvas canvas;
    public JPanel panel;
    public BufferStrategy bufferStrategy;

    //Declare the variables needed for images
    public Image cheesePic;
    public Image mousePic;
    public Image FalconPic;
    public Image CastlePic;
    public Image TiePic;
    public Image DestroyerPic;
    //Declare the character objects
    //public Mouse mouse1;
    public Cheese theCheese;
    public Player user;
    public Mouse[] tiefighters = new Mouse[5];
    public int x;
    public bullet[] red = new bullet[100];
    public background round2;
    public background[] target = new background[10];
    public Image bulletPic;
    public bullet green;
    public Image laserPic;
    public Image heart3Pic;
    public Image heart2Pic;
    public Image heart1Pic;
    public bullet[] blue = new bullet[100];
    public Image bluePic;
    public Mouse[] stardestroyers = new Mouse [3];
    public int y;
    public Image round2Pic;
    public Image targetPic;
    public Image GameOverPic;
    public background GameOver;
    public boolean gameover;
    public bullet[] coin = new bullet [4];
    public Image coinPic;




    // Main method definition
    // This is the code that runs first and automatically
    public static void main(String[] args) {
        CheeseWorld myApp = new CheeseWorld();   //creates a new instance of the game
        new Thread(myApp).start();               //creates a threads & starts up the code in the run( ) method
    }

    // Constructor Method - setup portion of the program
    // Initialize your variables and construct your program objects here.
    public CheeseWorld() {
        y = 0;
        setUpGraphics();

        /***
         * Step 2 for keyboard control - addKeyListener(this) to the canvas
         */
        canvas.addKeyListener(this);

        //load images
        //cheesePic = Toolkit.getDefaultToolkit().getImage("cheese.gif");
        laserPic = Toolkit.getDefaultToolkit().getImage("starwarslaser.png");
        mousePic = Toolkit.getDefaultToolkit().getImage("jerry.gif");
        FalconPic = Toolkit.getDefaultToolkit().getImage("xwingstarwars.png");
        CastlePic = Toolkit.getDefaultToolkit().getImage("space background.jpeg");
        TiePic = Toolkit.getDefaultToolkit().getImage("Starwarstiefighter.png");
        bulletPic = Toolkit.getDefaultToolkit().getImage("starwarsbullet.png");
        heart3Pic = Toolkit.getDefaultToolkit().getImage("3hearts.png");
        heart2Pic = Toolkit.getDefaultToolkit().getImage("2hearts.png");
        heart1Pic = Toolkit.getDefaultToolkit().getImage("1heart.png");
        bluePic = Toolkit.getDefaultToolkit().getImage("bluelaser.png");
        DestroyerPic = Toolkit.getDefaultToolkit().getImage("stardestroyer.png");
        round2Pic = Toolkit.getDefaultToolkit().getImage("Round_2-removebg-preview.png");
        targetPic = Toolkit.getDefaultToolkit().getImage("taget1.png");
        GameOverPic = Toolkit.getDefaultToolkit().getImage("GameOver.jpeg");
        //create (construct) the objects needed for the gamea
        //mouse1 = new Mouse(200, 300, 4, 4, mousePic);
        //theCheese = new Cheese(700, 300, 3, -4, cheesePic);
        user = new Player(250, 250, 20, 20, FalconPic);
        //red = new bullet (0,0,0,0, bulletPic);
        green = new bullet (0,0,0,0, laserPic);
        round2 = new background (0,0,0,0, round2Pic);
        GameOver = new background (0,0,0,0, GameOverPic);
        gameover = true;
        coinPic = Toolkit.getDefaultToolkit().getImage("Coin.png");

    } // CheeseWorld()


//*******************************************************************************
//User Method Section

    // main thread
    // this is the code that plays the game after you set things up
    public void moveThings() {

        user.move();
        for (int i = 0; i < red.length; i++) {
            red[x].move();
        }
        for (int i = 0; i < tiefighters.length; i++) {
            tiefighters[i].move();
            }
        for (int i = 0; i < stardestroyers.length; i++) {
            if (y == 5) {
                stardestroyers[i].move();
            }
        }
        if (green.isAlive == true) {
            green.move();
            }
        for (int i = 0; i < tiefighters.length; i++) {
            blue[i].move();
            if (blue[i].xpos < 10) {
                blue[i].xpos = tiefighters[i].xpos;
                blue[i].ypos = tiefighters[i].ypos;
                //System.out.println("blue " + i + "xpos = " + blue[x].xpos);}
        }}

            }

    public void checkIntersections() {
        for(int k = 0; k < red.length; k++) {
            for (int i = 0; i < tiefighters.length; i++) {
                if (tiefighters[i].rec.intersects(red[k].rec)) {
                    tiefighters[i].health = tiefighters[i].health - 1;
                }
            }
        }
        for (int i = 0; i < tiefighters.length; i++) {
            //System.out.println (blue[i].isAlive);
            if (blue[i].rec.intersects(user.rec) && blue[i].isAlive == true) {
                user.isAlive = false;
                gameover = false;
               // w tiefighters[i].isAlive = false;\
        }
        }
        for (int i = 0; i < tiefighters.length; i++){
            if (tiefighters[0].health < 1 && tiefighters[1].health <1 && tiefighters[2].health <1 && tiefighters[3].health <1 && tiefighters[4].health <1 && y<5 ){
                y = 5;}

    }
        for (int x = 0; x<coin.length; x++) {
            if (coin[x].rec.intersects(user.rec)) {
                coin[x].isAlive = false;
            }
        }

    }

    public void run() {
        for (int i = 0; i < tiefighters.length; i ++) {
            Mouse myTiefighters = new Mouse((int)(800 + Math.random()* 100), (int)(Math.random()*700), 0, 2,TiePic);
            tiefighters[i] = myTiefighters;
            //tiefighters[i].isAlive = true;
            bullet myblue = new bullet(-100, -100, 0, 0, bluePic);
            blue[i] = myblue;
            blue[i].xpos = tiefighters[i].xpos;
            blue[i].ypos = tiefighters[i].ypos;
            blue[i].isAlive = true;
            blue[i].dx = -8;
            System.out.println("tiefighter " + i + "xpos = " + tiefighters[i].xpos);
        }
        for (int x = 0; x < stardestroyers.length; x++) {
            Mouse myStardestroyers = new Mouse((int) (800 + Math.random() * 100), (int) (Math.random() * 700), 0, 2, TiePic);
            stardestroyers[x] = myStardestroyers;
            stardestroyers[x].isAlive = true;
        }

        for (int x = 0; x<coin.length; x++) {
            bullet mycoin  = new bullet((int) (200 + Math.random() * 100), (int) (Math.random() * 700), 0 , 2, coinPic);
            coin[x] = mycoin;
            coin[x].height = 20;
            coin[x].width = 20;
        }

        for (int x = 0; x < red.length; x ++) {
            bullet myred = new bullet(-100, -100, 0, 0, bulletPic);
            red[x] = myred;

        }



            while (true) {

            moveThings();           //move all the game objects
            checkIntersections();   // check character crashes
            render();               // paint the graphics
            pause(20);
            GameOver.height = 700;
            GameOver.width = 1000;


            // sleep for 20 ms
        }
    }

    //paints things on the screen using bufferStrategy
    private void render() {
        Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
        g.clearRect(0, 0, WIDTH, HEIGHT);

        //draw characters to the screen

        // g.drawImage(mouse1.pic, mouse1.xpos, mouse1.ypos, mouse1.width, mouse1.height, null);
        //g.drawImage(theCheese.pic, theCheese.xpos, theCheese.ypos, theCheese.width, theCheese.height, null);

        if (gameover == true) {
            g.drawImage(CastlePic, 0, 0, 1000, 700, null);
            g.drawImage(user.pic, user.xpos, user.ypos, user.width, user.height, null);
            System.out.println(gameover);
        }
        else{
            g.drawImage(GameOverPic, GameOver.xpos, GameOver.ypos, GameOver.width, GameOver.height, null);
        }


        if (gameover == true){
            for (int i = 0; i < tiefighters.length; i++) {
                tiefighters[i].isAlive = true;

                if (tiefighters[i].health == 3) {
                    //}
                    //if (tiefighters[i].isAlive == true)  {
                    g.drawImage(heart3Pic, tiefighters[i].xpos, tiefighters[i].ypos, tiefighters[i].width, tiefighters[i].height, null);
                }
                if (tiefighters[i].health == 2) {
                    g.drawImage(heart2Pic, tiefighters[i].xpos, tiefighters[i].ypos, tiefighters[i].width, tiefighters[i].height, null);
                }
                if (tiefighters[i].health == 1) {
                    g.drawImage(heart1Pic, tiefighters[i].xpos, tiefighters[i].ypos, tiefighters[i].width, tiefighters[i].height, null);
                }
                if (tiefighters[i].health < 1){
                    tiefighters[i].isAlive = false;
                    blue[i].isAlive = false;
                }
                if (tiefighters[i].isAlive == true){
                    g.drawImage(bluePic, blue[i].xpos, blue[i].ypos, blue[i].width, blue[i].height, null);
                }

            }
            for (int i = 0; i<stardestroyers.length; i = i + 1)
                if (y == 5) {
                    g.drawImage (round2Pic, round2.xpos, round2.ypos, round2.width, round2.height, null );
                    g.drawImage(DestroyerPic, stardestroyers[i].xpos, stardestroyers[i].ypos, stardestroyers[i].width, stardestroyers[i].height, null);
                }
            //for(bullet x : red){
            //if(x.isAlive == true){
            if (green.isAlive == true) {
                g.drawImage(laserPic, green.xpos, green.ypos, green.width, green.height, null);
            }
            if (red[x].isAlive == true) {
                g.drawImage(bulletPic, red[x].xpos, red[x].ypos, red[x].width, red[x].height, null);
            }
            for (x = 0; x<coin.length; x++){
                if (coin[x].isAlive == false);
                    g.drawImage(coinPic, coin[x].xpos,coin[x].ypos, coin[x].width, coin[x].height, null );
            }
        }

        g.dispose();
        bufferStrategy.show();
    }

    //public void intersections () {
        //if (red.rec.intersects(mouse1.rec) && red.isIntersecting == false);
  //  }

    /***
     * Step 3 for keyboard control - add required methods
     * You need to have all 3 even if you aren't going to use them all
     */
    public void keyPressed(KeyEvent event) {
        //This method will do something whenever any key is pressed down.
        //Put if( ) statements hereda
        char key = event.getKeyChar();     //gets the character of the key pressed
        int keyCode = event.getKeyCode();  //gets the keyCode (an integer) of the key pressed
        System.out.println("Key Pressed: " + key + "  Code: " + keyCode);

        if (keyCode == 68) { // d
            user.right = true;
        }
        if (keyCode == 65) { // a
            user.left = true;
        }

        if (keyCode == 83) { // s
            user.down = true;
        }
        if (keyCode == 87) { // w
            user.up = true;
        }
        if (keyCode == 68) { // d
            user.right = true;
        }
        if (keyCode == 65) { // a
            user.left = true;
        }

        if (keyCode == 83) { // s
            user.down = true;
        }
        if (keyCode == 87) { // w
            user.up = true;
        }
        if (keyCode == 32) {
            red[x].isAlive = true;
            red[x].xpos = user.xpos;
            red[x].ypos = user.ypos + 25;
            red[x].dx = 1;
                if (red[x].xpos == 1000) {
                    red[x].isAlive = false;
                }

        }
            if (keyCode == 69) {
                green.isAlive = true;
                green.dx = 50;
                green.xpos = user.xpos;
                green.ypos = user.ypos + 25;
            }


        }//keyPressed()

    public void keyReleased(KeyEvent event) {
        char key = event.getKeyChar();
        int keyCode = event.getKeyCode();
        //This method will do something when a key is released
        if (keyCode == 68) { // d
            user.right = false;
        }
        if (keyCode == 65) { // a
            user.left = false;
        }
        if (keyCode == 83) { // s
            user.down = false;
        }
        if (keyCode == 87) { // w
            user.up = false;
        }
      //  if (keyCode == 32);
        //red.isAlive = false;

    }//keyReleased()

    public void keyTyped(KeyEvent event) {
        // handles a press of a character key (any key that can be printed but not keys like SHIFT)
        // we won't be using this method, but it still needs to be in your program
    }//keyTyped()


    //Graphics setup method
    public void setUpGraphics() {
        frame = new JFrame("CheeseWorld");   //Create the program window or frame.  Names it.

        panel = (JPanel) frame.getContentPane();  //sets up a JPanel which is what goes in the frame
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));  //sizes the JPanel
        panel.setLayout(null);   //set the layout

        // creates a canvas which is a blank rectangular area of the screen onto which the application can draw
        // and trap input events (Mouse and Keyboard events)
        canvas = new Canvas();
        canvas.setBounds(0, 0, WIDTH, HEIGHT);
        canvas.setIgnoreRepaint(true);

        panel.add(canvas);  // adds the canvas to the panel.

        // frame operations
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //makes the frame close and exit nicely
        frame.pack();  //adjusts the frame and its contents so the sizes are at their default or larger
        frame.setResizable(false);   //makes it so the frame cannot be resized
        frame.setVisible(true);      //IMPORTANT!!!  if the frame is not set to visible it will not appear on the screen!

        // sets up things so the screen displays images nicely.
        canvas.createBufferStrategy(2);
        bufferStrategy = canvas.getBufferStrategy();
        canvas.requestFocus();
        System.out.println("DONE graphic setup");

    }

    //Pauses or sleeps the computer for the amount specified in milliseconds
    public void pause(int time) {
        //sleep
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {

        }
    }

}//class
