package andresemilio7.controldeasistencia.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey

@Entity (tableName = "Registo de Actividad",
    foreignKeys = arrayOf(ForeignKey(entity = Clases::class, parentColumns = arrayOf("idCodigo"), childColumns = arrayOf("Codigo de Clase")))
)

class RegistroActividad(
    @ColumnInfo(name = "Hora")
    var hora: String = "",
    @ColumnInfo(name = "Fecha")
    var fecha: String = "",
    @ColumnInfo(name = "Codigo de Clase")
    var idcodigo: String = "",
    @ColumnInfo(name = "Catedratico")
    var idCatedraticos: String = "",
    @ColumnInfo(name = "Revision")
    var revision: Boolean ) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0


}