package com.vynaloze.thegame2.core.engine

import com.vynaloze.thegame2.core.board.Node
import com.vynaloze.thegame2.core.content.Thing
import com.vynaloze.thegame2.core.content.property.Spell
import com.vynaloze.thegame2.core.content.trait.active.Sorcerous
import com.vynaloze.thegame2.core.linker.Linker


class SorceryEngine(linker: Linker) : Engine(linker) {
    fun <T> invoke(source: T, spell: Spell) where T : Thing, T : Sorcerous {
        TODO("Not yet implemented")
    }

    fun <T> invoke(source: T, spell: Spell, vararg target: Node) where T : Thing, T : Sorcerous {
        TODO("Not yet implemented")
    }

    fun <T> invoke(source: T, spell: Spell, vararg target: Thing) where T : Thing, T : Sorcerous {
        TODO("Not yet implemented")
    }
}