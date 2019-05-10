package ru.asshands.softwire.vkappclient.fragment.profile

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import ru.asshands.softwire.vkappclient.R
import ru.asshands.softwire.vkappclient.common.loadImage
import kotlinx.android.synthetic.main.item_post_message.view.*
import java.lang.ClassCastException
import java.lang.IllegalArgumentException
import java.lang.RuntimeException

class FeedAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        const val POST_MESSAGE = 1
        const val CAT_MESSAGE = 2
    }

    private val items: MutableList<BaseMessage> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = when (viewType) {
        POST_MESSAGE -> {
            Log.d("TAG","OnCreateViewHolder PostMessage")
            PostMessageHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_post_message,
                    parent,
                    false
                )

            )

        }

        CAT_MESSAGE -> {
            Log.d("TAG","OnBindViewHolder CATMessage")
            CatMessageHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_cat_message,
                    parent,
                    false
                )
            )
        }

        else -> throw IllegalArgumentException("viewType $viewType not found")

    }

    override fun getItemViewType(position: Int): Int = when (items[position]) {
        is PostMessage -> POST_MESSAGE
        is CatMessage -> CAT_MESSAGE
        else -> throw IllegalArgumentException("${items[position].javaClass} not found")
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Log.d("TAG","OnBindViewHolder $position")
        when (holder) {
            is PostMessageHolder -> holder.bind(items[position] as PostMessage)
            is CatMessageHolder -> holder.bind(items[position] as CatMessage)
        }
    }

    fun setItems(items: List<BaseMessage>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

}