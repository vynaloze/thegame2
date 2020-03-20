package com.vynaloze.thegame2.core.factory

import com.vynaloze.thegame2.core.content.Thing
import kotlin.reflect.KClass


interface ThingFactory {
    fun <T: Thing> create(thing:Thing, thingType: KClass<T>): T
}