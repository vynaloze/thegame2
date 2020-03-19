package com.vynaloze.thegame2.core.engine


class EngineProvider(val combatEngine: CombatEngine,
                     val creationEngine: CreationEngine,
                     val damageEngine: DamageEngine,
                     val moveEngine: MoveEngine,
                     val sorceryEngine: SorceryEngine
)