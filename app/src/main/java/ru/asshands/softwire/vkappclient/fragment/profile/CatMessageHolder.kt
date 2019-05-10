package ru.asshands.softwire.vkappclient.fragment.profile

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import ru.asshands.softwire.vkappclient.common.loadImage

class CatMessageHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(data: CatMessage) {
        (itemView as ImageView).loadImage(data.image)
    }
}