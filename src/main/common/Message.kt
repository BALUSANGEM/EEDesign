package common

import Kingdom

data class Message(val sender: Kingdom, val receiver: Kingdom, val message: String)