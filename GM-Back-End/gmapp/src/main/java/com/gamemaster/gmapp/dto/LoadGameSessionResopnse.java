package com.gamemaster.gmapp.dto;

import com.gamemaster.gmapp.model.GameSession;

//This class was created so that we could return both the GameSession object, and the latest save state blob in a single API response
public class LoadGameSessionResopnse {
    private GameSession session; //GameSession object for the loaded game
    private String latestStateBlob; //Blob representing the latest saved state of the game session

    public LoadGameSessionResopnse(GameSession session, String latestStateBlob) {
        this.session = session;
        this.latestStateBlob = latestStateBlob;
    }

    public GameSession getSession()
    {
        return session;
    }

    public String getLatestStateBlob()
    {
        return latestStateBlob;
    }
}
