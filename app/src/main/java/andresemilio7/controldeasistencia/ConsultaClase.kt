package andresemilio7.controldeasistencia

import andresemilio7.controldeasistencia.data.Clases
import andresemilio7.controldeasistencia.data.ControlDeAsistenciaDatabase
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.consultaclase.*

class ConsultaClase: AppCompatActivity(), ClaseAdapter.OnClaseClickListener{

    private var controlAsistenciaDatabase: ControlDeAsistenciaDatabase? = null
    private var claseAdapter: ClaseAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.consultaclase)


        controlAsistenciaDatabase = ControlDeAsistenciaDatabase.getInstance(this)
        claseAdapter = ClaseAdapter(controlAsistenciaDatabase?.getClasesDao()?.getClasesList())
        claseAdapter?.setClaseItemClickListener(this)


    }
    override fun onResume() {
        super.onResume()
        claseAdapter?.claseList = controlAsistenciaDatabase?.getClasesDao()?.getClasesList()
        rvClase.adapter = claseAdapter
        rvClase.layoutManager = LinearLayoutManager(this)
        rvClase.hasFixedSize()
    }

    /**
     * Sobreescribimos la funcionalidad de click desde la herencia de la interfaz
     * del TodoAdapter. Enviamos la información mediante un intent con parámetros
     * hacia el layout correspondiente.
     */
    override fun onClaseItemClickListener(clases: Clases) {
        val intent = Intent(this, AgregarClase::class.java)
        intent.putExtra("asinatura", clases.asignatura)
        intent.putExtra("seccion", clases.seccion)
        intent.putExtra("hora", clases.hora)
        intent.putExtra("aula", clases.aula)
        intent.putExtra("catedratico", clases.idCatedratico)
        startActivity(intent)
    }

    override fun onClaseItemLongClickListener(clases: Clases) {
        // Inicializar una nueva instancia de AlertDialog
        val builder = AlertDialog.Builder(this)


        // Los dialogos pueden tener hasta 3 botones, uno positivo (SI), uno negativo (NO)
        // y un boton neutro (CANCEL) los cuales utilizaremos para Modificar, Eliminar y Cancelar
        builder.setPositiveButton(R.string.hintAsignatura) {dialog, wich ->
            // Realizar el llamado a la activity de agregar enviando los valores mediante el intent
            val intent = Intent(this, Clases::class.java)
            intent.putExtra("asinatura", clases.asignatura)
            intent.putExtra("seccion", clases.seccion)
            intent.putExtra("hora", clases.hora)
            intent.putExtra("aula", clases.aula)
            intent.putExtra("catedratico", clases.idCatedratico)
            startActivity(intent)
        }
        // Crear el dialogo de alerta con todos los parámetros establecidos
        val dialogo: AlertDialog = builder.create()

        // Mostrar el dialogo
        dialogo.show()
    }
}