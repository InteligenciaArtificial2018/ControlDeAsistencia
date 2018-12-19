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


        val asignatura = intent.getStringExtra("CodigoClase")
        val catedratico = intent.getStringExtra("Catedratico")
        val hora = intent.getStringExtra("Hora")
        val aula = intent.getStringExtra("Aula")
        val fecha = intent.getStringExtra("Fecha")
        val registro = intent.getStringExtra("Revision")


        if (asignatura == null  || asignatura == ""){
            btnAgregarRevision.setOnClickListener {
                val revision = RegistroActividad(etAsignatura.text.toString(), etCatedratico.text.toString(),
                    etHora.text.toString(), etAula.text.toString(), etFechaRev.text.toString(), etregistro.text.toString())
                controlAsistenciaDB?.getRegistroActividadDAO()?.saveRegistroActividad(revision)
                Toast.makeText(this, "Guardado", Toast.LENGTH_SHORT).show()
                finish()

            }
        } else{
            intent.getIntExtra("id", 0)
            etAsignatura.setText(asignatura)
            etCatedratico.setText(catedratico)
            etHora.setText(hora)
            etAula.setText(aula)
            etFechaRev.setText(fecha)
            etregistro.setText(registro)
            btnAgregarRevision.setOnClickListener{
                val revision = RegistroActividad(etAsignatura.text.toString(), etCatedratico.text.toString(), etHora.text.toString(), etAula.text.toString(), etFechaRev.text.toString(), etregistro.text.toString())
                controlAsistenciaDB?.getRegistroActividadDAO()?.updateRegistroActividad(revision)
                Toast.makeText(this, "No guardado", Toast.LENGTH_SHORT).show()
                finish()

            }
        }
    }




}