package com.example.taller.triviapp;

public class Pregunta {

    private int mRespId;
    private boolean mRespuestaV;

    public Pregunta(int RespId, boolean RespuestaV) {
        this.mRespId = RespId;
        this.mRespuestaV = RespuestaV;
    }

    public int getRespId() {
        return mRespId;
    }

    public void setRespId(int RespId) {
        this.mRespId = RespId;
    }

    public boolean isRespuestaV() {
        return mRespuestaV;
    }

    public void setRespuestaV(boolean RespuestaV) {
        this.mRespuestaV = RespuestaV;
    }
}
