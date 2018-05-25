package com.testtask.santa.core.presentation.view

import android.arch.paging.PagedListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView

abstract class BaseAdapter<Data, VH: RecyclerView.ViewHolder>(
    diffs: DiffUtil.ItemCallback<Data>
): PagedListAdapter<Data, VH>(diffs) {

    abstract fun updateData(data: List<Data>)

}
