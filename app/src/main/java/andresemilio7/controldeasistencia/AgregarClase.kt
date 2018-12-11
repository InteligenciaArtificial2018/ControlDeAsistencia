package andresemilio7.controldeasistencia

import andresemilio7.controldeasistencia.data.Catedraticos
import andresemilio7.controldeasistencia.data.Clases
import andresemilio7.controldeasistencia.data.ControlDeAsistenciaDatabase
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.agregarcatedratico.*
import kotlinx.android.synthetic.main.agregarclase.*

class AgregarClase: AppCompatActivity() {
    private  var controlAsistenciaDB: ControlDeAsistenciaDatabase? = null

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.agregarclase)

        controlAsistenciaDB = ControlDeAsistenciaDatabase.getInstance(this)

        val codigoclase = intent.getStringExtra("idCodigo")
        val asignatura = intent.getStringExtra("asignatura")
        val seccion = intent.getStringExtra("seccion")
        val aula = intent.getStringExtra("aula")
        val hora = intent.getStringExtra("hora")
        val catedratico = intent.getStringExtra("idCatedratico")


        if (codigoclase == null  || codigoclase == ""){
            btnAgregarClase.setOnClickListener {
                val clases = Clases(codigoclase, asignatura, seccion, aula, hora, catedratico)
                controlAsistenciaDB?.getClasesDao()?.saveClases(clases)
                finish()
            }
        } else{
            etCodigoClase.setText(codigoclase)
            etAsignatura.setText(asignatura)
            etSeccion.setText(seccion)
            etAula.setText(aula)
            etHora.setText(hora)
            etCodigoCatedratico.setText(catedratico)
            btnAgregarClase.setOnClickListener{
                val clases = Clases(etCodigoClase.text.toString(),etAsignatura.text.toString(), etSeccion.text.toString(), etAula.text.toString(), etHora.text.toString(), etCodigoCatedratico.text.toString())
                controlAsistenciaDB?.getClasesDao()?.updateClases(clases)
                finish()
            }


        }


    }
}