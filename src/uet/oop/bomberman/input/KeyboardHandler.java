package uet.oop.bomberman.input;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import uet.oop.bomberman.entities.Bomber;
import java.util.HashMap;
import java.util.Map;

public class KeyboardHandler {
    private final Bomber bomber;
    private final Map<KeyCode, Runnable> keyActions = new HashMap<>();

    public KeyboardHandler(Scene scene, Bomber bomber) {
        this.bomber = bomber;

        keyActions.put(KeyCode.W, bomber::moveUp);
        keyActions.put(KeyCode.S, bomber::moveDown);
        keyActions.put(KeyCode.A, bomber::moveLeft);
        keyActions.put(KeyCode.D, bomber::moveRight);
        keyActions.put(KeyCode.SPACE, bomber::placeBomb);


        scene.setOnKeyPressed(event -> handleKeyPress(event.getCode()));
        scene.setOnKeyReleased(event -> handleKeyRelease(event.getCode()));
    }

    private void handleKeyPress(KeyCode key) {
        Runnable action = keyActions.get(key);
        if (action != null) {
            action.run();
        }
    }

    private void handleKeyRelease(KeyCode key) {
        bomber.stopMove();
    }
}
