package cat.itb.m08_uf1_p5.database;

import java.util.List;

public class PuntuacioRepository {
    PuntuacioDao dao;

    public PuntuacioRepository(PuntuacioDao dao) {
        this.dao = dao;
    }

    public void insert(Puntuacio p) {
        dao.insert(p);
    }

    public List<Puntuacio> getPuntuacions() {
        return dao.getPuntuacions();
    }

    public void nuke() {
        dao.nuke();
    }
}
