package divyansh.tech.kdrama.home.di

import android.app.Activity
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import divyansh.tech.kdrama.home.source.HomeDefaultDataSource
import divyansh.tech.kdrama.home.source.HomeDefaultRepository

@Module
@InstallIn(ViewModelComponent::class)
abstract class HomeModule {

    @Binds
    @ViewModelScoped
    abstract fun bindHomeRepo(
        localData: HomeDefaultRepository
    ): HomeDefaultDataSource
}