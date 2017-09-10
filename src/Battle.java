
public class Battle {
	static String enAtk1;
	static String enAtk2;
	static String enAtkS;
	static int atk1Chance;
	static int atk2Chance;
	static int atkSChance;
	static int atk1Dmg;
	static int atk2Dmg;
	static int atkSDmg;
	static int atk1Range;
	static int atk2Range;
	static int atkSRange;
	static int enDefence;
	static int enFocusCost;
	
	static int focus;
	static int luck;
	static int skill;
	static int defence;
	static int focusMax;
	
	static boolean skill2;
	static boolean skill3;
	static boolean skill4;
	static boolean confusion;
	static int confChance;
	
	static int enFocus;
	static int enLuck;
	
	static String choice;
	static int dmg;
	static int hit;
	static boolean defending;
	static boolean enDefending;
	static boolean meditating;
	static boolean meFirst;
	static boolean enStunned;
	static boolean stunned;
	
	public static void Begin (){
		focus = focusMax;
		Enemy.EnemyLib(Story.enemyName);
		System.out.println("========BATTLE START========");
		 if (meFirst){
			 System.out.println("My Focus: " + focus + "\n" +
					"Enemy Focus: " + enFocus);
			 MyTurn();
			 }
		 if (!meFirst)EnTurn();
	}
	public static void MyTurn (){
		Main.scan.nextLine();
		dmg = 0;
		defending = false;
		enStunned = false;
		meditating = false;
		System.out.println("--------Your Turn--------");
		System.out.println("[1]Attack\n" +
				"[2]Defend\n" +
				"[3]Skill\n" +
				"[4]Meditate");
		choice = Main.scan.next();
		if(choice.equals("1")){														//attack options
			System.out.println("[1]Slash (high hit chance, low focus break)\n" +
					"[2]Stab (low hit chance, high focus break)\n" +
					"[0]CANCEL");
			choice = Main.scan.next();
			if (choice.equals("1")){
				if (!enDefending)hit = Main.rand.nextInt(100)+luck;
				if(enDefending)hit = Main.rand.nextInt(100-enDefence)+luck;
				if(hit >= 20){
					if(enDefending)System.out.println("HIT! You broke the enemy "+Story.enemyName+"'s defences!");		//chose to slash
					if(!enDefending)System.out.println("HIT!");
					Main.scan.nextLine();
					dmg = Main.rand.nextInt(10)+skill;
					System.out.println("You broke enemy "+Story.enemyName+"'s focus by " + dmg + "!");
					Main.scan.nextLine();
					enFocus -= dmg;
					if (enFocus <= 0){
						System.out.println("Enemy "+Story.enemyName+" defeated!");
						System.out.println("========BATTLE END========");
						Main.scan.nextLine();
						
						Story.StoryLine();
					}
					else{
						EnTurn();
					}
				}
				else{
					if(enDefending)System.out.println("You were unable to break the enemy "+Story.enemyName+"'s defences!");
					if(!enDefending)System.out.println("MISS!");
					Main.scan.nextLine();
					Main.scan.nextLine();
					EnTurn();
				}
			}
			if (choice.equals("2")){
				if(!enDefending)hit = Main.rand.nextInt(100)+luck;
				if(enDefending)hit = Main.rand.nextInt(100-enDefence)+luck;
				if(hit >= 35){									//chose to stab
					if(!enDefending)System.out.println("HIT!");
					if(enDefending)System.out.println("HIT! You broke the enemy "+Story.enemyName+"'s defences!");
					Main.scan.nextLine();
					dmg = Main.rand.nextInt(10)+skill+7;
					System.out.println("You broke enemy "+Story.enemyName+"'s focus by " + dmg + "!");
					Main.scan.nextLine();
					enFocus -= dmg;
					if (enFocus <= 0){
						System.out.println("Enemy "+Story.enemyName+" defeated!");
						System.out.println("========BATTLE END========");
						Main.scan.nextLine();
						
						Story.StoryLine();
					}
					else{
						EnTurn();
					}
				}
				else{
					if(!enDefending)System.out.println("MISS!");
					if(enDefending)System.out.println("You were unable to break the enemy "+Story.enemyName+"'s defences!");
					Main.scan.nextLine();
					Main.scan.nextLine();
					EnTurn();
				}
			}
			if(choice.equals("0")){						//chose atk cancel
				MyTurn();
			}
		}
		else if(choice.equals("2")){
			System.out.println("You ready yourself for enemy "+Story.enemyName+"'s next attack!\n" +
					"Your focus goes up by 10 as you await your opponent's next move.");		//chose to defend
			defending = true;
			focus += 10;
			if(focus>focusMax)focus = focusMax;
			Main.scan.nextLine();
			EnTurn();
		}
		else if(choice.equals("3")){	//chose to use skill
			System.out.println("Focus: " + focus);
			System.out.println("[1]Slash At Knees - costs 20f - chance of enemy not attacking next turn!");
			if(skill2)System.out.println("[2]Sword Whip - costs 20f - high damage!");
			if(skill3)System.out.println("[3]BearSlash - costs 15 - high damage");
			if(skill4)System.out.println("[3]BEARNADO - costs 30f - SUPER DAMAGE");
			System.out.println("[0]CANCEL");
			choice = Main.scan.next();
			
			if (choice.equals("1")){
				if((focus - 20) <= 0){
					System.out.println("You can't focus on that now!!!");
					MyTurn();
				}
				focus -= 20;
				if(!enDefending)hit = Main.rand.nextInt(100)+luck;
				if(enDefending)hit = Main.rand.nextInt(100-enDefence/2)+luck;
				if (hit > 20){
					if(!enDefending)System.out.println("HIT!");
					if(enDefending)System.out.println("You broke through the enemy "+Story.enemyName+"'s defence with your focus and hit!");
					Main.scan.nextLine();
					dmg = Main.rand.nextInt(20)+14+skill;
					System.out.println("You broke enemy "+Story.enemyName+"'s focus by " + dmg + "!");
					Main.scan.nextLine();
					enFocus -= dmg;
					if (enFocus <= 0){
						System.out.println("Enemy "+Story.enemyName+" defeated!");
						System.out.println("========BATTLE END========");
						Main.scan.nextLine();
						
						Story.StoryLine();
					}
					else{
						System.out.println("There is also a chance that your opponent will be unable to attack next turn!");
						enStunned = true;
						EnTurn();
					}
				}
				else{
					if(!enDefending)System.out.println("MISS!");
					if(enDefending)System.out.println("Even with your focused attack you couldn't break the enemy "+Story.enemyName+"'s defence!");
					Main.scan.nextLine();
					Main.scan.nextLine();
					EnTurn();
				}
			}
			if (choice.equals("2")&&skill2){
				if((focus - 20) <= 0){
					System.out.println("You can't focus on that now!!!");
					MyTurn();
				}
				focus -= 20;
				if(!enDefending)hit = Main.rand.nextInt(100)+luck;
				if(enDefending)hit = Main.rand.nextInt(100-enDefence/2)+luck;
				if (hit > 25){
					if(!enDefending)System.out.println("SWORD WHIP HIT!");
					if(enDefending)System.out.println("You broke through the enemy "+Story.enemyName+"'s defence with your focus and hit!");
					Main.scan.nextLine();
					dmg = Main.rand.nextInt(15)+25+skill;
					System.out.println("You broke enemy "+Story.enemyName+"'s focus by " + dmg + "!");
					Main.scan.nextLine();
					enFocus -= dmg;
					if (enFocus <= 0){
						System.out.println("Enemy "+Story.enemyName+" defeated!");
						System.out.println("========BATTLE END========");
						Main.scan.nextLine();
						
						Story.StoryLine();
					}
					else{
						EnTurn();
					}
				}
				else{
					if(!enDefending)System.out.println("MISS!");
					if(enDefending)System.out.println("Even with your focused attack you couldn't break the enemy "+Story.enemyName+"'s defence!");
					Main.scan.nextLine();
					Main.scan.nextLine();
					EnTurn();
				}
			}
			if (choice.equals("3")&&skill3){
				if((focus - 15) <= 0){
					System.out.println("You can't focus on that now!!!");
					MyTurn();
				}
				focus -= 15;
				if(!enDefending)hit = Main.rand.nextInt(100)+luck;
				if(enDefending)hit = Main.rand.nextInt(100-enDefence/2)+luck;
				if (hit > 25){
					if(!enDefending)System.out.println("BearSlash HIT!");
					if(enDefending)System.out.println("You broke through the enemy "+Story.enemyName+"'s defence with your focus and hit!");
					Main.scan.nextLine();
					dmg = Main.rand.nextInt(15)+25+skill;
					System.out.println("You broke enemy "+Story.enemyName+"'s focus by " + dmg + "!");
					Main.scan.nextLine();
					enFocus -= dmg;
					if (enFocus <= 0){
						System.out.println("Enemy "+Story.enemyName+" defeated!");
						System.out.println("========BATTLE END========");
						Main.scan.nextLine();
						
						Story.StoryLine();
					}
					else{
						EnTurn();
					}
				}
				else{
					if(!enDefending)System.out.println("MISS!");
					if(enDefending)System.out.println("Even with your focused attack you couldn't break the enemy "+Story.enemyName+"'s defence!");
					Main.scan.nextLine();
					Main.scan.nextLine();
					EnTurn();
				}
			}
			if (choice.equals("3")&&skill4){
				if((focus - 30) <= 0){
					System.out.println("You can't focus on that now!!!");
					MyTurn();
				}
				focus -= 30;
				if(!enDefending)hit = Main.rand.nextInt(100)+luck;
				if(enDefending)hit = Main.rand.nextInt(100-enDefence/2)+luck;
				if (hit > 30){
					if(!enDefending)System.out.println("YOU SPIN AROUND MADLY WITH YOUR BEAR NUN-CHUCKS AND HIT!!!");
					if(enDefending)System.out.println("You broke through the enemy "+Story.enemyName+"'s defence with your flailing nun-chucks and hit!");
					Main.scan.nextLine();
					dmg = Main.rand.nextInt(15)+35+skill;
					System.out.println("You broke enemy "+Story.enemyName+"'s focus by " + dmg + "!");
					Main.scan.nextLine();
					enFocus -= dmg;
					if (enFocus <= 0){
						System.out.println("Enemy "+Story.enemyName+" defeated!");
						System.out.println("========BATTLE END========");
						Main.scan.nextLine();
						
						Story.StoryLine();
					}
					else{
						EnTurn();
					}
				}
				else{
					if(!enDefending)System.out.println("MISS!");
					if(enDefending)System.out.println("Even with your tornado of bear POWER you couldn't break the enemy "+Story.enemyName+"'s defence!");
					Main.scan.nextLine();
					Main.scan.nextLine();
					EnTurn();
				}
			}
			else if (choice.equals("0")){		//chose skill cancel
				MyTurn();
			}
			else MyTurn();
		}
		else if(choice.equals("4")){						//chose to meditate
			System.out.println("You pause and meditate.");
			dmg = Main.rand.nextInt(5)+14+luck;
			Main.scan.nextLine();
			focus += dmg;
			if(focus>focusMax)focus=focusMax;
			System.out.println("Your focus went up to " + focus);
			Main.scan.nextLine();
			meditating = true;
			EnTurn();
		}
		else MyTurn();
	}
	public static void EnTurn (){
		enDefending = false;
		dmg = 0;
		System.out.println("My Focus: " + focus + "\n" +
				"Enemy Focus: " + enFocus);
		System.out.println("--------Enemy Turn---------");
		Main.scan.nextLine();
		hit = Main.rand.nextInt(10)+1;
		if(enStunned){
			hit = Main.rand.nextInt(100)+luck+skill;
			if(hit >= 50){
				System.out.println("Your slash at the "+Story.enemyName+"'s knees has rendered him immobile this turn.");
				Main.scan.nextLine();
				MyTurn();
			}
			else{
				System.out.println("The "+Story.enemyName+" was able to shrug off the knee slash and continues to fight.");
			}
		}
		if(meditating && confusion){
			hit = Main.rand.nextInt(100)+luck;
			if(hit >= 100 - confChance){
				System.out.println("Your meditation and calmness distracted the  enemy "+Story.enemyName+"! He is too confused to move!");
				Main.scan.nextLine();
				MyTurn();
			}
		}
		if(enFocus <= enFocusCost+5)hit = 1;		//if enemy can't afford skill
		if(focus <= 20)hit = 1;                 // forces enemy to go for kill if possible
		
		if(hit <= 4){
			hit = Main.rand.nextInt(2)+1;								//enemy chooses attack
			if(hit==1){						//chooses atk1
				if(focus > 20){
					System.out.println("Enemy "+Story.enemyName+" uses " + enAtk1);
					if(!defending)hit = Main.rand.nextInt(100)+enLuck;
					if(defending)hit = Main.rand.nextInt(100 - defence)+enLuck;
					Main.scan.nextLine();
					if (hit >= atk1Chance){
						if(defending)System.out.println("HIT! "+Story.enemyName+" breaks your defences!");
						if(!defending)System.out.println("HIT!");
						dmg = Main.rand.nextInt(atk1Range)+atk1Dmg;
						Main.scan.nextLine();
						System.out.println(Story.enemyName+" broke your focus by " + dmg + "!");
						focus -= dmg;
						if (focus <= 0){
							focus = 0;
							System.out.println("Your focus has been broken to nothing!!!");
							System.out.println("My Focus: " + focus + "\n" +
									"Enemy Focus: " + enFocus);
							MyTurn();
						}
						else {
							System.out.println("My Focus: " + focus + "\n" +
									"Enemy Focus: " + enFocus);
							MyTurn();
						}
					}
					else{												//atk misses
						if(defending)System.out.println("Opponent was unable to break your defences!");
						if(!defending)System.out.println("MISS!");
						Main.scan.nextLine();
						Main.scan.nextLine();
						System.out.println("My Focus: " + focus + "\n" +
								"Enemy Focus: " + enFocus);
						MyTurn();
					}
				}
				else{
					System.out.println("The "+Story.enemyName+" noticed your lack of focus and attacked!");
					hit = Main.rand.nextInt(100)+enLuck;
					Main.scan.nextLine();
					if(hit > defence + 5){
						System.out.println("In your unfocused state, the "+Story.enemyName+" struck you and caused you to bleed out!\n" +
								"You are dead.");
						System.out.println("========BATTLE END========");
						Story.Lose();
					}
					else{
						System.out.println("Your luck saves you as the enemy "+Story.enemyName+" misses!");
						MyTurn();
					}
				}
			}
			if(hit==2){						//chooses atk2
				if(focus > 20){
					System.out.println("Enemy "+Story.enemyName+" uses " + enAtk2);
					if(!defending)hit = Main.rand.nextInt(100)+enLuck;
					if(defending)hit = Main.rand.nextInt(100 - defence)+enLuck;
					Main.scan.nextLine();
					if (hit >= atk2Chance){
						if(defending)System.out.println("HIT! Opponent breaks your defences!");
						if(!defending)System.out.println("HIT!");
						dmg = Main.rand.nextInt(atk2Range)+atk2Dmg;
						Main.scan.nextLine();
						System.out.println("Enemy "+Story.enemyName+" broke your focus by " + dmg + "!");
						focus -= dmg;
						if (focus <= 0){
							focus = 0;
							System.out.println("Enemy "+Story.enemyName + "'s attack broke your focus down to nothing!");
							System.out.println("My Focus: " + focus + "\n" +
									"Enemy Focus: " + enFocus);
							MyTurn();
						}
						else {
							System.out.println("My Focus: " + focus + "\n" +
									"Enemy Focus: " + enFocus);
							MyTurn();
						}
					
					}
					

					else{												//atk misses
						if(defending)System.out.println("Opponent was unable to break your defences!");
						if(!defending)System.out.println("MISS!");
						Main.scan.nextLine();
						Main.scan.nextLine();
						System.out.println("My Focus: " + focus + "\n" +
							"Enemy Focus: " + enFocus);
						MyTurn();
					}
				}
				
				
				else{
					System.out.println("The enemy "+Story.enemyName+"  noticed your lack of focus and attacked!");
					hit = Main.rand.nextInt(100)+enLuck;
					Main.scan.nextLine();
					if(hit > defence + 5){
						System.out.println("In your unfocused state, the "+Story.enemyName+" struck you and caused you to bleed out!\n" +
								"You are dead.");
						System.out.println("========BATTLE END========");
						Story.Lose();
					}
					else{
						System.out.println("Your luck saves you as the "+Story.enemyName+" misses!");
						MyTurn();
					}
				}
			}
			
			
		}
		if(hit==5||hit==6){
			System.out.println("Enemy "+Story.enemyName+" chose to defend and is ready for your next attack!");	//enemy chooses defend	
			enDefending = true;
			MyTurn();
		}
		if(hit >= 7){
			System.out.println("Enemy "+Story.enemyName+" chose to attack with \"" + enAtkS + "\"!");          //enemy chooses his special skill
			enFocus -= enFocusCost;
			Main.scan.nextLine();
			if(!defending)hit = Main.rand.nextInt(100)+enLuck;
			if(defending)hit = Main.rand.nextInt(100-defence)+enLuck;
			if(hit >= atkSChance){
				if(defending)System.out.println("The "+Story.enemyName+"'s special attack was able to pierce your defence!");
				if(!defending)System.out.println(Story.enemyName+"'s special attack hit!");
				Main.scan.nextLine();
				dmg = Main.rand.nextInt(atkSRange)+atkSDmg;
				System.out.println(Story.enemyName+"'s special attack took your focus down by " + dmg + "!\n" +
						"However it cost your opponent " + enFocusCost + " focus.");
				focus -= dmg;
				Main.scan.nextLine();
				if(focus <= 0){
					focus=0;
					System.out.println(Story.enemyName+"'s special attack destroyed your focus!!!");
					MyTurn();
				}
				System.out.println("My Focus: " + focus + "\n" +
						"Enemy Focus: " + enFocus);
				MyTurn();
			}
			if(hit < atkSChance){
				if(defending)System.out.println("Even with a special attack the "+Story.enemyName+" could not break your defence!");
				if(!defending)System.out.println("MISS!");
				Main.scan.nextLine();
				Main.scan.nextLine();
				System.out.println("My Focus: " + focus + "\n" +
						"Enemy Focus: " + enFocus);
				MyTurn();
			}
		}

	}

	
}
