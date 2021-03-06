package andresemilio7.controldeasistencia

import andresemilio7.controldeasistencia.data.Catedraticos
import andresemilio7.controldeasistencia.data.ControlDeAsistenciaDatabase
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.agregarcatedratico.*

class AgregarCatedratico : AppCompatActivity() {
    private  var controlAsistenciaDB: ControlDeAsistenciaDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.agregarcatedratico)

        controlAsistenciaDB = ControlDeAsistenciaDatabase.getInstance(this)


        val usuario = intent.getStringExtra("idcatedratico")
        val nombre = intent.getStringExtra("nombre")
        val apellido = intent.getStringExtra("apellido")
        val correo = intent.getStringExtra("correo")
        val facultad = intent.getStringExtra("facultad")
        val telefono = intent.getStringExtra("telefono")


        if (usuario == null  || usuario == ""){
            btnAgregarCatedratico.setOnClickListener {
                val maestro = Catedraticos(etNombre.text.toString(), etApellido.text.toString(), etCorreo.text.toString(), etFacultad.text.toString(), etTelefono.text.toString(), etIdCatedratico.text.toString())
                controlAsistenciaDB?.getCatedraticosDao()?.saveCatedraticos(maestro)
                Toast.makeText(this, "Guardado", Toast.LENGTH_SHORT).show()
                finish()

            }
        } else{
            etIdCatedratico.setText(usuario)
            etNombre.setText(nombre)
            etApellido.setText(apellido)
            etCorreo.setText(correo)
            etFacultad.setText(facultad)
            etTelefono.setText(telefono)
            btnAgregarCatedratico.setOnClickListener{
                val maestro = Catedraticos(etNombre.text.toString(), etApellido.text.toString(), etCorreo.text.toString(), etFacultad.text.toString(), etTelefono.text.toString(), etIdCatedratico.text.toString())
                controlAsistenciaDB?.getCatedraticosDao()?.updateCatedraticos(maestro)
                Toast.makeText(this, "No guardado", Toast.LENGTH_SHORT).show()
                finish()

            }


        }


    }
}