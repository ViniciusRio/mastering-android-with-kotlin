package dominando.android.adapter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_other.*
import org.parceler.Parcels

class OtherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)

        val name = intent.getStringExtra("name");
        val age = intent.getIntExtra("age", -1);
        val client = intent.getParcelableExtra<Client>("client")
        val clientParceler =
            Parcels.unwrap<ClientParceler?>(intent.getParcelableExtra<Client>("clientParcel"))
        val person = intent.getSerializableExtra("person") as Person?

        tvMessage.text = if (client != null) {
            getString(R.string.text_one_other_activity, client.name, client.code)
        } else if (person != null) {
            getString(R.string.text_two_other_activity, person.name, person.age)
        } else if (clientParceler != null) {
            getString(
                R.string.text_one_other_activity, clientParceler.name,
                clientParceler.code
            )
        } else {
            getString(R.string.text_two_other_activity, name, age)
        }

    }
}