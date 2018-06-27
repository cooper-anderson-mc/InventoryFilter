package ninja.cooperstuff.inventoryfilter;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

import java.util.logging.Filter;

@Mod(modid = InventoryFilter.MODID, name = InventoryFilter.NAME, version = InventoryFilter.VERSION)
public class InventoryFilter
{
    public static final String MODID = "inventoryfilter";
    public static final String NAME = "Inventory Filter";
    public static final String VERSION = "1.0";

    protected static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		// TODO CommandFilter implementation
    }

    @EventHandler
	public void postInit(FMLPostInitializationEvent event) {
	    MinecraftForge.EVENT_BUS.register(new PickupHandler());
    }

    public static boolean isItemAllowed(Item item) {
    	String name = item.getRegistryName().toString();
	    String list[] = FilterConfig.filterList;
	    boolean isWhitelist = FilterConfig.filterMode == FilterConfig.FilterMode.whitelist;
    	for (String regex : list) {
    		if (name.matches(regex)) {
    			return isWhitelist;
		    }
	    }
    	return !isWhitelist;
    }

    public static boolean isGamemodeEnabled(EntityPlayer player) {
	    return (FilterConfig.Gamemodes.adventure && !player.capabilities.allowEdit) ||
			    (FilterConfig.Gamemodes.creative && player.capabilities.isCreativeMode) ||
			    (FilterConfig.Gamemodes.survival && !player.capabilities.isCreativeMode && player.capabilities.allowEdit);
    }
}
