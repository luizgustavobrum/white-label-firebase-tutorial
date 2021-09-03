package br.com.douglasmotta.whitelabeltutorial.di

import br.com.douglasmotta.whitelabeltutorial.data.FirebaseProductDataSource
import br.com.douglasmotta.whitelabeltutorial.data.ProductDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Singleton
    @Binds
    fun bindProductDataSource(
        productDataSource: FirebaseProductDataSource
    ): ProductDataSource

}