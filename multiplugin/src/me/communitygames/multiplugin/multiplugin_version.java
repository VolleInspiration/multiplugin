package me.communitygames.multiplugin;

import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;

public class multiplugin_version
{
	multiplugin plugin;
	Command cmd;
	String[] args;
	Player p;

	public multiplugin_version(Command cmd, String[] args, Player p, multiplugin plugin)
	{
		this.cmd = cmd;
		this.args = args;
		this.p = p;
		this.plugin = plugin;
	}
	
	public boolean execute()
	{
		PluginDescriptionFile descFile = plugin.getDescription();
		p.sendMessage("*****************************************" + '\n' +  " MultiPlugin-Version: " + descFile.getVersion() + '\n' + " MultiPlugin-Author: " + descFile.getAuthors() + "   *" + '\n' + "*****************************************");
		return true;
	}
}