package br.com.douglasmotta.whitelabeltutorial.domain.usecase.impl

import br.com.douglasmotta.whitelabeltutorial.data.ProductRepository
import br.com.douglasmotta.whitelabeltutorial.domain.model.Product
import br.com.douglasmotta.whitelabeltutorial.domain.usecase.GetProductUseCase

class GetProductUseCaseImpl(
    private val productRepository: ProductRepository
) : GetProductUseCase {
    override suspend fun invoke(): List<Product> = productRepository.getProducts()
}