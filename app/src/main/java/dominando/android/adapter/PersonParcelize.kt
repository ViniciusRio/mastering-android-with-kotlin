package dominando.android.adapter

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PersonParcelize(val name: String, val age: Int) : Parcelable