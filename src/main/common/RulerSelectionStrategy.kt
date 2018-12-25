package common

import Kingdom

interface RulerSelectionStrategy {
    fun getRulerKingdom(kingdomsList: List<Kingdom>): Kingdom?
}