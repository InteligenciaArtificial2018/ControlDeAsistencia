package andresemilio7.controldeasistencia.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey


@Entity(tableName = "Clases")
class Clases(
    @ColumnInfo(name = "Asignatura")
    var asignatura: String = "",
    @ColumnInfo(name = "Secciòn")
    var seccion: String = "",
    @ColumnInfo(name = "Hora")
    var hora: String ="",
    @ColumnInfo(name = "Aula")
    var aula: Int = 0) {
    @PrimaryKey(autoGenerate = false)
    var idCodigo: String = ""
}