package ru.asshands.softwire.vkappclient.fragment.profile

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import ru.asshands.softwire.vkappclient.common.loadImage
import kotlinx.android.synthetic.main.item_post_message.view.*

class PostMessageHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(data: PostMessage) {
        itemView.itemPostMessage.text = data.message

        if (data.image.isNotEmpty()) {
            itemView.itemPostImage.loadImage(data.image)
        }
    }
}