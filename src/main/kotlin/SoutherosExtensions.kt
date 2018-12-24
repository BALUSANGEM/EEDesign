package secondproblem

import common.KingdomNotFoundException
import common.Southeros

fun Southeros.kingdomsExistInSoutheros(kingdomNamesList: List<String>) =
        try {
            kingdomNamesList.all { kingdomName ->
                val kingdom = getKingdomByName(kingdomName)
                kingdomsList.contains(kingdom)
            }
        } catch (exception: KingdomNotFoundException) {
            false
        }

fun Southeros.printRulerDetails() {
    val rulerKingdom = getRulerKingdom(SecondProblemRulerDecider())

    println("Who is the ruler of common.Southeros?")
    println(rulerKingdom?.name ?: "None")
    println("Allies of Ruler?")
    if (rulerKingdom == null) {
        println("None")
    } else {
        rulerKingdom.allies.forEach { ally ->
            print(ally.name + " ")
        }
    }
}