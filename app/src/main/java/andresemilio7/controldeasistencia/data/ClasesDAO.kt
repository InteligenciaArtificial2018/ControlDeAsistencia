package andresemilio7.controldeasistencia.data

import android.arch.persistence.room.*


@Dao
interface ClasesDAO{

    @Query("SELECT * FROM Clases ORDER BY Clase ASC")
    fun getClasesList(): List<Clases>

    /**
     * Retorna una tupla desde la tabla catedraticos
     * @param idcatedratico el valor de la llave primaria a retornar.
     */
    @Query("SELECT * FROM Clases WHERE Clase = :idCodigo")
    fun getClasesItem(idCodigo: String): Clases
    /**
     * Inserta una nueva tupla en la tabla Clases.
     * @param clases la tupla a insertar en la tabla.
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun saveClases(clases: Clases)


    /*@Query("SELECT Catedraticos.Usuario FROM Catedraticos INNER JOIN Clases ON CodigoCatedratico = Catedraticos.Usuario")
    fun getverificarCatedraticos(catedraticos: Catedraticos)*/
    /**
     * Actualiza una tupla en la tabla Clases.
     * @param clases  el valor de la tupla a actualizar.
     */
    @Update
    fun updateClases(clases: Clases)


    /**
     * Remueve una tupla de la tabla Clases.
     * @param clases el valor de la tupla a remover.
     */
    @Delete
    fun deleteClases(clases: Clases)



}