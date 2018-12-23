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
        } catch (exception: NoSuchElementException) {
            println("${exception.message}")
        }

        if (southeros.hasRuler()) {
            printRulerDetailsOf(southeros)
            break@loop
        }

    }
}

private fun printRulerDetailsOf(southeros: Southeros) {
    val rulerKingdom = southeros.getRulerKingdom()

    println("Who is the ruler of Southeros?")
    println(rulerKingdom?.rulerName ?: "None")

    println("Allies of Ruler?")
    if (rulerKingdom != null) {
        rulerKingdom.allies.forEach { print(it.name + " ") }
    } else {
        println("None")
    }
}