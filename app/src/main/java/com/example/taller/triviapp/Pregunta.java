package com.example.taller.triviapp;

public class Pregunta {

    private int mPreguntaId;
    private boolean mRespuestaV;



    public Pregunta(int PreguntaId, boolean RespuestaV) {
        this.mPreguntaId = PreguntaId;
        this.mRespuestaV = RespuestaV;
    }

    public int getPreguntaId() {
        return mPreguntaId;
    }

    public void setPreguntaId(int PreguntaId) {
        this.mPreguntaId = PreguntaId;
    }

    public boolean isRespuestaV() {
        return mRespuestaV;
    }

    public void setRespuestaV(boolean RespuestaV) {
        this.mRespuestaV = RespuestaV;
    }
}
