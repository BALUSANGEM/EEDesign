package goldencrown

import common.KingdomNotFoundException
import common.Message
import common.Southeros

class SelectSoutherosRulerWithGoldenCrown {
    fun select() {
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

            if (southeros.hasRuler(GoldenCrownRulerDecidingAlgo())) {
                printRulerDetailsOf(southeros)
                break@loop
            }

        }
    }

    private fun printRulerDetailsOf(southeros: Southeros) {
        val rulerKingdom = southeros.getRulerKingdom(GoldenCrownRulerDecidingAlgo())

        println("Who is the ruler of Southeros?")
        println(rulerKingdom?.rulerName ?: "None")

        println("Allies of Ruler?")
        if (rulerKingdom != null) {
            rulerKingdom.allies.forEach { print(it.name + ",") }
        } else {
            println("None")
        }
    }
}