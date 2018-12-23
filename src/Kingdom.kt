class Kingdom(val name: String, val emblem: String, val rulerName: String = "") {

    val allies = ArrayList<Kingdom>()
    var alligienceTo: Kingdom? = null

    fun sendMessage(message: Message) {
        message.receiver.receiveMessage(message)
    }

    private fun receiveMessage(message: Message) {
        if (MessageMatchingAlgo().isMessageMatchingWithEmblem(message.message, emblem)) {
            alligienceTo = message.sender
            message.sender.onAllegianceMadeBy(this)
        }
    }

    private fun onAllegianceMadeBy(kingdom: Kingdom) {
        if (!allies.contains(kingdom)) {
            allies.add(kingdom)
        }
    }
}