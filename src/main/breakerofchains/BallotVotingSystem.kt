package breakerofchains

import common.Southeros
import kingdomsExistInSoutheros
import Kingdom
import getKingdomsFromListOfKingdomNames

class BallotVotingSystem(val southeros: Southeros, val heighPriest: HighPriest, val ballot: Ballot) {

    fun getCompetingKingdomsList(): ArrayList<Kingdom> {
        var competingKingdomNamesList: List<String>
        do {
            println("Enter the kingdoms competing to be the ruler:")
            val inputLine = readLine()
            competingKingdomNamesList = inputLine!!.split(" ")

            val invalidNumberOfKingdoms = (competingKingdomNamesList.size == 1 || competingKingdomNamesList.size == 6)

        } while (!southeros.kingdomsExistInSoutheros(competingKingdomNamesList) || invalidNumberOfKingdoms)
        return southeros.getKingdomsFromListOfKingdomNames(competingKingdomNamesList)
    }

    fun allCompetingKingdomsVote(listOfCompetingKingdoms: ArrayList<Kingdom>) {
        listOfCompetingKingdoms.forEach { competingKingdom ->
            southeros.kingdomsList.forEach { recieverKingdom ->
                if (competingKingdom != recieverKingdom) {
                    competingKingdom.sendMessageAsVote(ballot, recieverKingdom)
                }
            }
        }
    }

    fun getKingdomsForNextRound(listOfCompetingKingdoms: ArrayList<Kingdom>) {
        val listOfKingdomsHavingMaxAllies = southeros.kingdomsList.getKingdomsHavingMaximumAllies()
        if (listOfKingdomsHavingMaxAllies[0].allies.size != 0) {
            listOfCompetingKingdoms.clear()
            listOfCompetingKingdoms.addAll(listOfKingdomsHavingMaxAllies)
        }
    }

}