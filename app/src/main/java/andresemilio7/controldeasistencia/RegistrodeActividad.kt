package andresemilio7.controldeasistencia

import andresemilio7.controldeasistencia.data.ControlDeAsistenciaDatabase
import andresemilio7.controldeasistencia.data.RegistroActividad
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.RadioGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.registroactividad.*

class RegistrodeActividad : AppCompatActivity() {
    private var controlAsistenciaDB: ControlDeAsistenciaDatabase? = null
    private var revision = 0

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
                val revision = RegistroActividad(etAsignatura.text.toString(), etCatedratico.text.toString(),
                    etHora.text.toString(), etAula.text.toString(), etFechaRev.text.toString(), etregistro.toString())
                controlAsistenciaDB?.getRegistroActividadDAO()?.saveRegistroActividad(revision)
                Toast.makeText(this, "Guardado", Toast.LENGTH_SHORT).show()
                finish()

            }
        } else{
            val id = intent.getIntExtra("id", 0)
            etAsignatura.setText(asignatura)
            etCatedratico.setText(catedratico)
            etHora.setText(hora)
            etAula.setText(aula)
            etFechaRev.setText(fecha)
            etregistro.setText(registro)
            btnAgregarRevision.setOnClickListener{
                val revision = RegistroActividad(etAsignatura.text.toString(), etCatedratico.text.toString(), etHora.text.toString(), etAula.text.toString(), etFechaRev.text.toString(), etregistro.toString())
                controlAsistenciaDB?.getRegistroActividadDAO()?.updateRegistroActividad(revision)
                Toast.makeText(this, "No guardado", Toast.LENGTH_SHORT).show()
                finish()

            }
        }
    }




}