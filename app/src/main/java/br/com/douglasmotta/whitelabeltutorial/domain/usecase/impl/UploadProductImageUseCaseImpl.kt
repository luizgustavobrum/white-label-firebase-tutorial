package br.com.douglasmotta.whitelabeltutorial.domain.usecase.impl

import android.net.Uri
import br.com.douglasmotta.whitelabeltutorial.data.ProductRepository
import br.com.douglasmotta.whitelabeltutorial.domain.usecase.UploadProductImageUseCase
import javax.inject.Inject

class UploadProductImageUseCaseImpl @Inject constructor(
    private val productRepository: ProductRepository
) : UploadProductImageUseCase {

    override suspend fun invoke(
        imageUri: Uri
    ): String = productRepository.uploadProductImage(imageUri = imageUri)

}