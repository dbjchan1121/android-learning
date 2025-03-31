package com.example.demoproject.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.example.demoproject.R
import com.example.demoproject.model.Affirmation


class ItemAdapter(private val context: Context, private val dataset: List<Affirmation>) :
    RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {


    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)

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
        val item = dataset[position]

        holder.textView.text = context.resources.getString(item.stringResourceId)
        holder.textView.paint.isFakeBoldText = true;
    }
}