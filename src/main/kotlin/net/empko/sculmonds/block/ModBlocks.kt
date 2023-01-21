package net.empko.sculmonds.block

import net.empko.sculmonds.Sculmonds
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Block
import net.minecraft.block.ExperienceDroppingBlock
import net.minecraft.block.Material
import net.minecraft.item.*
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier
import net.minecraft.util.math.intprovider.UniformIntProvider

class ModBlocks {
    companion object {
        val SCULMOND_BLOCK = registerBlock(
            "sculmond_block",
            Block(
                FabricBlockSettings.of(Material.METAL).strength(4f).requiresTool()
            ),
            ItemGroups.NATURAL,
            Items.DEEPSLATE_DIAMOND_ORE,
        )
        val SCULMOND_ORE = registerBlock(
            "sculmond_ore",
            ExperienceDroppingBlock(
                FabricBlockSettings.of(Material.METAL).strength(4f).requiresTool(),
                UniformIntProvider.create(3, 7)
            ),
            ItemGroups.BUILDING_BLOCKS,
            Items.DIAMOND_BLOCK,
        )

        private fun registerBlock(name: String, block: Block, tab: ItemGroup, addAfterInGroup: Item?): Block {
            // TODO allow adding to multiple item groups
            registerBlockItem(name, block, tab, addAfterInGroup)
            return Registry.register(Registries.BLOCK, Identifier(Sculmonds.MOD_ID, name), block)
        }

        private fun registerBlockItem(name: String, block: Block, tab: ItemGroup, addAfterInGroup: Item?): Item {
            // TODO allow adding to multiple item groups
            val item = Registry.register(
                Registries.ITEM,
                Identifier(Sculmonds.MOD_ID, name),
                BlockItem(block, FabricItemSettings())
            )
            ItemGroupEvents.modifyEntriesEvent(tab).register(ItemGroupEvents.ModifyEntries { content: FabricItemGroupEntries ->
                if (addAfterInGroup != null) {
                    content.addAfter(addAfterInGroup, item)
                } else {
                    content.add(item)
                }
            })
            return item
        }

        fun registerModBlocks() {
            Sculmonds.LOGGER.debug("Registering blocks for " + Sculmonds.MOD_ID)
        }
    }
}