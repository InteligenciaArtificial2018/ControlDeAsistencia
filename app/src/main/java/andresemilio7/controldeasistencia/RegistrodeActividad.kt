package andresemilio7.controldeasistencia

import andresemilio7.controldeasistencia.data.ControlDeAsistenciaDatabase
import andresemilio7.controldeasistencia.data.RegistroActividad
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.registroactividad.*

class RegistrodeActividad : AppCompatActivity() {
    private var controlAsistenciaDB: ControlDeAsistenciaDatabase? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registroactividad)


        controlAsistenciaDB = ControlDeAsistenciaDatabase.getInstance(this)


        val asignatura = intent.getStringExtra("idcodigo")
        val catedratico = intent.getStringExtra("idCatedratico")
        val hora = intent.getStringExtra("hora")
        val aula = intent.getStringExtra("aula")
        val fecha = intent.getStringExtra("fecha")
        val registro = intent.getStringExtra("revision")


        if (asignatura == null  || asignatura == ""){
            btnAgregarRevision.setOnClickListener {
                val revision = RegistroActividad(etCodigoClase.text.toString(), etCatedratico.text.toString(),
                    etHora.text.toString(), etAula.text.toString(), etFechaRev.text.toString(), etregistro.text.toString())
                controlAsistenciaDB?.getRegistroActividadDAO()?.saveRegistroActividad(revision)
                Toast.makeText(this, "Guardado", Toast.LENGTH_SHORT).show()
                finish()

            }
        } else{
            intent.getIntExtra("id", 0)
            etCodigoClase.setText(asignatura)
            etCatedratico.setText(catedratico)
            etHora.setText(hora)
            etAula.setText(aula)
            etFechaRev.setText(fecha)
            etregistro.setText(registro)
            btnAgregarRevision.setOnClickListener{
                val revision = RegistroActividad(etCodigoClase.text.toString(), etCatedratico.text.toString(), etHora.text.toString(), etAula.text.toString(), etFechaRev.text.toString(), etregistro.text.toString())
                controlAsistenciaDB?.getRegistroActividadDAO()?.updateRegistroActividad(revision)
                Toast.makeText(this, "No guardado", Toast.LENGTH_SHORT).show()
                finish()

            }
        }
    }




}