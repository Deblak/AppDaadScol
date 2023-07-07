package fr.doranco.flash.database;

import android.content.Context;
import android.util.Log;

import fr.doranco.flash.dao.LivreDao;
import fr.doranco.flash.entity.Livre;

public class LivreDatabaseTest extends Thread {

    private final DaoFactory daoFactory;
    private final LivreDao livreDao;


    public LivreDatabaseTest(Context context) {
        daoFactory = DaoFactory.getInstance(context);
        livreDao = daoFactory.getLivreDao();

    }

    @Override
    public void run() {
        super.run();
        // creation objet
        Livre livre1 = new Livre("","","", 39.99);
        // enregistrement en BD
        livreDao.create(livre1);
        Log.i("log-bd", "<---- Creation Specialite avec success ---->");
    }
}