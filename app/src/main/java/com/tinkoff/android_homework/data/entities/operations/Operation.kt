package com.tinkoff.android_homework.data.entities.operations

import kotlinx.serialization.Serializable

/**
 * @author d.shtaynmets
 */
@Serializable
data class Operation(
    val name: String,
    val amount: Int,
)
