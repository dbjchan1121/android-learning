package com.example.demoproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.demoproject.R
import com.example.demoproject.bean.Status
import com.example.demoproject.bean.UserBean


class ItemAdapter(private val context: Context, private val dataset: MutableList<UserBean>) :
//class ItemAdapter(private val context: Context, private val dataset: List<Affirmation>) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {


    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView: TextView = view.findViewById(R.id.item_title)
        val idTextView: TextView = view.findViewById(R.id.item_id)
        val avatarImageView: ImageView = view.findViewById(R.id.user_avatar)
        val acceptItem: AppCompatButton = view.findViewById(R.id.action_btn)
        val closeItem: ImageButton = view.findViewById(R.id.ic_close)
    }

    /**
     * 提供给布局管理器调用，为 RecyclerView 创建新的 ViewHolder（在不存在可重复使用的 ViewHolder 时）
     * 注意：一个 ViewHolder 代表一个列表项视图
     * @param parent 父项，RecyclerView，将列表项 View 作为子 View 加到视图组（ViewGroup）
     * @param viewType RecyclerView View的类型，当 RecyclerView 中存在多种列表项类型时需关注
     * @return
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        // inflate 膨胀
        // 存储对列表项视图的引用
        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        // 传入列表项视图
        return ItemViewHolder(adapterLayout)
    }

    // 数据集的大小
    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val user = dataset[position]

//        holder.textView.text = context.resources.getString(item.stringResourceId)
        holder.nameTextView.text = user.name
        holder.nameTextView.paint.isFakeBoldText = true;
        holder.idTextView.text = "ID:".plus(user.id)
        Glide.with(holder.avatarImageView).load(user.avatar).into(holder.avatarImageView)

        if (user.status == Status.ACTIVE) {
            holder.acceptItem.text = "Accepted"
            holder.acceptItem.isEnabled = false
            holder.acceptItem.setBackgroundResource(android.R.color.transparent)
            holder.acceptItem.setTextColor(context.getColor(android.R.color.holo_green_dark))  // 设置文本颜色为绿色
        } else {
            holder.acceptItem.text = "Accept"
            holder.acceptItem.isEnabled = true
            holder.acceptItem.setBackgroundResource(R.drawable.shape_button)
            holder.acceptItem.setTextColor(context.getColor(android.R.color.black))  // 恢复正常的文字颜色（黑色）
        }

        holder.acceptItem.setOnClickListener {
            user.status = Status.ACTIVE
            notifyItemChanged(position)
        }

        holder.closeItem.setOnClickListener {
            dataset.removeAt(position)
            notifyItemChanged(position)
            notifyItemRangeChanged(position, dataset.size)
        }

    }
}