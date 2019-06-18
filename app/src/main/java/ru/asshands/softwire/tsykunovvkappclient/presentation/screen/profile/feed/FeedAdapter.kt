package ru.asshands.softwire.tsykunovvkappclient.presentation.screen.profile.feed

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_post_message.view.*
import kotlinx.android.synthetic.main.item_profile_message.view.*
import ru.asshands.softwire.tsykunovvkappclient.R
import ru.asshands.softwire.tsykunovvkappclient.presentation.common.inflate
import ru.asshands.softwire.tsykunovvkappclient.presentation.common.loadImage
import ru.asshands.softwire.tsykunovvkappclient.presentation.entity.BaseMessage
import ru.asshands.softwire.tsykunovvkappclient.presentation.entity.PostMessage
import ru.asshands.softwire.tsykunovvkappclient.presentation.entity.ProfileMessage
import ru.asshands.softwire.tsykunovvkappclient.presentation.model.ProfileData
import timber.log.Timber
import java.lang.IllegalArgumentException

class FeedAdapter(private val onLoadPosts: () -> Unit) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    companion object {
        const val PROFILE_MESSAGE = 1
        const val POST_MESSAGE = 2
    }

    private val items: MutableList<BaseMessage> = mutableListOf()
    private lateinit var profileItem: ProfileMessage

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder = when (viewType) {

        PROFILE_MESSAGE -> {
               Timber.d("OnCreateViewHolder ProfileMessage")
            ProfileHolder((parent.inflate(R.layout.item_profile_message))
            )
        }

        POST_MESSAGE -> {
            Timber.d("OnCreateViewHolder PostMessage")
            PostMessageHolder(parent.inflate(R.layout.item_post_message))
            }

        else -> throw IllegalArgumentException("viewType $viewType not found")
    }

    override fun getItemViewType(position: Int): Int = when (items[position]) {
        is ProfileMessage -> PROFILE_MESSAGE
        is PostMessage -> POST_MESSAGE
        else -> throw IllegalArgumentException("${items[position].javaClass} not found")
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        Timber.d("OnBindViewHolder $position")
        if (items.size - position == 5) {
            onLoadPosts()
        }
        when (holder) {
            is ProfileHolder -> holder.bind(items[position] as ProfileMessage)
            is PostMessageHolder -> holder.bind(items[position] as PostMessage)
        }
    }

    fun setItems(items: List<BaseMessage>) {
        this.items.clear()
        profileItem.let {this.items.add(profileItem)}
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun setProfile(data: ProfileMessage) {
        profileItem = data
    }

    class ProfileHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(data: ProfileMessage) {
            itemView.profileViewFirstName.text = data.firstName
            itemView.profileViewSurname.text = data.lastName
            itemView.profileViewBirthday.text = data.birthday
            itemView.profileViewCity.text = data.city
            itemView.profileAvatarView.loadImage(data.avatar)
        }
    }

    class PostMessageHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(data: PostMessage) {
            itemView.itemPostMessage.text = data.message

            if (data.contentUrl.isNotEmpty()) {
                itemView.itemPostImage.loadImage(data.contentUrl)
            }
        }


    }

}