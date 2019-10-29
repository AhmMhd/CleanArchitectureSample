package com.cleansample.di

import android.content.Context
import androidx.room.Room
import com.cleansample.R
import com.data.db.MyDatabase
import dagger.Module
import dagger.Provides

@Module
object RoomModule {

    @Synchronized
    @JvmStatic
    @Provides
    fun providesDatabase(context: Context): MyDatabase =
        Room.databaseBuilder(
            context,
            MyDatabase::class.java,
            context.getString(R.string.db_name)
        ).build()

}