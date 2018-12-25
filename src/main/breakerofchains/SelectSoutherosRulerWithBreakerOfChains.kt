package breakerofchains

import common.Southeros
import Kingdom
import printRulerDetails
import setKingdomsIfParticipatingInCompetitionOrNot

class SelectSoutherosRulerWithBreakerOfChains {

    fun select() {
        val southeros = Southeros()
        val heightPriest = HighPriest()

        southeros.printRulerDetails()

        val ballot = Ballot()

        val ballotSystemVoting = BallotVotingSystem(southeros, heightPriest, ballot)
        val listOfCompetingKingdoms = ballotSystemVoting.getCompetingKingdomsList()

        var ballotCount = 0

        loop@ while (true) {

            ballotCount++

            southeros.setKingdomsIfParticipatingInCompetitionOrNot(listOfCompetingKingdoms)

            ballotSystemVoting.allCompetingKingdomsVote(listOfCompetingKingdoms)

            heightPriest.pickMessagesFromBallet(ballot)
            heightPriest.sendMessagesToPickedKingdoms()

            println("Results after round $ballotCount ballot count")
            listOfCompetingKingdoms.forEach { kingdom ->
                printAlliesSizeOfCompetingKingdoms(kingdom)
            }

            if (southeros.hasRuler(BreakerOfChainsRulerDecidingAlgo())) {
                southeros.printRulerDetails()
                break@loop
            } else {
                ballotSystemVoting.getKingdomsForNextRound(listOfCompetingKingdoms)
            }
        }
    }

    private fun printAlliesSizeOfCompetingKingdoms(kingdom: Kingdom) {
        println("Allies for ${kingdom.name} : ${kingdom.allies.size}")
    }
}