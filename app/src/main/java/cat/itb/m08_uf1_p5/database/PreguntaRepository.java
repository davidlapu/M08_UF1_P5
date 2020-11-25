package cat.itb.m08_uf1_p5.database;

import java.util.List;

public class PreguntaRepository {
    PreguntaDao dao;

    public PreguntaRepository(PreguntaDao dao) {
        this.dao = dao;
    }

    public List<Pregunta> getAll() {
        return dao.getAll();
    }

    public List<Pregunta> get5Rand() {
        return dao.get5Rand();
    }

    public void insert(Pregunta p) {
        dao.insert(p);
    }

}
