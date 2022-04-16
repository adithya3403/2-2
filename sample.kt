open class Employee(
    open var name : String,
    open val age : Int,
    open var experience : Double) {
        open fun display() {
            println("name : $name\tage : $age\texperience : $experience")
        }
}
class fullTimeEmployee(
    override var name : String,
    override val age : Int,
    override var experience : Double,
    var salary : Int) : Employee(name, age, experience) {
        override fun display() {
            println("name : $name\tage : $age\texperience : $experience\tsalary : $salary")
        }
}
class partTimeEmployee(
    override var name : String, 
    override val age : Int, 
    override var experience : Double, 
    var wagePerDay : Int) : Employee(name, age, experience) {
        override fun display() {
            println("name : $name\tage : $age\texperience : $experience\tsalary : $wagePerDay")
        }
        fun calcSalary() {
            print("Enter number of days worked : ")
            var days = readLine()!!.toInt()
            println("Salary : ${wagePerDay * days}")
        }
}