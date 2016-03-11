import java.util.Scanner;
import java.util.Random;
import java.text.NumberFormat;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;

public class MainRoom {
	static Scanner darkly = new Scanner(System.in);
	static Random rnd = new Random();
	static NumberFormat currency = NumberFormat.getCurrencyInstance();

	static boolean secretRoomFound = false;
	static boolean[] roomVisitedFlag = {false, false, false, false, false, false, false, false};
	static boolean exiting = false;
	//all flags initialized to false
	static int steps = 0;
	static double moneyCollected = 0.00;
	static String thingsSeen = "";
	static int hp = 20;
	static int sanity = 10;
	static boolean sane = true;
	static boolean GOD_MODE = false;

	//File IO
	static File file = new File("zork");
	static PrintWriter pw;
	static {
		try
		{
			pw = new PrintWriter(file);
		}
		catch (IOException e)
		{
			System.out.println("Error writing to file.");
		}
	}

	private static void roomDescribe(String where, String[] stuff, String directions)
	{
		System.out.println("\nYou have " + currency.format(moneyCollected));

		System.out.println("You are in " + where);
		for (String thing : stuff) {
			System.out.println("You see " + thing);
		}
		System.out.println("You can go " + directions);
	}

	public static void room1()
	{
		String place = "the Foyer";
		String[] things = new String[1];
		things[0] = "a dead scorpion";
		String direct = "to the north (n) or the south (s)";

		pw.println("You entered " + place);
		
		steps++;
		if(!roomVisitedFlag[0])
		{
			roomVisitedFlag[0] = true;
			collectMoney();
			noteThingsSeen(things);
		}
		checkSanity();
		checkHP();

		do
		{
			if(exiting)
			{
				break;
			}

			roomDescribe(place, things, direct);

			String choice = darkly.next();

			//When insane, 50% chance to move randomly north, south, east, or west
			//Will still allow user to check map and history
			if(!sane && rnd.nextInt(2) == 0 
					&& !choice.equalsIgnoreCase("map") 
					&& !choice.equalsIgnoreCase("history")
					&& !choice.equalsIgnoreCase("praise_the_sun"))
			{
				choice = randomMovement();
			}

			if (choice.equals("n")) 
			{
				room2();
			}
			else if (choice.equals("s"))
			{
				exit();
			}
			else if (choice.equalsIgnoreCase("history"))
			{
				displayHistory();
			}
			else if (choice.equalsIgnoreCase("map"))
			{
				displayMap();
			}
			else if (choice.equalsIgnoreCase("praise_the_sun"))
			{
				GOD_MODE = true;
			}
			else
			{
				walkIntoWall();
			}
		} while (1==1);
	}

	public static void room2()
	{
		String place = "the Front Room";
		String[] things = new String[1];
		things[0] = "a phone";
		String direct = "to the east (e), the south (s) or the west (w)";

		pw.println("You entered " + place);
		steps++;
		if(!roomVisitedFlag[1])
		{
			roomVisitedFlag[1] = true;
			collectMoney();
			noteThingsSeen(things);
		}
		checkSanity();
		checkHP();

		do
		{
			if(exiting)
			{
				break;
			}

			roomDescribe(place, things, direct);

			String choice = darkly.next();

			//When insane, 50% chance to move randomly north, south, east, or west
			//Will still allow user to check map and history
			if(!sane && rnd.nextInt(2) == 0 
					&& !choice.equalsIgnoreCase("map") 
					&& !choice.equalsIgnoreCase("history")
					&& !choice.equalsIgnoreCase("praise_the_sun"))
			{
				choice = randomMovement();
			}

			if (choice.equals("s")) 
			{
				room1();
			}
			else if (choice.equals("e")) 
			{
				room4();
			}
			else if (choice.equals("w")) 
			{
				room3();
			}
			else if (choice.equalsIgnoreCase("history"))
			{
				displayHistory();
			}
			else if (choice.equalsIgnoreCase("map"))
			{
				displayMap();
			}
			else if (choice.equalsIgnoreCase("praise_the_sun"))
			{
				GOD_MODE = true;
			}
			else
			{
				walkIntoWall();
			}
		} while (1==1);
	}

	public static void room3()
	{
		String place = "the Library";
		String[] things = new String[1];
		things[0] = "spiders";
		String direct = "to the north (n) or the east (e)";

		pw.println("You entered " + place);
		steps++;
		if(!roomVisitedFlag[2])
		{
			roomVisitedFlag[2] = true;
			collectMoney();
			noteThingsSeen(things);
		}
		checkSanity();
		checkHP();

		do
		{
			if(exiting)
			{
				break;
			}

			roomDescribe(place, things, direct);

			String choice = darkly.next();

			//When insane, 50% chance to move randomly north, south, east, or west
			//Will still allow user to check map and history
			if(!sane && rnd.nextInt(2) == 0 
					&& !choice.equalsIgnoreCase("map") 
					&& !choice.equalsIgnoreCase("history"))
			{
				choice = randomMovement();
			}

			if (choice.equals("n")) 
			{
				room5();
			}
			else if (choice.equals("e")) 
			{
				room2();
			}
			else if (choice.equalsIgnoreCase("history"))
			{
				displayHistory();
			}
			else if (choice.equalsIgnoreCase("map"))
			{
				displayMap();
			}
			else if (choice.equalsIgnoreCase("praise_the_sun"))
			{
				GOD_MODE = true;
			}
			else
			{
				walkIntoWall();
			}
		} while (1==1);
	}

	public static void room4()
	{
		String place = "the Kitchen";
		String[] things = new String[1];
		things[0] = "bats";
		String direct = "to the north (n) or the west (w)";

		pw.println("You entered " + place);
		steps++;
		if(!roomVisitedFlag[3])
		{
			roomVisitedFlag[3] = true;
			collectMoney();
			noteThingsSeen(things);
		}
		checkSanity();
		checkHP();

		do
		{
			if(exiting)
			{
				break;
			}

			roomDescribe(place, things, direct);

			String choice = darkly.next();
			
			//When insane, 50% chance to move randomly north, south, east, or west
			//Will still allow user to check map and history
			if(!sane && rnd.nextInt(2) == 0 
					&& !choice.equalsIgnoreCase("map") 
					&& !choice.equalsIgnoreCase("history")
					&& !choice.equalsIgnoreCase("praise_the_sun"))
			{
				choice = randomMovement();
			}

			if (choice.equals("n")) 
			{
				room7();
			}
			else if (choice.equals("w")) 
			{
				room2();
			}
			else if (choice.equalsIgnoreCase("history"))
			{
				displayHistory();
			}
			else if (choice.equalsIgnoreCase("map"))
			{
				displayMap();
			}
			else if (choice.equalsIgnoreCase("praise_the_sun"))
			{
				GOD_MODE = true;
			}
			else
			{
				walkIntoWall();
			}
		} while (1==1);
	}

	public static void room5()
	{
		String place = "the Dining Room";
		String[] things = new String[2];
		things[0] = "dust";
		things[1] = "an empty box";
		String direct = "to the south (s)";

		pw.println("You entered " + place);
		steps++;
		if(!roomVisitedFlag[4])
		{
			roomVisitedFlag[4] = true;
			collectMoney();
			noteThingsSeen(things);
		}
		checkSanity();
		checkHP();

		do
		{
			if(exiting)
			{
				break;
			}

			roomDescribe(place, things, direct);

			String choice = darkly.next();

			//When insane, 50% chance to move randomly north, south, east, or west
			//Will still allow user to check map and history
			if(!sane && rnd.nextInt(2) == 0 
					&& !choice.equalsIgnoreCase("map") 
					&& !choice.equalsIgnoreCase("history")
					&& !choice.equalsIgnoreCase("praise_the_sun"))
			{
				choice = randomMovement();
			}

			if (choice.equals("s")) 
			{
				room3();
			}
			else if (choice.equalsIgnoreCase("history"))
			{
				displayHistory();
			}
			else if (choice.equalsIgnoreCase("map"))
			{
				displayMap();
			}
			else if (choice.equalsIgnoreCase("praise_the_sun"))
			{
				GOD_MODE = true;
			}
			else
			{
				walkIntoWall();
			}
		} while (1==1);
	}

	public static void room6()
	{
		String place = "the Vault";
		String[] things = new String[1];
		things[0] = "3 walking skeletons";
		String direct = "to the east (e)";

		pw.println("You entered " + place);
		steps++;
		if(!roomVisitedFlag[5])
		{
			roomVisitedFlag[5] = true;
			collectMoney();
			noteThingsSeen(things);
		}
		checkSanity();
		checkHP();

		if(!secretRoomFound)
		{
			int discoverRoom = rnd.nextInt(4);
			if(discoverRoom == 0)
			{
				secretRoomFound = true;
			}
		}
		else
		{
			direct += " or to the secret room to the east (x)";
		}

		do
		{
			if(exiting)
			{
				break;
			}

			roomDescribe(place, things, direct);

			String choice = darkly.next();

			//When insane, 50% chance to move randomly north, south, east, or west
			//Will still allow user to check map and history
			if(!sane && rnd.nextInt(2) == 0 
					&& !choice.equalsIgnoreCase("map") 
					&& !choice.equalsIgnoreCase("history")
					&& !choice.equalsIgnoreCase("praise_the_sun"))
			{
				choice = randomMovement();
			}

			if (choice.equals("e")) 
			{
				room7();
			}
			else if(secretRoomFound && choice.equals("x"))
			{
				room8();
			}
			else if (choice.equalsIgnoreCase("history"))
			{
				displayHistory();
			}
			else if (choice.equalsIgnoreCase("map"))
			{
				displayMap();
			}
			else if (choice.equalsIgnoreCase("praise_the_sun"))
			{
				GOD_MODE = true;
			}
			else
			{
				walkIntoWall();
			}
		} while (1==1);
	}

	public static void room7()
	{
		String place = "the Parlor";
		String[] things = new String[1];
		things[0] = "a treasure chest";
		String direct = "to the south (s) or the west (w)";

		pw.println("You entered " + place);
		steps++;
		if(!roomVisitedFlag[6])
		{
			roomVisitedFlag[6] = true;
			collectMoney();
			noteThingsSeen(things);
		}
		checkSanity();
		checkHP();

		do
		{
			if(exiting)
			{
				break;
			}

			roomDescribe(place, things, direct);

			String choice = darkly.next();

			//When insane, 50% chance to move randomly north, south, east, or west
			//Will still allow user to check map and history
			if(!sane && rnd.nextInt(2) == 0 
					&& !choice.equalsIgnoreCase("map") 
					&& !choice.equalsIgnoreCase("history")
					&& !choice.equalsIgnoreCase("praise_the_sun"))
			{
				choice = randomMovement();
			}

			if (choice.equals("s")) 
			{
				room4();
			}
			else if (choice.equals("w")) 
			{
				room6();
			}
			else if (choice.equalsIgnoreCase("history"))
			{
				displayHistory();
			}
			else if (choice.equalsIgnoreCase("map"))
			{
				displayMap();
			}
			else if (choice.equalsIgnoreCase("praise_the_sun"))
			{
				GOD_MODE = true;
			}
			else
			{
				walkIntoWall();
			}
		} while (1==1);
	}

	public static void room8()
	{
		String place = "the Secret Room";
		String[] things = new String[1];
		things[0] = "piles of gold";
		String direct = "to the west (w)";

		pw.println("You entered " + place);
		steps++;
		if(!roomVisitedFlag[7])
		{
			roomVisitedFlag[7] = true;
			collectMoney();
			noteThingsSeen(things);
		}
		checkSanity();
		checkHP();

		do
		{
			if(exiting)
			{
				break;
			}

			roomDescribe(place, things, direct);

			String choice = darkly.next();

			//When insane, 50% chance to move randomly north, south, east, or west
			//Will still allow user to check map and history
			if(!sane && rnd.nextInt(2) == 0 
					&& !choice.equalsIgnoreCase("map") 
					&& !choice.equalsIgnoreCase("history")
					&& !choice.equalsIgnoreCase("praise_the_sun"))
			{
				choice = randomMovement();
			}

			if (choice.equals("w")) 
			{
				room6();
			}
			else if (choice.equalsIgnoreCase("history"))
			{
				displayHistory();
			}
			else if (choice.equalsIgnoreCase("map"))
			{
				displayMap();
			}
			else if (choice.equalsIgnoreCase("praise_the_sun"))
			{
				GOD_MODE = true;
			}
			else
			{
				walkIntoWall();
			}
		} while (1==1);
	}

	public static void exit()
	{
		String place = "the Exit";
		String[] things = new String[1];
		things[0] = "nothing";
		String direct = "nowhere";

		roomDescribe(place, things, direct);

		int roomsVisited = 0;
		for(int i = 0; i < roomVisitedFlag.length; i++)
		{
			if(roomVisitedFlag[i])
			{
				roomsVisited++;
			}
		}
		System.out.printf("%nYou took %d steps%n", steps);
		System.out.printf("You visited %d rooms%n", roomsVisited);
		System.out.printf("You saw: %n%s", thingsSeen);

		if(sane)
		{
			System.out.println("You escape with your mind intact.");
		}
		else if(GOD_MODE)
		{
			System.out.println("You are grossly incandescent.");
		}
		else
		{
			System.out.println("Your mental faculties are compromised.");
		}
		System.out.printf("%nYou have %d hp remaining%n", hp);

		int followed = rnd.nextInt(4);
		if(followed == 0)
		{
			System.out.println("The ghost of Zork has followed you out.");
		}
		else
		{
			System.out.println("You were not followed.");
		}
		exiting = true;
	}

	public static void collectMoney()
	{
		double moneyInRoom = (double)rnd.nextInt(100000) / 100;
		//Using random integer from 0-100000 divided by 100 to give exactly two decimal places
		System.out.println("You found " + currency.format(moneyInRoom));
		moneyCollected += moneyInRoom;

		pw.println("You found " + currency.format(moneyInRoom));
	}

	public static void noteThingsSeen(String[] stuff)
	{
		for (String thing : stuff) {
			thingsSeen += "\t" + thing + "\n";
			pw.println("You saw " + thing);
		}
	}

	public static void displayHistory()
	{
		displayMap();
		pw.flush();
		String line;
		try{
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			System.out.println();
			while ( (line = br.readLine())!= null)
			{
				System.out.println(line);
			}
			System.out.println();
		}
		catch (IOException e)
		{
			System.out.println("Error reading history.");
		}
	}

	public static void displayMap()
	{
		for(int i = 0; i < 7; i++)
		{
			//Dining Room
			if(roomVisitedFlag[4])
			{
				switch(i)
				{
				case 0: 
				case 6: System.out.print("*****************");
				break;
				case 1: System.out.print("*Dining Room\t*");
				break;
				default: System.out.print("*\t\t*");
				break;
				}
			}
			else
			{
				System.out.print(" \t\t ");
			}

			//Vault
			if(roomVisitedFlag[5])
			{
				switch(i)
				{
				case 0: 
				case 6: System.out.print("****************");
				break;
				case 1: System.out.print("*Vault\t\t*");
				break;
				default: System.out.print("*\t\t*");
				break;
				}
			}
			else
			{
				System.out.print(" \t\t ");
			}

			//Parlor
			if(roomVisitedFlag[6])
			{
				//Secret Room
				if(roomVisitedFlag[7])
				{
					switch(i)
					{
					case 0: 
					case 6: System.out.print("****************");
					break;
					case 1: System.out.print("*Parlor\t*");
					break;
					case 3: System.out.print("********\t*");
					break;
					case 4: System.out.print("*Secret*\t*");
					break;
					case 5: System.out.print("*      *\t*");
					break;
					default: System.out.print("*\t\t*");
					break;
					}
				}
				else
				{
					switch(i)
					{
					case 0: 
					case 6: System.out.print("****************");
					break;
					case 1: System.out.print("*Parlor\t*");
					break;
					default: System.out.print("*\t\t*");
					break;
					}
				}
			}
			else
			{
				System.out.print(" \t\t ");
			}
			System.out.println();
		}

		for(int j = 0; j < 7; j++)
		{
			//Library
			if(roomVisitedFlag[2])
			{
				switch(j)
				{
				case 0: 
				case 6: System.out.print("*****************");
				break;
				case 1: System.out.print("*Library\t*");
				break;
				default: System.out.print("*\t\t*");
				break;
				}
			}
			else
			{
				System.out.print(" \t\t ");
			}

			//Front Room
			if(roomVisitedFlag[1])
			{
				switch(j)
				{
				case 0: 
				case 6: System.out.print("****************");
				break;
				case 1: System.out.print("*Front Room\t*");
				break;
				default: System.out.print("*\t\t*");
				break;
				}
			}
			else
			{
				System.out.print(" \t\t ");
			}

			//Kitchen
			if(roomVisitedFlag[3])
			{
				switch(j)
				{
				case 0: 
				case 6: System.out.print("****************");
				break;
				case 1: System.out.print("*Kitchen\t*");
				break;
				default: System.out.print("*\t\t*");
				break;
				}
			}
			else
			{
				System.out.print(" \t\t ");
			}
			System.out.println();
		}

		for(int k = 0; k < 7; k++)
		{
			System.out.print(" \t\t ");
			//Foyer
			if(roomVisitedFlag[0])
			{
				switch(k)
				{
				case 0: 
				case 6: System.out.print("****************");
				break;
				case 1: System.out.print("*Foyer\t\t*");
				break;
				default: System.out.print("*\t\t*");
				break;
				}
			}
			else
			{
				System.out.print(" \t\t ");
			}
			System.out.print(" \t\t ");
			System.out.println();
		}
	}

	public static void checkHP()
	{
		if(!sane)
		{
			System.out.println("You attempt to injure yourself.");
			takeDamage(2); //0-2 damage from trying to hurt yourself
		}
		if(hp <= 0)
		{
			death();
		}
		else
		{
			System.out.println("You currently have " + hp + " hit points.");
		}
	}

	public static void checkSanity()
	{
		if(sane)
		{
			//Sanity has steps/20 chance of decreasing
			int sanityLossChance = rnd.nextInt(21);
			if(sanityLossChance < steps)
			{
				int sanityDamage = rnd.nextInt(3); //When sanity decreases, it decreases by 0-2
				sanity -= sanityDamage;
				System.out.println("You feel spooked. You take " + sanityDamage + " mental damage.");
			}

			if(sanity <= 0)
			{
				sane = false;
				System.out.println("Your current sanity is " + sanity + ".");
				System.out.println("You have gone insane.");
			}
			else
			{
				System.out.println("Your current sanity is " + sanity + ".");
			}
		}
		else
		{
			System.out.println("You have gone insane");
		}
	}

	public static String randomMovement()
	{
		String randomDirection = "";
		int randomChoice = rnd.nextInt(4);
		System.out.print("You stumble and go ");
		switch(randomChoice)
		{
		case 0: randomDirection = "n";
		System.out.println("north.");
		break;
		case 1: randomDirection = "s";
		System.out.println("south.");
		break;
		case 2: randomDirection = "e";
		System.out.println("east.");
		break;
		case 3: randomDirection = "w";
		System.out.println("west.");
		break;
		}
		return randomDirection;
	}

	public static void walkIntoWall()
	{
		System.out.print("You walk into a wall.");
		pw.println("You walked into a wall.");
		takeDamage(2); // 0-2 damage from walking into a wall
		checkSanity();
		checkHP();
	}
	
	public static void death()
	{
		exiting = true;
		System.out.println("You have died.");
		int roomsVisited = 0;
		for(int i = 0; i < roomVisitedFlag.length; i++)
		{
			if(roomVisitedFlag[i])
			{
				roomsVisited++;
			}
		}
		System.out.printf("%nYou took %d steps%n", steps);
		System.out.printf("You visited %d rooms%n", roomsVisited);
		System.out.printf("You saw: %n%s", thingsSeen);
	}
	
	public static void takeDamage(int maxDamage)
	{
		int damage;
		if(GOD_MODE)
		{
			damage = 0;
		}
		else
		{
			damage = rnd.nextInt(maxDamage + 1);
		}
		hp -= damage;
		System.out.println("You take " + damage + " physical damage.");
	}

	public static void main(String[] args) {
		System.out.println("Welcome to the House of Fun.");
		System.out.println("At any time, type \'history\' to view history or \'map\' to display a map.\n");
		room1();
		darkly.close();
		pw.close();
	}

}