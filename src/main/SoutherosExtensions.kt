import common.KingdomNotFoundException
import common.Southeros
import breakerofchains.BreakerOfChainsRulerDecidingAlgo

fun Southeros.kingdomsExistInSoutheros(kingdomNamesList: List<String>) =
        try {
            if (kingdomNamesList.isEmpty()) {
                false
            } else {
                kingdomNamesList.all { kingdomName ->
                    val kingdom = getKingdomByName(kingdomName)
                    kingdomsList.contains(kingdom)
                }
            }
        } catch (exception: KingdomNotFoundException) {
            false
        }

fun Southeros.printRulerDetails() {
    val rulerKingdom = getRulerKingdom(BreakerOfChainsRulerDecidingAlgo())

    println("Who is the ruler of Southeros?")
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

fun Southeros.getKingdomsFromListOfKingdomNames(kingdomsNamesList: List<String>): ArrayList<Kingdom> {
    val kingdomsList = ArrayList<Kingdom>()
    kingdomsNamesList.forEach { kingdomName ->
        kingdomsList.add(getKingdomByName(kingdomName))
    }
    return kingdomsList;
}

fun Southeros.setKingdomsIfParticipatingInCompetitionOrNot(listOfCompetingKingdoms: ArrayList<Kingdom>) {
    kingdomsList.forEach { kingdom ->
        kingdom.isCompetingToBeRuler = listOfCompetingKingdoms.contains(kingdom)
    }
}