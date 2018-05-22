package com.testtask.santa.core.presentation.adapter

import android.support.v7.util.DiffUtil

class DiffUtilCommon<Type>(
        private val old: List<Type>,
        private val new: List<Type>
): DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            old[oldItemPosition]?.hashCode() == new[newItemPosition]?.hashCode()

    override fun getOldListSize(): Int = old.size

    override fun getNewListSize(): Int = new.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            old[oldItemPosition] == new[newItemPosition]
}