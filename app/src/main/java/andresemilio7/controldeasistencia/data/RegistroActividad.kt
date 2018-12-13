package andresemilio7.controldeasistencia.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey

@Entity (tableName = "Registo de Actividad",
    foreignKeys = [ForeignKey(entity = Clases::class, parentColumns = arrayOf("idCodigo"), childColumns = arrayOf("CodigoClase")), ForeignKey(entity = Catedraticos::class, parentColumns = arrayOf("id"), childColumns = arrayOf("Catedratico"))]
)

class RegistroActividad(
    @ColumnInfo(name = "Hora")
    var hora: String = "",
    @ColumnInfo(name = "Fecha")
    var fecha: String = "",
    @ColumnInfo(name = "CodigoClase")
    var idcodigo: String = "",
    @ColumnInfo(name = "Catedratico")
    var idCatedratico: String = "",
    @ColumnInfo(name = "Revision")
    var revision: Boolean ) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0


}