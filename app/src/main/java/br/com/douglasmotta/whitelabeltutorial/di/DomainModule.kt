package br.com.douglasmotta.whitelabeltutorial.di

import br.com.douglasmotta.whitelabeltutorial.domain.usecase.CreateProductUseCase
import br.com.douglasmotta.whitelabeltutorial.domain.usecase.GetProductUseCase
import br.com.douglasmotta.whitelabeltutorial.domain.usecase.UploadProductImageUseCase
import br.com.douglasmotta.whitelabeltutorial.domain.usecase.impl.CreateProductUseCaseImpl
import br.com.douglasmotta.whitelabeltutorial.domain.usecase.impl.GetProductUseCaseImpl
import br.com.douglasmotta.whitelabeltutorial.domain.usecase.impl.UploadProductImageUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
interface DomainModule {

    @Binds
    fun bindCreateProductUseCase(
        createProductUseCaseImpl: CreateProductUseCaseImpl
    ): CreateProductUseCase

    @Binds
    fun bindGetProductUseCase(
        getProductUseCaseImpl: GetProductUseCaseImpl
    ): GetProductUseCase

    @Binds
    fun bindUploadProductImageUseCase(
        uploadProductImageUseCaseImpl: UploadProductImageUseCaseImpl
    ): UploadProductImageUseCase


}