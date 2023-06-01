package fr.first92.octaapi.game.gamestate;

import java.util.Arrays;

public class GameStateManager {

    public void setState(GameState gameState) {

        Arrays.stream(GameState.values()).forEach(rs -> rs.setState(false));
        gameState.setState(true);
    }

    public GameState getState() {
        return Arrays.stream(GameState.values()).filter(rs -> rs.isState() == true).findFirst().get();
    }

    public boolean isState(GameState gameState) {
        return gameState.isState();
    }
}
