package us.timinc.mc.cobblemon.granularshinies.common

import com.cobblemon.mod.common.api.Priority
import com.cobblemon.mod.common.api.events.CobblemonEvents
import com.cobblemon.mod.common.api.pokemon.PokemonProperties
import us.timinc.mc.cobblemon.granularshinies.common.events.ShinyChanceCalculationHandler
import us.timinc.mc.cobblemon.granularshinies.common.extensions.isInvalid
import us.timinc.mc.cobblemon.timcore.AbstractConfig
import us.timinc.mc.cobblemon.timcore.AbstractMod

const val MOD_ID = "cobblemon_granularshinies"

object GranularShinies : AbstractMod<GranularShinies.Config>(MOD_ID, Config::class.java) {
    class Config : AbstractConfig() {
        val overrides: Map<String, Float> = mutableMapOf()
    }

    init {
        validateConfig()
        CobblemonEvents.SHINY_CHANCE_CALCULATION.subscribe(Priority.HIGHEST, ShinyChanceCalculationHandler::handle)
    }

    private fun validateConfig() {
        CobblemonEvents.DATA_SYNCHRONIZED.subscribe {
            config.overrides.forEach { (properties) ->
                if (PokemonProperties.parse(properties).isInvalid()) {
                    this.debugger.debug("Your override of $properties does not contain a valid species and may match more Pokemon than intended", overrideConfig = true)
                }
            }
        }
    }
}
