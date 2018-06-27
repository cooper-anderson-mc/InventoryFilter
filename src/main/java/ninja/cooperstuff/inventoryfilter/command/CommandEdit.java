package ninja.cooperstuff.inventoryfilter.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import ninja.cooperstuff.inventoryfilter.FilterConfig;
import ninja.cooperstuff.inventoryfilter.InventoryFilter;

public class CommandEdit extends CommandBase {
	@Override
	public String getName() {
		return "edit";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		return InventoryFilter.MODID + ":commands.filter.edit.usage";
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		if (args.length < 2) {
			sender.sendMessage(FilterCommand.formatMessage(sender, InventoryFilter.MODID + ":commands.filter.edit.error"));
			return;
		}
		int index;
		String regex = args[1];
		try {
			index = Integer.parseInt(args[0]) - 1;
		} catch(NumberFormatException nfe) {
			sender.sendMessage(FilterCommand.formatMessage(sender, InventoryFilter.MODID + ":commands.filter.edit.integer"));
			return;
		}
		int length = FilterConfig.filterList.length;
		if (length == 0) {
			sender.sendMessage(FilterCommand.formatMessage(sender, InventoryFilter.MODID + ":commands.filter.edit.empty"));
			return;
		} else if (index < 0 || index > length - 1) {
			ITextComponent msg = FilterCommand.formatMessage(sender, InventoryFilter.MODID + ":commands.filter.edit.bounds", length);
			msg.getStyle().setColor(TextFormatting.RED);
			sender.sendMessage(msg);
			return;
		}
		FilterConfig.filterList[index] = regex;
		FilterConfig.saveConfig();
		sender.sendMessage(FilterCommand.formatMessage(sender, InventoryFilter.MODID + ":commands.filter.edit.success", index+1, regex));
	}
}
