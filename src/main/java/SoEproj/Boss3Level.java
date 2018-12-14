package SoEproj;


import java.util.List;


public class Boss3Level extends Alien implements Runnable{

    // TODO Cambiare immagine boss1
    private String imagePath = ".\\src\\main\\java\\SoEproj\\Resource\\Boss3Image.png";
    private boolean goDown = true;          // to set boss go at first down and then up
    private final int TOT_LIFE = life;
    private List<Alien> aliens;

    public Boss3Level(int x, int y, List<Alien> aliens) {
        super(x, y, 20);
        this.aliens = aliens;
        SPACE = 3/2;
        super.points = 800;

        loadImage(imagePath);
        getImageDimensions();

        Thread AlienMissileAnimator = new Thread(this);
        AlienMissileAnimator.start();
    }
    
    
    @Override
    public void move() {            // Boss enters in scene and then moves up and down
        if (x >= INITIAL_X-30) {
            x -= SPACE;
        }
        else {
            if (goDown) {
                y += SPACE;
                if (y > 400) {
                    goDown = false;
                }
            } else {
                y -= SPACE;
                if (y < 0) {
                    goDown = true;
                }
            }
        }
    }


    public synchronized List<Missile> getMissiles() {
        return missiles;
    }


    public synchronized void fire() {
            missiles.add(new Missile(x , y + height/2, "Laser", "rightToTop"));
            missiles.add(new Missile(x , y + height/2, "Laser", "rightToLeft"));
            missiles.add(new Missile(x , y + height/2, "Laser", "rightToBottom"));
    }


    @Override
    public void run() {
        while(isVisible()){
            synchronized(aliens){
                if (life < TOT_LIFE * 0.5 && aliens.size() == 1) {  // the aliens must appear only if there aren't other aliens 
                    aliens.add(new EasyAlien(x, y - 30, "BossHelper", goDown));
                    aliens.add(new EasyAlien(x, y, "BossHelper", goDown));
                    aliens.add(new EasyAlien(x, y + 30, "BossHelper", goDown));
                }
            }

            try {
                Thread.sleep(5000);
                fire();
            } catch (InterruptedException e) {
                System.out.println("Thread Boss1: " + e.getMessage());
            }

        }
    }

}