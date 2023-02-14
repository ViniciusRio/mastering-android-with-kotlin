package dominando.android.adapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cities = listOf(
            "Caruaru",
            "Cabo de Santo Agostinho",
            "Recife",
            "São Paulo",
            "Santos",
            "Santa Cruz"
        )

        val adapter = CitySearchAdapter(
            this,
            android.R.layout.simple_dropdown_item_1line,
            cities
        )

        tvAutocomplete.setAdapter(adapter)
    }
}