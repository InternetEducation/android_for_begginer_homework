package com.tinkoff.android_homework.data.network.entities.operations

import kotlinx.serialization.Serializable

/**
 * @author d.shtaynmets
 */
@Serializable
data class Operations(
    val operation: List<Operation>,
)
