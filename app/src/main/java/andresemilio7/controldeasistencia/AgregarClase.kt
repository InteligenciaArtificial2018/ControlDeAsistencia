package andresemilio7.controldeasistencia

import andresemilio7.controldeasistencia.data.Catedraticos
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
        val hora = intent.getStringExtra("hora")
        val aula = intent.getStringExtra("aula")
        val catedratico = intent.getStringExtra("idCatedratico")
        val id = intent.getStringExtra("idCodigo")

        if (asignatura == null  || asignatura == ""){
            btnAgregarClase.setOnClickListener {
                val clases = Clases(etAsignatura.text.toString(), etHora.text.toString(), etAula.text.toString(), etCodigoCatedratico.text.toString(), etCodigoClase.text.toString())

                        controlAsistenciaDB?.getClasesDao()?.saveClases(clases)
                        Toast.makeText(this, "Guardado", Toast.LENGTH_SHORT).show()
                        finish()

            }
        } else{

            etAsignatura.setText(asignatura)
            etHora.setText(hora)
            etAula.setText(aula)
            etCodigoCatedratico.setText(catedratico)
            etCodigoClase.setText(id)
            btnAgregarClase.setOnClickListener{
                val clases = Clases(etAsignatura.text.toString(),  etHora.text.toString(), etAula.text.toString(), etCodigoCatedratico.text.toString(), etCodigoClase.text.toString())

                controlAsistenciaDB?.getClasesDao()?.updateClases(clases)
                Toast.makeText(this, "No guardado", Toast.LENGTH_SHORT).show()
                finish()
            }
        }
    }
}