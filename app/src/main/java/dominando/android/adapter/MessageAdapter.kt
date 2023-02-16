package dominando.android.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_message.view.*

class MessageAdapter(
    private val messages: List<Message>,
    // higher-order-functions
    private val callback: (Message) -> Unit,
) : RecyclerView.Adapter<MessageAdapter.MessageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        // item_message represents each item
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_message, parent, false)
        val viewHolder = MessageViewHolder(view)

        viewHolder.itemView.setOnClickListener {
            val message = messages[viewHolder.absoluteAdapterPosition]
            callback(message)
        }

        return viewHolder
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val title = messages[position].title
        val text = messages[position].text

        holder.txtTitle.text = title
        holder.txtText.text = text
    }

    override fun getItemCount(): Int = messages.size

    class MessageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val txtTitle: TextView = itemView.txtTitle
        val txtText: TextView = itemView.txtText

    }


}