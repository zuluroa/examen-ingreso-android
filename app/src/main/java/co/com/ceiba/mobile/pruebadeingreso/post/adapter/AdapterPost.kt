package co.com.ceiba.mobile.pruebadeingreso.post.adapter

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Filter
import android.widget.LinearLayout
import android.widget.TextView
import co.com.ceiba.mobile.pruebadeingreso.R
import co.com.ceiba.mobile.pruebadeingreso.post.model.User

class AdapterPost(private val listUser: ArrayList<User>, var ic: interfaceClick) : RecyclerView.Adapter<AdapterPost.ViewHolderPost>() {

    var listUserPost:ArrayList<User> = ArrayList()
    var listAuxListPost:ArrayList<User> = ArrayList()

    init {
        this.listUserPost.clear()
        this.listUserPost = listUser
        this.listAuxListPost.addAll(listUserPost)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderPost {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.user_list_item, null)
        return ViewHolderPost(v)
    }

    override fun onBindViewHolder(holder: ViewHolderPost, position: Int) {
        val (_, name, _, email, _, phone) = listUser[position]
        holder.name.text = name
        holder.phone.text = phone
        holder.email.text = email
        holder.btn_view_post.setOnClickListener {
            ic.onClick(listUser, position)
        }
    }

    fun filter(): Filter = object : Filter() {
        override fun performFiltering(charSequence: CharSequence): FilterResults {
            val filterList = ArrayList<User>()
            if (charSequence.toString().isEmpty()) {
                filterList.addAll(listAuxListPost)
                Log.e("","Vacio?-->"+listAuxListPost.toString())
            } else {
                for (user in listAuxListPost) {
                    if (user.name.toLowerCase().contains(charSequence.toString().toLowerCase())) {
                        filterList.add(user)
                    }
                }
            }
            val filterResults = FilterResults()
            filterResults.values = filterList
            return filterResults
        }

        override fun publishResults(charSequence: CharSequence, filterResults: FilterResults) {
            listUserPost.clear()
            listUserPost.addAll(filterResults.values as Collection<User>)//filterResults.values as Collection<User?>
            notifyDataSetChanged()
        }
    }


    fun getFilter(): Filter? {
        return filter()
    }

    override fun getItemCount(): Int {
        return listUser.size
    }

    interface interfaceClick {
        fun onClick(User: ArrayList<User>, position: Int)
    }

    inner class ViewHolderPost(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var contentCard: LinearLayout
        var name: TextView
        var phone: TextView
        var email: TextView
        var btn_view_post: Button

        init {
            contentCard = itemView.findViewById(R.id.contentCard)
            name = itemView.findViewById(R.id.name)
            phone = itemView.findViewById(R.id.phone)
            email = itemView.findViewById(R.id.email)
            btn_view_post = itemView.findViewById(R.id.btn_view_post)
        }
    }
}