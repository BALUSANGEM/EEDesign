class FirstProblemRulerDecider : RulerSelectorStrategy {
    override fun getRulerKingdom(kingdomsList: List<Kingdom>): Kingdom? {
        kingdomsList.forEach { kingdom ->
            if (kingdom.allies.size >= 3) {
                return kingdom
            }
        }
        return null
    }

}