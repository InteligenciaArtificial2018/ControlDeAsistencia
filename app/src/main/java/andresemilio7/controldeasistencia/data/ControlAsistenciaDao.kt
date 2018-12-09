package andresemilio7.controldeasistencia.data

import android.arch.persistence.room.*

@Dao
interface ControlAsistenciaDao {

    /**
     * Inserta una nueva tupla en la tabla Catedraticos, Clases y RegistroActividad.
     * @param catedraticos @param clases la tupla a insertar en la tabla.
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun saveCatedraticos(catedraticos: Catedraticos)
    fun saveClases(clases:Clases)
    fun saveRegistroActividad(registroActividad: RegistroActividad)

    /**
     * Actualiza una tupla en la tabla Catedraticos.
     * @param catedraticos el valor de la tupla a actualizar.
     */
    @Update
    fun updateCatedraticos(catedraticos: Catedraticos)
    fun updateClases(clases: Clases)
    fun updateRegistroActividad(registroActividad: RegistroActividad)

    /**
     * Remueve una tupla de la tabla Catedraticos.
     * @param catedraticos el valor de la tupla a remover.
     */
    @Delete
    fun deleteCatedraticos(catedraticos: Catedraticos)
    fun deleteClases(clases: Clases)
    fun deleteRegistroActividad(registroActividad: RegistroActividad)


}