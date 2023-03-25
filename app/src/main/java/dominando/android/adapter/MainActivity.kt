package dominando.android.adapter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btToast.setOnClickListener {
            val text = etText.text.toString()
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
        }

        btButton2.setOnClickListener {
        // CustomClass::class.java return object type KClass<CustomClass>
            val intent = Intent(this, OtherActivity::class.java)
            intent.putExtra("name", etText.text.toString())
            intent.putExtra("age", 26)
            startActivity(intent)
        }
    }
}