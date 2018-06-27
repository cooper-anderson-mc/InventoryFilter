package ninja.cooperstuff.inventoryfilter.command;

import net.minecraft.command.ICommandSender;
import net.minecraft.util.text.TextComponentBase;
import net.minecraftforge.server.command.CommandTreeBase;
import net.minecraftforge.server.command.TextComponentHelper;
import ninja.cooperstuff.inventoryfilter.InventoryFilter;

public class FilterCommand extends CommandTreeBase {
	public FilterCommand() {
		super.addSubcommand(new CommandList());
		super.addSubcommand(new CommandAdd());
		super.addSubcommand(new CommandRemove());
		super.addSubcommand(new CommandEdit());
		super.addSubcommand(new CommandConfig());
		super.addSubcommand(new CommandHelp(this));
	}

	@Override
	public String getName() {
		return "filter";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		return InventoryFilter.MODID + ":commands.filter.usage";
	}

	public static TextComponentBase formatMessage(ICommandSender sender, String message, Object ... args) {
		return TextComponentHelper.createComponentTranslation(sender, message, args);
	}
}
