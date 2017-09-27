package com.mcndsj.Bw_lobby;

import com.mcndsj.Lobby_Display.Lobby_Display;
import com.mcndsj.Bw_lobby.Listeners.PlayerListener;
import com.mcndsj.Bw_lobby.Scoreboard.BwCaller;
import com.mcndsj.Bw_lobby.ServerSelector.ServerSelectorController;
import com.mcndsj.lobby_Control.LobbyControlAPIs;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Matthew on 2016/4/16.
 */
public class Bw_Lobby extends JavaPlugin{


    private ServerSelectorController control;
    private static Bw_Lobby instance;

    public void onEnable(){
        instance = this;
        Lobby_Display.getInstance().getApi().registerBoardCaller(new BwCaller());
        control = new ServerSelectorController();


        //getServer().getPluginManager().registerEvents(new PlayerListener(),this);

        LobbyControlAPIs.registerRestartPort(Config.startingPort);
    }

    public static Bw_Lobby get(){
        return instance;
    }
}
