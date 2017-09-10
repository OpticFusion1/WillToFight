
public class Enemy {
	
	public static void EnemyLib (String name){
		if(name.equals("Lady")){
			Battle.enFocus = 100;
			Battle.enLuck = 1;
			Battle.enAtk1 = "Poke";
			Battle.enAtk2 = "Scratch";
			Battle.enAtkS = "Hit With Purse";
			Battle.atk1Chance = 10;
			Battle.atk2Chance = 20;
			Battle.atkSChance = 30;
			Battle.atk1Range=1;
			Battle.atk2Range=5;
			Battle.atkSRange=5;
			Battle.atk1Dmg = 9;
			Battle.atk2Dmg = 15;
			Battle.atkSDmg = 20;
			Battle.enDefence = 20;
			Battle.enFocusCost = 15;
		}
		if(name.equals("Zombie")){
			Battle.enFocus = 150;
			Battle.enLuck = 5;
			Battle.enAtk1 = "Scary Groan";
			Battle.enAtk2 = "Swing Arm";
			Battle.enAtkS = "Bite";
			Battle.atk1Chance = 1;
			Battle.atk2Chance = 20;
			Battle.atkSChance = 30;
			Battle.atk1Range=1;
			Battle.atk2Range=5;
			Battle.atkSRange=10;
			Battle.atk1Dmg = 9;
			Battle.atk2Dmg = 15;
			Battle.atkSDmg = 20;
			Battle.enDefence = 20;
			Battle.enFocusCost = 10;
		}
		if(name.equals("Bear")){
			Battle.enFocus = 175;
			Battle.enLuck = 5;
			Battle.enAtk1 = "Bear Roar";
			Battle.enAtk2 = "Big Paw";
			Battle.enAtkS = "Chomp";
			Battle.atk1Chance = 1;
			Battle.atk2Chance = 20;
			Battle.atkSChance = 20;
			Battle.atk1Range=1;
			Battle.atk2Range=20;
			Battle.atkSRange=5;
			Battle.atk1Dmg = 14;
			Battle.atk2Dmg = 10;
			Battle.atkSDmg = 20;
			Battle.enDefence = 20;
			Battle.enFocusCost = 20;
		}
		
		if(name.equals("Lucky Dieased Rat")){
			Battle.enFocus = 15;
			Battle.enLuck = 25;
			Battle.enAtk1 = "Cough Blood";
			Battle.enAtk2 = "Wiggle";
			Battle.enAtkS = "Bite";
			Battle.atk1Chance = 100;
			Battle.atk2Chance = 50;
			Battle.atkSChance = 50;
			Battle.atk1Range=1;
			Battle.atk2Range=1;
			Battle.atkSRange=4;
			Battle.atk1Dmg = 0;
			Battle.atk2Dmg = 0;
			Battle.atkSDmg = 1;
			Battle.enDefence = 10;
			Battle.enFocusCost = 1;
		}
		if(name.equals("Banshee")){
			Battle.enFocus = 150;
			Battle.enLuck = 10;
			Battle.enAtk1 = "Witchly Howl";
			Battle.enAtk2 = "Not-So-Witchly Howl";
			Battle.enAtkS = "Claw To Face Disgrace";
			Battle.atk1Chance = 60;
			Battle.atk2Chance = 60;
			Battle.atkSChance = 15;
			Battle.atk1Range=15;
			Battle.atk2Range=20;
			Battle.atkSRange=10;
			Battle.atk1Dmg = 10;
			Battle.atk2Dmg = 0;
			Battle.atkSDmg = 40;
			Battle.enDefence = 14;
			Battle.enFocusCost = 5;
		}
		if(name.equals("Boxer")){
			Battle.enFocus = 200;
			Battle.enLuck = 8;
			Battle.enAtk1 = "Right Hook";
			Battle.enAtk2 = "Left Uppercut";
			Battle.enAtkS = "HAYMAKER";
			Battle.atk1Chance = 60;
			Battle.atk2Chance = 40;
			Battle.atkSChance = 20;
			Battle.atk1Range=10;
			Battle.atk2Range=10;
			Battle.atkSRange=10;
			Battle.atk1Dmg = 5;
			Battle.atk2Dmg = 10;
			Battle.atkSDmg = 40;
			Battle.enDefence = 10;
			Battle.enFocusCost = 1;
		}
		if(name.equals("Helvetica")){
            Battle.enFocus = 150;
            Battle.enLuck = 12;
            Battle.enAtk1 = "Font Fight";
            Battle.enAtk2 = "Bold Backhand";
            Battle.enAtkS = "Serif Slap";
            Battle.atk1Chance = 60;
            Battle.atk2Chance = 60;
            Battle.atkSChance = 40;
            Battle.atk1Range=10;
            Battle.atk2Range=10;
            Battle.atkSRange=15;
            Battle.atk1Dmg = 5;
            Battle.atk2Dmg = 5;
            Battle.atkSDmg = 50;
            Battle.enDefence = 10;
            Battle.enFocusCost = 10;
        }
		
	}
}
