package breakerofchains

import common.Message

interface IBallot {
    fun addMessageAsVote(message: Message)
}