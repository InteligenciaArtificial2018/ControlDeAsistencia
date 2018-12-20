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
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name= "Usuario")
    var idCatedratico: String = ""){

    @Ignore
    constructor(nombre: String, apellido: String, correo: String, facultad: String, telefono: String, idCatedratico: String, id:Int): this(){
        this.nombre = nombre
        this.apellido = apellido
        this.correo = correo
        this.facultad = facultad
        this.telefono = telefono
        this.idCatedratico = idCatedratico
    }
    }