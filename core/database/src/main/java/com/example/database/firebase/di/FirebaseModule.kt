package com.example.database.firebase.di

import com.example.database.firebase.auth.FirebaseAuth
import com.example.database.firebase.auth.FirebaseAuthAPI
import com.example.data.firebase.auth.exceptions.ExceptionAuth
import com.example.database.firebase.auth.exceptions.ExceptionAuthMapper
import com.example.database.firebase.connection.FirebaseConnection
import com.example.database.firebase.connection.FirebaseConnectionImpl
import com.example.data.firebase.database.users.FirebaseUsersDataSource
import com.example.data.firebase.database.users.FirebaseUsersDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class FirebaseModule {

    @Binds
    abstract fun bindFirebaseAuth(firebaseAuth: FirebaseAuth): FirebaseAuthAPI

    @Binds
    abstract fun bindFirebaseUsersDataSource(firebaseUsersDataSourceImpl: FirebaseUsersDataSourceImpl):
            FirebaseUsersDataSource

    @Binds
    abstract fun bindFirebaseConnection(firebaseConnectionImpl: FirebaseConnectionImpl): FirebaseConnection

    @Binds
    abstract fun bindAuthErrorHandler(authErrorHandlerImpl: ExceptionAuthMapper): ExceptionAuth
}