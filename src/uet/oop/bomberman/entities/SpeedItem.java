package uet.oop.bomberman.entities;

import javafx.scene.image.Image;

public class SpeedItem extends Entity {
    public SpeedItem(int x, int y, Image img) {
        super(x, y, img);
    }

    @Override
    public void update() {
        // Khi bomber chạm vào, có thể tăng tốc độ di chuyển
    }
}
