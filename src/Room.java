import java.util.ArrayList;

public class Room {

	private String roomName;
	private Inventory things;
	private boolean visited;
	private ArrayList<Room> connectedRooms;

	//Constructors
	public Room()
	{

	}
	public Room(String name)
	{
		roomName = name;
		things = new Inventory();
		visited = false;
		connectedRooms = new ArrayList<Room>();
	}
	public Room(String name, Inventory stuff, boolean seen)
	{
		roomName = name;
		things = stuff;
		visited = seen;
		connectedRooms = new ArrayList<Room>();
	}
	//end Constructors

	//Getters
	public String getRoomName()
	{
		return roomName;
	}
	public Inventory getThings()
	{
		return things;
	}
	public boolean getVisited()
	{
		return visited;
	}
	public ArrayList<Room> getConnectedRooms()
	{
		return connectedRooms;
	}
	//end Getters

	//Setters
	public void setRoomName(String name)
	{
		roomName = name;
	}
	public void setThings(Inventory stuff)
	{
		things = stuff;
	}
	public void setVisited(boolean seen)
	{
		visited = seen;
	}
	//end Setters

	//Other methods
	public void addConnection(Room otherRoom)
	{
		boolean alreadyConnected = false;
		for(Room aRoom: connectedRooms)
		{
			if(aRoom.equals(otherRoom))
			{
				alreadyConnected = true;
			}
		}
		if(!alreadyConnected)
		{
			connectedRooms.add(otherRoom);
			otherRoom.getConnectedRooms().add(this);
		}
	}

	public void addConnection(Room room1, Room room2)
	{
		addConnection(room1);
		addConnection(room2);
	}

	public void addConnection(Room room1, Room room2, Room room3)
	{
		addConnection(room1);
		addConnection(room2);
		addConnection(room3);
	}

	public boolean equals(Room otherRoom)
	{
		boolean same = false;
		if(this.getRoomName().equals(otherRoom.getRoomName()))
		{
			same = true;
		}
		return same;
	}

	public boolean isConnected(Room otherRoom)
	{
		boolean connected = false;
		for(Room aRoom: connectedRooms)
		{
			if(aRoom.equals(otherRoom))
			{
				connected = true;
			}
		}
		return connected;
	}
	
	@Override
	public String toString()
	{
		String returnString = "Room Name: " + roomName + "\n";
		returnString += things.toString();
		returnString += "\nConnected to: ";
		for(Room aRoom: connectedRooms)
		{
			returnString += "\n\t" + aRoom.getRoomName();
		}
		return returnString;
	}
}
