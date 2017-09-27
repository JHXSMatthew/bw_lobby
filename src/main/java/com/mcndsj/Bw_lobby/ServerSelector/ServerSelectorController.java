package com.mcndsj.Bw_lobby.ServerSelector;

import com.mcndsj.LobbyServerSelector.LobbyServerSelector;

/**
 * Created by Matthew on 2016/4/18.
 */
public class ServerSelectorController {
    public ServerSelectorController(){
        LobbyServerSelector.getInstance().getApi().register("bw","经典起床");
    }
}
