package co.com.ceiba.mobile.pruebadeingreso.database

import androidx.room.TypeConverter
import co.com.ceiba.mobile.pruebadeingreso.post.model.Adress
import co.com.ceiba.mobile.pruebadeingreso.post.model.Company
import com.google.gson.Gson

class Converters {
    @TypeConverter
    fun ToAdrees(modelo: Adress): String {
        return Gson().toJson(modelo)
    }

    @TypeConverter
    fun fromAdrees(modelo: String): Adress {
        return Gson().fromJson(modelo, Adress::class.java)
    }

    @TypeConverter
    fun Tocompany(company: Company): String {
        return Gson().toJson(company)
    }

    @TypeConverter
    fun fromcompany(company: String): Company {
        return Gson().fromJson(company, Company::class.java)
    }
}