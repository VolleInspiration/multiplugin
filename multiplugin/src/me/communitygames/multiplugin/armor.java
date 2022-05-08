package me.communitygames.multiplugin;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class armor
{
	multiplugin plugin;
	Command cmd;
	String[] args;
	Player p;

	public armor(Command cmd, String[] args, Player p, multiplugin plugin)
	{
		this.cmd = cmd;
		this.args = args;
		this.p = p;
		this.plugin = plugin;
	}
	
	public boolean execute()
	{
		if (args.length == 0) 
		{
			p.sendMessage(/*_languages.getText(getArmorEN) +*/ ChatColor.YELLOW + "[multiplugin] " + ChatColor.GREEN + "You get Armor and Sword of Diamond!");
			p.getInventory().setHelmet(new ItemStack(Material.DIAMOND_HELMET, 1));
			p.getInventory().setBoots(new ItemStack(Material.DIAMOND_BOOTS, 1));
			p.getInventory().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE, 1));
			p.getInventory().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS, 1));
			p.getInventory().addItem(new ItemStack(Material.DIAMOND_SWORD, 1));
			return true;
		}
		
		if (args.length != 0) 
		{
			p.sendMessage(ChatColor.YELLOW + "[multiplugin] " + ChatColor.RED + "Wrong input! Use /armor");
			return false;
		}
		return false;
	}
}