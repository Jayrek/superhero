package com.jrektabasa.superhero.di

import com.jrektabasa.superhero.data.remote.data_source.auth.AuthRemoteDataSource
import com.jrektabasa.superhero.data.remote.data_source.auth.AuthRemoteDataSourceImpl
import com.jrektabasa.superhero.data.remote.data_source.biography.*
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {

    @Singleton
    @Binds
    abstract fun bindsBiographyRemoteDataSource(
        biographyRemoteDataSourceImpl: BiographyRemoteDataSourceImpl
    ): BiographyRemoteDataSource
    @Singleton
    @Binds
    abstract fun bindsAuthRemoteDataSource(
        authRemoteDataSourceImpl: AuthRemoteDataSourceImpl
    ): AuthRemoteDataSource
}