package common

import Kingdom

interface RulerSelectorStrategy {
    fun getRulerKingdom(kingdomsList: List<Kingdom>): Kingdom?
}