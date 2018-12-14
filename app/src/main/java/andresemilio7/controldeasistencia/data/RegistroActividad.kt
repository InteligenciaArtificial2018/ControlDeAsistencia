package andresemilio7.controldeasistencia.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey

@Entity (tableName = "RegistoDeActividad"
)

class RegistroActividad(
    @ColumnInfo(name = "CodigoClase")
    var idcodigo: String = "",
    @ColumnInfo(name = "Catedratico")
    var idCatedratico: String = "",
    @ColumnInfo(name = "Hora")
    var hora: String = "",
    @ColumnInfo(name = "Aula")
    var aula: String = "",
    @ColumnInfo(name = "Fecha")
    var fecha: String = "",
    @ColumnInfo(name = "Revision")
    var revision: Int = 0 ) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0


}