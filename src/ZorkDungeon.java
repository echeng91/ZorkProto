import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ZorkDungeon {

	public static void main(String[] args)
	{
		Random rnd = new Random();
		Scanner sc = new Scanner(System.in);

		Room foyer = new Room("Foyer");
		Room frontRoom = new Room("Front Room");
		Room library = new Room("Library");
		Room kitchen = new Room("Kitchen");
		Room diningRoom = new Room("Dining Room");
		Room vault = new Room("Vault");
		Room parlor = new Room("Parlor");
		SecretRoom secret = new SecretRoom("Secret Room");

		foyer.addConnection(frontRoom);
		frontRoom.addConnection(library, kitchen);
		library.addConnection(diningRoom);
		kitchen.addConnection(parlor);
		parlor.addConnection(vault);

		//populates rooms with money
		ArrayList<Room> rooms = new ArrayList<Room>();
		rooms.add(foyer);
		rooms.add(frontRoom);
		rooms.add(library);
		rooms.add(kitchen);
		rooms.add(diningRoom);
		rooms.add(vault);
		rooms.add(parlor);
		rooms.add(secret);

		for(Room room: rooms)
		{
			room.getThings().addMoney((double)rnd.nextInt(100000)/100.0);
		}
		System.out.print("Input name: ");
		Player p1 = new Player(sc.nextLine());
		p1.setLocation(foyer);
		String choice = "";
		while(!choice.equals("exit"))
		{
			if(p1.getLocation().equals(vault))
			{
				if(rnd.nextInt(4) == 0 && !secret.getDiscovered())
				{
					System.out.println(secret.discover());
					secret.addConnection(vault);
				}
			}
			System.out.println(p1.getLocation().toString());
			System.out.print("Where will you go? ");
			choice = sc.nextLine();
			System.out.println();
			boolean roomFound = false;
			if(choice.equals("take"))
			{
				System.out.println(p1.takeAllFromRoom());
			}
			else if(choice.equals("status"))
			{
				System.out.println(p1.getStatus());
			}
			else if(choice.equals("exit"))
			{
				System.out.println("Coward");
			}
			else
			{
				for(Room room: rooms)
				{
					if(room.getRoomName().equalsIgnoreCase(choice))
					{
						roomFound = true;
						System.out.println(p1.moveTo(room));
					}
				}
				if(!roomFound)
				{
					System.out.println("No such room.");
				}
			}
			
			System.out.println();
		}

		sc.close();
	}
}
