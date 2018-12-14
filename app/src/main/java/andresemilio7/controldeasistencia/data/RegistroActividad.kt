package andresemilio7.controldeasistencia.data

import android.arch.persistence.room.*


@Entity(tableName = "RegistroActividad"

)


class RegistroActividad {
    @ColumnInfo(name = "Asignatura")
    var idcodigo: String = "",
    @ColumnInfo(name = "Catedratico")
    var idCatedratico: String = "",
    @ColumnInfo(name = "Hora")
    var hora: String = "",
    @ColumnInfo(name = "Aula")
    var aula: String = "",
    @ColumnInfo(name = "Fecha")
    var fecha: String = "")
    { @PrimaryKey(autoGenerate = true)
        var id: Int = 0}
