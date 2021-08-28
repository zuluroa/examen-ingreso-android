package co.com.ceiba.mobile.pruebadeingreso.post.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import co.com.ceiba.mobile.pruebadeingreso.post.model.User

@Dao
interface PostDao {

    @Query("SELECT * FROM User")
    fun getAll(): ArrayList<User>

    @Query("SELECT * FROM User WHERE id = :userId")
    fun getId(userId: Int): User

    @Insert
    fun insetPost(user: User)

}