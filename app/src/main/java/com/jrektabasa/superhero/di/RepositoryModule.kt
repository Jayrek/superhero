package com.jrektabasa.superhero.di

import com.jrektabasa.superhero.data.repository.biography.BiographyRepositoryImpl
import com.jrektabasa.superhero.domain.repository.biography.BiographyRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Singleton
    @Binds
    abstract fun bindsBiographyRepository(
        biographyRepositoryImpl: BiographyRepositoryImpl
    ): BiographyRepository
}