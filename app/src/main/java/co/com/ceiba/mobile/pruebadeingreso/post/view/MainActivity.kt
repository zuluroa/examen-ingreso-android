package co.com.ceiba.mobile.pruebadeingreso.post.view

import android.app.Activity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText
import co.com.ceiba.mobile.pruebadeingreso.R
import co.com.ceiba.mobile.pruebadeingreso.post.adapter.AdapterPost
import co.com.ceiba.mobile.pruebadeingreso.post.model.User
import co.com.ceiba.mobile.pruebadeingreso.post.presenter.PresenterMainActivity

class MainActivity : Activity(), IMainActivity {

    private var recyclerViewSearchResults:RecyclerView ?= null
    private var presenter = PresenterMainActivity(this, this)
    private var editTextSearch:EditText ?=null
    private var adapterPost: AdapterPost? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerViewSearchResults = findViewById<RecyclerView>(R.id.recyclerViewSearchResults)
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
        editTextSearch?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                adapterPost?.getFilter()?.filter(p0.toString())
            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })
        recyclerViewSearchResults?.layoutManager = GridLayoutManager(this, 1)
        adapterPost = AdapterPost(listUser, object : AdapterPost.interfaceClick {
            override fun onClick(User: ArrayList<User>, position: Int) {
                var post_user: User = listUser.get(position)
                Log.e("", "Usuario selecionado main--->" + post_user.name)
            }
        })
        recyclerViewSearchResults?.adapter = adapterPost

    }
}