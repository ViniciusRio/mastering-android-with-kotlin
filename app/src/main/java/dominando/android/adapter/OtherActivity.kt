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
            getString(R.string.text_one_other_activity, client.name, client.code)
        } else if (person !=null ) {
            getString(R.string.text_two_other_activity, person?.name, person?.age)
        } else {
            getString(R.string.text_two_other_activity, name, age)
        }

    }
}