package us.timinc.mc.cobblemon.granularshinies.common.extensions

import com.cobblemon.mod.common.api.pokemon.PokemonProperties

fun PokemonProperties.isInvalid(): Boolean = this.species === null
