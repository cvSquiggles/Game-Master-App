package com.gamemaster.gmapp.dto;

import java.util.UUID;

public class SaveGameSessionRequest {

    private UUID activeSessionToken; //Token representing the most recent user session that "loaded" the game session from the database
    private String stateBlob; //This is going to be a JSONBlob string containing all the game state information to be saved if the activeSessionToken is validated successfully

    //Getters and Setters

    public UUID getActiveSessionToken() {
        return activeSessionToken;
    }

    public void setActiveSessionToken(UUID activeSessionToken) {
        this.activeSessionToken = activeSessionToken;
    }

    public String getStateBlob() {
        return stateBlob;
    }

    public void setStateBlob(String stateBlob) {
        this.stateBlob = stateBlob;
    }
}
