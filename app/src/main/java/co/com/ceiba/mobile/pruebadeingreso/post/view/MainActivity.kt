package co.com.ceiba.mobile.pruebadeingreso.post.view

import android.app.Activity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.widget.EditText
import co.com.ceiba.mobile.pruebadeingreso.R
import co.com.ceiba.mobile.pruebadeingreso.post.model.User
import co.com.ceiba.mobile.pruebadeingreso.post.presenter.PresenterMainActivity

class MainActivity : Activity(), IMainActivity {

    var recyclerViewSearchResults:RecyclerView ? = null
    var editTextSearch:EditText ?= null
    var  presenter = PresenterMainActivity(this, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerViewSearchResults = findViewById(R.id.recyclerViewSearchResults)
        editTextSearch = findViewById<EditText>(R.id.editTextSearch)
    }

    override fun onStart() {
        super.onStart()
        getUser()
    }

    override fun showDialog(tittle: String, message: String) {

    }

    override fun cancelDialog() {

    }

    override fun getUser() {
        presenter.getUser()
    }

    override fun setUser(listUser: ArrayList<User>) {
        TODO("Not yet implemented")
    }
}