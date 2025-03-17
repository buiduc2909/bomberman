package uet.oop.bomberman.entities;

import javafx.application.Platform;
import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;

import java.util.Timer;
import java.util.TimerTask;

public class Brick extends Entity {
    private boolean exploding = false;
    private Timer timer = new Timer();

    public Brick(int x, int y, Image img) {
        super(x, y, img);
    }

    public void explode() {
        if (!exploding) {
            exploding = true;

            // Chuyển ảnh nổ theo thời gian
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    Platform.runLater(() -> setImg(Sprite.brick_exploded.getFxImage()));
                }
            }, 0);

            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    Platform.runLater(() -> setImg(Sprite.brick_exploded1.getFxImage()));
                }
            }, 200);

            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    Platform.runLater(() -> setImg(Sprite.brick_exploded2.getFxImage()));
                }
            }, 400);

            // Sau khi xong hiệu ứng, xóa brick
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    Platform.runLater(() -> removeBrick());
                }
            }, 600);
        }
    }

    private void removeBrick() {
        // Có thể set active hoặc báo cho game rằng gạch đã bị phá
        this.setActive(false); // Nếu bạn có thuộc tính active
    }

    @Override
    public void update() {
        // Kiểm tra nếu đang nổ thì cập nhật ảnh nổ
        if (exploding) {
            // Hình ảnh đã được cập nhật qua TimerTask nên không cần thay đổi gì thêm
        }
    }
}
