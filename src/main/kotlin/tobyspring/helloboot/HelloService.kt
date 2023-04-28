package tobyspring.helloboot

fun interface HelloService {

    fun sayHello(name: String): String

    fun countOf(name: String): Int {
        return 0
    }
}
