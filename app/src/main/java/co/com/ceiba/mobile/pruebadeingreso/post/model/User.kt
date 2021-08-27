package co.com.ceiba.mobile.pruebadeingreso.post.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import co.com.ceiba.mobile.pruebadeingreso.post.model.Adress
import co.com.ceiba.mobile.pruebadeingreso.post.model.Company

@Entity
data class User (
        @PrimaryKey(autoGenerate = false)
        @ColumnInfo(name = "id") val id :Int,
        @ColumnInfo(name = "name") val name: String,
        @ColumnInfo(name = "username") val username: String,
        @ColumnInfo(name = "email") val email: String,
        @ColumnInfo(name = "address") val address: Adress,
        @ColumnInfo(name = "phone") val phone: String,
        @ColumnInfo(name = "website") val website: String,
        @ColumnInfo(name = "company") val company: Company
)
