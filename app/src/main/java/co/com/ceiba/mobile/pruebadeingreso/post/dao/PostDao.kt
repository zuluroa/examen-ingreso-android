package co.com.ceiba.mobile.pruebadeingreso.post.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import co.com.ceiba.mobile.pruebadeingreso.post.model.User

@Dao
interface PostDao {

    @Query("SELECT * FROM User")
    suspend fun getAll(): List<User>

}