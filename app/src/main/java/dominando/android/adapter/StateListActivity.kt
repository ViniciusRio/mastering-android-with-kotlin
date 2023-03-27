package dominando.android.adapter

import android.content.Intent
import android.os.Bundle
import android.widget.AbsListView
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class StateListActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_STATE = "state"
        const val EXTRA_RESULT = "result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val listView = ListView(this)
        setContentView(listView)

        val states = resources.getStringArray(R.array.states)
        val listAdapter =
            ArrayAdapter(this, android.R.layout.simple_list_item_single_choice, states)
        listView.adapter = listAdapter
        listView.choiceMode = AbsListView.CHOICE_MODE_SINGLE

        getIntent(states, listView)

        setListeners(listView)
    }

    private fun getIntent(states: Array<out String>, listView: ListView) {
        val state = intent.getStringExtra(EXTRA_STATE)
        state?.let {
            val position = states.indexOf(state)
            listView.setItemChecked(position, true)
        }
    }

    private fun setListeners(listView: ListView) {
        listView.setOnItemClickListener { adapterView, view, i, l ->
            createIntent(adapterView, i)
        }
    }

    private fun createIntent(adapterView: AdapterView<*>, i: Int) {
        val result = adapterView.getItemAtPosition(i) as String

        val intent = Intent()
        intent.putExtra(EXTRA_RESULT, result)
        setResult(RESULT_OK, intent)
        finish()
    }
}