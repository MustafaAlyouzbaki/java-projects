public class Game implements Runnable {

    private boolean running;
    private final double updateRate = 1.0d/60.0d;
    private long nextTime ;
    private int fps, ups;
    private GameFrame game = new GameFrame();

    @Override
    public void run() {
        running = true;
        double accumulator = 0;
        long currentTime, lastUpdate = System.currentTimeMillis();
        nextTime = System.currentTimeMillis() + 1000;

        while(running) {
            currentTime = System.currentTimeMillis();
            double lastRenderTimeInSeconds = (currentTime - lastUpdate) / 1000d;
            accumulator += lastRenderTimeInSeconds;
            lastUpdate = currentTime;

            while(accumulator > updateRate) {
                update();
                accumulator -= updateRate;
            }
            render();
        }
    }

    private void render() {
        fps++;

        if(System.currentTimeMillis() > nextTime) {
            // Stats
            System.out.println(String.format("FPS: %d, UPS: %d", fps, ups));
            fps = 0;
            ups = 0;
            nextTime = System.currentTimeMillis() + 1000;

            // Game state and shape
            game.setCurrY(game.currY+1);

            game.gamePanel.repaint();
        }
    }

    private void update() {
        ups++;
    }
}
