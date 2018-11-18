package saskes;

import java.util.Arrays;
import java.util.Scanner;

public class GameEngine {
	boolean turn = true;
	Player player = new Player();
	Map map = new Map();
	GameRules rules = new GameRules(map);
	
	GameEngine(){
	System.out.println("Sveiki atvykę į šaškių turnyrą");
	play();
	}
	
	public void play() {
		if (turn==true) System.out.println("----Baltųjų eilė----");
		else System.out.println("----Juodųjų eilė----");
		System.out.println(Arrays.deepToString(map.getMap()));
		System.out.println(map.getMapValues(3,2));
		askForInput(player);
		process(player);
		//System.out.print(Arrays.deepToString(map.getMap()));
		turn = !turn;
		play();
	}
	
	public void process(Player player) {
		if ((rules.isSpotAvailable(player.getY2(), player.getX2())) &&		
			((rules.canCheckerMove(turn, player.getY1(),player.getX1(), player.getY2(), player.getX2())==true)
					|| (rules.canCheckerKill(turn, player.getY1(), player.getX1(), player.getY2(), player.getX2())==true))) {
			map.changeMap(player.getY1(), player.getX1(),  player.getY2(),player.getX2(), player.getValue());
		}
		else {
			System.out.println("Įvyko klaidelė, zaiskite dar karteli");
			play();
		}
		player.changeValue(turn);
		rules.isGameOver();
	}

	
	public void askForInput(Player player) {
		System.out.println("IŠ");
		Scanner scan = new Scanner(System.in);
		player.setY1(scan.nextInt());
		player.setX1(scan.nextInt());
		System.out.println("Link");
		player.setY2(scan.nextInt());
		player.setX2(scan.nextInt());
	}
}
