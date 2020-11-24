package cat.itb.m08_uf1_p5.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PreguntaDao {

    @Query("SELECT * FROM pregunta")
    List<Pregunta> getAll();

    @Insert
    void insert(Pregunta pregunta);


}
