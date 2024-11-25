package com.example.data.di

import com.example.data.repository.users.UsersRepository
import com.example.data.repository.users.UsersRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    internal abstract fun bindsUserRepository(usersRepositoryImpl: UsersRepositoryImpl): UsersRepository

}