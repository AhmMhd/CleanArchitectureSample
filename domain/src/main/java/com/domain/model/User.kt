package com.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    val followers: Int,
    val full_name: String?="",
    @PrimaryKey(autoGenerate = true)
    val dbKey : Int
)
