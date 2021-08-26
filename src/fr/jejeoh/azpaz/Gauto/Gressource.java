package fr.jejeoh.azpaz.Gauto;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import fr.jejeoh.azpaz.Base;


public class Gressource extends BukkitRunnable {
	
	private Base main;
	
	
	public Gressource(Base main) {
		this.main = main; 
	}
	
	@Override
	public void run() {
		
		if(main.timersec == -1) {
			if(main.timermin == 0) {
				cancel();
				
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "time set day");
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "weather clear");
				Grpvp cycle = new Grpvp(main);
				cycle.runTaskTimer(main, 0, 1);

				
				Bukkit.broadcastMessage("§eLa phase pvp commence veuiller vos pouvoir entre en jeu !");
				
				main.setState(Gstate.PVP);
				
				for(Player pls : main.getBlue()) {
					
					Location blue = new Location(Bukkit.getWorld("world"), -104.5, 65, -9.5, 179.5f, 0.5f);
					pls.teleport(blue);
					pls.setBedSpawnLocation(blue);

					cancel();
				
				}
				
				for(Player pls : main.getRed()) {
					
					Location red = new Location(Bukkit.getWorld("world"), -240.5, 65, -94.5, 0.5f, -1f);
					pls.teleport(red);
					pls.setBedSpawnLocation(red);

					cancel();

				}
			}
			else {
				
				Bukkit.broadcastMessage("§1Il reste plus que " + main.timermin + " min !");
				
				main.timersec = 59;
				main.timermin = main.timermin-1;
			}
		}
		

		for(Player ply : main.getBlue()) {
			final ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
			final Scoreboard scoreboard = scoreboardManager.getNewScoreboard();
			final Objective objetctive = scoreboard.registerNewObjective("general", "dummy");
			
			objetctive.setDisplayName(ChatColor.AQUA + "JejeohGame");
			objetctive.setDisplaySlot(DisplaySlot.SIDEBAR);
			
			final Score equipe = objetctive.getScore(ChatColor.BLUE + "TU ES BLEU");
			final Score eguale = objetctive.getScore(ChatColor.GOLD + "===============");
			final Score eguale2 = objetctive.getScore(ChatColor.GOLD + "=============== ");
			final Score timer = objetctive.getScore(ChatColor.RED + "Timer : " + main.timermin + " m et " + main.timersec + " s");
			final Score pub = objetctive.getScore(ChatColor.DARK_GRAY+ "by jeje oh");

			pub.setScore(0);
			
			eguale.setScore(5);
			equipe.setScore(4);
			timer.setScore(3);
			eguale2.setScore(2);

			
			
			ply.setScoreboard(scoreboard);
		}
		for(Player ply : main.getRed()) {
			final ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
			final Scoreboard scoreboard = scoreboardManager.getNewScoreboard();
			final Objective objetctive = scoreboard.registerNewObjective("general", "dummy");
			
			objetctive.setDisplayName(ChatColor.AQUA + "JejeohGame");
			objetctive.setDisplaySlot(DisplaySlot.SIDEBAR);
			
			final Score equipe = objetctive.getScore(ChatColor.RED + "TU ES ROUGE");
			final Score eguale = objetctive.getScore(ChatColor.GOLD + "===============");
			final Score eguale2 = objetctive.getScore(ChatColor.GOLD + "=============== ");
			final Score timer = objetctive.getScore(ChatColor.BLUE + "Timer : " + main.timermin + " m et " + main.timersec + " s");
			final Score pub = objetctive.getScore(ChatColor.DARK_GRAY+ "by jeje oh");

			pub.setScore(0);
			
			eguale.setScore(5);
			equipe.setScore(4);
			timer.setScore(3);
			eguale2.setScore(2);

			
			
			ply.setScoreboard(scoreboard);
		}
		



		main.timersec--;
		
	}
}
