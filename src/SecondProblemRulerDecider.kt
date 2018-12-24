class SecondProblemRulerDecider : RulerSelectorStrategy {
    override fun getRulerKingdom(kingdomsList: List<Kingdom>): Kingdom? {
        val listOfKingdomsWithMaxAllies = kingdomsList.getKingdomsHavingMaximumAllies()
        return if (listOfKingdomsWithMaxAllies.size == 1) {
            listOfKingdomsWithMaxAllies[0]
        } else {
            null
        }
    }

}