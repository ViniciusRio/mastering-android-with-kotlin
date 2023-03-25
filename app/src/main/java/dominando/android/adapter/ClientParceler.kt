package dominando.android.adapter

import org.parceler.Parcel
import org.parceler.ParcelConstructor

@Parcel
class ClientParceler(var code: Int, var name: String) {
    @ParcelConstructor
    constructor() : this(0, "")
}

