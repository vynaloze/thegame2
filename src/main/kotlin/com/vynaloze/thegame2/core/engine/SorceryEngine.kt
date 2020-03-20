package com.vynaloze.thegame2.core.engine

import com.vynaloze.thegame2.core.board.Node
import com.vynaloze.thegame2.core.content.Thing
import com.vynaloze.thegame2.core.content.property.Spell
import com.vynaloze.thegame2.core.content.trait.active.Sorcerous
import com.vynaloze.thegame2.core.engine.exception.OutOfManaException
import com.vynaloze.thegame2.core.engine.exception.SpellTargetOutOfRangeException
import com.vynaloze.thegame2.core.linker.Linker


class SorceryEngine(linker: Linker) : Engine(linker) {
    fun <T> invoke(source: T, spell: Spell, target: Node) where T : Thing, T : Sorcerous {
        this.validateManaAmount(source, spell)
        val position = this.linker.findPositionOf(source)
        // todo remember to include blocking in range eval
        val range = spell.effectArea.evaluate(position.node, position.rotation)
        if (target !in range) {
            throw SpellTargetOutOfRangeException("target node $target is out of spell range of thing $this ($range)")
        }
        spell.effect.invoke(target)
    }

    private fun validateManaAmount(thing: Thing, spell: Spell) {
        val ownerMana = thing.owner.manaPoints.value
        val spellCost = spell.cost.value
        if (ownerMana < spellCost) {
            throw OutOfManaException("$thing cannot invoke $spell (needs $spellCost but ${thing.owner} has only $ownerMana)")
        }
    }
}