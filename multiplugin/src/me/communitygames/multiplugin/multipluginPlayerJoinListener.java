package me.communitygames.multiplugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import me.communitygames.multiplugin.multiplugin;

public class multipluginPlayerJoinListener implements Listener 
{
	Command cmd;
	String[] args;
	Player p;
	
	public multipluginPlayerJoinListener(Command cmd, String[] args, Player p, multiplugin plugin)
	{
		this.cmd = cmd;
		this.args = args;
		this.p = p;
		this.plugin = plugin;
	}
	
	public multipluginPlayerJoinListener(multiplugin plugin)
	{
		this.plugin = plugin;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerJoin(PlayerJoinEvent e)
	{
		Player p = e.getPlayer();
		String msg = plugin.getConfig().getString("Config.message.join");
		msg = msg.replace("%p%", p.getName());
		e.setJoinMessage(ChatColor.translateAlternateColorCodes('&', msg));
		//TODO: locate player and print it ;)
		//checks if p is op or not
		if(p.isOp())
		{
			String msgisop = plugin.getConfig().getString("Config.message.isOp");
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', msgisop));
			
			//updater on off
			boolean updh = plugin.getConfig().getBoolean("Config.update-info-start", true);
			if(updh == true)
			{
				//check for update on site
				UpdateChecker updateChecker = new UpdateChecker(plugin, "http://dev.bukkit.org/bukkit-plugins/multiplugin/files.rss");
				if(updateChecker.updateNeeded())
				{
					//write on admin join, if update available
					boolean update = plugin.getConfig().getBoolean("Config.update-info-on-start", true);
					if(update == true)
					{
						p.sendMessage(ChatColor.YELLOW + "[multiplugin] " + ChatColor.AQUA + "A new version is available \"" + updateChecker.getVersion() + "\"");
						p.sendMessage(ChatColor.YELLOW + "[multiplugin] " + ChatColor.AQUA + "Get it from: "  + updateChecker.getLink());
					}
				}
			}
		}
		else 
		{
			//player is no op
			boolean opmsg = plugin.getConfig().getBoolean("Config.message.no-Op", true);
			if(opmsg == true)
			{
				String msgisnoop = plugin.getConfig().getString("Config.message.isNoOp");
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', msgisnoop));
			}
		}
	}
	
	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerQuit(PlayerQuitEvent e)
	{
		Player p = e.getPlayer();
		String msg = plugin.getConfig().getString("Config.message.quit");
		msg = msg.replace("%p%", p.getName());
		e.setQuitMessage(ChatColor.translateAlternateColorCodes('&', msg));
	}
	private multiplugin plugin;
}
