package andresemilio7.controldeasistencia.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = [Catedraticos::class, Clases::class, RegistroActividad::class], version = 21, exportSchema = false)
abstract class ControlDeAsistenciaDatabase: RoomDatabase() {
    /*
     * Este es un método abstracto que retorna el DAO para la base de datos.
     */
    abstract fun getCatedraticosDao(): CatedraticosDAO
    abstract fun getClasesDao(): ClasesDAO
    abstract fun getRegistroActividadDAO(): RegistroActividadDAO

    /**
     * Un patrón de diseño Singleton es utilizado para asegurarnos que
     * solamente se cree una instancia de la base de datos.
     */
    companion object {
        val databaseName = "controlasistenciadatabase"
        var controlAsistenciaDatabase: ControlDeAsistenciaDatabase? = null

        fun getInstance(context: Context): ControlDeAsistenciaDatabase? {
            if (controlAsistenciaDatabase == null) {
                controlAsistenciaDatabase = Room.databaseBuilder(
                    context,
                    ControlDeAsistenciaDatabase::class.java,
                    ControlDeAsistenciaDatabase.databaseName
                )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return controlAsistenciaDatabase
        }
    }
}
