package co.com.ceiba.mobile.pruebadeingreso.post.presenter

import co.com.ceiba.mobile.pruebadeingreso.post.model.User

interface IPresenterMainActivity {
    fun showDialog(tittle: String, message: String)
    fun cancelDialog()
    fun setUser(listUser: ArrayList<User>)
}