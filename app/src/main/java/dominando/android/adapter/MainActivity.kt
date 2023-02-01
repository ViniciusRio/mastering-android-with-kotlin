package dominando.android.adapter

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var vehicles: MutableList<Vehicle>
    private lateinit var tvFooter: TextView
    private lateinit var tvHeader: TextView
    private val padding = 8

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        vehicles = mutableListOf(
            Vehicle(1,
                getString(R.string.onix),
                2018,
                Manufacturer.GM.value,
                gasoline = true,
                ethanol = true),
            Vehicle(2,
                getString(R.string.uno),
                2007,
                Manufacturer.FIAT.value,
                gasoline = true,
                ethanol = false),
            Vehicle(3,
                getString(R.string.del_rey),
                1988,
                Manufacturer.FORD.value,
                gasoline = false,
                ethanol = true),
            Vehicle(4,
                getString(R.string.gol),
                2014,
                Manufacturer.VOLKSWAGEN.value,
                gasoline = true,
                ethanol = true),
        )

        setContentView(R.layout.activity_main)

        listView.emptyView = empty

        val vehicleAdapter = VehicleAdapter(this, vehicles)
        listView.adapter = vehicleAdapter

        initHeader(listView)
        initFooter(listView, vehicleAdapter)

        // parent = list view
        // view = item clicked
        // position = index
        // id = object id from getItemId(int)
        listView.setOnItemClickListener { parent, view, position, id ->
            val vehicle = parent.getItemAtPosition(position) as? Vehicle

            if (vehicle != null) {
                Toast.makeText(
                    this,
                    "${vehicle.model} ${vehicle.year}",
                    Toast.LENGTH_SHORT
                ).show()
                vehicles.remove(vehicle)
                vehicleAdapter.notifyDataSetChanged()
                tvFooter.text = setTextFooter(vehicleAdapter)
            }
        }
    }

    private fun initHeader(listView: ListView) {
        tvHeader = TextView(this)

        // Color.rgb(int, int, int) create a custom color
        tvHeader.setBackgroundColor(Color.GRAY)
        tvHeader.setTextColor(Color.WHITE)
        tvHeader.setText(R.string.vehicle_header_text)
        tvHeader.setPadding(padding, padding, 0, padding)

        listView.addHeaderView(tvHeader)
    }

    private fun initFooter(listView: ListView, adapter: VehicleAdapter) {
        tvFooter = TextView(this)

        tvFooter.text = setTextFooter(adapter)
        tvFooter.setBackgroundColor(Color.LTGRAY)
        tvFooter.gravity = Gravity.END
        tvFooter.setPadding(0, padding, padding, padding)

        listView.addFooterView(tvFooter)
    }

    private fun setTextFooter(adapter: VehicleAdapter) =
        resources.getQuantityString(
            R.plurals.vehicle_footer_text,
            adapter.count,
            adapter.count
        )
}