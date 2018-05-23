

package com.testtask.santa.core.utils

import com.testtask.santa.core.data.mapper.Mappable

@Suppress("NOTHING_TO_INLINE")
inline fun <D: Any> List<Mappable<D>>.mapAll(): List<D> = this.map { it.map() }
