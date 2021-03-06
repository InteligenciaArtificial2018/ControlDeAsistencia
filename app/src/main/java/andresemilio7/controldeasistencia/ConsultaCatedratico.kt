package andresemilio7.controldeasistencia

import andresemilio7.controldeasistencia.data.Catedraticos
import andresemilio7.controldeasistencia.data.ControlDeAsistenciaDatabase
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.consultacatedratico.*

class ConsultaCatedratico: AppCompatActivity(), CatedraticoAdapter.OnCatedraticoClickListener{

    private var controlAsistenciaDatabase: ControlDeAsistenciaDatabase? = null
    private var catedraticoAdapter: CatedraticoAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.consultacatedratico)


        controlAsistenciaDatabase = ControlDeAsistenciaDatabase.getInstance(this)
        catedraticoAdapter = CatedraticoAdapter(controlAsistenciaDatabase?.getCatedraticosDao()?.getCatedraticosList())
        catedraticoAdapter?.setCatedraticoItemClickListener(this)


    }
    override fun onResume() {
        super.onResume()
        catedraticoAdapter?.catedraticoList = controlAsistenciaDatabase?.getCatedraticosDao()?.getCatedraticosList()
        rvCatedraticos.adapter = catedraticoAdapter
        rvCatedraticos.layoutManager = LinearLayoutManager(this)
        rvCatedraticos.hasFixedSize()
    }

    /**
     * Sobreescribimos la funcionalidad de click desde la herencia de la interfaz
     * del TodoAdapter. Enviamos la información mediante un intent con parámetros
     * hacia el layout correspondiente.
     */
    override fun onCatedraticoItemClickListener(catedraticos: Catedraticos) {
        val intent = Intent(this, AgregarCatedratico::class.java)
        intent.putExtra("idcatedratico", catedraticos.idCatedratico)
        intent.putExtra("nombre", catedraticos.nombre)
        intent.putExtra("apellido", catedraticos.apellido)
        intent.putExtra("correo", catedraticos.correo)
        intent.putExtra("facultad", catedraticos.facultad)
        intent.putExtra("telefono", catedraticos.telefono)
        startActivity(intent)
    }

    override fun onCatedraticoItemLongClickListener(catedraticos: Catedraticos) {
        // Inicializar una nueva instancia de AlertDialog
        val builder = AlertDialog.Builder(this)


        // Los dialogos pueden tener hasta 3 botones, uno positivo (SI), uno negativo (NO)
        // y un boton neutro (CANCEL) los cuales utilizaremos para Modificar, Eliminar y Cancelar
        builder.setPositiveButton(R.string.hintIdCatedratico) {dialog, wich ->
            // Realizar el llamado a la activity de agregar enviando los valores mediante el intent
            val intent = Intent(this, AgregarCatedratico::class.java)
            intent.putExtra("idcatedratico", catedraticos.idCatedratico)
            intent.putExtra("nombre", catedraticos.nombre)
            intent.putExtra("apellido", catedraticos.apellido)
            intent.putExtra("correo", catedraticos.correo)
            intent.putExtra("facultad", catedraticos.facultad)
            intent.putExtra("telefono", catedraticos.telefono)
            startActivity(intent)
        }
        // Crear el dialogo de alerta con todos los parámetros establecidos
        val dialogo: AlertDialog = builder.create()

        // Mostrar el dialogo
        dialogo.show()
    }
}