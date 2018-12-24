class Kingdom(val name: String, val emblem: String, val rulerName: String = "") {

    var isCompetingToBeRuler = false
        set(value) {
            allies.clear()
            alligienceTo = null
            field = value
        }

    val allies = ArrayList<Kingdom>()
    var alligienceTo: Kingdom? = null

    fun sendMessage(message: Message) {
        message.receiver.receiveMessage(message)
    }

    fun sendMessageAsVote(ballot: IBallot, receiverKingdom: Kingdom) {
        val randomMessage = MessagesTable().getRandomMessage()
        ballot.addMessageAsVote(Message(this, receiverKingdom, randomMessage))
    }

    fun receiveMessage(message: Message) {
        if (AllyDecider().isAlly(MessageMatchingAlgo(message.message, emblem))) {
            if (alligienceTo == null && !isCompetingToBeRuler) {
                alligienceTo = message.sender
                message.sender.onAllegianceMadeBy(this)
            }
        }
    }

    private fun onAllegianceMadeBy(kingdom: Kingdom) {
        if (!allies.contains(kingdom)) {
            allies.add(kingdom)
        }
    }
}