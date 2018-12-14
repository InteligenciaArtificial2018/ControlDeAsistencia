package andresemilio7.controldeasistencia.data

import android.arch.persistence.room.*

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
    var telefono: String = "",
    @ColumnInfo(name= "Usuario")
    var idCatedratico: String = ""){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
    }