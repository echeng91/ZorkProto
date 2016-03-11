import java.text.NumberFormat;

public class Player extends Character{

	public Player(String name)
	{
		super(name);
	}
	
	public String moveTo(Room aRoom)
	{
		String movement;
		this.getLocation().setVisited(true);
		if(this.getLocation().isConnected(aRoom) || aRoom.getVisited())
		{
			this.setLocation(aRoom);
			movement = "Moved to " + this.getLocation().getRoomName();
		}
		else
		{
			movement = "Cannot go there. Remain in " + this.getLocation().getRoomName();
		}
		return movement;
	}
	

	/*
	 * empty inventory of other, add all of them to player inventory
	 */
	public String takeAllFromRoom()
	{
		String loot = "Looted: \n";
		for(Item item: this.getLocation().getThings().getItems())
		{
			this.getInventory().addItem(item);
			this.getLocation().getThings().removeItem(item);
			loot += item.getID();
		}
		this.getInventory().addMoney(this.getLocation().getThings().getMoney());
		loot += NumberFormat.getCurrencyInstance().format(this.getLocation().getThings().getMoney());
		this.getLocation().getThings().setMoney(0.00);
		return loot;
	}
	
	public String getStatus()
	{
		String status = "";
		status += "Name: " + this.getID();
		status += "\nInventory: " + this.getInventory().toString();
		return status;
	}
	
}
