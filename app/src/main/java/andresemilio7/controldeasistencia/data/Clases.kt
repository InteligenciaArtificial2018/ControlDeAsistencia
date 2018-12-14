package andresemilio7.controldeasistencia.data

import android.arch.persistence.room.*


@Entity(tableName = "Clases"/*,
    foreignKeys = arrayOf(ForeignKey(entity = Catedraticos::class, parentColumns = arrayOf("id"), childColumns = arrayOf("CodigoCatedratico"))),
    indices = arrayOf(Index(value =  ["Hora"], unique = true))*/

)
class Clases(
    @ColumnInfo(name = "Asignatura")
    var asignatura: String = "",
    @ColumnInfo(name = "Seccion")
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
