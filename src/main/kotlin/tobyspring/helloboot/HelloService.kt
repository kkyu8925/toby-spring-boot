package tobyspring.helloboot

interface HelloService {
    fun sayHello(name: String): String

    fun countOf(name: String): Int
}
