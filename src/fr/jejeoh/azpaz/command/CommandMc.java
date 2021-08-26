package fr.jejeoh.azpaz.command;


import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.jejeoh.azpaz.Base;
import fr.jejeoh.azpaz.Gauto.Gauto;
import fr.jejeoh.azpaz.Gauto.Gstate;


public class CommandMc implements CommandExecutor {

	private Base main;

	
	public CommandMc(Base main) {
		this.main = main;
	}

	


	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		if(sender instanceof Player) {
			Player player = (Player)sender;
			
	        int px = player.getLocation().getBlockX();
	        int py = player.getLocation().getBlockY();
	        int pz = player.getLocation().getBlockZ();
	        
	        int arenax1 = -47;
	        int arenay1 = 54;
	        int arenaz1 = 4;
	        int arenax2 = -295;
	        int arenay2 = 120;
	        int arenaz2 = -105;
	        
			
			
			if(cmd.getName().equalsIgnoreCase("spawn")) {
				
				
				if(main.isState(Gstate.RESSOURCE)) {
					if(main.getBlue().contains(player)) {
						Location blue = new Location(Bukkit.getWorld("world"), -104.5, 65, -9.5, 179.5f, 0.5f);
						player.teleport(blue);
						player.sendMessage("§1Vous venez d'être teleporter");

						
					}
					else if(main.getRed().contains(player)) {
						Location red = new Location(Bukkit.getWorld("world"), -240.5, 65, -94.5, 0.5f, -1f);
						player.teleport(red);
						player.sendMessage("§1Vous venez d'être teleporter");
					}else {
						player.sendMessage("§4Une erreur est durvenue merci de contacter un administrateur pour le tp");
					}
				}else if(!(px <= arenax1 && py >= arenay1 && pz <= arenaz1 && px >= arenax2 && py <= arenay2 && pz >= arenaz2)){
					if(main.getBlue().contains(player)) {
						Location blue = new Location(Bukkit.getWorld("world"), -104.5, 65, -9.5, 179.5f, 0.5f);
						player.teleport(blue);
						player.sendMessage("§1Vous venez d'être teleporter");

						
					}
					else if(main.getRed().contains(player)) {
						Location red = new Location(Bukkit.getWorld("world"), -240.5, 65, -94.5, 0.5f, -1f);
						player.teleport(red);
						player.sendMessage("§1Vous venez d'être teleporter");
					}else {
						player.sendMessage("§4Une erreur est durvenue merci de contacter un administrateur pour le tp");
					}
		        }
				else {
					player.sendMessage("§4Cette commande est disponible que pendant la fase des ressource !");
				}
				
			}
			else if(cmd.getName().equalsIgnoreCase("start")) {
				
				if(!(main.getSans().size() == 0)) {
					player.sendMessage("§4Il faut que " + main.getSans() + "choisisse une equipe !");;
					return false;
				}
				if(!(main.getSans2().size() == 0)) {
					player.sendMessage("§4Il faut que " + main.getSans2() + "choisisse un kit !");;
					return false;
				}
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "difficulty peaceful");
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "time set day");
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "weather clear");


				if(main.isState(Gstate.WAITING)) {
					
				
				Gauto start = new Gauto(main);
				start.runTaskTimer(main, 0, 20);
				main.setState(Gstate.STARTING);
				}
			}
			else if(cmd.getName().equalsIgnoreCase("best")) {
					if(args.length == 0) {
						if(!main.getGold().contains(player)) {
							player.sendMessage("§1Votre gold mod est activer");

							main.getGold().add(player);
						} else {
							main.getGold().remove(player);
							player.sendMessage("§1Votre gold mod est desactiver");


						}
					}if(args.length == 1) {
						
						String targetName = args[0];
						
						 if(Bukkit.getPlayer(targetName) != null) {
							Player target = Bukkit.getPlayer(targetName);
							
							if(main.getGold().contains(target)) {
								main.getGold().remove(target);
								target.sendMessage("§1Votre gold mod est desactiver");
								player.sendMessage("§1Le gold mod a " + targetName + "est desactiver");

							}else {
								main.getGold().add(target);
								target.sendMessage("§1Votre gold mod est activer");
								player.sendMessage("§1Le gold mod a " + targetName + "est activer");
							}
								
							}
					}
				}
			else if(cmd.getName().equalsIgnoreCase("force")) {
				if(main.isState(Gstate.RESSOURCE)) {
					main.timersec =  10;
					main.timermin = 0;
				}else {
					player.sendMessage("§4Ceci est disponible que durant la phase ressource");
				}
			}
			else if(cmd.getName().equalsIgnoreCase("mine")) {
				
				if(main.isState(Gstate.RESSOURCE)) {
				player.sendMessage("§7Vous avez était teleporter a la mine");
				Location mine = new Location(Bukkit.getWorld("world"), -318, 86, 296);
				player.teleport(mine);
				}
				else {
					player.sendMessage("§4Cette commande est faite pour le moment de recuperation de ressource!");
				}
			}
			else if(cmd.getName().equalsIgnoreCase("pre")) {
				if(main.isState(Gstate.RESSOURCE)) {
						Location mine = new Location(Bukkit.getWorld("world"), -75.5, 77, 63.5);
						player.teleport(mine);
						player.sendMessage("§7Vous avez était teleporter au pre");
					}
					else {
						player.sendMessage("§4Cette commande est faite pour le moment de recuperation de ressource!");
					}
				
			}





				
			
		}
		
		else {
			sender.sendMessage("§4Les commandes sont faite pour les joueur!");
		}
		
		
		return false;
	}

}
