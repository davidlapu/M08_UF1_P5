package cat.itb.m08_uf1_p5.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Pregunta {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_pregunta")
    private int idPregunta;
    private String enunciat, resposta;

    public Pregunta(String enunciat, String resposta) {
        this.enunciat = enunciat;
        this.resposta = resposta;
    }

    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getEnunciat() {
        return enunciat;
    }

    public void setEnunciat(String enunciat) {
        this.enunciat = enunciat;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }
}