package andresemilio7.controldeasistencia.data

import android.arch.persistence.room.*

@Dao
interface CatedraticosDAO{

    @Query("SELECT * FROM Catedraticos ORDER BY Usuario ASC")
    fun getCatedraticosList(): List<Catedraticos>

    /**
     * Retorna una tupla desde la tabla catedraticos
     * @param idcatedratico el valor de la llave primaria a retornar.
     */
    @Query("SELECT * FROM Catedraticos WHERE Usuario = :id")
    fun getCatedraticosItem(id: Int): Catedraticos



    /**
     * Inserta una nueva tupla en la tabla Catedraticos.
     * @param catedraticos la tupla a insertar en la tabla.
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun saveCatedraticos(catedraticos: Catedraticos)


    /**
     * Actualiza una tupla en la tabla Catedraticos.
     * @param catedraticos  el valor de la tupla a actualizar.
     */
    @Update
    fun updateCatedraticos(catedraticos: Catedraticos)


    /**
     * Remueve una tupla de la tabla Catedraticos.
     * @param catedraticos el valor de la tupla a remover.
     */
    @Delete
    fun deleteCatedraticos(catedraticos: Catedraticos)



}