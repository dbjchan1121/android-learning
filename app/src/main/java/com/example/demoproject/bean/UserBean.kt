package com.example.demoproject.bean


enum class Status(val value: Int) {
    INACTIVE(0),
    ACTIVE(1);

    companion object {
        fun fromValue(value: Int): Status {
            return values().find { it.value == value }
                ?: throw IllegalArgumentException("Unknown status value: $value")
        }
    }
}

data class UserBean(
    var avatar: String = "",
    var name: String = "",
    var id: String = "",
    var status: Status = Status.INACTIVE
)
