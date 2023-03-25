package dominando.android.adapter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.parceler.ParcelWrapper
import org.parceler.Parcels

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btToast.setOnClickListener {
            val text = etText.text.toString()
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
        }

        btCallIntent.setOnClickListener {
        // CustomClass::class.java return object type KClass<CustomClass>
            val intent = Intent(this, OtherActivity::class.java)
            intent.putExtra("name", etText.text.toString())
            intent.putExtra("age", 26)
            startActivity(intent)
        }

        btParcel.setOnClickListener {
            val client = Client(1, "Vinícius")
            val intent = Intent(this, OtherActivity::class.java)
            intent.putExtra("client", client)
            startActivity(intent)
        }

        btSerializable.setOnClickListener {
            val person = Person("Valber", 50)
            val intent = Intent(this, OtherActivity::class.java)
            intent.putExtra("person", person)

            startActivity(intent)
        }

        btParceler.setOnClickListener {
            val clientParceler = ClientParceler(code = 1, name = "Wilyanne")
            val intent = Intent(this, OtherActivity::class.java)
            intent.putExtra("clientParcel", Parcels.wrap(clientParceler))

            startActivity(intent)
        }
    }
}