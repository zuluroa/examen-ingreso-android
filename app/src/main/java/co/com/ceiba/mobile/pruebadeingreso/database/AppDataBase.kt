package co.com.ceiba.mobile.pruebadeingreso.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import co.com.ceiba.mobile.pruebadeingreso.post.model.User

@Database(entities = [User::class], version = 1)
object AppDataBase : RoomDatabase() {
    var INSTANCE: AppDataBase? = null
    fun getInstance(context: Context?): AppDataBase? {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context!!, AppDataBase::class.java, "pruebaingreso.db")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
        }
        return INSTANCE
    }
}