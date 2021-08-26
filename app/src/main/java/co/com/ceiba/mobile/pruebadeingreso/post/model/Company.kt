package co.com.ceiba.mobile.pruebadeingreso.post.model

class Company {
    var name: String? = null
    var catchPhrase: String? = null
    var bs: String? = null
    override fun toString(): String {
        return "Company{" +
                "name='" + name + '\'' +
                ", catchPhrase='" + catchPhrase + '\'' +
                ", bs='" + bs + '\'' +
                '}'
    }
}