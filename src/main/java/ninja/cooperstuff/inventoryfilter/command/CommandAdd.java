package ninja.cooperstuff.inventoryfilter.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import ninja.cooperstuff.inventoryfilter.FilterConfig;
import ninja.cooperstuff.inventoryfilter.InventoryFilter;

public class CommandAdd extends CommandBase {
	@Override
	public String getName() {
		return "add";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		return InventoryFilter.MODID + ":commands.filter.add.usage";
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		if (args.length < 1) {
			sender.sendMessage(FilterCommand.formatMessage(sender, InventoryFilter.MODID + ":commands.filter.add.error"));
			return;
		}
		String list[] = FilterConfig.filterList;
		String regex = args[0];
		for (String item: list) {
			if (regex.equals(item)) {
				sender.sendMessage(FilterCommand.formatMessage(sender, InventoryFilter.MODID + ":commands.filter.add.exists"));
				return;
			}
		}
		int length = list.length;
		String[] listNew = new String[length + 1];
		System.arraycopy(list, 0, listNew, 0, length);
		listNew[length] = regex;
		FilterConfig.filterList = listNew;
		FilterConfig.saveConfig();
		sender.sendMessage(FilterCommand.formatMessage(sender, InventoryFilter.MODID + ":commands.filter.add.success", regex, length+1));
	}
}
