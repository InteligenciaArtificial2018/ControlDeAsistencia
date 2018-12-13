package andresemilio7.controldeasistencia.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey


@Entity(tableName = "Clases",
    foreignKeys = arrayOf(ForeignKey(entity = Catedraticos::class, parentColumns = arrayOf("id"), childColumns = arrayOf("CodigoCatedratico")))
)
class Clases(
    @ColumnInfo(name = "Asignatura")
    var asignatura: String = "",
    @ColumnInfo(name = "Secciòn")
    var seccion: String = "",
    @ColumnInfo(name = "Hora")
    var hora: String = "",
    @ColumnInfo(name = "Aula")
    var aula: String = "",
    @ColumnInfo(name = "CodigoCatedratico")
    var idCatedratico: Int = 0) {
    @PrimaryKey(autoGenerate = true)
    var idCodigo: Int = 0
    }
