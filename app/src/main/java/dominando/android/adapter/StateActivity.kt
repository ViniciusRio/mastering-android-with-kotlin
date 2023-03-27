package dominando.android.adapter

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import kotlinx.android.synthetic.main.activity_state.*

class StateActivity : AppCompatActivity() {
    var state: String? = null

    private var registerForActivityResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        if (it.resultCode == Activity.RESULT_OK && it.data?.hasExtra(StateListActivity.EXTRA_RESULT) == true) {
            state = it.data!!.getStringExtra(StateListActivity.EXTRA_RESULT)
            btnState.text = state
        }
    }

    companion object {
        const val EXTRA_STATE = "state"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_state)

        setListeners()

        if (savedInstanceState != null) {
            state = savedInstanceState.getString(EXTRA_STATE)

            if (state != null) {
                btnState.text = state
            }
        }

    }

    private fun setListeners() {
        btnState.setOnClickListener {
            val intent = Intent(this, StateListActivity::class.java)
            intent.putExtra(StateListActivity.EXTRA_STATE, state)

            registerForActivityResult.launch(intent)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(EXTRA_STATE, state)
    }
}