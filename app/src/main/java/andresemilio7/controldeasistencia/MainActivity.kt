package andresemilio7.controldeasistencia


import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class MainActivity : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btncat = findViewById<Button>(R.id.btnAgregarCatedraticoMain)
        val btnclase = findViewById<Button>(R.id.btnAgregarClaseMain)
        val btnrev = findViewById<Button>(R.id.btnRegistroactividadMain)
        val btnconcat = findViewById<Button>(R.id.btnConsultaCatedratico)
        val btnconclase = findViewById<Button>(R.id.btnConsultaClase)
        val btnconrev = findViewById<Button>(R.id.btnConsultaRegistro)

        btncat.setOnClickListener {
            val intentCatedratico = Intent(this, AgregarCatedratico::class.java)
            startActivity(intentCatedratico)
        }

        btnclase.setOnClickListener {
            val intentClase = Intent(this, AgregarClase::class.java)
            startActivity(intentClase)
        }

        btnrev.setOnClickListener {
            val intentRegistro = Intent(this,RegistroActividad::class.java)
            startActivity(intentRegistro)
        }

        btnconcat.setOnClickListener {
            val intentConsultaCatedratico = Intent(this,ConsultaCatedratico::class.java)
            startActivity(intentConsultaCatedratico)
        }

        btnconclase.setOnClickListener {
            val intentConsultaClase = Intent(this,ConsultaClase::class.java)
            startActivity(intentConsultaClase)
        }

        btnconrev.setOnClickListener {
            val intentConsultaRevision = Intent(this,ConsultaRevision::class.java)
            startActivity(intentConsultaRevision)
        }




    }
}
