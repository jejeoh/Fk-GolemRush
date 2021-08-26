package fr.jejeoh.azpaz.listener;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.jejeoh.azpaz.Base;
import fr.jejeoh.azpaz.Gauto.Gstate;

public class Listenaire implements Listener {

	private Base main;
	
	public Listenaire(Base main) {
		this.main = main;
	}
	@EventHandler
	public void OnJoin(PlayerJoinEvent e) {
		Player player = e.getPlayer();
		Location spawn = new Location(Bukkit.getWorld("world"), 0.5, 201, 0.5, -90f, 0f);
		
		
		if(!main.isState(Gstate.WAITING)) {
			if(main.getPlayers().contains(player)) return;
			player.setGameMode(GameMode.SPECTATOR);
			player.sendMessage("Le jeu est deja en cour de route !");
			e.setJoinMessage(null);
			return;
		}
		
		if(!main.getPlayers().contains(player)) {
			main.getPlayers().add(player);
		}
		if(!main.getSans().contains(player)) {
			main.getSans().add(player);
		}
		if(!main.getSans2().contains(player)) {
			main.getSans2().add(player);
		}
		player.getInventory().clear();
		player.setFoodLevel(20);
		player.setHealth(20);
		player.teleport(spawn);
		player.setGameMode(GameMode.SURVIVAL);
		e.setJoinMessage("§4" + player.getName() + "§e s'est connecter §4" + main.getPlayers().size() + "/8 !");
		
		
		ItemStack choise = new ItemStack(Material.WOOL,1);
		ItemMeta chois = choise.getItemMeta();
		chois.setDisplayName("§1Choisir une equipe §f(Click droit)");
		choise.setItemMeta(chois);
		
		ItemStack role = new ItemStack(Material.NAME_TAG,1);
		ItemMeta row = role.getItemMeta();
		row.setDisplayName("§1Choisir une role §f(Click droit)");
		role.setItemMeta(row);
		player.getInventory().setItem(6, role);

		player.getInventory().setItem(2, choise);
		

	}
	@EventHandler
	public void OnQuit(PlayerQuitEvent e) {
		Player player = e.getPlayer();
		if(main.isState(Gstate.WAITING)) {
			if(main.getPlayers().contains(player)) {
				main.getPlayers().remove(player);
				return;
			}
			if(main.getSans().contains(player)) {
				main.getSans().remove(player);
				return;
			}
			if(main.getSans2().contains(player)) {
				main.getSans2().remove(player);
				return;
			}
		}

		
	}
	@EventHandler
	public void OnInteract(PlayerInteractEvent e) {
		
		Player player = e.getPlayer();
		ItemStack it = e.getItem();
		
		if(it == null) {
			return;
		}
		
		


				
			
		
		if(it.getType() == Material.WOOL && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("§1Choisir une equipe §f(Click droit)")) {
			Inventory team = Bukkit.createInventory(null, 27, "§7Chosir les equipes");
			
			
			String contien = "";
			String contienr = "";
			
			if(main.getBlue().contains(player)) {
				contien = "§4Vous êtes deja la dedans";
			} else {
				contien = "§bRejoindre les bleu";
			}
			
			if(main.getRed().contains(player)) {
				contienr = "§4Vous êtes deja la dedans";
			} else {
				contienr = "§bRejoindre les rouge";
			}
			
			ItemStack blue = new ItemStack(Material.LAPIS_BLOCK ,main.getBlue().size());
			ItemMeta bleu = blue.getItemMeta();
			bleu.setDisplayName("§1choisir la team bleu");
			bleu.setLore(Arrays.asList(contien, "", "§7click pour rejoindre"));
			
			blue.setItemMeta(bleu);
			
			ItemStack red = new ItemStack(Material.REDSTONE_BLOCK ,main.getRed().size());
			ItemMeta rouge = red.getItemMeta();
			rouge.setDisplayName("§4choisir la team rouge");
			rouge.setLore(Arrays.asList(contienr, "", "§7click pour rejoindre"));
			
			red.setItemMeta(rouge);
			
			ItemStack rien = new ItemStack(Material.STAINED_GLASS_PANE ,1);
			ItemMeta r = rien.getItemMeta();
			r.setDisplayName(" ");
			
			rien.setItemMeta(r);
			
			team.setItem(0, rien);
			team.setItem(1, rien);
			team.setItem(2, rien);
			team.setItem(3, rien);
			team.setItem(4, rien);
			team.setItem(5, rien);
			team.setItem(6, rien);
			team.setItem(7, rien);
			team.setItem(8, rien);
			team.setItem(9, rien);
			team.setItem(10, rien);
			team.setItem(11, blue);
			team.setItem(12, rien);
			team.setItem(13, rien);
			team.setItem(14, rien);
			team.setItem(15, red);
			team.setItem(16, rien);
			team.setItem(17, rien);
			team.setItem(18, rien);
			team.setItem(19, rien);
			team.setItem(20, rien);
			team.setItem(21, rien);
			team.setItem(22, rien);
			team.setItem(23, rien);
			team.setItem(24, rien);
			team.setItem(25, rien);
			team.setItem(26, rien);

			
			player.openInventory(team);
		}
		if(it.getType() == Material.NAME_TAG && it.hasItemMeta() && it.getItemMeta().hasDisplayName() && it.getItemMeta().getDisplayName().equalsIgnoreCase("§1Choisir une role §f(Click droit)")) {
			
			Inventory role = Bukkit.createInventory(null, 27, "§7Chosir les role");
			
			
			String contien = "";
			String contienr = "";
			
			if(main.getAttack().contains(player)) {
				contien = "§4Vous êtes deja la dedans";
			} else {
				contien = "§bRejoindre les attaquant";
			}
			
			if(main.getDefender().contains(player)) {
				contienr = "§4Vous êtes deja la dedans";
			} else {
				contienr = "§bRejoindre les deffenseur";
			}
			
			ItemStack blue = new ItemStack(Material.DIAMOND_SWORD ,main.getAttack().size());
			ItemMeta bleu = blue.getItemMeta();
			bleu.setDisplayName("§1choisir le role attaquanr");
			bleu.setLore(Arrays.asList(contien, "§5Vous pouvez attaquer le villageois de l'equipe adverse mais vous ne pouvez pas poser des bloc chez vous", "§7click pour rejoindre"));
			
			blue.setItemMeta(bleu);
			
			ItemStack red = new ItemStack(Material.DIAMOND_PICKAXE ,main.getDefender().size());
			ItemMeta rouge = red.getItemMeta();
			rouge.setDisplayName("§1choisir le role defenseur");
			rouge.setLore(Arrays.asList(contienr, "§5Vous ne pouvez pas attaquer le villageois de l'equipe adverse mais vous pouvez poser des bloc chez vous", "§7click pour rejoindre"));
			
			red.setItemMeta(rouge);
			
			ItemStack rien = new ItemStack(Material.STAINED_GLASS_PANE ,1);
			ItemMeta r = rien.getItemMeta();
			r.setDisplayName(" ");
			
			rien.setItemMeta(r);
			
			role.setItem(0, rien);
			role.setItem(1, rien);
			role.setItem(2, rien);
			role.setItem(3, rien);
			role.setItem(4, rien);
			role.setItem(5, rien);
			role.setItem(6, rien);
			role.setItem(7, rien);
			role.setItem(8, rien);
			role.setItem(9, rien);
			role.setItem(10, rien);
			role.setItem(11, blue);
			role.setItem(12, rien);
			role.setItem(13, rien);
			role.setItem(14, rien);
			role.setItem(15, red);
			role.setItem(16, rien);
			role.setItem(17, rien);
			role.setItem(18, rien);
			role.setItem(19, rien);
			role.setItem(20, rien);
			role.setItem(21, rien);
			role.setItem(22, rien);
			role.setItem(23, rien);
			role.setItem(24, rien);
			role.setItem(25, rien);
			role.setItem(26, rien);

			
			
			player.openInventory(role);
		}
		
	}
	@EventHandler
	public void OnClick(InventoryClickEvent e) {
		
		Inventory inv = e.getInventory();
		Player player = (Player) e.getWhoClicked();
		ItemStack current = e.getCurrentItem();
		
		if (current == null) return;
		
		if(inv.getName().equalsIgnoreCase("§7Chosir les equipes")) {
			
			e.setCancelled(true);
			
			if(current.getType()==Material.LAPIS_BLOCK) {
				player.closeInventory();
				if(main.getBlue().contains(player)) return;
				main.getBlue().add(player);
				if(main.getRed().contains(player)) {
				main.getRed().remove(player);
				}
				if(main.getSans().contains(player)) {
					main.getSans().remove(player);
				}


			}
			
			if(current.getType()==Material.REDSTONE_BLOCK) {
				player.closeInventory();
				if(main.getRed().contains(player)) return;
				main.getRed().add(player);
				if(main.getBlue().contains(player)) {
				main.getBlue().remove(player);
				}
				if(main.getSans().contains(player)) {
					main.getSans().remove(player);
				}
			}
			
		}
		if(inv.getName().equalsIgnoreCase("§7Chosir les role")) {
			
			e.setCancelled(true);
			
			if(current.getType()==Material.DIAMOND_SWORD) {
				player.closeInventory();
				if(main.getAttack().contains(player)) return;
				main.getAttack().add(player);
				if(main.getDefender().contains(player)) {
				main.getDefender().remove(player);
				}
				if(main.getSans2().contains(player)) {
					main.getSans2().remove(player);
				}
			}
			
			if(current.getType()==Material.DIAMOND_PICKAXE) {
				player.closeInventory();
				if(main.getDefender().contains(player)) return;
				main.getDefender().add(player);
				if(main.getAttack().contains(player)) {
				main.getAttack().remove(player);
				}
				if(main.getSans2().contains(player)) {
					main.getSans2().remove(player);
				}
			}
			
		}
		
	}
	
	

	
	
}
