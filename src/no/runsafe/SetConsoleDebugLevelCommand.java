package no.runsafe;


import no.runsafe.framework.command.ICommand;
import no.runsafe.framework.command.RunsafeConsoleCommand;
import no.runsafe.framework.output.Console;
import no.runsafe.framework.output.IOutput;
import no.runsafe.framework.server.player.RunsafePlayer;
import org.apache.commons.lang.StringUtils;

import java.util.Collection;
import java.util.logging.Level;

public class SetConsoleDebugLevelCommand extends RunsafeConsoleCommand
{
	public SetConsoleDebugLevelCommand(IOutput output)
	{
		super("debug", null, "level");
		this.output = output;
	}

	@Override
	public String getCommandParams()
	{
		String part = commandName + " NONE|SEVERE|WARNING|INFO|CONFIG|FINE|FINER|FINEST|ALL";

		if(superCommand != null)
			return superCommand.getCommandParams() + " " + part;

		return part;
	}

	@Override
	public String OnExecute(RunsafePlayer executor, String[] args)
	{
		output.setDebugLevel(Level.parse(getArg("level")));
		return String.format("Debug level is now %s.", output.getDebugLevel().getName());
	}

	private IOutput output;
}
