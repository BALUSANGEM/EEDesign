package secondproblem

import Kingdom

fun List<Kingdom>.getKingdomsHavingMaximumAllies(): List<Kingdom> {
    val listOfKingdomsWithMaxAllies = ArrayList<Kingdom>()
    var maxAllies = 0
    forEach { kingdom ->
        if (maxAllies == kingdom.allies.size) {
            listOfKingdomsWithMaxAllies.add(kingdom)
        } else if (maxAllies < kingdom.allies.size) {
            maxAllies = kingdom.allies.size
            listOfKingdomsWithMaxAllies.clear()
            listOfKingdomsWithMaxAllies.add(kingdom)
        }
    }
    return listOfKingdomsWithMaxAllies
}