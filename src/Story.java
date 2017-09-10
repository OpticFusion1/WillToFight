
public class Story {
	
	static String name = null;
	static int progress;
	static String enemyName;
	static String choice;
	
	public static void Intro (){
		System.out.println("Welcome to WILL TO FIGHT, if you have a character already type LOAD if not type your new name.");
		choice = Main.scan.nextLine();
		
		if(choice.equalsIgnoreCase("load")){
			Main.Load();
			Main.Stats();
			System.out.println("Type START to start the game from the first enemy.\n" +
					"Type LOAD to start the game from where you last left off.");
			choice = "1";
			while(!choice.equalsIgnoreCase("START") && !choice.equalsIgnoreCase("LOAD")){
				choice=Main.scan.nextLine();
				if(choice.equalsIgnoreCase("START")){
					progress = 1;
					Story.StoryLine();
				}
				if(choice.equalsIgnoreCase("LOAD")){
					Story.StoryLine();
				}
			}
			
		}
		else name = choice;
		
		System.out.println("Ok "+ name +" since this is in the making the story is pretty much this.\n" +
				"You are like, a hero or something. \n" +
				"There is trouble afoot because evil stuff. \n" +
				"Kill some shit. Press enter to continue when nothing is happening." );
		Main.scan.nextLine();
		System.out.println("NOW GO FIGHT THAT ENEMY OVER THERE\n" +
				"And keep in mind that you'll be vulnerable when your focus drops below 20!\n" +
				"Break your opponents focus before that!");
		Main.scan.nextLine();
		
		enemyName = "Lady";
		Battle.meFirst = true;
		progress = 2;
		Battle.Begin();																											//HERE ITS HERE RIGHT HERE YO
	}
	
	public static void Lose(){
		if(progress==2){
			System.out.println("I cannot beleive that you managed to lose to the old lady...");
			Main.scan.nextLine();
			System.out.println("How even???");
			Main.scan.nextLine();
			System.out.println("Well, whatevs, it's game over for you n00b.");
			Main.Continue();
		}
		if(progress==3){
			System.out.println("So the zombie was too good for you eh.");
			Main.scan.nextLine();
			System.out.println("That's too bad, I was rather starting to like you.");
			Main.scan.nextLine();
			System.out.println("Oh well, your dead. So bye :)");
			Main.Continue();
		}
		if(progress==4){
			System.out.println("HAHA that was awesome! That bear beat the living shit out of you!");
			Main.scan.nextLine();
			System.out.println("It's too bad though...");
			Main.scan.nextLine();
			System.out.println("I bet there was something really nice in that forest!");
			Main.Continue();
		}
		if(progress==5){
			System.out.println("HAHA that was awesome! That bear beat the living shit out of you!");
			Main.scan.nextLine();
			System.out.println("Too bad for the damsel though. She's probably dead now thanks to you.");
			Main.scan.nextLine();
			System.out.println("Have fun in hell.");
			Main.Continue();
		}
		if(progress==6){
			System.out.println("Looks like that rat was too much for you...");
			Main.scan.nextLine();
			System.out.println("It was very lucky though so don't feel TOO bad.");
			Main.scan.nextLine();
			System.out.println("Have fun in hell.");
			Main.Continue();
		}
		if(progress==7){
			System.out.println("Looks like that rat was too much for you...");
			Main.scan.nextLine();
			System.out.println("It was very lucky though so don't feel TOO bad.");
			Main.scan.nextLine();
			System.out.println("Have fun in hell.");
			Main.Continue();
		}
		if(progress==8){
			System.out.println("That was a pretty freaky banshee!");
			Main.scan.nextLine();
			System.out.println("and it killed ya");
			Main.scan.nextLine();
			System.out.println("Have fun in hell.");
			Main.Continue();
		}
		if(progress==9){
			System.out.println("So you couldn't bring yourself to take the lady beast?");
			Main.scan.nextLine();
			System.out.println("SHE WAS EVIL AND YOUR INABILTY TO END HER IS SIN.");
			Main.scan.nextLine();
			System.out.println("Have fun in hell.");
			Main.Continue();
		}
		
		Main.scan.nextLine();
		System.exit(0);
	}
	
	public static void StoryLine (){
		if (progress == 2){
			System.out.println("Hey " + name + ", don't think too highly of yourself for defeating that first enemy.");
			Main.scan.nextLine();
			System.out.println("It was just an old lady we found on the side of the road and her power lvl was only 0.5 Raditz!");
			Main.scan.nextLine();
			choice = "s";
			Main.Upgrade();
			Main.Stats();
			Main.scan.nextLine();
			System.out.println("Would you like to save?");
			choice = Main.scan.next();
			if(choice.equalsIgnoreCase("YES")){
				Main.Save();
			}
			else System.out.println("NO? Okay.");
			System.out.println("Well now that your stronger, think you can take on a zombie???");
			Main.scan.nextLine();
			enemyName = "Zombie";
			Battle.meFirst = true;
			progress = 3;
			Battle.Begin();
		}
		
		
		
		if(progress == 3){
			System.out.println("Wow...you actually took down that zombie...");
			Main.scan.nextLine();
			System.out.println("Im impressed...So impressed that it's skill upgrade time!!!");
			Main.scan.nextLine();
			choice = "s";
			while(!choice.equals("1")&&!choice.equals("2")){
				System.out.println("[1]Using meditate triggers a 30% chance of your enemy getting confused and not attacking\n" +
								   "[2]NEW SKILL: Sword Whip (costs 20 and does more damage than Slash At Knee but has no effect.");
				choice = Main.scan.next();
				if(choice.equals("1")){
					System.out.println("Congratulations! You learned mediationary confusion!");
					Battle.confusion = true;
					Battle.confChance = 30;
				}
				if(choice.equals("2")){
					System.out.println("Congratulations! You learned Sword Whip!");
					Battle.skill2 = true;
				}
			}
			System.out.println("Ah wtf, I'll let you level a stat too.");
			Main.scan.nextLine();
			choice = "s";
			Main.Upgrade();
			Main.Stats();
			Main.scan.nextLine();
			System.out.println("Would you like to save?");
			choice = Main.scan.next();
			if(choice.equalsIgnoreCase("YES")){
				Main.Save();
			}
			else System.out.println("NO? Okay.");
			System.out.println("Well...now what...");
			Main.scan.nextLine();
			System.out.println("I KNOW!!!");
			Main.scan.nextLine();
			choice = "s";
			while(!choice.equals("1")&&!choice.equals("2")){
				System.out.println("You can either:\n" +
						"[1]Enter the scary looking forest on your right, OR\n" +
						"[2]Attempt to save the *SCREAM FROM AFAR* damsel in distress over >there>");
				choice = Main.scan.next();
				if(choice.equals("1")){
					System.out.println("So your not into ladies eh ;) Don't worry I wont judge...");
					Main.scan.nextLine();
					System.out.println("Anywho, upon entering the forest you see a BEAR! What do ?");
					Main.scan.nextLine();
					System.out.println("TOO LATE THE BEAR IS APPROACHING!");
					enemyName = "Bear";
					Battle.meFirst = false;
					progress = 4;
					Battle.Begin();
				}
				if(choice.equals("2")){
					System.out.println("HAHA you just want to see the sex scene dont you ;)\n" +
							"Well anyways, while walking towards the screamy direction you encounter a BEAR!");
					Main.scan.nextLine();
					System.out.println("You're paralyzed with fear and the bear makes the first move!");
					enemyName = "Bear";
					Battle.meFirst = false;
					progress = 5;
					Battle.Begin();
					
				}
			
				
			}
			
		}
		
		if (progress == 4){
			System.out.println("HOLY SHIT YOU KILLED THE BEAR!");
			Main.scan.nextLine();
			System.out.println("Would you like to save?");
			choice = Main.scan.next();
			if(choice.equalsIgnoreCase("YES")){
				Main.Save();
			}
			else System.out.println("NO? Okay.");
			System.out.println("Well, while walking along in the dark forest you're attacked by A LUCKY DISEASED RAT!");
			Main.scan.nextLine();
			enemyName="Lucky Dieased Rat";
			Battle.meFirst = false;
			progress = 6;
			Battle.Begin();
		}
		
		if (progress == 5){
			System.out.println("HOLY SHIT YOU KILLED THE BEAR!");
			Main.scan.nextLine();
			System.out.println("Would you like to save?");
			choice = Main.scan.next();
			if(choice.equalsIgnoreCase("YES")){
				Main.Save();
			}
			else System.out.println("NO? Okay.");
			System.out.println("Well as it turns out, the princess was being held captive by that bear!");
			Main.scan.nextLine();
			System.out.println("BUT NOW A LUCKY DISEASED RAT ATTACKS!");
			Main.scan.nextLine();
			enemyName="Lucky Dieased Rat";
			Battle.meFirst = false;
			progress = 7;
			Battle.Begin();
		}
		
		if (progress == 6 || progress == 7){
			System.out.println("Well now that random monsters are no longer attacking you, it's upgrade time!");
			Main.scan.nextLine();
			choice = "s";
			Main.Upgrade();
			Main.Stats();
			Main.scan.nextLine();
			System.out.println("While examining the area around the dead bear and rat you notice a very nice \n" +
					"looking set of bear claws beside a piece of wood and some rope.");
			Main.scan.nextLine();
			choice = "s";
			while(!choice.equals("1")&&!choice.equals("2")){
				System.out.println("Would you like to:\n" +
						"[1]Create a bear claw sword which increases damage and grants the BEAR-SLASH ability OR\n" +
						"[2]Create bear nun-chucks which increases luck (through hit-chance) and grants the BEARNADO ability.");
				choice = Main.scan.next();
				if(choice.equals("1")){
					if(Battle.skill==1){
						Battle.skill = 5;
					}
					else{ 
						Battle.skill += 5;
					}
					Battle.skill3 = true;
					System.out.println("Your skill level is now " + Battle.skill +"!");
					
				}
				if(choice.equals("2")){
					if(Battle.luck==1){
						Battle.luck = 5;
					}
					else{ 
						Battle.luck += 5;
					}
					Battle.skill4 = true;
					System.out.println("Your luck level is now " + Battle.luck +"!");
					
				}
			}
			Main.scan.nextLine();
			Main.Stats();
			Main.scan.nextLine();
			
		}
		
		if(progress == 6){
			System.out.println("Would you like to save?");
			choice = Main.scan.next();
			if(choice.equalsIgnoreCase("YES")){
				Main.Save();
			}
			else System.out.println("NO? Okay.");
			System.out.println("So while searching the dark dark dark forest, you encounter a BANSHEE!");
			Main.scan.nextLine();
			System.out.println("It freaks the shit out of you and gets the first attack!");
			Main.scan.nextLine();
			enemyName = "Banshee";
			Battle.meFirst = false;
			progress = 8;
			Battle.Begin();
		}
		
		if(progress == 7){
			System.out.println("Would you like to save?");
			choice = Main.scan.next();
			if(choice.equalsIgnoreCase("YES")){
				Main.Save();
			}
			else System.out.println("NO? Okay.");
			System.out.println("Behind the bear carcass you find the damsel that was, up until now, in great distress.");
			Main.scan.nextLine();
			System.out.println("AND THEN SHE WAS A BANSHEE! (it freaked you out and you stumbled back allowing her the first attack)");
			Main.scan.nextLine();
			enemyName = "Banshee";
			Battle.meFirst = false;
			progress = 9;
			Battle.Begin();
		}
		
		if(progress == 8){
			System.out.println("Would you like to save?");
			choice = Main.scan.next();
			if(choice.equalsIgnoreCase("YES")){
				Main.Save();
			}
			else System.out.println("NO? Okay.");
			Main.Upgrade();
			System.out.println("After defeating the banshee you relax for a couple of hours and regain your strength...");
			Main.scan.nextLine();
			System.out.println("You wake up to right cross and left jab!!");
			Main.scan.nextLine();
			enemyName = "Boxer";
			Battle.meFirst = false;
			progress = 10;
			Battle.Begin();
		}
		
		if(progress == 9){
			System.out.println("Would you like to save?");
			choice = Main.scan.next();
			if(choice.equalsIgnoreCase("YES")){
				Main.Save();
			}
			else System.out.println("NO? Okay.");
			Main.Upgrade();
			System.out.println("The dead banshee is now laying on the dead bear. You cant help but laugh because you are troubled.");
			Main.scan.nextLine();
			System.out.println("You turn around when you hear laughing from behind you! You finda professional boxer, and he is off gaurd!");
			Main.scan.nextLine();
			enemyName = "Boxer";
			Battle.meFirst = true;
			progress = 11;
			Battle.Begin();
		}
		if(progress==10){
            System.out.println("So you couldn't bring yourself to take the lady beast?");
            Main.scan.nextLine();
            System.out.println("SHE WAS EVIL AND YOUR INABILTY TO END HER IS SIN.");
            Main.scan.nextLine();
            System.out.println("Have fun in hell.");
            Main.Continue();
        }
		
		
		
		
	
	}

	
}
