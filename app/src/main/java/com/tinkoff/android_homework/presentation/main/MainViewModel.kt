package com.tinkoff.android_homework.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tinkoff.android_homework.domain.main.usecases.SubscribeTotalUseCase
import kotlinx.coroutines.launch

/**
 * @author d.shtaynmets
 */
class MainViewModel(
    private val subscribeTotalUseCase: SubscribeTotalUseCase,
) : ViewModel() {

    init {
        viewModelScope.launch {
            subscribeTotalUseCase.invoke()
        }
    }
}
