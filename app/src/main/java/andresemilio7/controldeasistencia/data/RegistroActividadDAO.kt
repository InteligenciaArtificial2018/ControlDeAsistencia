package andresemilio7.controldeasistencia.data

import android.arch.persistence.room.*

@Dao
interface RegistroActividadDAO {
    @Query("SELECT * FROM RegistroActividad ORDER BY id ASC")
    fun getRegistroList(): List<RegistroActividad>

    /**
     * Retorna una tupla desde la tabla catedraticos
     * @param idcatedratico el valor de la llave primaria a retornar.
     */
    @Query("SELECT * FROM RegistroActividad WHERE id = :id")
    fun getRegistroItem(id: Int): RegistroActividad

    /**
     * Inserta una nueva tupla en la tabla RegistroActividad.
     * @param registroactividad la tupla a insertar en la tabla.
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun saveRegistroActividad(registroActividad: RegistroActividad)


    /**
     * Actualiza una tupla en la tabla RegistroActividad.
     * @param registroactividad el valor de la tupla a actualizar.
     */
    @Update
    fun updateRegistroActividad(registroActividad: RegistroActividad)


    /**
     * Remueve una tupla de la tabla RegistroActividad.
     * @param registroactividad el valor de la tupla a remover.
     */
    @Delete
    fun deleteRegistroActividad(registroActividad: RegistroActividad)
}