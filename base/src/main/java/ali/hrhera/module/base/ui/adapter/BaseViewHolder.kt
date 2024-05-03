package ali.hrhera.module.base.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding

open class BaseViewHolder<out viewBinding : ViewBinding>(val binding: viewBinding) : RecyclerView.ViewHolder(binding.root)