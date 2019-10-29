package com.data.mapper

import com.data.response.UserResponse
import com.domain.model.User
import javax.inject.Inject

class UserMapper @Inject constructor()
{
    fun transform(user:UserResponse) = User(user.followers,user.full_name,-1)

    fun transform(users : List<UserResponse>) : List<User>
    {
        val list = ArrayList<User>()
        users.forEach{
            list.add(transform(it))
        }
        return list
    }
}