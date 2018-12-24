fun SoutherosCompat.kingdomsExistInSoutheros(kingdomNamesList: List<String>) =
        try {
            kingdomNamesList.all { kingdomName ->
                val kingdom = getKingdomByName(kingdomName)
                kingdomsList.contains(kingdom)
            }
        } catch (exception: KingdomNotFoundException) {
            false
        }

fun SoutherosCompat.printRulerDetails() {
    val rulerKingdom = getRulerKingdom()

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