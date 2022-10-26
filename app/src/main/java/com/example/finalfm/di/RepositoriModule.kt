package com.example.finalfm.di

import com.example.finalfm.domain.api.FmGenresService
import com.example.finalfm.domain.repositories.FmGenresRepo
import com.example.finalfm.domain.repositories.FmGenresRepolmpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoriModule {
    @Binds
    abstract fun provideGenresRepo(categoryRepo: FmGenresRepo): FmGenresRepo

    companion object{
        @Provides
        fun getFmGenresRepoImpl(fmGenresService: FmGenresService): FmGenresRepolmpl {
            return FmGenresRepolmpl(fmGenresService)
        }
    }
}