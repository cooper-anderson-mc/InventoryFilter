package ninja.cooperstuff.inventoryfilter.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import ninja.cooperstuff.inventoryfilter.FilterConfig;
import ninja.cooperstuff.inventoryfilter.InventoryFilter;

public class CommandList extends CommandBase {
	@Override
	public String getName() {
		return "list";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		return InventoryFilter.MODID + ":commands.filter.list.usage";
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		String list[] = FilterConfig.filterList;
		String header = (list.length == 0) ? "empty" : "header";
		sender.sendMessage(FilterCommand.formatMessage(sender, InventoryFilter.MODID + ":commands.filter.list." + header));
		for (int i = 0; i < list.length; i++) {
			sender.sendMessage(FilterCommand.formatMessage(sender, InventoryFilter.MODID + ":commands.filter.list.item", i+1, list[i]));
		}
	}
}
