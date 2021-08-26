package co.com.ceiba.mobile.pruebadeingreso.post.view

import co.com.ceiba.mobile.pruebadeingreso.post.model.User

interface IMainActivity {
    fun showDialog(tittle: String, message: String)
    fun cancelDialog()
    fun getUser()
    fun setUser(listUser: ArrayList<User>)
}