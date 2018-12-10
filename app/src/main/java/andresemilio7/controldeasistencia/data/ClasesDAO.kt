package andresemilio7.controldeasistencia.data

import android.arch.persistence.room.*


@Dao
interface ClasesDAO{

    /**
     * Inserta una nueva tupla en la tabla Clases.
     * @param clases la tupla a insertar en la tabla.
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun saveClases(clases: Clases)


    /**
     * Actualiza una tupla en la tabla Clases.
     * @param clases  el valor de la tupla a actualizar.
     */
    @Update
    fun updateCatedraticos(clases: Clases)


    /**
     * Remueve una tupla de la tabla Clases.
     * @param clases el valor de la tupla a remover.
     */
    @Delete
    fun deleteClases(clases: Clases)



}