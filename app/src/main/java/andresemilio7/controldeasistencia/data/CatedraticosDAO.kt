package andresemilio7.controldeasistencia.data

import android.arch.persistence.room.*

@Dao
interface CatedraticosDAO{

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