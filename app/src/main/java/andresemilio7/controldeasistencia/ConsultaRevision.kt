package andresemilio7.controldeasistencia

import andresemilio7.controldeasistencia.data.RegistroActividad
import andresemilio7.controldeasistencia.data.ControlDeAsistenciaDatabase
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.consultaregistro.*

 class ConsultaRevision: AppCompatActivity(), RegistroAdapter.OnRegistroClickListener{

    private var controlAsistenciaDatabase: ControlDeAsistenciaDatabase? = null
    private var registroAdapter: RegistroAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.consultaregistro)


        controlAsistenciaDatabase = ControlDeAsistenciaDatabase.getInstance(this)
        registroAdapter = RegistroAdapter(controlAsistenciaDatabase?.getRegistroActividadDAO()?.getRegistroList())
        registroAdapter?.setRegistroItemClickListener(this)


    }
    override fun onResume() {
        super.onResume()
        registroAdapter?.registroList = controlAsistenciaDatabase?.getRegistroActividadDAO()?.getRegistroList()
        rvRegistro.adapter = registroAdapter
        rvRegistro.layoutManager = LinearLayoutManager(this)
        rvRegistro.hasFixedSize()
    }

    /**
     * Sobreescribimos la funcionalidad de click desde la herencia de la interfaz
     * del TodoAdapter. Enviamos la información mediante un intent con parámetros
     * hacia el layout correspondiente.
     */
    override fun onRegistroItemClickListener(registroActividad: RegistroActividad) {
        val intent = Intent(this, RegistrodeActividad::class.java)
        intent.putExtra("idcodigo", registroActividad.idcodigo)
        intent.putExtra("idCatedratico", registroActividad.idCatedratico)
        intent.putExtra("hora", registroActividad.hora)
        intent.putExtra("aula", registroActividad.aula)
        intent.putExtra("fecha", registroActividad.fecha)
        intent.putExtra("revision", registroActividad.revision)
        startActivity(intent)
    }

    override fun onRegistroItemLongClickListener(registroActividad: RegistroActividad) {
        // Inicializar una nueva instancia de AlertDialog
        val builder = AlertDialog.Builder(this)


        // Los dialogos pueden tener hasta 3 botones, uno positivo (SI), uno negativo (NO)
        // y un boton neutro (CANCEL) los cuales utilizaremos para Modificar, Eliminar y Cancelar
        builder.setPositiveButton(R.string.asignatura) {dialog, wich ->
            // Realizar el llamado a la activity de agregar enviando los valores mediante el intent
            val intent = Intent(this, RegistrodeActividad::class.java)
            intent.putExtra("idcodigo", registroActividad.idcodigo)
            intent.putExtra("idCatedratico", registroActividad.idCatedratico)
            intent.putExtra("hora", registroActividad.hora)
            intent.putExtra("aula", registroActividad.aula)
            intent.putExtra("fecha", registroActividad.fecha)
            intent.putExtra("revision", registroActividad.revision)

            startActivity(intent)
        }
        // Crear el dialogo de alerta con todos los parámetros establecidos
        val dialogo: AlertDialog = builder.create()

        // Mostrar el dialogo
        dialogo.show()
    }
}