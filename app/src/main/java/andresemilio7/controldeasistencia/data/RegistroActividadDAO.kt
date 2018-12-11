package andresemilio7.controldeasistencia.data

import android.arch.persistence.room.*

@Dao
interface RegistroActividadDAO {

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