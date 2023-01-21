package net.empko.sculmonds.item

import net.empko.sculmonds.Sculmonds
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import net.minecraft.item.*
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier

class ModItems {
    companion object {

        val SCULMOND = registerItem(
            "sculmond",
            Item(FabricItemSettings()),
            ItemGroups.INGREDIENTS,
            Items.DIAMOND,
        )

        private fun registerItem(name: String, item: Item, tab: ItemGroup, addAfterInGroup: Item?): Item {
            // TODO allow adding to multiple item groups
            val registeredItem = Registry.register(
                Registries.ITEM,
                Identifier(Sculmonds.MOD_ID, name),
                item
            )
            ItemGroupEvents.modifyEntriesEvent(tab).register(ItemGroupEvents.ModifyEntries { content: FabricItemGroupEntries ->
                if (addAfterInGroup != null) {
                    content.addAfter(addAfterInGroup, registeredItem)
                } else {
                    content.add(registeredItem)
                }
            })
            return registeredItem
        }

        fun registerModItems() {
            Sculmonds.LOGGER.debug("Registering items for " + Sculmonds.MOD_ID)
        }

    }
}