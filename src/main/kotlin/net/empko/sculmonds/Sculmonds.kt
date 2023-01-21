package net.empko.sculmonds

import net.empko.sculmonds.block.ModBlocks
import net.empko.sculmonds.item.ModItems
import net.fabricmc.api.ModInitializer
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class Sculmonds: ModInitializer {
    companion object {
        const val MOD_ID = "sculmonds"
        val LOGGER: Logger = LoggerFactory.getLogger(MOD_ID)
    }
    override fun onInitialize() {
        ModItems.registerModItems()
        ModBlocks.registerModBlocks()
    }
}