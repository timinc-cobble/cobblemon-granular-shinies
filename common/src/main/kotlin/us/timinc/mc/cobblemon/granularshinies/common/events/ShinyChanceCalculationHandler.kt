package us.timinc.mc.cobblemon.granularshinies.common.events

import com.cobblemon.mod.common.api.events.pokemon.ShinyChanceCalculationEvent
import com.cobblemon.mod.common.api.pokemon.PokemonProperties
import us.timinc.mc.cobblemon.granularshinies.common.GranularShinies.config
import us.timinc.mc.cobblemon.granularshinies.common.GranularShinies.debug

object ShinyChanceCalculationHandler {
    fun handle(event: ShinyChanceCalculationEvent) {
        event.addModificationFunction { chance, _, pokemon ->
            val found = with(config.overrides.entries) {
                this.find { PokemonProperties.parse(it.key).matches(pokemon) } ?: return@addModificationFunction chance
            }

            debug("Found matching shiny override of \"${found.key}\":${found.value} for ${pokemon.form.name} ${pokemon.species.name}")
            return@addModificationFunction found.value
        }
    }
}
