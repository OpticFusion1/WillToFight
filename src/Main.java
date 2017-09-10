import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
public class Main {
	
	static Scanner scan = new Scanner (System.in);
	static Random rand = new Random ();

	public static void main (String args []){
		Battle.skill2=false;
		Battle.skill3=false;
		Battle.skill4=false;
		Battle.confusion = false;
		Battle.focus = 100;
		Battle.focusMax = 100;
		Battle.skill = 1;
		Battle.luck = 1;
		Battle.defence = 50;
		Story.Intro();
	}
	
	public static void Stats (){
		System.out.println("Name: " + Story.name);
		System.out.println("========STATS========");
		System.out.println("MAX FOCUS: \t\t" + Battle.focusMax);
		System.out.println("SKILL: \t\t\t" + Battle.skill);
		System.out.println("LUCK: \t\t\t" + Battle.luck);
		System.out.println("DEFENCE: \t\t" + Battle.defence);
		System.out.println("SKILLS KNOWN: \t\t"+"Slash At Knees");
		if(Battle.skill2)System.out.println("\t\t\tSword Whip");
		if(Battle.confusion)System.out.println("\t\t\tMeditationary Confusion");
		if(Battle.skill3)System.out.println("\t\t\tBearSlash");
		if(Battle.skill4)System.out.println("\t\t\tBEARNADO");
		System.out.println("ITEMS OWNED:");
		System.out.println("\t\t\tManly sword");
		if(Battle.skill3)System.out.println("\t\t\tBear Claw Sword");
		if(Battle.skill4)System.out.println("\t\t\tBear Nun-Chcucks");
		System.out.println("=====================");
		
	}
	
	public static void Load (){
		int cnt = 0;
		String sc = null;
		String s2 = null;
		String s3 = null;
		String s4 = null;
		String fileName = "stats.txt";
		String line = null;
		try {
            FileReader fileReader = 
                new FileReader(fileName);

            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
            	cnt ++;
            	if(cnt == 1)Story.name = line;
            	if(cnt == 2)Battle.focusMax = Integer.parseInt(line);
            	if(cnt == 3)Battle.luck = Integer.parseInt(line);
            	if(cnt == 4)Battle.skill = Integer.parseInt(line);
            	if(cnt == 5)Battle.defence = Integer.parseInt(line);
            	if(cnt == 6)sc = (line);
            	if(cnt == 7)s2 = (line);
            	if(cnt == 8)s3 = (line);
            	if(cnt == 9)s4 = (line);
            	if(cnt == 10)Story.progress = Integer.parseInt(line);
            }	

            bufferedReader.close();			
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");				
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");					
        }
		if(sc.equals("confusion true"))Battle.confusion = true;
		if(s2.equals("skill2 true"))Battle.skill2 = true;
		if(s3.equals("skill3 true"))Battle.skill3 = true;
		if(s4.equals("skill4 true"))Battle.skill4 = true;
		
	}
	
	public static void Save (){
		try {
			PrintWriter out = new PrintWriter("stats.txt");
			out.println(Story.name);
			out.println(Battle.focusMax);
			out.println(Battle.luck);
			out.println(Battle.skill);
			out.println(Battle.defence);
			if (Battle.confusion){out.println("confusion true");}
			else if(!Battle.confusion){out.println("confusion false");}
			if (Battle.skill2){out.println("skill2 true");}
			else if(!Battle.skill2){out.println("skill2 false");}
			if (Battle.skill3){out.println("skill3 true");}
			else if(!Battle.skill3){out.println("skill3 false");}
			if (Battle.skill4){out.println("skill4 true");}
			else if(!Battle.skill4){out.println("skill4 false");}
			out.println(Story.progress);
			
			out.close();
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public static void Continue (){
		System.out.println("Would you like to continue playing?");
		Story.choice = scan.next();
		if(Story.choice.equalsIgnoreCase("yes")){
			Story.progress -= 1;
			Story.StoryLine();
		}
		else System.out.println("Well then I hope you enjoyed my little game :)");
		
	}

	public static void Upgrade (){
		String choice = "x";
		while(!choice.equals("1")&&!choice.equals("2")&&!choice.equals("3")&&!choice.equals("4")){
			System.out.println("As a victory bonus you may: \n" +
					"[1]Increase skill by 5 (adds to damage)\n" +
					"[2]Increase luck by 5 (adds to hit chance and special chance)\n" +
					"[3]Increase focus by 10\n" +
					"[4]Increse defence by 5 (decreases chance of being hit while defending and increases chance of surviving a hit while un-focused)");
			choice = Main.scan.next();
			if (choice.equals("1")){
				Battle.skill += 5;
				if(Battle.skill==6)Battle.skill=5;
				System.out.println("Your skill level is now "+Battle.skill+"!");
			}
			else if (choice.equals("2")){
				Battle.luck += 5;
				if(Battle.luck==6)Battle.luck=5;
				System.out.println("Your luck level is now "+Battle.luck+"!");	
			}
			else if (choice.equals("3")){
				Battle.focusMax += 10;
				System.out.println("Your maximum focus is now "+Battle.focusMax+"!");
			}
			else if (choice.equals("4")){
				Battle.defence += 5;
				if(Battle.defence==6)Battle.defence=5;
				System.out.println("Your defence level is now "+Battle.defence+"!");
			}
		}
	}
}

