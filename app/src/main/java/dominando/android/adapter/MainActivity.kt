package dominando.android.adapter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.parceler.ParcelWrapper
import org.parceler.Parcels

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("NGVL", "MainActivity::onCreate")


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

        btParcelize.setOnClickListener {
            val personParcelize = PersonParcelize("Cleide", 60)
            val intent = Intent(this, OtherActivity::class.java)
            intent.putExtra("personParcelize", personParcelize)

            startActivity(intent)
        }

        btLifecycle.setOnClickListener {
            val intent = Intent(this, LifecycleActivity::class.java)
            startActivity(intent)
        }
    }

    // Called after onCreate, already visible
    override fun onStart() {
        super.onStart()
        Log.i("NGVL", "MainActivity::onStart")
    }

    // Called after onCreate
    override fun onResume() {
        super.onResume()
        Log.i("NGVL", "MainActivity::onResume")

    }

    /*
        Called when other activity is started and partially visible
        As well press home button call onPause and after onStop
     */
    override fun onPause() {
        super.onPause()
        Log.i("NGVL", "MainActivity::onPause")

    }

    /*
       Called when initial methods from other activity is started
       here a first will not be visible.

       As well press home button call onStop after onPause
    */
    override fun onStop() {
        super.onStop()
        Log.i("NGVL", "MainActivity::onStop")

    }

    /*
        Called when back to screen from other, after onStart and onResume is called.
     */
    override fun onRestart() {
        super.onRestart()
        Log.i("NGVL", "MainActivity::onRestart")

    }

    // Called when back button is press, for example. Is equivalent call method finish()
    override fun onDestroy() {
        super.onDestroy()
        Log.i("NGVL", "MainActivity::onDestroy")

    }
}