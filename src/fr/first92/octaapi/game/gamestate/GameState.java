package fr.first92.octaapi.game.gamestate;

public enum GameState {

    WAITING(true), COUNTDOWN(false), GAME(false), END(false);

    private boolean state;

    GameState(boolean state) {
        this.state = state;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
