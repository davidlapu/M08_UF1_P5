package cat.itb.m08_uf1_p5.database;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface PuntuacioDao {



    @Insert
    void insert(Puntuacio puntuacio);
}
