package uet.oop.bomberman.entities;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;
import java.util.List;
import javafx.scene.input.KeyCode;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;


public class Bomber extends Entity {
    private int speed = 2;
    private boolean movingUp, movingDown, movingLeft, movingRight;
    private List<Entity> enemies;
    public List<Entity> getBombs() {
        return bombs;
    }

    public void setBombs(List<Entity> bombs) {
        this.bombs = bombs;
    }

    private List<Entity> stillObjects; // Danh sách các vật thể tĩnh (để kiểm tra va chạm)
    private List<Entity> bombs;  // Danh sách các quả bom

    public Bomber(int x, int y, Image img, List<Entity> stillObjects, List<Entity> bombs,List<Entity> enemies) {
        super(x, y, img);
        this.stillObjects = stillObjects;
        this.enemies = enemies;
        this.bombs = bombs;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveUp() {
        int newY = y - Sprite.SCALED_SIZE;
        if (canMove(x, newY)) {
            y = newY;
        }
    }

    public void moveDown() {
        int newY = y + Sprite.SCALED_SIZE;
        if (canMove(x, newY)) {
            y = newY;
        }
    }

    public void moveLeft() {
        int newX = x - Sprite.SCALED_SIZE;
        if (canMove(newX, y)) {
            x = newX;
        }
    }

    public void moveRight() {
        int newX = x + Sprite.SCALED_SIZE;
        if (canMove(newX, y)) {
            x = newX;
        }
    }


    public void stopMove() {
        movingUp = movingDown = movingLeft = movingRight = false;
    }

    private boolean canMove(int newX, int newY) {
        for (Entity entity : stillObjects) {
            if (entity instanceof Wall || entity instanceof Brick) {
                if (entity.getX() == newX && entity.getY() == newY) {
                    return false; // Không thể di chuyển vào tường hoặc gạch
                }
            }
        }
        return true;
    }

    public void placeBomb() {
        int bombX = this.x / Sprite.SCALED_SIZE;
        int bombY = this.y / Sprite.SCALED_SIZE;

        // Kiểm tra nếu chưa có bom ở vị trí đó
        for (Entity bomb : bombs) {
            if (bomb.getX() / Sprite.SCALED_SIZE == bombX && bomb.getY() / Sprite.SCALED_SIZE == bombY) {
                return; // Đã có bom, không đặt thêm
            }
        }

        Bomb bomb = new Bomb(bombX, bombY, stillObjects, bombs,enemies);
        bombs.add(bomb);
    }


    @Override
    public void update() {
        int newX = x, newY = y;

        if (movingUp) newY -= speed;
        if (movingDown) newY += speed;
        if (movingLeft) newX -= speed;
        if (movingRight) newX += speed;

        // Kiểm tra trước khi di chuyển
        if (canMove(newX, newY)) {
            x = newX;
            y = newY;
        }
    }
}
