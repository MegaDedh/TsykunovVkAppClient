package ru.asshands.softwire.tsykunovvkappclient.presentation.widget

import android.content.Context
import android.util.AttributeSet
import androidx.annotation.DrawableRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.getColorOrThrow
import androidx.core.content.res.getResourceIdOrThrow
import kotlinx.android.synthetic.main.view_avatar_picker.view.*
import ru.asshands.softwire.tsykunovvkappclient.R
import ru.asshands.softwire.tsykunovvkappclient.presentation.common.inflate


class AvatarPickerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    style: Int = 0
) : ConstraintLayout(context, attrs, style) {

    init {
        inflate(R.layout.view_avatar_picker, true)
        attrs?.let(::setAttrs)
    }

    fun setOnIconClickListener(action: () -> Unit) {
        apb_icon.setOnClickListener { action() }
    }

    private fun setAttrs(attrs: AttributeSet) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.AvatarPickerView)

        try {
            val avatar = typedArray.getResourceIdOrThrow(R.styleable.AvatarPickerView_apv_image)
            val icon = typedArray.getResourceIdOrThrow(R.styleable.AvatarPickerView_apv_icon)
            val iconBackground = typedArray.getColorOrThrow(R.styleable.AvatarPickerView_apv_icon_background)

            initView(avatar, icon, iconBackground)
        } finally {
            typedArray.recycle()
        }
    }

    private fun initView(@DrawableRes avatar: Int, @DrawableRes icon: Int, iconBackground: Int) {
        apv_image.setImageResource(avatar)
        apb_icon.setImageResource(icon)
        apb_icon.setBackgroundColor(iconBackground)
    }
}