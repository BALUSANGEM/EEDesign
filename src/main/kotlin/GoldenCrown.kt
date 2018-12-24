import common.KingdomNotFoundException
import common.Message
import common.Southeros
import firstproblem.FirstProblemRulerDecider

fun main(args: Array<String>) {
    val southeros = Southeros()

    printRulerDetailsOf(southeros)
    loop@ while (true) {

        val inputLine = readLine()

        try {
            val (kingdomName, message) = inputLine!!.split(",")
            val shanKingdom = southeros.getKingdomByRulerName("Shan")
            val receiverKingdom = southeros.getKingdomByName(kingdomName)
            shanKingdom.sendMessage(Message(shanKingdom, receiverKingdom, message))

        } catch (exception: IndexOutOfBoundsException) {
            println("Please enter input properly suggested format:kingdomName,encrypted message")
            continue@loop

        } catch (exception: KingdomNotFoundException) {
            println("${exception.message}")
            continue@loop
        }

        if (southeros.hasRuler(FirstProblemRulerDecider())) {
            printRulerDetailsOf(southeros)
            break@loop
        }

    }
}

private fun printRulerDetailsOf(southeros: Southeros) {
    val rulerKingdom = southeros.getRulerKingdom(FirstProblemRulerDecider())

    println("Who is the ruler of common.Southeros?")
    println(rulerKingdom?.rulerName ?: "None")

    println("Allies of Ruler?")
    if (rulerKingdom != null) {
        rulerKingdom.allies.forEach { print(it.name + ",") }
    } else {
        println("None")
    }
}