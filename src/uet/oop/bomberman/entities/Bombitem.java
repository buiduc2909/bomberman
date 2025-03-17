package uet.oop.bomberman.entities;

import javafx.scene.image.Image;

public class Bombitem extends Entity {
    public Bombitem(int x, int y, Image img) {
        super(x, y, img);
    }

    @Override
    public void update() {
        // Khi bomber chạm vào, có thể tăng số lượng bom
    }
}
