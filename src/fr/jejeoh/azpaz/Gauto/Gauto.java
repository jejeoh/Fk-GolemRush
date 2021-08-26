package fr.jejeoh.azpaz.Gauto;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import fr.jejeoh.azpaz.Base;


public class Gauto extends BukkitRunnable {

	private Base main;
	private int timer = 10;
	
	public Gauto(Base main) {
		this.main = main;
	}

	@Override
	public void run() {
		for(Player pls : Bukkit.getOnlinePlayers()) {
			pls.setLevel(timer);
		}
		
		if(timer==10 || timer==5 || timer==4 || timer==3 || timer==2 || timer==1) {
			Bukkit.broadcastMessage("Lancement du jeu dans " + timer + "s");
		}
		
		if(timer==0) {
			Bukkit.broadcastMessage("§dLancement du jeu");
			main.setState(Gstate.RESSOURCE);
			cancel();
			

			
			for(Player pls : main.getBlue()) {
			
				Location blue = new Location(Bukkit.getWorld("world"), -104.5, 65, -9.5, 179.5f, 0.5f);
				pls.teleport(blue);
				pls.getInventory().clear();
				cancel();
			
			}
			
			for(Player pls : main.getRed()) {
				
				Location red = new Location(Bukkit.getWorld("world"), -240.5, 65, -94.5, 0.5f, -1f);
				pls.teleport(red);


				pls.getInventory().clear();
				cancel();

			}
			
			Gressource cycle = new Gressource(main);
			cycle.runTaskTimer(main, 0, 20);
			
		}
		
		timer--;
	}

}
//-104.5 64 -9.5