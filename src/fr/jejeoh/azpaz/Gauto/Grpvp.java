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


public class Grpvp extends BukkitRunnable {
	
	private Base main;
	
	
	public Grpvp(Base main) {
		this.main = main; 
	}
	public void run() {
		
		for(Player pls : main.getPlayers()) {
			
			final ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
			final Scoreboard scoreboard = scoreboardManager.getNewScoreboard();
			final Objective objetctive = scoreboard.registerNewObjective("general", "dummy");
			
			objetctive.setDisplayName(ChatColor.AQUA + "JejeohGame");
			objetctive.setDisplaySlot(DisplaySlot.SIDEBAR);
			
			final Score eguale = objetctive.getScore(ChatColor.GOLD + "====================");
			final Score red = objetctive.getScore(ChatColor.RED + "PV Villageois Rouge " + main.redvil);
			final Score blue = objetctive.getScore(ChatColor.BLUE + "PV Villageois Bleu " + main.bluevil);
			final Score eguale2 = objetctive.getScore(ChatColor.GOLD + "==================== ");
			final Score pub = objetctive.getScore(ChatColor.DARK_GRAY+ "by jeje oh");

			pub.setScore(1);
			eguale.setScore(5);
			red.setScore(4);
			blue.setScore(3);
			eguale2.setScore(2);
			
			
			pls.setScoreboard(scoreboard);
			
		}
		if(main.redvil <= 0) {
			cancel();
			main.setState(Gstate.FINISH);
			Bukkit.broadcastMessage("§1Les bleu ont gagner");
			for(Player pls : main.getPlayers()) {
				
				Location blue = new Location(Bukkit.getWorld("world"), -120.5, 20, 65.5, 1.3f, -2f);
				pls.teleport(blue);
				pls.getInventory().clear();
				
				final ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
				final Scoreboard scoreboard = scoreboardManager.getNewScoreboard();
				final Objective objetctive = scoreboard.registerNewObjective("general", "dummy");
				
				objetctive.setDisplayName(ChatColor.AQUA + "JejeohGame");
				objetctive.setDisplaySlot(DisplaySlot.SIDEBAR);
				final Score eguale2 = objetctive.getScore(ChatColor.GOLD + "==================== ");

				final Score red = objetctive.getScore(ChatColor.BLUE + "Les bleu ont gagner");
				final Score eguale = objetctive.getScore(ChatColor.GOLD + "====================");
				final Score pub = objetctive.getScore(ChatColor.DARK_GRAY+ "by jeje oh");

				pub.setScore(1);
				eguale2.setScore(4);
				red.setScore(3);
				eguale.setScore(2);
				
				
				pls.setScoreboard(scoreboard);
				
			
			}
		}
		if(main.bluevil <= 0) {
			cancel();
			main.setState(Gstate.FINISH);
			Bukkit.broadcastMessage("§4Les rouge ont gagner");
			for(Player pls : main.getPlayers()) {
				
				Location blue = new Location(Bukkit.getWorld("world"), -110.5, 19, 20.5, 1.3f, -2f);
				pls.teleport(blue);
				pls.getInventory().clear();
				
				final ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
				final Scoreboard scoreboard = scoreboardManager.getNewScoreboard();
				final Objective objetctive = scoreboard.registerNewObjective("general", "dummy");
				
				objetctive.setDisplayName(ChatColor.AQUA + "JejeohGame");
				objetctive.setDisplaySlot(DisplaySlot.SIDEBAR);
				
				final Score eguale2 = objetctive.getScore(ChatColor.GOLD + "=============== ");
				final Score red = objetctive.getScore(ChatColor.RED + "Les rouge ont gagner");
				final Score eguale = objetctive.getScore(ChatColor.GOLD + "===============");
				final Score pub = objetctive.getScore(ChatColor.DARK_GRAY+ "by jeje oh");


				
				pub.setScore(1);
				eguale2.setScore(4);
				red.setScore(3);
				eguale.setScore(2);
				
				
				pls.setScoreboard(scoreboard);
				
			
			}
		}
	}
}
