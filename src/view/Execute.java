package view;

import com.formdev.flatlaf.FlatLightLaf;
import logic.LogicLobby;

public class Execute {
    public static void main(String[] args) {
        FlatLightLaf.setup();
        LogicLobby lobby = new LogicLobby(new Lobby());
    }
}
