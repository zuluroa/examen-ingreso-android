package co.com.ceiba.mobile.pruebadeingreso.post.presenter

import android.content.Context
import co.com.ceiba.mobile.pruebadeingreso.post.iterator.IIteratorMainActivity
import co.com.ceiba.mobile.pruebadeingreso.post.iterator.IteratorMainActivity
import co.com.ceiba.mobile.pruebadeingreso.post.model.User
import co.com.ceiba.mobile.pruebadeingreso.post.view.IMainActivity
import java.util.*

class PresenterMainActivity : IPresenterMainActivity {

    var view: IMainActivity? = null
    var context: Context? = null
    var iterator: IIteratorMainActivity? = null

    constructor(view: IMainActivity?, context: Context?) {
        this.view = view
        this.context = context
        this.iterator = IteratorMainActivity(context,this)
    }


    override fun getUser() {
        iterator?.getUser()
    }
    override fun cancelDialog() {

    }
    override fun setUser(listUser: ArrayList<User>) {
        view?.setUser(listUser)
    }
}