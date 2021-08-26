package fr.jejeoh.azpaz.listener;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

import fr.jejeoh.azpaz.Base;
import fr.jejeoh.azpaz.Gauto.GStart;
import fr.jejeoh.azpaz.Gauto.Gstate;

public class event implements Listener {

	private Base main;
	
	public event(Base main) {
		this.main = main;
	}
	
	
	
	@EventHandler
	public void onBreak(BlockBreakEvent e) {
		
		Player player = e.getPlayer();
		
		if(player.getGameMode().equals(GameMode.CREATIVE)) return;

		
		if(main.isState(Gstate.WAITING) || main.isState(Gstate.STARTING) || main.isState(Gstate.FINISH)) {
			e.setCancelled(true);
			
			player.sendMessage("§4Vous avez pas le droit !");
			return;
		}else if (main.isState(Gstate.RESSOURCE)) {

		        int px = player.getLocation().getBlockX();
		        int py = player.getLocation().getBlockY();
		        int pz = player.getLocation().getBlockZ();
		        
		        int spawnx1 = 12;
		        int spawny1 = 207;
		        int spawnz1 = 12;
		        int spawnx2 = -12;
		        int spawny2 = 195;
		        int spawnz2 = -12;
		        
		        int arenax1 = -47;
		        int arenay1 = 54;
		        int arenaz1 = 4;
		        int arenax2 = -295;
		        int arenay2 = 120;
		        int arenaz2 = -105;


		        
		        if(px <= spawnx1 && py <= spawny1 && pz <= spawnz1 && px >= spawnx2 && py >= spawny2 && pz >= spawnz2){
		        	player.sendMessage("§4Vous n'avez pas le droit de detruire");
		        	e.setCancelled(true);
		        }
		        else if(px <= arenax1 && py >= arenay1 && pz <= arenaz1 && px >= arenax2 && py <= arenay2 && pz >= arenaz2){
		        	player.sendMessage("§4Vous n'avez pas le droit de detruire");
		        	e.setCancelled(true);
		        }
		}
			else if (main.isState(Gstate.PVP)) {
		        int px = player.getLocation().getBlockX();
		        int py = player.getLocation().getBlockY();
		        int pz = player.getLocation().getBlockZ();
		        
		        int arenax1 = -47;
		        int arenay1 = 54;
		        int arenaz1 = 4;
		        int arenax2 = -295;
		        int arenay2 = 120;
		        int arenaz2 = -105;
		        if(!(px <= arenax1 && py >= arenay1 && pz <= arenaz1 && px >= arenax2 && py <= arenay2 && pz >= arenaz2)){
		        	player.sendMessage("§4Vous n'avez pas le droit de detruire la map dans la mine");
		        	e.setCancelled(true);
		        }
			}

		
	}
	@EventHandler
	public void setBlock(BlockPlaceEvent e) {
		Player player = e.getPlayer();
		
		if(player.getGameMode().equals(GameMode.CREATIVE)) return;

		
        int px = player.getLocation().getBlockX();
        int py = player.getLocation().getBlockY();
        int pz = player.getLocation().getBlockZ();
        
        
        
        
        
        int arenax1 = -47;
        int arenay1 = 54;
        int arenaz1 = 4;
        int arenax2 = -295;
        int arenay2 = 120;
        int arenaz2 = -105;

		if(main.isState(Gstate.WAITING) || main.isState(Gstate.STARTING) || main.isState(Gstate.FINISH)) {
			if(player.getGameMode().equals(GameMode.CREATIVE)) return;
				
			player.sendMessage("§4Imossible de faire l'acction");
			e.setCancelled(true);
			return;
		} else if (main.isState(Gstate.RESSOURCE)) {
			if(px <= arenax1 && py >= arenay1 && pz <= arenaz1 && px >= arenax2 && py <= arenay2 && pz >= arenaz2){
				e.setCancelled(true);

			} else {
				return;
			}

			
			
		}else if(main.isState(Gstate.PVP)) {

	        if(!(px <= arenax1 && py >= arenay1 && pz <= arenaz1 && px >= arenax2 && py <= arenay2 && pz >= arenaz2)){
	        	player.sendMessage("§4Vous n'avez pas le droit de construire la map dans la mine ou le champ");
	        	e.setCancelled(true);
	        }
			else if(main.getAttack().contains(player)) {
				if(px <= arenax1 && py >= arenay1 && pz <= arenaz1 && px >= arenax2 && py <= arenay2 && pz >= arenaz2){
					player.sendMessage("§4Vous avez pas choisi le bon role ! Votre role ne permet pas cela");
					e.setCancelled(true);
					return;
				} else {
					return;
				}
			}
		}
		
	}
	
	@EventHandler
	public void setDamage(EntityDamageByEntityEvent e) {
		Entity en = e.getEntity();
		Entity damage = e.getDamager();
		double dame = e.getDamage();
		
		
		
		if(en instanceof Villager) {
			e.setCancelled(true);
			if(damage instanceof Player) {
				
				if(!main.isState(Gstate.PVP)) return;
				
				
				Player p = (Player) e.getDamager();
				if(main.getDefender().contains(p)) {
					p.sendMessage("§4Vous etes deffenseur, vous etes pas senser pouvoir attaquer !");
					return;
				}
				
				
		        int px = p.getLocation().getBlockX();
		        int py = p.getLocation().getBlockY();
		        int pz = p.getLocation().getBlockZ();
		        
		        
		        int spawnx1 = -82;
		        int spawny1 = 75;
		        int spawnz1 = -44;
		        int spawnx2 = -72;
		        int spawny2 = 80;
		        int spawnz2 = -56;
		        
		        
		        int arenax1 = -258;
		        int arenay1 = 75;
		        int arenaz1 = -47;
		        int arenax2 = -274;
		        int arenay2 = 80;
		        int arenaz2 = -62;
				
				if(px <= arenax1 && py >= arenay1 && pz <= arenaz1 && px >= arenax2 && py <= arenay2 && pz >= arenaz2 && main.getBlue().contains(p)){
					

					main.redvil = (int) (main.redvil - dame);

				}
				else if(px >= spawnx1 && py >= spawny1 && pz <= spawnz1 && px <= spawnx2 && py <= spawny2 && pz >= spawnz2 && main.getRed().contains(p)){
					

					main.bluevil = (int) (main.bluevil - dame);

				}
				else if(px <= arenax1 && py >= arenay1 && pz <= arenaz1 && px >= arenax2 && py <= arenay2 && pz >= arenaz2 && main.getRed().contains(p)){
					p.sendMessage("§4Vous ne pouvez pas tapper votre propre villageois!");
				
				}
				else if(px >= spawnx1 && py >= spawny1 && pz <= spawnz1 && px <= spawnx2 && py <= spawny2 && pz >= spawnz2 && main.getBlue().contains(p)){
					p.sendMessage("§4Vous ne pouvez pas tapper votre propre villageois!");

				}

				else if (px <= arenax1 && py >= arenay1 && pz <= arenaz1 && px >= arenax2 && py <= arenay2 && pz >= arenaz2 || px >= spawnx1 && py >= spawny1 && pz <= spawnz1 && px <= spawnx2 && py <= spawny2 && pz >= spawnz2) {
					
					p.sendMessage("choisissait une team");
				} else {
					p.kickPlayer("Raison : reach");
				}


				
			}
		
		}
		else if(en instanceof Player && main.getGold().contains(en)) {
			e.setCancelled(true);
		}
		
		else if(en instanceof Player && main.isState(Gstate.WAITING) || main.isState(Gstate.STARTING) || main.isState(Gstate.FINISH) || main.isState(Gstate.RESSOURCE)) {
			e.setCancelled(true);
		}
		else if(en instanceof Player && damage instanceof Player) {
			
			if(main.getRed().contains(en) && main.getRed().contains(damage)) {
				e.setCancelled(true);
			}
			else if(main.getBlue().contains(en) && main.getBlue().contains(damage)) {
				e.setCancelled(true);
			}
			else {
				e.setDamage(dame*3);
			
			}
			
		}
		
		
		
		
		



	}
	
	@EventHandler
	public void onDrop(PlayerDropItemEvent e) {
		
		Player p = e.getPlayer();
		
				
		
		if(main.isState(Gstate.WAITING) || main.isState(Gstate.STARTING) ) {
			e.setCancelled(true);
			p.sendMessage("§4Vous ne pouvez pas effectuer l'action demander");

		}
		
		

		
		
		
	}

   @EventHandler
   public void onDeath(PlayerDeathEvent e) {
	   e.setKeepInventory(true);
	   e.setKeepLevel(true);
	   Player player = e.getEntity();
	   player.setHealth(20);
	   player.setFoodLevel(20);
	   player.setGameMode(GameMode.ADVENTURE);
	   main.getDeath().add(player);
		Location spawn = new Location(Bukkit.getWorld("world"), 0.5, 201, 0.5, -90f, 0f);
		player.teleport(spawn);
	   GStart start = new GStart(main);
	   start.runTaskTimer(main, 0, 20);
	   

   }

	

	
	
	
	
}
