package br.com.douglasmotta.whitelabeltutorial.ui.addproducts

import android.net.Uri
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.douglasmotta.whitelabeltutorial.R
import br.com.douglasmotta.whitelabeltutorial.domain.usecase.CreateProductUseCase
import br.com.douglasmotta.whitelabeltutorial.util.fromCurrency
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddProductViewModel @Inject constructor(
    private val createProductUseCase: CreateProductUseCase
) : ViewModel() {

    private val _imageUriErrorResId = MutableLiveData<Int>()
    val imageUriErrorResId: LiveData<Int> get() = _imageUriErrorResId

    private val _descriptionFieldErrorResId = MutableLiveData<Int?>()
    val descriptionFieldErrorResId: LiveData<Int?> get() = _descriptionFieldErrorResId

    private val _priceFieldErrorResId = MutableLiveData<Int?>()
    val priceFieldErrorResId: LiveData<Int?> get() = _priceFieldErrorResId

    private var isFormValid = false

    fun createProduct(
        description: String,
        price: String,
        imageUri: Uri?
    ) = viewModelScope.launch {
        isFormValid = true

        _imageUriErrorResId.postValue(getDrawableResIdIfNull(imageUri))

        _descriptionFieldErrorResId.postValue(getErrorStringResIdIfEmpty(description))

        _priceFieldErrorResId.postValue(getErrorStringResIdIfEmpty(price))

        if (isFormValid) {
            try {
                val product = createProductUseCase(
                    description,
                    price.fromCurrency(),
                    imageUri!!
                )
            } catch (e: Exception) {
                Log.e("AddProductViewModel", e.toString())

            }
        }
    }

    private fun getErrorStringResIdIfEmpty(
        value: String
    ): Int? {
        return if (value.isEmpty()) {
            isFormValid = false
            R.string.add_product_field_error
        } else null
    }

    private fun getDrawableResIdIfNull(
        value: Uri?
    ): Int {
        return if (value == null) {
            isFormValid = false
            R.drawable.background_product_image_error
        } else R.drawable.background_product_image
    }

}