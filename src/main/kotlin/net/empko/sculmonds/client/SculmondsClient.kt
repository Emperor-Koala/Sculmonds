package net.empko.sculmonds.client

import net.empko.sculmonds.block.ModBlocks
import net.fabricmc.api.ClientModInitializer
import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment

@Environment(EnvType.CLIENT)
class SculmondsClient: ClientModInitializer {
    override fun onInitializeClient() {
        ModBlocks.registerModBlocks()
    }
}