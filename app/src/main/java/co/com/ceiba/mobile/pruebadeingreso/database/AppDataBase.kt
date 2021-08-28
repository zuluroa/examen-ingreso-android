package co.com.ceiba.mobile.pruebadeingreso.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.content.Context
import co.com.ceiba.mobile.pruebadeingreso.post.dao.PostDao
import co.com.ceiba.mobile.pruebadeingreso.post.model.User

@Database(entities = [User::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDataBase : RoomDatabase() {
    abstract fun postUser(): PostDao
    var INSTANCE: AppDataBase? = null
    fun getInstance(context: Context?): AppDataBase? {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context!!, AppDataBase::class.java, "pruebaingreso")
                    .build()
        }
        return INSTANCE
    }
}