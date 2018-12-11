package andresemilio7.controldeasistencia

import andresemilio7.controldeasistencia.data.Clases
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btncat = findViewById<Button>(R.id.btnAgregarCatedraticoMain)
        val btnclase = findViewById<Button>(R.id.btnAgregarClaseMain)
        val btnrev = findViewById<Button>(R.id.btnRegistroactividadMain)

        btncat.setOnClickListener {
            val intent = Intent(this, AgregarCatedratico::class.java)
            startActivity(intent)
        }

        btnclase.setOnClickListener {
            val intent = Intent(this, AgregarClase::class.java)
            startActivity(intent)
        }

        btnrev.setOnClickListener {
            val intent = Intent(this,RegistroActividad::class.java)
            startActivity(intent)
        }


    }
}
