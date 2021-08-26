package fr.jejeoh.azpaz.command;

import java.util.Iterator;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;

public class Commandextra implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		
		
		if(sender instanceof Player) {
			Player player = (Player)sender;
			
			
			if(cmd.getName().equalsIgnoreCase("feed")) {
				
				if(player.getFoodLevel() >= 20) {
					player.sendMessage("§4Vous etes deja plein en nourriture !");
					return true;
				}
				player.setFoodLevel(100);
				player.sendMessage("§6Vous venez d'etre plein dans la nourriture !");
			}
			else if(cmd.getName().equalsIgnoreCase("furnace")) {
								
				ItemStack resultat = null;
				final ItemStack baseItem = player.getItemInHand();
				final Iterator<Recipe> i = Bukkit.recipeIterator();	
				while(i.hasNext()) {
					Recipe r = i.next();
					if(!(r instanceof FurnaceRecipe)) continue;
					FurnaceRecipe fr =(FurnaceRecipe)r;
					if(fr.getInput().getType() != baseItem.getType()) continue;
					resultat = fr.getResult();
					break;
				}
				if(resultat != null) {
					sender.sendMessage("§aTu as bien fait cuire x" + baseItem.getAmount()+ " " + baseItem.getType().name());
					ItemStack vrai = new ItemStack(resultat.getType(), baseItem.getAmount());
					player.setItemInHand(vrai);
				}else {
					sender.sendMessage("§4Attention, cet item ne peut pas etre cuit.");
				}
			}
			

		}
		return false;
	}

}
