package andresemilio7.controldeasistencia.data

import android.arch.persistence.room.*


@Entity(tableName = "Clases",
        indices = arrayOf(Index(value = "CodigoCatedratico", name = "codCatedratico")),
        foreignKeys = arrayOf(
            ForeignKey(
            entity = Catedraticos::class,
            parentColumns = arrayOf("Usuario"),
            childColumns = arrayOf("CodigoCatedratico")
        )))

class Clases(
    @ColumnInfo(name = "Asignatura")
    var asignatura: String = "",
    @ColumnInfo(name = "Hora")
    var hora: String = "",
    @ColumnInfo(name = "Aula")
    var aula: String = "",
    @ColumnInfo(name = "CodigoCatedratico")
    var idCatedratico: String = ""){
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "Clase")
    var idCodigo: String = ""

    @Ignore
    constructor(asignatura: String, hora: String, aula: String, idCatedratico: String, idCodigo: String): this(){
        this.asignatura = asignatura
        this.hora = hora
        this.aula = aula
        this.idCatedratico = idCatedratico
        this.idCodigo = idCodigo
    }
}

