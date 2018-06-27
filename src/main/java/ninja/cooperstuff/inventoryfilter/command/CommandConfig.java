package ninja.cooperstuff.inventoryfilter.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import ninja.cooperstuff.inventoryfilter.FilterConfig;
import ninja.cooperstuff.inventoryfilter.InventoryFilter;
import javax.annotation.Nullable;
import java.util.*;

public class CommandConfig extends CommandBase {
	@Override
	public String getName() {
		return "config";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		return InventoryFilter.MODID + ":commands.filter.config.usage";
	}


	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		if (args.length == 0) {
			sender.sendMessage(FilterCommand.formatMessage(sender, InventoryFilter.MODID + ":commands.filter.config.error"));
			return;
		} else {
			if (args[0].equals("enabled")) {
				if (args.length == 1) {
					sender.sendMessage(FilterCommand.formatMessage(sender, InventoryFilter.MODID + ":commands.filter.config.display", "enabled", FilterConfig.enabled));
					return;
				} else if (args[1].equals("true")) {
					FilterConfig.enabled = true;
					sender.sendMessage(FilterCommand.formatMessage(sender, InventoryFilter.MODID + ":commands.filter.config.success", "enabled", "true"));
				} else if (args[1].equals("false")) {
					FilterConfig.enabled = false;
					sender.sendMessage(FilterCommand.formatMessage(sender, InventoryFilter.MODID + ":commands.filter.config.success", "enabled", "false"));
				} else {
					sender.sendMessage(FilterCommand.formatMessage(sender, InventoryFilter.MODID + ":commands.filter.config.enabled.usage"));
					return;
				}
			} else if (args[0].equals("filtermode")) {
				if (args.length == 1) {
					sender.sendMessage(FilterCommand.formatMessage(sender, InventoryFilter.MODID + ":commands.filter.config.display", "filtermode", FilterConfig.filterMode));
					return;
				} else if (args[1].equals("whitelist")) {
					FilterConfig.filterMode = FilterConfig.FilterMode.whitelist;
					sender.sendMessage(FilterCommand.formatMessage(sender, InventoryFilter.MODID + ":commands.filter.config.success", "filtermode", "whitelist"));
				} else if (args[1].equals("blacklist")) {
					FilterConfig.filterMode = FilterConfig.FilterMode.blacklist;
					sender.sendMessage(FilterCommand.formatMessage(sender, InventoryFilter.MODID + ":commands.filter.config.success", "filtermode", "blacklist"));
				} else {
					sender.sendMessage(FilterCommand.formatMessage(sender, InventoryFilter.MODID + ":commands.filter.config.filtermode.usage"));
					return;
				}
			} else if (args[0].equals("gamemodes")) {
				if (args.length == 1) {
					sender.sendMessage(FilterCommand.formatMessage(sender, InventoryFilter.MODID + ":commands.filter.config.display", "gamemodes.adventure", FilterConfig.Gamemodes.adventure));
					sender.sendMessage(FilterCommand.formatMessage(sender, InventoryFilter.MODID + ":commands.filter.config.display", "gamemodes.creative", FilterConfig.Gamemodes.creative));
					sender.sendMessage(FilterCommand.formatMessage(sender, InventoryFilter.MODID + ":commands.filter.config.display", "gamemodes.survival", FilterConfig.Gamemodes.survival));
					return;
				} else {
					if (args[1].equals("adventure")) {
						if (args.length == 2) {
							sender.sendMessage(FilterCommand.formatMessage(sender, InventoryFilter.MODID + ":commands.filter.config.display", "gamemodes.adventure", FilterConfig.Gamemodes.adventure));
							return;
						} else if (args[2].equals("true")) {
							FilterConfig.Gamemodes.adventure = true;
							sender.sendMessage(FilterCommand.formatMessage(sender, InventoryFilter.MODID + ":commands.filter.config.success", "gamemodes.adventure", "true"));
						} else if (args[2].equals("false")) {
							FilterConfig.Gamemodes.adventure = false;
							sender.sendMessage(FilterCommand.formatMessage(sender, InventoryFilter.MODID + ":commands.filter.config.success", "gamemodes.adventure", "false"));
						} else {
							sender.sendMessage(FilterCommand.formatMessage(sender, InventoryFilter.MODID + ":commands.filter.config.gamemodes.mode.usage", "adventure"));
							return;
						}
					} else if (args[1].equals("creative")) {
						if (args.length == 2) {
							sender.sendMessage(FilterCommand.formatMessage(sender, InventoryFilter.MODID + ":commands.filter.config.display", "gamemodes.creative", FilterConfig.Gamemodes.creative));
							return;
						} else if (args[2].equals("true")) {
							FilterConfig.Gamemodes.creative = true;
							sender.sendMessage(FilterCommand.formatMessage(sender, InventoryFilter.MODID + ":commands.filter.config.success", "gamemodes.creative", "true"));
						} else if (args[2].equals("false")) {
							FilterConfig.Gamemodes.creative = false;
							sender.sendMessage(FilterCommand.formatMessage(sender, InventoryFilter.MODID + ":commands.filter.config.success", "gamemodes.creative", "false"));
						} else {
							sender.sendMessage(FilterCommand.formatMessage(sender, InventoryFilter.MODID + ":commands.filter.config.gamemodes.mode.usage", "creative"));
							return;
						}
					} else if (args[1].equals("survival")) {
						if (args.length == 2) {
							sender.sendMessage(FilterCommand.formatMessage(sender, InventoryFilter.MODID + ":commands.filter.config.display", "gamemodes.survival", FilterConfig.Gamemodes.survival));
							return;
						} else if (args[2].equals("true")) {
							FilterConfig.Gamemodes.survival = true;
							sender.sendMessage(FilterCommand.formatMessage(sender, InventoryFilter.MODID + ":commands.filter.config.success", "gamemodes.survival", "true"));
						} else if (args[2].equals("false")) {
							FilterConfig.Gamemodes.survival = false;
							sender.sendMessage(FilterCommand.formatMessage(sender, InventoryFilter.MODID + ":commands.filter.config.success", "gamemodes.survival", "false"));
						} else {
							sender.sendMessage(FilterCommand.formatMessage(sender, InventoryFilter.MODID + ":commands.filter.config.gamemodes.mode.usage", "survival"));
							return;
						}
					} else {
						sender.sendMessage(FilterCommand.formatMessage(sender, InventoryFilter.MODID + ":commands.filter.config.gamemodes.usage"));
						return;
					}
				}
			} else {
				sender.sendMessage(FilterCommand.formatMessage(sender, InventoryFilter.MODID + ":commands.filter.config.valid"));
				return;
			}
		}
		FilterConfig.saveConfig();
	}

	@Override
	public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, @Nullable BlockPos targetPos) {
		ArrayList<String> data = new ArrayList<>(Arrays.asList(args));
		data.removeAll(Arrays.asList(""));
		int length = data.size();

		List<String> output = new ArrayList<>();
		Map<String, List<String>> completions = new HashMap<>();
		completions.put("enabled", new ArrayList<>(Arrays.asList("true", "false")));
		completions.put("filtermode", new ArrayList<>(Arrays.asList("whitelist", "blacklist")));
		completions.put("gamemodes", new ArrayList<>(Arrays.asList("adventure", "creative", "survival")));

		if (length == 0) {
			output.add("enabled");
			output.add("filtermode");
			output.add("gamemodes");
		} else if (length == 1) {
			if (completions.containsKey(data.get(0))) {
				output = completions.get(data.get(0));
			}
		} else if (length == 2) {
			if (completions.get("gamemodes").contains(data.get(1))) {
				output.add("true");
				output.add("false");
			}
		}
		return output;
	}
}
