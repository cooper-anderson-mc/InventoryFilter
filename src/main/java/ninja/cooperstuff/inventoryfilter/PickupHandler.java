package ninja.cooperstuff.inventoryfilter;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;

public class PickupHandler {
	@SubscribeEvent
	public void OnItemPickup(EntityItemPickupEvent event) {
		if (FilterConfig.enabled && InventoryFilter.isGamemodeEnabled(event.getEntityPlayer())) {
			event.setCanceled(!InventoryFilter.isItemAllowed(event.getItem().getItem().getItem()));
		}
	}
}
