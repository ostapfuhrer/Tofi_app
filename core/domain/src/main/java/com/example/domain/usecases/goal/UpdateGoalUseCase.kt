package com.example.domain.usecases.goal

import com.example.data.repository.users.UsersRepository
import com.example.database.firebase.state.UpdateUserState
import com.example.database.room.entities.Goal
import javax.inject.Inject

class UpdateGoalUseCase @Inject constructor(
    private val usersRepository: UsersRepository,
) {
    suspend fun updateGoal(userId: String, goal: Goal): UpdateUserState {
        return usersRepository.updateGoal(userId, goal)
    }
}