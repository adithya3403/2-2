open class Employee(
    open var name: String,
    open val age: Int,
    open var experience: Double) {
    open fun display() {
        println("name : $name\tage : $age\texperience : $experience")
    }
}

class fullTimeEmployee(
    override var name: String,
    override val age: Int,
    override var experience: Double,    
    var salary: Int
) : Employee(name, age, experience) {
    override fun display() {
        println("name : $name\tage : $age\texperience : $experience\tsalary : $salary")
    }
}

class partTimeEmployee(
    override var name: String,
    override val age: Int,
    override var experience: Double,
    var wagePerDay: Int
) : Employee(name, age, experience) {
    override fun display() {
        println("name : $name\tage : $age\texperience : $experience\tsalary : $wagePerDay")
    }

    fun calculateSalary() {
        print("Enter number of days worked : ")
        var days = readLine()!!.toInt()
        println("Total salary earned : ${wagePerDay * days}")
    }
}

fun main() {
    var fE = fullTimeEmployee("Kiran", 25, 4.5, 20000)
    var pE = partTimeEmployee("Sri", 26, 5.5, 200)
    fE.display()
    fE.experience = 6.7
    fE.display()
    pE.display()
    pE.name = "John"
    pE.display()
    pE.calculateSalary()
}
