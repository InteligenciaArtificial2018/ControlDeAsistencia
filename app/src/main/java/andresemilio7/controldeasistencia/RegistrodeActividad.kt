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
        rgRevision.checkedRadioButtonId

        val asignatura = intent.getStringExtra("idcodigo")
        val catedratico = intent.getStringExtra("idCatedratico")
        val hora = intent.getStringExtra("hora")
        val aula = intent.getStringExtra("aula")
        val fecha = intent.getStringExtra("fecha")


        if (asignatura == null  || asignatura == ""){
            btnAgregarRevision.setOnClickListener {
                val revision = RegistroActividad(etAsignatura.text.toString(), etCatedratico.text.toString(),
                    etHora.text.toString(), etAula.text.toString(), etFechaRev.text.toString(), revision.toString())
                controlAsistenciaDB?.getRegistroActividadDAO()?.saveRegistroActividad(revision)
                Toast.makeText(this, "Guardado", Toast.LENGTH_SHORT).show()
                finish()

            }
        } else{
            etAsignatura.setText(asignatura)
            etCatedratico.setText(catedratico)
            etHora.setText(hora)
            etAula.setText(aula)
            etFechaRev.setText(fecha)
            btnAgregarRevision.setOnClickListener{
                val revision = RegistroActividad(etAsignatura.text.toString(), etCatedratico.text.toString(), etHora.text.toString(), etAula.text.toString(), etFechaRev.text.toString(), revision.toString())
                controlAsistenciaDB?.getRegistroActividadDAO()?.updateRegistroActividad(revision)
                Toast.makeText(this, "No guardado", Toast.LENGTH_SHORT).show()
                finish()

            }
        }
    }
    fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        if (checkedId == R.id.rbVerificado) {
            revision = 1
        } else if (checkedId == R.id.rbNoRealizado) {
            revision = 2
        }
    }



}