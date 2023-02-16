package dominando.android.adapter

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var messages = mutableListOf<Message>()
    private var adapter = MessageAdapter(messages, this::onMessageItemClick)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()

        fabAdd.setOnClickListener {
            addMessage()
        }
    }

    private fun initRecyclerView() {
        rvMessages.adapter = adapter

        //LinearLayoutManager organize linear items
        //StagedredGridLayoutManager similar to Grid, but allow items with many forms, like mosaic
        val layoutManager = GridLayoutManager(this, 2)
        layoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            // Which item fill two column? Position 0 2 column otherwise 1
            override fun getSpanSize(position: Int): Int {
                return if (position == 0) 2 else 1
            }
        }

        rvMessages.layoutManager = layoutManager
    }

    private fun addMessage() {
        val message = Message(edtTitle.text.toString(), edtText.text.toString())
        messages.add(message)

        adapter.notifyItemInserted(messages.lastIndex)

        edtTitle.text?.clear()
        edtText.text?.clear()
        edtTitle.requestFocus()

    }

    private fun onMessageItemClick(message: Message) {
        val messageTile = "${message.title}\n${message.text}"

        Toast.makeText(this, messageTile, Toast.LENGTH_SHORT).show()

    }


}