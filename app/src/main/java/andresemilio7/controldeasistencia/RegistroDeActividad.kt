package andresemilio7.controldeasistencia

import andresemilio7.controldeasistencia.data.ControlDeAsistenciaDatabase
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.RadioGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.agregarcatedratico.*
import kotlinx.android.synthetic.main.template_registro.*

class RegistroDeActividad : AppCompatActivity() {
    private var controlAsistenciaDB: ControlDeAsistenciaDatabase? = null
    private var revision = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registroactividad)


        controlAsistenciaDB = ControlDeAsistenciaDatabase.getInstance(this)
        rgRevision.setOnCheckedChangeListener(this)

        val asignatura = intent.getStringExtra("idcodigo")
        val catedratico = intent.getStringExtra("idCatedratico")
        val hora = intent.getStringExtra("hora")
        val aula = intent.getStringExtra("aula")
        val fecha = intent.getStringExtra("fecha")


        if (asignatura == null  || asignatura == ""){
            btnAgregarRevision.setOnClickListener {
                val revision = RegistroActividad(etAsignatura.text.toString(), etCatedratico.text.toString(),
                    etHora.text.toString(), etAula.text.toString(), etFechaRev.text.toString(), revision)
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
                val revision = RegistroActividad(etAsignatura.text.toString(), etCatedratico.text.toString(), etHora.text.toString(), etAula.text.toString(), etFechaRev.text.toString(), revision)
                controlAsistenciaDB?.getRegistroActividadDAO()?.updateRegistroActividad(revision)
                Toast.makeText(this, "No guardado", Toast.LENGTH_SHORT).show()
                finish()

            }


        }


    }

    override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {
        if (checkedId == R.id.rbVerificado) {
            prioridad = 1
        } else if (checkedId == R.id.rbNoRealizado) {
            prioridad = 2
        }
    }



}
