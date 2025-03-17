package uet.oop.bomberman.entities;

import javafx.scene.image.Image;

public class Wall extends Entity {
    public Wall(int x, int y, Image img) {
        super(x, y, img);
    }

    public boolean isSolid() {
        return true;
    }

    @Override
    public void update() {
        // Không cần cập nhật vì Wall là vật thể cố định
    }
}
