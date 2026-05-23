package us.timinc.mc.cobblemon.granularshinies.common

import com.cobblemon.mod.common.api.Priority
import com.cobblemon.mod.common.api.events.CobblemonEvents
import com.cobblemon.mod.common.api.pokemon.PokemonProperties
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import us.timinc.mc.cobblemon.granularshinies.common.config.ConfigBuilder
import us.timinc.mc.cobblemon.granularshinies.common.config.GranularShiniesConfig
import us.timinc.mc.cobblemon.granularshinies.common.events.ShinyChanceCalculationHandler
import us.timinc.mc.cobblemon.granularshinies.common.extensions.isInvalid
import java.util.UUID

object GranularShinies {
    @Suppress("MemberVisibilityCanBePrivate")
    const val MOD_ID = "cobblemon_granularshinies"
    lateinit var config: GranularShiniesConfig
    val logger: Logger = LoggerFactory.getLogger(MOD_ID)

    fun init() {
        config = ConfigBuilder.load(GranularShiniesConfig::class.java, MOD_ID)
        validateConfig()
        CobblemonEvents.SHINY_CHANCE_CALCULATION.subscribe(Priority.HIGHEST, ShinyChanceCalculationHandler::handle)
    }

    private fun validateConfig() {
        CobblemonEvents.DATA_SYNCHRONIZED.subscribe {
            config.overrides.forEach { (properties) ->
                if (PokemonProperties.parse(properties).isInvalid()) {
                    debug("Your override of $properties is invalid and will match all Pokemon", bypassConfig = true)
                }
            }
        }
    }

    fun debug(msg: String, uuid: UUID? = null, bypassConfig: Boolean = false) {
        if (!config.debug && !bypassConfig) return
        logger.info(if (uuid == null) msg else "$msg ($uuid)")
    }
}
