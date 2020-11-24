package cat.itb.m08_uf1_p5.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Puntuacio {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_puntuacio")
    private int idPuntuacio;
    @ColumnInfo(name =  "user_name")
    private String userName;
    private int puntuacio;

    public Puntuacio(String userName, int puntuacio) {
        this.userName = userName;
        this.puntuacio = puntuacio;
    }


    public int getIdPuntuacio() {
        return idPuntuacio;
    }

    public void setIdPuntuacio(int idPuntuacio) {
        this.idPuntuacio = idPuntuacio;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getPuntuacio() {
        return puntuacio;
    }

    public void setPuntuacio(int puntuacio) {
        this.puntuacio = puntuacio;
    }
}
