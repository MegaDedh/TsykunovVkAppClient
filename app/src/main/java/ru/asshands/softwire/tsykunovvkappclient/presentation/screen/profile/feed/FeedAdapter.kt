package ru.asshands.softwire.tsykunovvkappclient.presentation.screen.profile.feed

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_post_message.view.*
import ru.asshands.softwire.tsykunovvkappclient.R
import ru.asshands.softwire.tsykunovvkappclient.presentation.common.loadImage
import timber.log.Timber
import java.lang.IllegalArgumentException

class FeedAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        const val POST_MESSAGE = 1
        const val CAT_MESSAGE = 2
    }

    private val items: MutableList<BaseMessage> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = when (viewType) {
        POST_MESSAGE -> {
            Timber.d("OnCreateViewHolder PostMessage")
            PostMessageHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.item_post_message,
                    parent,
                    false
                )

            )
        }

        CAT_MESSAGE -> {
            Timber.d("OnCreateViewHolder CATMessage")
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
        Timber.d("OnBindViewHolder $position")
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

    inner class PostMessageHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(data: PostMessage) {
            itemView.itemPostMessage.text = data.message

            if (data.image.isNotEmpty()) {
                itemView.itemPostImage.loadImage(data.image)
            }
        }
    }

    inner class CatMessageHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(data: CatMessage) {
            (itemView as ImageView).loadImage(data.image)
        }
    }
}