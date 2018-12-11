package andresemilio7.controldeasistencia.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "Catedraticos")
class Catedraticos(
    @ColumnInfo(name = "Nombre")
    var nombre: String = "",
    @ColumnInfo(name = "Apellido")
    var apellido: String = "",
    @ColumnInfo(name = "Correo")
    var correo: String = "",
    @ColumnInfo(name = "Facultad")
    var facultad: String = "",
    @ColumnInfo(name = "Telefono")
    var telefono: String = "" ,
    @PrimaryKey(autoGenerate = false)
    var idCatedratico: String = "")