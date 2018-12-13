package andresemilio7.controldeasistencia

import andresemilio7.controldeasistencia.data.Clases
import andresemilio7.controldeasistencia.data.ControlDeAsistenciaDatabase
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.agregarclase.*

class AgregarClase: AppCompatActivity() {
    private  var controlAsistenciaDB: ControlDeAsistenciaDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.agregarclase)

        controlAsistenciaDB = ControlDeAsistenciaDatabase.getInstance(this)

        val asignatura = intent.getStringExtra("asignatura")
        val seccion = intent.getStringExtra("seccion")
        val hora = intent.getStringExtra("hora")
        val aula = intent.getStringExtra("aula")
        val catedratico = intent.getIntExtra("idCaterdatico", 0)


        if (asignatura == null  || asignatura == ""){
            btnAgregarClase.setOnClickListener {
                val clases = Clases(asignatura, seccion, hora, aula, catedratico)
                controlAsistenciaDB?.getClasesDao()?.saveClases(clases)
                finish()
                Toast.makeText(this, "Seguardo", Toast.LENGTH_SHORT).show()
            }
        } else{
            val codigoclase = intent.getIntExtra("idCodigo", 0)
            etAsignatura.setText(asignatura)
            etSeccion.setText(seccion)
            etHora.setText(hora)
            etAula.setText(aula)
            etCodigoCatedratico.setText(catedratico)
            btnAgregarClase.setOnClickListener{
                val clases = Clases(etAsignatura.text.toString(), etSeccion.text.toString(), etAula.text.toString(), etHora.text.toString(), etCodigoCatedratico.id)
                clases.idCodigo = codigoclase
                controlAsistenciaDB?.getClasesDao()?.updateClases(clases)
                finish()
            }


        }


    }
}