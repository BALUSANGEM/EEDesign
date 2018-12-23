class Southeros {
    val kingdomsList by lazy {
        listOf(
                Kingdom("Space", "Gorilla", "Shan"),
                Kingdom("Land", "Panda"),
                Kingdom("Water", "Octopus"),
                Kingdom("Air", "Owl"),
                Kingdom("Ice", "Mammoth"),
                Kingdom("Fire", "Dragon")
        )
    }

    fun getKingdomByName(name: String) =
            kingdomsList.first { kingdom ->
                kingdom.name == name
            }

    fun getKingdomByRulerName(rulerName: String) =
            kingdomsList.first { kingdom ->
                kingdom.rulerName == rulerName
            }

    fun getRulerKingdom(): Kingdom? {
        kingdomsList.forEach { kingdom ->
            if (kingdom.allies.size >= 3) {
                return kingdom
            }
        }
        return null
    }

    fun hasRuler() = getRulerKingdom() != null
}