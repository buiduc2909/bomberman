package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;

import java.util.List;
import java.util.Random;

public class Balloon extends Ghost {
    private int direction = new Random().nextInt(4); // 0: Up, 1: Down, 2: Left, 3: Right

    public Balloon(int x, int y, Image img, List<Entity> stillObjects) {
        super(x, y, img, stillObjects);
    }

    @Override
    public void move() {
        if (!alive) return;

        int dx = 0, dy = 0;
        switch (direction) {
            case 0: dy = -Sprite.SCALED_SIZE; img = Sprite.balloom_left1.getFxImage(); break;
            case 1: dy = Sprite.SCALED_SIZE; img = Sprite.balloom_right1.getFxImage(); break;
            case 2: dx = -Sprite.SCALED_SIZE; img = Sprite.balloom_left2.getFxImage(); break;
            case 3: dx = Sprite.SCALED_SIZE; img = Sprite.balloom_right2.getFxImage(); break;
        }

        if (canMove(x + dx, y + dy)) {
            x += dx;
            y += dy;
        } else {
            direction = new Random().nextInt(4); // Đổi hướng nếu gặp tường
        }
    }

    private boolean canMove(int newX, int newY) {
        int gridX = newX / Sprite.SCALED_SIZE;
        int gridY = newY / Sprite.SCALED_SIZE;

        for (Entity entity : stillObjects) {
            int entityGridX = entity.getX() / Sprite.SCALED_SIZE;
            int entityGridY = entity.getY() / Sprite.SCALED_SIZE;

            if (entityGridX == gridX && entityGridY == gridY) {
                return !(entity instanceof Wall || entity instanceof Brick);
            }
        }
        return true;
    }
}
