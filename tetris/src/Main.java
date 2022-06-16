/*
Author: Mustafa Al-Youzbaki
Title: Tetris

I'm making this project because I love to play tetris but many sites limit player autonomy.
I want to make a tetris game with customizable controls, colours, modes, and more.
The GUI for this game is made using the java swing library.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Thread loop = new Thread(new Game());
        boolean running = true;
        loop.start();
    }

}
