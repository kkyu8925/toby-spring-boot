package tobyspring.config

import org.springframework.boot.context.annotation.ImportCandidates
import org.springframework.context.annotation.DeferredImportSelector
import org.springframework.core.type.AnnotationMetadata
import java.util.function.Consumer

class MyAutoConfigImportSelector(
    private val classLoader: ClassLoader
) : DeferredImportSelector {

    override fun selectImports(importingClassMetadata: AnnotationMetadata): Array<String> {
        val autoConfigs: MutableList<String> = ArrayList()
        ImportCandidates.load(MyAutoConfiguration::class.java, classLoader).forEach(Consumer { autoConfigs.add(it) })
        return autoConfigs.toTypedArray<String>()
    }
}
