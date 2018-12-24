package common

import Kingdom

open class Southeros {
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
            try {
                kingdomsList.first { kingdom ->
                    kingdom.name.toLowerCase() == name.toLowerCase()
                }
            } catch (exception: NoSuchElementException) {
                throw KingdomNotFoundException("No kingdom with name:$name")
            }

    fun getKingdomByRulerName(rulerName: String) =
            try {
                kingdomsList.first { kingdom ->
                    kingdom.rulerName.toLowerCase() == rulerName.toLowerCase()
                }
            } catch (exception: NoSuchElementException) {
                throw KingdomNotFoundException("No kingdom has rulerName:$rulerName")
            }

    fun getRulerKingdom(rulerSelectorStrategy: RulerSelectorStrategy): Kingdom? =
            rulerSelectorStrategy.getRulerKingdom(kingdomsList)

    fun hasRuler(rulerSelectorStrategy: RulerSelectorStrategy) = getRulerKingdom(rulerSelectorStrategy) != null
}