package breakerofchains

import common.Message

class Ballot : IBallot {

    val messages = ArrayList<Message>()
    override fun addMessageAsVote(message: Message) {
        messages.add(message)
    }

}