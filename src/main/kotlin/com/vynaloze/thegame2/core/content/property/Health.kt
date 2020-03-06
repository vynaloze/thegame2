package com.vynaloze.thegame2.core.content.property


data class Health(private var value: Int) {
    fun increase(health: Health) {
        this.value += health.value
    }

    fun decrease(health: Health) {
        this.value -= health.value
    }

    fun isDepleted(): Boolean {
        return this.value <= 0
    }

    override fun toString(): String {
        return this.value.toString()
    }
}
