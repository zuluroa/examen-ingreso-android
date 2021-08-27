package co.com.ceiba.mobile.pruebadeingreso.post.model

import co.com.ceiba.mobile.pruebadeingreso.post.model.Adress
import co.com.ceiba.mobile.pruebadeingreso.post.model.Company

class User {
    private val id = 0
    private val name: String? = null
    private val username: String? = null
    private val email: String? = null
    private val address: Adress? = null
    private val phone: String? = null
    private val website: String? = null
    private val company: Company? = null
    override fun toString(): String {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", address=" + address +
                ", phone='" + phone + '\'' +
                ", website='" + website + '\'' +
                ", company=" + company +
                '}'
    }
}