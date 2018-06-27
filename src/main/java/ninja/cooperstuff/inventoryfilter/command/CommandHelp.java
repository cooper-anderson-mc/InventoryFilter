package ninja.cooperstuff.inventoryfilter.command;

import net.minecraft.command.ICommandSender;
import net.minecraftforge.server.command.CommandTreeBase;
import net.minecraftforge.server.command.CommandTreeHelp;
import ninja.cooperstuff.inventoryfilter.InventoryFilter;

public class CommandHelp extends CommandTreeHelp {
	public CommandHelp(CommandTreeBase parent) {
		super(parent);
	}

	@Override
	public String getUsage(ICommandSender sender)
	{
		return InventoryFilter.MODID + ":commands.filter.usage.help";
	}
}
