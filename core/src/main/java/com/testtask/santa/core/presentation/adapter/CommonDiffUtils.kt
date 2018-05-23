

package com.testtask.santa.core.presentation.adapter

import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import com.testtask.santa.core.presentation.view.BaseAdapter

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


@Suppress("NOTHING_TO_INLINE")
inline fun <Data, VH : RecyclerView.ViewHolder> BaseAdapter<Data, VH>.calculateDiffs(
    old: List<Data>,
    new: List<Data>,
    detectMoves: Boolean = false
) {
    val result = DiffUtil.calculateDiff(DiffUtilCommon(old, new), detectMoves)
    updateData(new)
    result.dispatchUpdatesTo(this)
}
