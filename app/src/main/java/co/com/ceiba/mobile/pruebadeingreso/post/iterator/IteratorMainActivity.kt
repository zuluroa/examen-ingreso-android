package co.com.ceiba.mobile.pruebadeingreso.post.iterator

import android.content.Context
import co.com.ceiba.mobile.pruebadeingreso.post.presenter.PresenterMainActivity

class IteratorMainActivity : IIteratorMainActivity {

    var context:Context ?=null
    var presenter:PresenterMainActivity? = null

    constructor(context: Context?, presenter: PresenterMainActivity?) {
        this.context = context
        this.presenter = presenter
    }

    override fun getUser() {
        TODO("Not yet implemented")
    }

}