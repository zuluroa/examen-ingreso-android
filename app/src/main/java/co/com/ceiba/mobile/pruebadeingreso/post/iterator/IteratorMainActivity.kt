package co.com.ceiba.mobile.pruebadeingreso.post.iterator

import android.content.Context
import android.util.Log
import co.com.ceiba.mobile.pruebadeingreso.post.model.User
import co.com.ceiba.mobile.pruebadeingreso.post.presenter.PresenterMainActivity
import co.com.ceiba.mobile.pruebadeingreso.rest.Endpoints
import co.com.ceiba.mobile.pruebadeingreso.rest.IRestUser
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class IteratorMainActivity : IIteratorMainActivity {

    var context:Context ?=null
    var presenter:PresenterMainActivity? = null

    constructor(context: Context?, presenter: PresenterMainActivity?) {
        this.context = context
        this.presenter = presenter
    }

    private fun getRetrofit():Retrofit{
        return Retrofit.Builder()
                .baseUrl(Endpoints.URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    override fun getUser() {
            val restService = getRetrofit().create(IRestUser::class.java)
            val result: Call<List<User>> = restService.getAll()

            result.enqueue(object: Callback<List<User>>{
                override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                    Log.e("","TENGO LOS DATOS")
                }

                override fun onFailure(call: Call<List<User>>, t: Throwable) {
                    Log.e("","ERROR AL CONSUMIR")
                }

            })

    }

}