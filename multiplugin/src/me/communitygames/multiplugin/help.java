package me.communitygames.multiplugin;

import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class help
{
	multiplugin plugin;
	Command cmd;
	String[] args;
	Player p;

	public help(Command cmd, String[] args, Player p, multiplugin plugin)
	{
		this.cmd = cmd;
		this.args = args;
		this.p = p;
		this.plugin = plugin;
	}
	
	public boolean execute()
	{
		p.sendMessage("---MultiPlugin Help---");
		p.sendMessage("/armor - get diamond-armor and diamond-sword");
		p.sendMessage("/ban <t> - ban a player by name");
		p.sendMessage("/ban? <t> - is player currently banned?");
		//p.sendMessage("/bannedp - get list of all banned players");
		p.sendMessage("/broadcast - broadcast a message (config.yml)");
		p.sendMessage("/day - set time to day");
		p.sendMessage("/del <t> - clear your or players inventory");
		p.sendMessage("/fill - fill your inventory -> 64p.");
		p.sendMessage("/fly <t> - toggle flightmodus");
		p.sendMessage("/isfly <t> - has target permissions to fly?");
		p.sendMessage("/food <t> - fill foodlevel to 10.0");
		p.sendMessage("/gm(a/c/s) <t> - change gamemode");
		p.sendMessage("/health - set health to 10.0");
		p.sendMessage("/hello - \"HELLO\"");
		
		//p.sendMessage("/isfly <t> - have player permissions to fly?");
		p.sendMessage("/kick <t> - kick player from server");
		p.sendMessage("/kill <t> - kills you or a player by name");
		p.sendMessage("/mphelp - get multiplugin help");
		p.sendMessage("/mpversion - print the actual plugin version");
		p.sendMessage("/night - set time to night");
		//p.sendMessage("/ops - print all names of owners");
		p.sendMessage("/pheal - player can health himself");
		p.sendMessage("/rain - set rainy weather");
		p.sendMessage("/rules - print server-rules");
		p.sendMessage("/save - saves the world");
		p.sendMessage("/suizide - suicide...");
		p.sendMessage("/sun - set sunny weather");
		p.sendMessage("/thunder - set thunder");
		p.sendMessage("/unban - unbans a player from banning-list");
		//TODO: HERE
		
	return false;	
	}
}