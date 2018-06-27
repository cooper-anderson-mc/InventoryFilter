package ninja.cooperstuff.inventoryfilter;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.common.config.ConfigManager;

@Config(modid = InventoryFilter.MODID)
public class FilterConfig {
	@Config.Name("Enabled")
	@Config.Comment({"Simple way to toggle all features", "(without restarting)"})
	public static boolean enabled = true;

	@Config.Name("Filter Mode")
	@Config.Comment("Whether the listed items are whitelisted or blacklisted")
	public static FilterMode filterMode = FilterMode.whitelist;

	@Config.Name("Filter List")
	@Config.Comment({"List of items/blocks to filter", "Supports Regular Expressions", "Examples:", "minecraft:diamond_pickaxe", "minecraft:[a-zA-Z0-9_]*sword"})
	public static String[] filterList = {};

	@Config.Name("Gamemodes")
	@Config.Comment("What gamemodes to apply the filter to")
	public static Gamemodes gamemodes;

	public enum FilterMode {whitelist, blacklist}

	public static final class Gamemodes {
		@Config.Name("Survival")
		@Config.Comment({"Whether the filter is applied in Survival mode", "(not recommended)"})
		public static boolean survival = false;

		@Config.Name("Creative")
		@Config.Comment({"Whether the filter is applied in Creative mode", "(not recommended)"})
		public static boolean creative = false;

		@Config.Name("Adventure")
		@Config.Comment("Whether the filter is applied in Adventure mode")
		public static boolean adventure = true;
	}

	public static void saveConfig() {
		ConfigManager.sync(InventoryFilter.MODID, Config.Type.INSTANCE);
	}

	@Mod.EventBusSubscriber(modid = InventoryFilter.MODID)
	private static class ConfigHandler {
		@SubscribeEvent
		public static void onConfigChanged(final ConfigChangedEvent.OnConfigChangedEvent event) {
			if (event.getModID().equals(InventoryFilter.MODID)) {
				saveConfig();
			}
		}
	}
}
