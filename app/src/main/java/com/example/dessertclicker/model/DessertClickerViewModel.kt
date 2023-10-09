package com.example.dessertclicker.model

import kotlinx.coroutines.flow.update
import com.example.dessertclicker.data.Datasource.dessertList

class DessertClickerViewModel : DessertClickerModel() {

    override fun determineDessertIndex(dessertsSold: Int): Int {
        var dessertIndex = 0
        for (index in dessertList.indices) {
            if (dessertsSold >= dessertList[index].startProductionAmount) {
                dessertIndex = index
            } else {
                // The list of desserts is sorted by startProductionAmount. As you sell more
                // desserts, you'll start producing more expensive desserts as determined by
                // startProductionAmount. We know to break as soon as we see a dessert who's
                // "startProductionAmount" is greater than the amount sold.
                break
            }
        }
        return dessertIndex
    }

    override fun onDessertClicked() {
        _uiState.update {
            val dessertsSold = it.dessertsSold + 1
            val nextDessertIndex = determineDessertIndex(dessertsSold)
            it.copy(
                currentDessertIndex = nextDessertIndex,
                revenue = it.revenue + it.currentDessertPrice,
                dessertsSold = dessertsSold,
                currentDessertImageId = dessertList[nextDessertIndex].imageId,
                currentDessertPrice = dessertList[nextDessertIndex].price
            )
        }
    }

}
