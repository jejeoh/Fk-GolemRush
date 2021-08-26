package fr.jejeoh.azpaz;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import fr.jejeoh.azpaz.Gauto.Gstate;
import fr.jejeoh.azpaz.command.CommandMc;
import fr.jejeoh.azpaz.command.Commandextra;
import fr.jejeoh.azpaz.listener.Listenaire;
import fr.jejeoh.azpaz.listener.event;

public class Base extends JavaPlugin {
	
	private static Base instance;
	
	private List<Player> players = new ArrayList<>();
	private List<Player> blue = new ArrayList<>();
	private List<Player> red = new ArrayList<>();
	private List<Player> defender = new ArrayList<>();	
	private List<Player> attack = new ArrayList<>();
	private List<Player> gold = new ArrayList<>();
	private List<Player> playersans = new ArrayList<>();
	private List<Player> playersans2 = new ArrayList<>();
	private List<Player> death = new ArrayList<>();


	
	public int bluevil = 500;
	public int redvil = 500;
	public int timersec = 59;
	public int timermin = 9;


	
	private Gstate state;
	
	@Override
	public void onEnable() {
		
		
		
		instance = this;
		setState(Gstate.WAITING);

	    getServer().getPluginManager().registerEvents(new Listenaire(this), this);
	    getServer().getPluginManager().registerEvents(new event(this), this);

		
		System.out.println("Le jeu est en trein de démarrer");
		getCommand("spawn").setExecutor(new CommandMc(this));
		getCommand("start").setExecutor(new CommandMc(this));
		getCommand("feed").setExecutor(new Commandextra());
		getCommand("furnace").setExecutor(new Commandextra());
		getCommand("mine").setExecutor(new CommandMc(this));
		getCommand("pre").setExecutor(new CommandMc(this));
		getCommand("best").setExecutor(new CommandMc(this));	
		getCommand("force").setExecutor(new CommandMc(this));	





	}
	public void onDisable() {
		System.out.println("[OhPlugin]Le OhPlugin c'est bien etenit !!!");
		WorldManager.replaceWorld(true);
	}
	
	public void setState(Gstate state) {
		this.state = state;
	}
	
	public boolean isState(Gstate state) {
		return this.state == state;
	}
	
	public List<Player> getPlayers(){
		return players;
	}
	public List<Player> getBlue(){
		return blue;
	}
	public List<Player> getRed(){
		return red;
	}
	public List<Player> getSans(){
		return playersans;
	}
	public List<Player> getSans2(){
		return playersans2;
	}
	public List<Player> getDefender(){
		return defender;
	}
	public List<Player> getAttack(){
		return attack;
	}
	public List<Player> getGold(){
		return gold;
	}
	public List<Player> getDeath(){
		return death;
	}
	public int getHp(){
		return bluevil;
	}
	public int getHp2(){
		return redvil;
	}
	public static Base getInstance() {
		return instance;
	}
}
