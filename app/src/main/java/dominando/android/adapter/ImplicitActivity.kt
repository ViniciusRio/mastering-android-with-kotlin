package dominando.android.adapter

import android.app.SearchManager
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.Settings
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import java.util.*

class ImplicitActivity : AppCompatActivity() {
    lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        createListView()
        setListeners()

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (grantResults.first() == PackageManager.PERMISSION_GRANTED) {
            callNumber()
        }
    }

    private fun createListView() {
        listView = ListView(this);
        setContentView(listView)

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            resources.getStringArray(R.array.intent_actions)
        )
        listView.adapter = adapter
    }

    private fun setListeners() {
        listView.setOnItemClickListener { adapterView, view, i, l ->
            openIntentAtPosition(i)
        }
    }

    private fun callNumber() {
        val uri = Uri.parse("tel: 99988877766")
        val intent = Intent(Intent.ACTION_CALL, uri)

        openIntent(intent)
    }

    private fun openIntentAtPosition(position: Int) {
        val uri: Uri?
        val intent: Intent?

        when (position) {
            0 -> {
                uri = Uri.parse("http://www.nglauber.com.br")
                intent = Intent(Intent.ACTION_VIEW, uri)

                openIntent(intent)
            }
            1 -> {
                if (ActivityCompat.checkSelfPermission(
                        this,
                        android.Manifest.permission.CALL_PHONE
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    ActivityCompat.requestPermissions(
                        this,
                        arrayOf<String>(android.Manifest.permission.CALL_PHONE),
                        0
                    )
                } else {
                    callNumber()
                }
//                uri = Uri.parse("tel: 99988877766")
//                intent = Intent(Intent.ACTION_DIAL, uri)
//
//                openIntent(intent)
            }
            2 -> {
                uri = Uri.parse("geo:0,0?q=Rua+Amelia,Recife")
                intent = Intent(Intent.ACTION_VIEW, uri)

                openIntent(intent)
            }
            3 -> {
                uri = Uri.parse("sms:12345")
                intent = Intent(Intent.ACTION_VIEW, uri).putExtra("sms_body", "Mensagem SMS")

                openIntent(intent)
            }
            4 -> {
                intent = Intent()
                intent.setAction(Intent.ACTION_SEND)
                    .putExtra(Intent.EXTRA_TEXT, "Compartilhando via Intent")
                    .setType("text/plain")

                openIntent(intent)
            }
            5 -> {
                intent = Intent(AlarmClock.ACTION_SET_ALARM)
                    .putExtra(AlarmClock.EXTRA_MESSAGE, "Estudar Android")
                    .putExtra(AlarmClock.EXTRA_HOUR, 19)
                    .putExtra(AlarmClock.EXTRA_MINUTES, 19)
                    .putExtra(AlarmClock.EXTRA_SKIP_UI, true)
                    .putExtra(
                        AlarmClock.EXTRA_DAYS, arrayListOf(
                            Calendar.MONDAY,
                            Calendar.WEDNESDAY
                        )
                    )

                openIntent(intent)
            }
            6 -> {
                intent = Intent(Intent.ACTION_SEARCH)
                    .putExtra(SearchManager.QUERY, "Novatec")

                openIntent(intent)
            }

            7 -> {
                intent = Intent(Settings.ACTION_SETTINGS)
                openIntent(intent)
            }

            8 -> {
                intent = Intent("dominando.android.adapter.CUSTOM_ACTION")
                openIntent(intent)
            }
            9 -> {
                uri = Uri.parse("produto://Notebook/Slim")
                intent = Intent(Intent.ACTION_VIEW, uri)
                openIntent(intent)
            }
            else -> finish()
        }
    }

    private fun openIntent(intent: Intent) {
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Toast.makeText(this, R.string.error_intent, Toast.LENGTH_LONG).show()
        }
    }
}