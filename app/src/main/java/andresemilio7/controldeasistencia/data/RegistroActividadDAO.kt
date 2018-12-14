package andresemilio7.controldeasistencia.data

import android.arch.persistence.room.*

@Dao
interface RegistroActividadDAO {
    @Query("SELECT * FROM RegistoDeActividad ORDER BY id ASC")
    fun getRegistrosList(): List<RegistroActividad>

    /**
     * Retorna una tupla desde la tabla catedraticos
     * @param id el valor de la llave primaria a retornar.
     */
    @Query("SELECT * FROM RegistoDeActividad WHERE id = :id")
    fun getRegistrosItem(id: Int): RegistroActividad

    /**
     * Inserta una nueva tupla en la tabla RegistroActividad.
     * @param registroactivid la tupla a insertar en la tabla.
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