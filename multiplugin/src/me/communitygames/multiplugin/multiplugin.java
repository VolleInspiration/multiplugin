package me.communitygames.multiplugin;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.logging.Logger;

import me.communitygames.multiplugin.armor;
import me.communitygames.multiplugin.ban;
import me.communitygames.multiplugin.bannedp;
import me.communitygames.multiplugin.broadcast;
import me.communitygames.multiplugin.day;
import me.communitygames.multiplugin.del;
import me.communitygames.multiplugin.fill;
import me.communitygames.multiplugin.food;
import me.communitygames.multiplugin.gma;
import me.communitygames.multiplugin.gmc;
import me.communitygames.multiplugin.gms;
import me.communitygames.multiplugin.health;
import me.communitygames.multiplugin.hello;
import me.communitygames.multiplugin.isban;
import me.communitygames.multiplugin.isfly;
import me.communitygames.multiplugin.kick;
import me.communitygames.multiplugin.kill;
import me.communitygames.multiplugin.multipluginPlayerJoinListener;
import me.communitygames.multiplugin.night;
import me.communitygames.multiplugin.ops;
import me.communitygames.multiplugin.pheal;
import me.communitygames.multiplugin.rain;
import me.communitygames.multiplugin.rules;
import me.communitygames.multiplugin.save;
import me.communitygames.multiplugin.suizide;
import me.communitygames.multiplugin.sun;
import me.communitygames.multiplugin.thunder;
import me.communitygames.multiplugin.unban;
import me.communitygames.multiplugin.multiplugin_version;
import me.communitygames.multiplugin.fly;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings({ "unused", "resource" })
public class multiplugin extends JavaPlugin 
{
	protected Logger log;
	protected UpdateChecker updateChecker;

	@Override
	public void onDisable() 
	{
		System.out.println("[multiplugin] Plugin disabled!");
	}
	
	@Override
	public void onEnable() 
	{
		//Event Teil laden (PlayerJoinEvent)
		registerEvent();
		
		// Config Teil
		loadConfig();
		
		//UPDATE
		boolean upd = this.getConfig().getBoolean("Config.update-info-log", true);
		if(upd == true)
		{
			this.log = this.getLogger();
			this.updateChecker = new UpdateChecker(this, "http://dev.bukkit.org/bukkit-plugins/multiplugin/files.rss");
	
			if(this.updateChecker.updateNeeded())
			{
					this.log.info("A new version is available " + this.updateChecker.getVersion());
					this.log.info("Get it from: " + this.updateChecker.getLink());
			} 
			else 
			{
				this.log.info("[UPDATEINFO] You don't need a new update.");
			}
		}
		//CREATE TEXTFILE (rules.txt)
		File datei = new File(getDataFolder(),"rules.txt");
		if(!datei.exists())
		{
			try
			{
				datei.createNewFile();
				FileWriter fw = new FileWriter(datei, true);
				BufferedWriter in = new BufferedWriter(fw);
				BufferedWriter out = new BufferedWriter(new FileWriter("plugins/multiplugin/rules.txt", true));
				String zeile = "1. Rule"+System.lineSeparator()+"2. Rule"+System.lineSeparator()+"3. Rule"+System.lineSeparator()+"etc...";
				out.write(zeile);
				out.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		// CREATE TEXTFILE (info.txt)	
		File info = new File(getDataFolder(),"info.txt");
		if(!info.exists())
		{
			try
			{
				info.createNewFile();
				FileWriter fw = new FileWriter(info, true);
				BufferedWriter in = new BufferedWriter(fw);
				BufferedWriter out = new BufferedWriter(new FileWriter("plugins/multiplugin/info.txt", true));
				String zeile = 	//"ServerInfo: server.mc-crazycraft.de (german server)"+ System.lineSeparator()+System.lineSeparator() + 
								"Color codes in Minecraft: " + System.lineSeparator() + "§0: black" + System.lineSeparator() + "§1: dark blue" + System.lineSeparator() 
								+ "§2: dark green" + System.lineSeparator() + "§3: dark turquoise" + System.lineSeparator() + "$4: dark red" + System.lineSeparator()
								+ "§5: purple" + System.lineSeparator() + "§6: gold" + System.lineSeparator() + "§7: gray" + System.lineSeparator() + "§8: dark gray" + System.lineSeparator()
								+ "§a: light green" + System.lineSeparator() + "§b: turquoise" + System.lineSeparator() + "§c: red" + System.lineSeparator() + "§d: pink" + System.lineSeparator()
								+ "§e: yellow" + System.lineSeparator() + "§f: white"
								+ System.lineSeparator() + System.lineSeparator()
								+ "heal-pheal: max heal = 20 half heart";
				out.write(zeile);
				out.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		
		PluginDescriptionFile descFile = this.getDescription();
		System.out.println("[multiplugin] #                                    #");
		System.out.println("[multiplugin] # ################################## #");
		System.out.println("[multiplugin] # #        #             #         # #");
		System.out.println("[multiplugin] # #       ## MultiPlugin ##        # #");
		System.out.println("[multiplugin] # #        # # # # # # # #         # #");
		System.out.println("[multiplugin] # #                                # #");
		System.out.println("[multiplugin] # # Plugin by " + descFile.getAuthors() + "     # #");
		System.out.println("[multiplugin] # # Version " + descFile.getVersion() + "               # #");
		System.out.println("[multiplugin] # # Plugin enabled!                # #");
		System.out.println("[multiplugin] # #                                # #");
		System.out.println("[multiplugin] # ################################## #");
		System.out.println("[multiplugin] #                                    #");
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args)
	{
		Player p = (Player) sender;
		
		//TODO: isfly, kit, pheal max 1x in einer best. zeit.
		/*if(cmd.getName().equalsIgnoreCase("test"))
		{
			return new _languages(cmd, args, p, this).execute();
		}*/
		// ARMOR
		if((cmd.getName().equalsIgnoreCase("armor")) && (p.hasPermission("multiplugin.armor")))
		{
			return new armor(cmd, args, p, this).execute();
		}
		
		// BAN
		else if ((cmd.getName().equalsIgnoreCase("ban")) && (p.hasPermission("multiplugin.ban"))) 
		{
			return new ban(cmd, args, p, this).execute();
		}

		// BROADCAST
		else if ((cmd.getName().equalsIgnoreCase("broadcast")) && (p.hasPermission("multiplugin.broadcast"))) 
		{
			return new broadcast(cmd, args, p, this).execute();
		}

		// FILL --> another class
		else if ((cmd.getName().equalsIgnoreCase("fill")) && (p.hasPermission("multiplugin.fill"))) 
		{
			return new fill(cmd, args, p, this).execute();
		}

		// FOOD
		else if ((cmd.getName().equalsIgnoreCase("food")) && (p.hasPermission("multiplugin.food"))) 
		{
			return new food(cmd, args, p, this).execute();
		}

		// HEALTH
		else if ((cmd.getName().equalsIgnoreCase("health")) && (p.hasPermission("multiplugin.health"))) 
		{
			return new health(cmd, args, p, this).execute();
		}

		// HEAL
		/*else if ((cmd.getName().equalsIgnoreCase("heal")) && (p.hasPermission("multiplugin.heal"))) 
		{
			return new health(cmd, args, p, this).execute();
		}*/
		
		// Player Heal
		else if((cmd.getName().equalsIgnoreCase("pheal")) && (p.hasPermission("multiplugin.pheal")))
		{
			return new pheal(cmd, args, p, this).execute();
		}

		// UNBAN
		else if ((cmd.getName().equalsIgnoreCase("unban")) && (p.hasPermission("multiplugin.unban"))) 
		{
			return new unban(cmd, args, p, this).execute();
		}	

		//version
		else if((cmd.getName().equalsIgnoreCase("mpversion")) && (p.hasPermission("multiplugin.version")))
		{
			return new multiplugin_version(cmd, args, p, this).execute();
		}
		
		// KILL
		else if ((cmd.getName().equalsIgnoreCase("kill")) && (p.hasPermission("multiplugin.kill"))) 
		{
			return new kill(cmd, args, p, this).execute();
		}

		// KICK
		else if ((cmd.getName().equalsIgnoreCase("kick")) && (p.hasPermission("multiplugin.kick"))) 
		{
			return new kick(cmd, args, p, this).execute();
		}

		// Kommando "Fly"
		else if ((cmd.getName().equalsIgnoreCase("fly")) && (p.hasPermission("multiplugin.fly"))) 
		{
			return new fly(cmd, args, p, this).execute();
		}

		// Kommando Inventar leeren
		else if ((cmd.getName().equalsIgnoreCase("del")) && (p.hasPermission("multiplugin.del")))
		{
			return new del(cmd, args, p, this).execute();
		}

		// sun
		else if ((cmd.getName().equalsIgnoreCase("sun")) && (p.hasPermission("multiplugin.sun")))
		{
			return new sun(cmd, args, p, this).execute();
		}

		// rain
		else if ((cmd.getName().equalsIgnoreCase("rain")) && (p.hasPermission("multiplugin.rain"))) 
		{
			return new rain(cmd, args, p, this).execute();
		}

		// thunder
		else if ((cmd.getName().equalsIgnoreCase("thunder")) && (p.hasPermission("multiplugin.thunder"))) 
		{
			return new thunder(cmd, args, p, this).execute();
		}

		// ban?
		else if ((cmd.getName().equalsIgnoreCase("ban?")) && (p.hasPermission("multiplugin.isbanned"))) 
		{
			return new isban(cmd, args, p, this).execute();
		}
		
		// isfly
		else if ((cmd.getName().equalsIgnoreCase("isfly")) && (p.hasPermission("multiplugin.isfly"))) 
		{
			return new isfly(cmd, args, p, this).execute();
		}
		
		// save
		else if ((cmd.getName().equalsIgnoreCase("save")) && (p.hasPermission("multiplugin.save")))
		{
			return new save(cmd, args, p, this).execute();
		}
	
		//hello
		else if((cmd.getName().equalsIgnoreCase("hello")) && (p.hasPermission("multiplugin.hello")))
		{
			return new hello(cmd, args, p, this).execute();
		}
		
		//GAMEMODE adventure
		else if((cmd.getName().equalsIgnoreCase("gma")) && (p.hasPermission("multiplugin.gma")))
		{
			return new gma(cmd, args, p, this).execute();
		}
		
		//GAMEMODE creative
		else if((cmd.getName().equalsIgnoreCase("gmc")) && (p.hasPermission("multiplugin.gmc")))
		{
			return new gmc(cmd, args, p, this).execute();		
		}
			
		//GAMEMODE survival
		else if((cmd.getName().equalsIgnoreCase("gms")) && (p.hasPermission("multiplugin.gms")))
		{
			return new gms(cmd, args, p, this).execute();
		}		
		
		// Zeigt die momentanen OPs an
		else if((cmd.getName().equalsIgnoreCase("ops")) && (p.hasPermission("multiplugin.ops")))
		{
			p.sendMessage("see cmd for more information");
			System.out.println("this command is currently not available");
			return false;
			//return new ops(cmd, args, p, this).execute();
		}
		
		// Zeigt die gebannten Spieler an
		else if((cmd.getName().equalsIgnoreCase("bannedp")) && (p.hasPermission("multiplugin.bannedp")))
		{
			p.sendMessage("see cmd for more information");
			System.out.println("this command is currently not available");
			return false;
			//return new bannedp(cmd, args, p, this).execute();
		}
		
		// Regeln vom Server anzeigen
		else if((cmd.getName().equalsIgnoreCase("rules")) && (p.hasPermission("multiplugin.rules")))
		{
			return new rules(cmd, args, p, this).execute();
		}
		
		// Suizide
		else if((cmd.getName().equalsIgnoreCase("suizide")) && (p.hasPermission("multiplugin.suizide")))
		{
			return new suizide(cmd, args, p, this).execute();
		}
		
		// Day
		else if((cmd.getName().equalsIgnoreCase("day")) && (p.hasPermission("multiplugin.day")))
		{
			return new day(cmd, args, p, this).execute();
		}	

		//Night
		else if((cmd.getName().equalsIgnoreCase("night")) && (p.hasPermission("multiplugin.night")))
		{
			return new night(cmd, args, p, this).execute();
		}
		
		//help mp
		else if((cmd.getName().equalsIgnoreCase("mphelp")) && (p.hasPermission("multiplugin.help")))
		{
			return new help(cmd, args, p, this).execute();
		}
		
	/**
	 *  ENDE public boolean onCommand	
	 */
		return true;
	}

	//TXT
	private boolean File(String string) 
	{
		return false;
	}

	/**
	 *  LOAD CONFIG
	 */
	private void loadConfig() 
	{
		this.getConfig().options().copyDefaults(true);
		this.saveConfig();
	}
	//Event Teil (PlayerJoinEvent)
	private void registerEvent()
	{
		mpjl = new multipluginPlayerJoinListener(this);
	}
	
	private multipluginPlayerJoinListener mpjl;
}