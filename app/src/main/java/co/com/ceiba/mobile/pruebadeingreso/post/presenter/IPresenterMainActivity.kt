package co.com.ceiba.mobile.pruebadeingreso.post.presenter

import co.com.ceiba.mobile.pruebadeingreso.post.model.User

interface IPresenterMainActivity {
    fun getUser()
    fun cancelDialog()
    fun setUser(listUser: ArrayList<User>)
}