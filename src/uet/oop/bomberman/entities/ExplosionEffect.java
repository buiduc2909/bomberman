package uet.oop.bomberman.entities;

import javafx.application.Platform;
import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

class ExplosionEffect extends Entity {
    private int direction;

    public ExplosionEffect(int x, int y, Image img, int direction) {
        super(x , y, img);
        this.direction = direction;
    }

    public int getDirection() {
        return direction;
    }

    public void updateSprite(Image img) {
        setImg(img);
        System.out.println("🔄 Updating explosion sprite");
    }
    @Override
    public void update(){
        System.out.println("🔄 ExplosionEffect update called for " + x + ", " + y);
    }
}