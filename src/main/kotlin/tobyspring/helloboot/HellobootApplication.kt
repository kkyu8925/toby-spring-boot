package tobyspring.helloboot

import org.springframework.boot.runApplication
import tobyspring.config.MySpringBootApplication

@MySpringBootApplication
class HellobootApplication {

//    @Bean
//    fun applicationRunner(env: Environment): ApplicationRunner {
//        return ApplicationRunner {
//            val name = env.getProperty("my.name")
//            println(name)
//        }
//    }
}

fun main(args: Array<String>) {
    runApplication<HellobootApplication>(*args)
}
