package andresemilio7.controldeasistencia.data

import android.arch.persistence.room.*


@Entity(tableName = "Clases"

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
    var idCatedratico: String = ""){
    @PrimaryKey(autoGenerate = true)
    var idCodigo: Int = 0}

