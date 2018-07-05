package ninja.cooperstuff.inventoryfilter;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class FilterEventHandler {
	@SubscribeEvent
	public void onItemPickup(EntityItemPickupEvent event) {
		if (FilterConfig.enabled && InventoryFilter.isGamemodeEnabled(event.getEntityPlayer())) {
			event.setCanceled(!InventoryFilter.isItemAllowed(event.getItem().getItem().getItem()));
		}
	}

	@SubscribeEvent
	public void onInventoryChange(TickEvent.PlayerTickEvent event) {
		for (int i = 0; i < event.player.inventory.getSizeInventory(); i++) {
			ItemStack itemStack = event.player.inventory.getStackInSlot(i);
			if (FilterConfig.enabled && InventoryFilter.isGamemodeEnabled(event.player) && itemStack.getItem() != Items.AIR && !InventoryFilter.isItemAllowed(itemStack.getItem())) {
				event.player.dropItem(itemStack, true);
				event.player.inventory.removeStackFromSlot(i);
			}
		}
	}
}
