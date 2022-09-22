package com.justin.taipeizoobrowser.home


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.justin.taipeizoobrowser.data.Building
import com.justin.taipeizoobrowser.data.HomeItem
import com.justin.taipeizoobrowser.databinding.ItemHomeBuildingBinding


class HomeAdapter(private val onClickListener: OnClickListener):
    ListAdapter<HomeItem, RecyclerView.ViewHolder>(DiffCallback) {

    class BuildingViewHolder(private var binding: ItemHomeBuildingBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(building: Building, onClickListener: OnClickListener) {
            binding.building = building
            binding.root.setOnClickListener { onClickListener.onClick(building) }
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<HomeItem>() {
        override fun areItemsTheSame(oldItem: HomeItem, newItem: HomeItem): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: HomeItem, newItem: HomeItem): Boolean {
            return oldItem.id == newItem.id
        }

        private const val ITEM_VIEW_TYPE_BUILDING = 0x00
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ITEM_VIEW_TYPE_BUILDING -> BuildingViewHolder(
                ItemHomeBuildingBinding.inflate(
                    LayoutInflater.from(parent.context), parent, false
                )
            )
            else -> throw ClassCastException("Unknown viewType $viewType")
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is BuildingViewHolder -> {
                holder.bind((getItem(position) as HomeItem.BuildingItem).building, onClickListener)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is HomeItem.BuildingItem -> ITEM_VIEW_TYPE_BUILDING
        }
    }

    class OnClickListener(val clickListener: (building: Building) -> Unit) {
        fun onClick(building: Building) = clickListener(building)
    }
}