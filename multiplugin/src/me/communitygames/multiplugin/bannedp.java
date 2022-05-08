package me.communitygames.multiplugin;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;

public class bannedp
{
	multiplugin plugin;
	Command cmd;
	String[] args;
	Player p;

	public bannedp(Command cmd, String[] args, Player p, multiplugin plugin)
	{
		this.cmd = cmd;
		this.args = args;
		this.p = p;
		this.plugin = plugin;
	}
	
	public boolean execute()
	{	
		if(args.length != 0)
		{
			p.sendMessage(ChatColor.YELLOW + "[multiplugin] " + ChatColor.RED + "Wrong input! Use: /bannedp");
			return false;		
		}
		
		else if(args.length == 0)
		{
			try 
			{
				/*BufferedReader in = new BufferedReader(new FileReader("banned-players.json"));
				String zeile = null;*/
				
				p.sendMessage(ChatColor.GREEN + "Banned Player(s):" + "\n");
				
				//BanList bl = null;
				//System.out.println("HHH: "+bl.getBanEntry("name"));
				//Set<OfflinePlayer> pl = Bukkit.getServer().getBannedPlayers();
				//pl = (Set<OfflinePlayer>) Bukkit.getOfflinePlayer(pl.toString());
				//p.sendMessage( pl.toString() );
				//Bukkit.getServer().getBanList(BanList.Type.NAME).toString();
				
				
				/*while ((zeile = in.readLine()) != null)
				{
					if(zeile.contains("|"))
					{
						int ende;
						String value;
						
						ende = zeile.indexOf("|");
						value = zeile.substring(0, ende);
						
						p.sendMessage(ChatColor.GOLD + value);
						
						boolean bannedPLog = plugin.getConfig().getBoolean("Config.banned-player-in-log", true);
						if(bannedPLog == true)
						{
							System.out.println("banned players: " + value);
						//
						}
					}	
				}*/
				p.sendMessage(ChatColor.WHITE + "Full list in your LOG");
			} 
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	return false;
	}
}