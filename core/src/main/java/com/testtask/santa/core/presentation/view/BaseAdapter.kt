package com.testtask.santa.core.presentation.view

import android.support.v7.widget.RecyclerView

abstract class BaseAdapter<in Data, VH: RecyclerView.ViewHolder>: RecyclerView.Adapter<VH>() {

    abstract fun updateData(data: List<Data>)

}
