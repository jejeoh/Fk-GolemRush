package fr.jejeoh.azpaz.Gauto;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import fr.jejeoh.azpaz.Base;

public class GStart extends BukkitRunnable {
	
	private Base main;


	public GStart(Base main) {
		this.main = main;
	}
	
	int death = 4;
	
	@Override
	public void run() {
		for(Player player : main.getDeath()) {

		
			death = death-1;
			
			player.sendMessage("§4Il vous reste " + death + " s");
			
			if(death == 0) {
				
				death = 4;

				main.getDeath().remove(player);
	
				if(main.getBlue().contains(player)) {
					Location blue = new Location(Bukkit.getWorld("world"), -104.5, 65, -9.5, 179.5f, 0.5f);
					player.teleport(blue);
					player.sendMessage("§1Vous venez d'être teleporter");
					player.setGameMode(GameMode.SURVIVAL);

		
					
				}
				else if(main.getRed().contains(player)) {
					Location red = new Location(Bukkit.getWorld("world"), -240.5, 65, -94.5, 0.5f, -1f);
					player.teleport(red);
					player.sendMessage("§1Vous venez d'être teleporter");
					player.setGameMode(GameMode.SURVIVAL);

				}
				
				cancel();
			}
		}
	}

}
