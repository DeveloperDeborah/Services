package no.runsafe;

import no.runsafe.framework.RunsafePlugin;
import no.runsafe.framework.messaging.IMessagePump;
import no.runsafe.framework.messaging.MessagePump;

public class RunsafeMessageBus extends RunsafePlugin
{
	@Override
	protected void PluginSetup()
	{
		this.addComponent(new MessagePump());
	}

	public IMessagePump getInstance()
	{
		return getComponent(IMessagePump.class);
	}
}
