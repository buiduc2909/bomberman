package uet.oop.bomberman.entities;

import javafx.scene.image.Image;

public class FlameItem extends Entity {
    public FlameItem(int x, int y, Image img) {
        super(x, y, img);
    }

    @Override
    public void update() {
        // Khi bomber chạm vào, có thể tăng tầm nổ của bom
    }
}
