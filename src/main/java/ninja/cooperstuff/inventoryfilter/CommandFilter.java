package ninja.cooperstuff.inventoryfilter;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.command.CommandException;

public class CommandFilter extends CommandBase {
	@Override
	public String getName() {
		return "filter";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		return "commands.filter.usage";
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		if (args[0].equals("list")) {
			// TODO
		}
	}
}
