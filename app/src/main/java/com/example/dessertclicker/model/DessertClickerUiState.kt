package com.example.dessertclicker.model

import androidx.annotation.DrawableRes
import androidx.lifecycle.ViewModel
import com.example.dessertclicker.data.Datasource.dessertList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

data class DessertClickerUiState(
    var revenue: Int = 0,
    var dessertsSold: Int = 0,
    val currentDessertIndex: Int = 0,
    var currentDessertPrice: Int = dessertList[currentDessertIndex].price,
    @DrawableRes var currentDessertImageId: Int =  dessertList[currentDessertIndex].imageId
)

abstract class DessertClickerModel : ViewModel() {

    protected val _uiState = MutableStateFlow(DessertClickerUiState())
    val uiState = _uiState.asStateFlow()

    protected abstract fun determineDessertIndex(dessertsSold: Int): Int

    abstract internal fun onDessertClicked()


}