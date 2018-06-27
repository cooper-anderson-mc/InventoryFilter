package ninja.cooperstuff.inventoryfilter.command;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import ninja.cooperstuff.inventoryfilter.FilterConfig;
import ninja.cooperstuff.inventoryfilter.InventoryFilter;

public class CommandRemove extends CommandBase {
	@Override
	public String getName() {
		return "remove";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		return InventoryFilter.MODID + ":commands.filter.remove.usage";
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		if (args.length < 1) {
			sender.sendMessage(FilterCommand.formatMessage(sender, InventoryFilter.MODID + ":commands.filter.remove.error"));
			return;
		}
		int index;
		try {
			index = Integer.parseInt(args[0]) - 1;
		} catch(NumberFormatException nfe) {
			sender.sendMessage(FilterCommand.formatMessage(sender, InventoryFilter.MODID + ":commands.filter.remove.integer"));
			return;
		}
		String list[] = FilterConfig.filterList;
		int length = list.length;
		if (length == 0) {
			sender.sendMessage(FilterCommand.formatMessage(sender, InventoryFilter.MODID + ":commands.filter.remove.empty"));
			return;
		} else if (index < 0 || index > length - 1) {
			ITextComponent msg = FilterCommand.formatMessage(sender, InventoryFilter.MODID + ":commands.filter.remove.bounds", length);
			msg.getStyle().setColor(TextFormatting.RED);
			sender.sendMessage(msg);
			return;
		}
		int count = 0;
		String regex = "";
		String[] listNew = new String[length - 1];
		for (int i = 0; i < length; i++) {
			if (i != index) {
				listNew[count] = list[i];
				count++;
			} else {
				regex = list[i];
			}
		}
		FilterConfig.filterList = listNew;
		FilterConfig.saveConfig();
		sender.sendMessage(FilterCommand.formatMessage(sender, InventoryFilter.MODID + ":commands.filter.remove.success", regex, index+1));
	}
}
