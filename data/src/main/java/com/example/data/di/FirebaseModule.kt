package com.example.data.di

import com.example.data.firebase.auth.FirebaseAuth
import com.example.data.firebase.auth.FirebaseAuthAPI
import com.example.data.firebase.auth.handlers.AuthErrorHandler
import com.example.data.firebase.auth.handlers.AuthErrorHandlerImpl
import com.example.data.firebase.connection.FirebaseConnection
import com.example.data.firebase.connection.FirebaseConnectionImpl
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
    abstract fun bindAuthErrorHandler(authErrorHandlerImpl: AuthErrorHandlerImpl): AuthErrorHandler
}