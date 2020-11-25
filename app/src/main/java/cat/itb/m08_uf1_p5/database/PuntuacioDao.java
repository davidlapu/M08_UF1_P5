package cat.itb.m08_uf1_p5.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PuntuacioDao {

    @Insert
    void insert(Puntuacio puntuacio);

    @Query("SELECT * FROM puntuacio ORDER BY puntuacio DESC")
    List<Puntuacio> getPuntuacions();

    @Query("DELETE FROM puntuacio")
    void nuke();

}
