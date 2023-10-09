/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.dessertclicker.model

import androidx.annotation.DrawableRes
import com.example.dessertclicker.R

/**
 * [Dessert] is the data class to represent the Dessert imageId, price, and startProductionAmount
 */
data class Dessert(
    @DrawableRes val imageId: Int = R.drawable.cupcake,
    val price: Int = 5,
    val startProductionAmount: Int = 0
)