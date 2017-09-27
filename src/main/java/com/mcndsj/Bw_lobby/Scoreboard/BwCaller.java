package com.mcndsj.Bw_lobby.Scoreboard;

import com.mcndsj.Lobby_Display.API.BoardCaller;
import com.mcndsj.Lobby_Display.API.BoardRep;
import com.mcndsj.Lobby_Display.API.EntryContainer;
import com.mcndsj.Lobby_Display.Animations.WhiteAndGold;
import com.mcndsj.Lobby_Display.Scoreboard.BoardEntity;
import com.mcndsj.Lobby_Display.Scoreboard.BoardEntityStatsCallBack;
import com.mcndsj.Lobby_Statistics.Cache.DataType;
import com.mcndsj.Lobby_Statistics.lobby_Statistics;

import java.util.Collection;
import java.util.HashSet;

/**
 * Created by Matthew on 2016/4/17.
 */
public class BwCaller implements BoardCaller {
    BoardRep rep = null;

    public BwCaller(){
        Collection c = new HashSet<EntryContainer>();
        c.add(new EntryContainer(0, "www.mcndsj.com",null,false));
        c.add(new EntryContainer(1, " ",null,false));

        c.add(new EntryContainer(2, "积分: $1",null,true));
        c.add(new EntryContainer(3, "摧毁床数: $1",null,true));
        c.add(new EntryContainer(4, "  ",null,false));
        c.add(new EntryContainer(5, "K/D: $1",null,true));
        c.add(new EntryContainer(6, "击杀: $1",null,true));
        c.add(new EntryContainer(7, "胜利: $1",null,true));
        c.add(new EntryContainer(8, "场次: $1",null,true));
        c.add(new EntryContainer(9, "   ",null,false));

        rep = new BoardRep("起床战争",new WhiteAndGold("起床战争"),c);
    }

    public BoardRep getRep() {
        return rep;
    }

    public void newBoadEntryQuery(BoardEntity boardEntity, EntryContainer entryContainer) {
        String[] array;
        switch(entryContainer.index){
            case 2:
                array = new String[1];
                array[0] ="score";
                break;
            case 3:
                array = new String[1];
                array[0] ="destroyedBeds";
                break;
            case 5:
                array = new String[1];
                array[0] ="kd";
                break;
            case 6:
                array = new String[1];
                array[0] ="kills";
                break;
            case 7:
                array = new String[1];
                array[0] ="wins";
                break;
            case 8:
                array = new String[1];
                array[0] ="games";
                break;
            default:
                boardEntity.setEntry(entryContainer.index,entryContainer.entry);
                return;
        }
        lobby_Statistics.getInstance().getApi().getData(boardEntity.getPlayer().getName(),
                DataType.bedWar,
                new BoardEntityStatsCallBack(array,entryContainer,boardEntity));
    }

}
