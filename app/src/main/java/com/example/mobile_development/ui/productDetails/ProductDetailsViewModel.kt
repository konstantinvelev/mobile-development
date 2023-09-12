package com.example.mobile_development.ui.productDetails

import androidx.lifecycle.ViewModel
import com.example.mobile_development.api.API
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductDetailsViewModel @Inject constructor(private val apiService: API) : ViewModel() {
    val id = 0
    val title: String = ""
    val description = ""
    val short_description = ""
    val stock = 0
    val price = 0
    val rating = 0
    val image = ""
    val category = ""
}