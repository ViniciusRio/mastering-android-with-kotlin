package dominando.android.adapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    private val vehicles: MutableList<Vehicle> by lazy {
        mutableListOf(
            Vehicle(getString(R.string.onix), 2018, 2, gasoline = true, ethanol = true),
            Vehicle(getString(R.string.uno), 2007, 0, gasoline = true, ethanol = false),
            Vehicle(getString(R.string.del_rey), 1988, 3, gasoline = false, ethanol = true),
            Vehicle(getString(R.string.gol), 2014, 1, gasoline = true, ethanol = true),
        )

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val listView = ListView(this)
        setContentView(listView)

        val vehicleAdapter = VehicleAdapter(this, vehicles)
        listView.adapter = vehicleAdapter
    }
}