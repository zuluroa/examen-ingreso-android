package co.com.ceiba.mobile.pruebadeingreso.post.iterator

import android.content.Context
import android.util.Log
import co.com.ceiba.mobile.pruebadeingreso.database.AppDataBase
import co.com.ceiba.mobile.pruebadeingreso.post.dao.PostDao
import co.com.ceiba.mobile.pruebadeingreso.post.model.User
import co.com.ceiba.mobile.pruebadeingreso.post.presenter.PresenterMainActivity
import co.com.ceiba.mobile.pruebadeingreso.rest.Endpoints
import co.com.ceiba.mobile.pruebadeingreso.rest.IRestUser
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import kotlin.collections.ArrayList

class IteratorMainActivity : IIteratorMainActivity {

    var context: Context? = null
    var presenter: PresenterMainActivity? = null
    var postDao: PostDao? = null
    var db: AppDataBase? = null
    var user_Post:ArrayList<User> = ArrayList()

    constructor(context: Context?, presenter: PresenterMainActivity?) {
        this.context = context
        this.presenter = presenter
        this.postDao = db?.getInstance(context)?.postUser()
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(Endpoints.URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    override fun getUser() {
        user_Post = postDao?.getAll()!!
        if (user_Post.isEmpty()) {
            val restService = getRetrofit().create(IRestUser::class.java)
            val result: Call<List<User>> = restService.getAll()

            result.enqueue(object : Callback<List<User>> {
                override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
                    saveInDataBase(response.body() as ArrayList<User>)
                }

                override fun onFailure(call: Call<List<User>>, t: Throwable) {
                    Log.e("", "ERROR AL CONSUMIR")
                }

            })
        } else {
            presenter?.setUser(user_Post)
        }
    }

    fun saveInDataBase(listUserPost: ArrayList<User>) {
        for (User in listUserPost) {
            val user: User = postDao?.getId(User.id)!!
            if (user.name.equals("")) {
                postDao?.insetPost(user)
            }
        }
        user_Post = ArrayList(postDao?.getAll())
        presenter?.setUser(user_Post)
    }

}