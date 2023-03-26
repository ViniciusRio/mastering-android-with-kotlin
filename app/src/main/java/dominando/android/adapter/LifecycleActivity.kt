package dominando.android.adapter

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class LifecycleActivity : AppCompatActivity() {

    // Called when started the app
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lifecycle)

        Log.i("NGVL", "LifecycleActivity::onCreated")
    }

    // Called after onCreate, already visible
    override fun onStart() {
        super.onStart()
        Log.i("NGVL", "LifecycleActivity::onStart")
    }

    // Called after onCreate
    override fun onResume() {
        super.onResume()
        Log.i("NGVL", "LifecycleActivity::onResume")

    }

    /*
        Called when other activity is started and partially visible
        As well press home button call onPause and after onStop
     */
    override fun onPause() {
        super.onPause()
        Log.i("NGVL", "LifecycleActivity::onPause")

    }

    /*
       Called when initial methods from other activity is started
       here a first will not be visible.

       As well press home button call onStop after onPause.

       Recommend get data here
    */
    override fun onStop() {
        super.onStop()
        Log.i("NGVL", "LifecycleActivity::onStop")

    }

    /*
        Called when back to screen from other, after onStart and onResume is called.
     */
    override fun onRestart() {
        super.onRestart()
        Log.i("NGVL", "LifecycleActivity::onRestart")

    }

    // Called when back button is press, for example. Is equivalent call method finish()
    override fun onDestroy() {
        super.onDestroy()
        Log.i("NGVL", "LifecycleActivity::onDestroy")

    }
}