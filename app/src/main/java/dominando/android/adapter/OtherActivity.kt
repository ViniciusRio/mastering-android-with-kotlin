package dominando.android.adapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_other.*

class OtherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)

        val name = intent.getStringExtra("name");
        val age = intent.getIntExtra("age", -1);
        val client = intent.getParcelableExtra<Client>("client")
        val person = intent.getSerializableExtra("person") as Person?

        tvMessage.text = if(client != null) {
            "Nome: ${client.name} / Código: ${client.code}"
        } else {
            "Nome: ${person?.name} / Idade: ${person?.age}"
        }

    }
}