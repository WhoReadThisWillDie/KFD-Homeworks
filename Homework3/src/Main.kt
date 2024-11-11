import java.util.*
import kotlin.reflect.KClass
import kotlin.reflect.full.primaryConstructor

fun main() {
    val testClass = createRandomInstance(TestClass::class)
    println(testClass)
}

fun <T : Any> createRandomInstance(clazz: KClass<T>) : T {
    val args = clazz.primaryConstructor!!.parameters.associateWith {
        when (it.type.classifier as KClass<*>) {
            Int::class -> Random().nextInt()
            Double::class -> Random().nextDouble()
            Boolean::class -> Random().nextBoolean()
            String::class -> (1..10).map {Random().nextInt(65, 91).toChar()}.joinToString("")
            else -> null
        }
    }

    return clazz.primaryConstructor!!.callBy(args)
}

data class TestClass(val b: Boolean, val i: Int, val d: Double, val s: String, val any: Any?) {}
