package com.commandiron.vacationchecklist.domain.di

import com.commandiron.vacationchecklist.domain.repository.Repository
import com.commandiron.vacationchecklist.domain.use_cases.DeleteAllCheckItems
import com.commandiron.vacationchecklist.domain.use_cases.GetAllVacations
import com.commandiron.vacationchecklist.domain.use_cases.InsertAllCheckItems
import com.commandiron.vacationchecklist.domain.use_cases.GetAllCheckItems
import com.commandiron.vacationchecklist.domain.use_cases.InsertCheckItem
import com.commandiron.vacationchecklist.domain.use_cases.UseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object DomainModule {

    @ViewModelScoped
    @Provides
    fun provideUseCases(
        repository: Repository
    ): UseCases {
        return UseCases(
            getAllVacations = GetAllVacations(),
            insertAllCheckItems = InsertAllCheckItems(repository),
            deleteAllCheckItems = DeleteAllCheckItems(repository),
            getAllCheckItems = GetAllCheckItems(repository),
            insertCheckItem = InsertCheckItem(repository)
        )
    }
}