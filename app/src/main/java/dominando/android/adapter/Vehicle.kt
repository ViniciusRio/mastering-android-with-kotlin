package dominando.android.adapter

data class Vehicle(
    var id: Int,
    var model: String,
    var year: Int,
    var manufacturer: Int,
    var gasoline: Boolean,
    var ethanol: Boolean
)