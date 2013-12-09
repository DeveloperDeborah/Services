package no.runsafe;

import no.runsafe.command.DebugLevelCommand;
import no.runsafe.command.ReloadConfigCommand;
import no.runsafe.command.RunsafePluginVersions;
import no.runsafe.framework.RunsafeConfigurablePlugin;
import no.runsafe.framework.api.command.Command;

public class RunsafeServices extends RunsafeConfigurablePlugin
{
	@Override
	protected void PluginSetup()
	{
		Command command = new Command("runsafe", "Runsafe core services", null);

		Command config = new Command("config", "Commands to control plugin configurations", null);
		config.addSubCommand(getInstance(ReloadConfigCommand.class));
		command.addSubCommand(config);

		command.addSubCommand(getInstance(DebugLevelCommand.class));
		command.addSubCommand(getInstance(RunsafePluginVersions.class));

		addComponent(command);
	}
}
