package com.jrektabasa.superhero.di

import com.jrektabasa.superhero.data.repository.auth.AuthRepositoryImpl
import com.jrektabasa.superhero.data.repository.biography.BiographyRepositoryImpl
import com.jrektabasa.superhero.data.repository.hero.HeroRepositoryImpl
import com.jrektabasa.superhero.domain.repository.HeroRepository
import com.jrektabasa.superhero.domain.repository.auth.AuthRepository
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
    @Singleton
    @Binds
    abstract fun bindsAuthRepository(
        authRepositoryImpl: AuthRepositoryImpl
    ): AuthRepository
    @Singleton
    @Binds
    abstract fun bindsHeroRepository(
        heroRepositoryImpl: HeroRepositoryImpl
    ): HeroRepository
}