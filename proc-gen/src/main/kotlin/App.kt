
class App {
	fun sayHello(name : String) : String  {
		return "Hello $name"
	}
}

fun main(args : Array<String>) : Unit {
    println(App().sayHello("Matt"));
}
