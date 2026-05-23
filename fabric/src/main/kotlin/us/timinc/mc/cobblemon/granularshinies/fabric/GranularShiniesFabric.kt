package us.timinc.mc.cobblemon.granularshinies.fabric

import net.fabricmc.api.ModInitializer
import us.timinc.mc.cobblemon.granularshinies.common.GranularShinies

object GranularShiniesFabric : ModInitializer {
    override fun onInitialize() {
        GranularShinies.init()
    }
}
