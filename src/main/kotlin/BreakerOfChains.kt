fun main(args: Array<String>) {
    val southeros = Southeros()
    val heightPriest = HighPriest()

    southeros.printRulerDetails()

    var competingKingdomNamesList: List<String>
    do {
        println("Enter the kingdoms competing to be the ruler:")
        val inputLine = readLine()
        competingKingdomNamesList = inputLine!!.split(" ")

        val invalidNumberOfKingdoms = (competingKingdomNamesList.size == 1 || competingKingdomNamesList.size == 6)

    } while (!southeros.kingdomsExistInSoutheros(competingKingdomNamesList) || invalidNumberOfKingdoms)

    val listOfCompetingKingdoms = getKingdomsFromListOfKingdomNames(southeros, competingKingdomNamesList)

    var ballotCount = 0

    loop@ while (true) {

        val ballot = Ballot()
        ballotCount++

        setKingdomsIfParticipatingInCompetitionOrNot(listOfCompetingKingdoms, southeros)

        listOfCompetingKingdoms.forEach { competingKingdom ->

            southeros.kingdomsList.forEach { recieverKingdom ->
                if (competingKingdom != recieverKingdom) {
                    competingKingdom.sendMessageAsVote(ballot, recieverKingdom)
                }
            }

        }

        heightPriest.pickMessagesFromBallet(ballot)
        heightPriest.sendMessagesToPickedKingdoms()

        println("Results after round $ballotCount ballot count")
        listOfCompetingKingdoms.forEach { kingdom ->
            printAlliesSizeOfCompetingKingdoms(kingdom)
        }

        if (southeros.hasRuler(SecondProblemRulerDecider())) {
            southeros.printRulerDetails()
            break@loop
        } else {
            val listOfKingdomsHavingMaxAllies = southeros.kingdomsList.getKingdomsHavingMaximumAllies()
            if (listOfKingdomsHavingMaxAllies[0].allies.size != 0) {
                listOfCompetingKingdoms.clear()
                listOfCompetingKingdoms.addAll(listOfKingdomsHavingMaxAllies)
            }
        }

    }
}

fun setKingdomsIfParticipatingInCompetitionOrNot(listOfCompetingKingdoms: ArrayList<Kingdom>, southeros: Southeros) {
    southeros.kingdomsList.forEach { kingdom ->
        kingdom.isCompetingToBeRuler = listOfCompetingKingdoms.contains(kingdom)
    }
}

fun getKingdomsFromListOfKingdomNames(southeros: Southeros, kingdomsNamesList: List<String>): ArrayList<Kingdom> {
    val kingdomsList = ArrayList<Kingdom>();
    kingdomsNamesList.forEach { kingdomName ->
        kingdomsList.add(southeros.getKingdomByName(kingdomName))
    }
    return kingdomsList;
}

fun printAlliesSizeOfCompetingKingdoms(kingdom: Kingdom) {
    println("Allies for ${kingdom.name} : ${kingdom.allies.size}")
}


