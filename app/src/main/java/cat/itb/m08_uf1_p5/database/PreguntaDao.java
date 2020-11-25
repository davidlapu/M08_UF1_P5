package cat.itb.m08_uf1_p5.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PreguntaDao {

    @Query("SELECT * FROM pregunta")
    List<Pregunta> getAll();

    @Query("SELECT * FROM pregunta ORDER BY RANDOM() LIMIT 5")
    List<Pregunta> get5Rand();

    @Insert
    void insert(Pregunta pregunta);

}
