/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamodel;

/**
 *
 * @author bwilliams4
 */
public abstract class building {
    
    private int roomCode;
    private String roomState;
    private String roomMode;

    public int getRoomCode() {
        return roomCode;
    }

    public void setRoomCode(int roomCode) {
        this.roomCode = roomCode;
    }

    public String getRoomState() {
        return roomState;
    }

    public void setRoomState(String roomState) {
        this.roomState = roomState;
    }

    public String getRoomMode() {
        return roomMode;
    }

    public void setRoomMode(String roomMode) {
        this.roomMode = roomMode;
    }
    
    public building(){}
    
    public building(int code){
        this.roomCode = code;
    }
    
    public building(int code, String Rstate){
        this.roomCode = code;
        this.roomState = Rstate;
    }
    
    public building(int code, String Rstate, String Rmode)
    {
        this.roomCode = code;
        this.roomState = Rstate;
        this.roomMode = Rmode;
    }
    
    public abstract room getRoom();
}
