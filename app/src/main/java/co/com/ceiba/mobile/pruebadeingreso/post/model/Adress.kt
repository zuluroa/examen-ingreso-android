package co.com.ceiba.mobile.pruebadeingreso.post.model

class Adress {
    var street: String? = null
    var suite: String? = null
    var city: String? = null
    var zipcode: String? = null
    var geo: Geo? = null

    override fun toString(): String {
        return "Adress{" +
                "street='" + street + '\'' +
                ", suite='" + suite + '\'' +
                ", city='" + city + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", geo=" + geo +
                '}'
    }
}