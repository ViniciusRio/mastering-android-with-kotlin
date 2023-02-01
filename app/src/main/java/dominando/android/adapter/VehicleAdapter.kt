package dominando.android.adapter

import android.content.Context
import android.content.res.TypedArray
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.StringRes
import kotlinx.android.synthetic.main.item_vehicle.view.*

class VehicleAdapter(
    private val context: Context,
    private val vehicles: List<Vehicle>,
) : BaseAdapter() {

    private val logos: TypedArray by lazy {
        context.resources.obtainTypedArray(R.array.logos)
    }

    override fun getCount(): Int = vehicles.size

    override fun getItem(position: Int): Any = vehicles[position]

    override fun getItemId(position: Int): Long = vehicles[position].id.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val vehicle = vehicles[position]
        val holder: ViewHolder
        val row: View

        // none view to reuse
        if (convertView == null) {
            Log.d("NGVL", "New View  => position: $position")
            // load layout
            row = LayoutInflater.from(context).inflate(R.layout.item_vehicle, parent, false)
            // viewHolder receive a view
            holder = ViewHolder(row)
            // tag can receive any object
            row.tag = holder

            // view can reuse
        } else {
            Log.d("NGVL", "Existence View => position: $position")

            row = convertView
            holder = convertView.tag as ViewHolder
        }

        holder.ivLogo.setImageDrawable(logos.getDrawable(vehicle.manufacturer))
        holder.tvModel.text = vehicle.model
        holder.tvYear.text = vehicle.year.toString()

        val fuel = context.getString(getFuel(vehicle))
        holder.tvFuel.text = fuel

        return row
    }

    @StringRes
    private fun getFuel(vehicle: Vehicle): Int {
        if (vehicle.gasoline && vehicle.ethanol) {
            return R.string.vehicle_fuel_flex
        } else if (vehicle.gasoline) {
            return R.string.vehicle_fuel_gasoline
        } else if (vehicle.ethanol) {
            return R.string.vehicle_fuel_ethanol
        }

        return R.string.vehicle_fuel_invalid
    }

    companion object {
        data class ViewHolder(val view: View) {
            val ivLogo: ImageView = view.ivLogo
            val tvModel: TextView = view.tvModel
            val tvYear: TextView = view.tvYear
            val tvFuel: TextView = view.tvFuel
        }
    }
}