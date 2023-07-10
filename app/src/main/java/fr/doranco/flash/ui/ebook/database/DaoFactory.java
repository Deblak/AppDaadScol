package fr.doranco.flash.ui.ebook.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import fr.doranco.flash.ui.ebook.dao.LivreDao;
import fr.doranco.flash.ui.ebook.entity.Livre;

/**
 * Classe initialisation de la BD de notre app
 */
@Database(entities = {Livre.class}, version = 1)
public abstract class DaoFactory extends RoomDatabase {
    private static final String DATABASE_NAME = "DAADSCOOL";
    private static DaoFactory daoFactory;

    /**
     * Getter de l'unique instance de la class
     * @param context context d'execution de l'app
     * @return instance de DaoFactory.class
     */
    public static DaoFactory getInstance(Context context){
        if (daoFactory == null){
            daoFactory = Room
                    .databaseBuilder(context, DaoFactory.class, DATABASE_NAME)
                    .build();
        }
        return daoFactory;
    }

    public  abstract LivreDao getLivreDao();
}
