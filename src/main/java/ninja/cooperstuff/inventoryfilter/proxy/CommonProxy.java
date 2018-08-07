package ninja.cooperstuff.inventoryfilter.proxy;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import ninja.cooperstuff.inventoryfilter.FilterEventHandler;
import ninja.cooperstuff.inventoryfilter.InventoryFilter;

@Mod.EventBusSubscriber(modid = InventoryFilter.MODID)
public class CommonProxy {
	public static final String COMMON = "ninja.cooperstuff.inventoryfilter.proxy.CommonProxy";
	public static final String CLIENT = "ninja.cooperstuff.inventoryfilter.proxy.ClientProxy";
	public static final String SERVER = "ninja.cooperstuff.inventoryfilter.proxy.ServerProxy";

	public void preInit(FMLPreInitializationEvent event) {

	}

	public void init(FMLInitializationEvent event) {

	}

	public void postInit(FMLPostInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(new FilterEventHandler());
	}
}
