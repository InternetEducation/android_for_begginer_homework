package com.tinkoff.android_homework.presentation.model.operations

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * @author d.a.korotkov
 */
@Serializable
enum class OperationType {
    @Serializable
    @SerialName("OUTCOME")
    OUTCOME,
    @SerialName("INCOME")
    INCOME
}
