package fr.doranco.flash.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import fr.doranco.flash.entity.Livre;

@Dao
public interface LivreDao {

    /**
     * @param livre
     */
    @Insert
    void create(Livre livre);

    /**
     * @param id
     * @return
     */
    @Query("SELECT * FROM livres WHERE id= :id")
    Livre findById(int id);

    /**
     * @return
     */
    @Query("SELECT * FROM livres")
    List<Livre> findByAll();

    @Update
    void update(Livre livre);

    @Delete
    void delete(Livre livre);
}
