package dominando.android.adapter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_other.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btToast.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                val text = etText.text.toString()
                Toast.makeText(this@MainActivity, text, Toast.LENGTH_SHORT)
            }
        })

//        btToast.setOnClickListener {
//            Toast.makeText(this@MainActivity, etText.text.toString(), Toast.LENGTH_SHORT)
//        }

        btButton2.setOnClickListener {
        // CustomClass::class.java return object type KClass<CustomClass>
            val intent = Intent(this, OtherActivity::class.java)
            intent.putExtra("name", etText.text)
            startActivity(intent)
        }
    }
}