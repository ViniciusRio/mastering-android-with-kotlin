package dominando.android.adapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnToast = findViewById<Button>(R.id.btnToast)

        btnToast.setOnClickListener(object: View.OnClickListener {
            override fun onClick(p0: View?) {
                val text = etText.text.toString()
                Toast.makeText(this@MainActivity, text, Toast.LENGTH_SHORT).show()
            }
        })

    }
}