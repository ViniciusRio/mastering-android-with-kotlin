package dominando.android.adapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_orientation_main.*

class OrientationMainActivity : AppCompatActivity() {
    var names = arrayListOf<String>()
    var adapter: ArrayAdapter<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orientation_main)
        // option 1 deprecated
//        if (lastCustomNonConfigurationInstance != null) {
//            names = lastCustomNonConfigurationInstance as ArrayList<String>
//        }
        /*
        option 2
        * Android save content with id and not modification programmatically
        * */
//        if (savedInstanceState != null) {
//            names = savedInstanceState.getStringArrayList("names") as ArrayList<String>
//        }

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, names)
        lvNames.adapter = adapter
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
//        outState?.putStringArrayList("names", names)
    }

    override fun onRetainCustomNonConfigurationInstance(): Any? {
        return names
    }

    fun btnAddClick(view: View) {
        names.add(etName.text.toString())
        etName.text.clear()
        adapter?.notifyDataSetChanged()
    }
}