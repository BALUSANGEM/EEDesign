package goldencrown

import Kingdom
import common.RulerSelectionStrategy

class GoldenCrownRulerDecidingAlgo : RulerSelectionStrategy {
    override fun getRulerKingdom(kingdomsList: List<Kingdom>): Kingdom? {
        kingdomsList.forEach { kingdom ->
            if (kingdom.allies.size >= 3) {
                return kingdom
            }
        }
        return null
    }

}