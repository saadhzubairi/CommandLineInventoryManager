import java.util.ArrayList;
import java.util.Scanner;

abstract class Item {
	public String name;
	public double price;
	public int quantity;
	Item() {
	}
	Item(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getPrice() {
		return price;
	}
	public int getQuantity() {
		return quantity;
	}
	@Override
	public String toString() {
		return "name    : " + name + "\nprice   : " + price + "\nquantity: " + quantity;
	}
}
class Clothes extends Item {
	Clothes() {
	}
	Clothes(String name, double price, int quantity) {
		super(name, price, quantity);
	}
}
class Cosmetics extends Item {
	Cosmetics() {
	}
	Cosmetics(String name, double price, int quantity) {
		super(name, price, quantity);
	}
}
class Electronics extends Item {
	Electronics() {
	}
	Electronics(String name, double price, int quantity) {
		super(name, price, quantity);
	}
}
class Order {
	public String CustomerName;
	public double OrderTotal;
	public ArrayList<Item> OrderItems = new ArrayList<>();
	public void addItem(Item I) {
		OrderItems.add(I);
	}
	public void removeItem(Item I) {
		OrderItems.remove(I);
	}
	public String showItems(){
		String It = "";
		for(int i = 0; i<OrderItems.size(); i++){
			It = It + "#" + (i+1) + " " + OrderItems.get(i).name +"  $"+ OrderItems.get(i).price +"  "+OrderItems.get(i).quantity +" pcs" +"\n";
		}
		return It;
	}
	public void roughshow(){
		System.out.println("Your Order:");
		for(int i = 0; i<OrderItems.size(); i++){
			System.out.println(OrderItems.get(i).name+ " " + OrderItems.get(i).quantity+" pcs " + OrderItems.get(i).price*OrderItems.get(i).quantity);
		}
		System.out.println("ORDER TOTAL ================= $"+OrderTotal);
	}
	@Override
	public String toString() {
		return "\nCustomer Name  : " + CustomerName 
			 + "\nOrder Total    : $" + OrderTotal 
			 + "\n---------OrderItems---------\n" 
			 + showItems() 
			 +"\n*****************************";
	}
}
class Inventory {
	public ArrayList<Item> Item = new ArrayList<>();
	public ArrayList<Order> Order = new ArrayList<>();
	Inventory() {
	}
	public void addInventory(Item I) {
		Item.add(I);
	}
	public void addOrders(Order O) {
		Order.add(O);
	}
	public String getInventory() {
		return Item.toString();
	}
	public String getOrders() {
		return Order.toString();
	}
	public void ShowInventory(){
		System.out.println("---Clothes---");
		for (int i = 0; i < Item.size(); i++)  
		{
			if (Item.get(i) instanceof Clothes) 
			{
				System.out.println("\n" + Item.get(i) + "\n");
			}
		}
		System.out.println("---Cosmetics---");
		for (int i = 0; i < Item.size(); i++) 
		{
			if (Item.get(i) instanceof Cosmetics) 
			{
				System.out.println("\n" + Item.get(i) + "\n");
			}
		}
		System.out.println("---Electronics---");
		for (int i = 0; i < Item.size(); i++) 
		{
			if (Item.get(i) instanceof Electronics) 
			{
				System.out.println("\n" + Item.get(i) + "\n");
			}
		}
	}
	
	public void ShowOrders(){
		for(int i =0; i<Order.size(); i++){
			System.out.println("#"+i +": " +Order.get(i).CustomerName + " ---- $" + Order.get(i).OrderTotal);
		}
	}
	@Override
	public String toString() {
		return "\nItems: \n" + Item + "\nOrder: \n" + Order;
	}
}

public class IDMS {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Inventory inv = new Inventory();
		while (true) {
			System.out.print("\033[H\033[2J");
			int X=0;System.out.println(
					"----------------------------\nWelcome to Inventroy System!\n----------------------------\nPlease Make your Selection\n(1) Add Inventroy\n(2) Add Order\n(3) Show Inventory\n(4) Show Orders\n(5) Show All Details\n(6) Exit Systems");
			
			try{
				X = in.nextInt();in.nextLine();
			}
			catch(Exception e){
				System.out.println("ENTER A NUMBER!");
			}
			if (X == 1) {
				while(true){
					System.out.print("\033[H\033[2J");
					System.out.println("You can add Items from the following List\n(1) Clothes\n(2) Cosmetics\n(3) Electronics\n(0) To Go Back");
					int add = in.nextInt(); in.nextLine();
					String name = null;
					double price = 0.0;
					int quantity = 0;
					if(add!=0 && add<4){
						System.out.println("Enter Name:");
						name = in.nextLine();
						System.out.println("Enter Price per Unit");
							try{
								price = Double.parseDouble(in.nextLine());
							}
							catch(NumberFormatException ne){
								System.out.println("INVALID INPUT!\n!INPUT PRICE AGAIN!");
								price = Double.parseDouble(in.nextLine());					
							}
						System.out.println("Enter Quantity:");
							try{
								quantity = Integer.parseInt(in.nextLine());
							}
							catch(NumberFormatException ne){
								System.out.println("INVALID INPUT!\n\n!INPUT QUANTITY AGAIN!");
								quantity = Integer.parseInt(in.nextLine());
							}
					}
					
					if (add == 1) {
						Item I = new Clothes(name, price, quantity);
						inv.addInventory(I);
					} 
					else if (add == 2) {
						Item I = new Cosmetics(name, price, quantity);
						inv.addInventory(I);
					} 
					else if (add == 3) {
						Item I = new Electronics(name, price, quantity);
						inv.addInventory(I);
					}
					else if (add == 0) break;
					else if (add>3 || add<0){
						System.out.println("Invalid Input!\nPress Enter"); 
						in.nextLine();
					}
				}
			}
			
			if (X == 2) {
                while(true){
					System.out.print("\033[H\033[2J");
                    System.out.println("Guidelines :\n-----------------------------");
                    System.out.println("Press (1) to Create New Order");
                    System.out.println("Press (0) to Exit\n-----------------------------");
					int alpha=-1;
					try {
						alpha = Integer.parseInt(in.nextLine());
					} 
					catch (NumberFormatException ne) {
						System.out.println("INVALID! ENTER AGAIN");
					}
					if(alpha==1){
                        Order NewOrder = new Order();
                        System.out.println("Customer Name: ");
                        String CusName = in.nextLine();
						double Ordtot = 0.0;
						NewOrder.OrderTotal = 0.0;
						NewOrder.CustomerName = CusName.toUpperCase();
						System.out.print("\033[H\033[2J");
                        System.out.println("Select from the Following Items:\n");
                        inv.ShowInventory();
                        //add or remove items:
                outer : while(true){
                            System.out.println("Enter Item Name to Add:");
                            String ITEM = in.next();
                            for(int i = 0; i<inv.Item.size(); i++){
								if(inv.Item.get(i).name.toLowerCase().replaceAll(" ", "").equals(ITEM.toLowerCase().replaceAll(" ", "")))
                                {
                                    Item comp = inv.Item.get(i);
                                    String dapname = inv.Item.get(i).name;
                                    double dappriz = inv.Item.get(i).price;
                                    System.out.println("Enter Quantity:");
									int dapquan = in.nextInt();in.nextLine();
									if(dapquan>comp.quantity){
										System.out.println("Sorry, But we don't have that many\nEnter Quantity again:");
										dapquan = in.nextInt();in.nextLine();
									}
									else{
										inv.Item.get(i).quantity=inv.Item.get(i).quantity-dapquan;
									}

                                    Ordtot = Ordtot + dapquan*dappriz;
                                    if(comp instanceof Clothes){
                                        NewOrder.OrderItems.add(new Clothes(dapname, dappriz, dapquan));   
                                    }
                                    else if(comp instanceof Cosmetics){
                                        NewOrder.OrderItems.add(new Cosmetics(dapname, dappriz, dapquan));    
                                    }
                                    else if(comp instanceof Electronics){
                                        NewOrder.OrderItems.add(new Electronics(dapname, dappriz, dapquan));    
                                    }
									
									NewOrder.OrderTotal = NewOrder.OrderTotal + Ordtot;
									System.out.println("Wanna Add More Items? (Y/N)");
									
									String prompt = in.nextLine();
									
									if(prompt.toLowerCase().equals("y")){i=0; break;}
									else if(prompt.toLowerCase().equals("n")) {
										System.out.println("This is your Order:");
										System.out.println(NewOrder);
										System.out.println("To proceed, press enter, or input \"edit\" to edit");
										String oog = in.nextLine();
										if(oog.isEmpty() || oog.isBlank()){
											inv.addOrders(NewOrder); break outer;
										}
									}
									else{
										System.out.println("This is your Order:");
										System.out.println(NewOrder);
										System.out.println("To proceed, press enter, or input \"del\" to remove item");
										String oog = in.nextLine();
										if(oog.isEmpty() || oog.isBlank()){
											inv.addOrders(NewOrder); break outer;
										}
									}
								}
								else if(i==inv.Item.size()-1 && !(inv.Item.get(i).name.toLowerCase().replaceAll(" ", "").equals(ITEM.toLowerCase().replaceAll(" ", ""))))
								{
                                    while(true){
										System.out.println("Sorry, but the item you are looking for is unavailable at the moment\n----------------Meanwhile Press Enter to Return---------------------");
                                        String enter = in.nextLine();
										if(enter.isEmpty() || enter.isBlank() || enter.equals("0") || enter.equals("NULL")){break;}
                                    }
                                }
                            }
                        }
                    }
                    else if(alpha==0){
						break;
                    }
                    else{
                        while(true){
                            System.out.println(".....INVALID!....\n[ENTER TO RETURN]");
                            String x = in.nextLine();
                            if(x.isBlank() || x.isEmpty() ) break;
                        }
                    }
                }					
			}
			
			if (X == 3) {
				while(true){	
					System.out.println("---------Inventory---------\n");
					inv.ShowInventory();
					System.out.println("\n**Press Enter to Return**\n");
					String x = in.nextLine();
					if(x.isBlank() || x.isEmpty()) break;
				}
			}
			
			if (X == 4) {
				while(true){
					System.out.println("-------Orders-------");
					System.out.println(inv.getOrders());
					System.out.println("\n**Press Enter to Return**\n");
					String x = in.nextLine();
					if(x.isBlank() || x.isEmpty()) break;
				}	
			}
			
			if (X == 5) {
				while(true){ 
					System.out.println("_____________ALL DETAILS:_____________" + "\n" +
									   "--------------------------------------" + "\n");
					System.out.println("**********-----Inventory----**********\n");
					inv.ShowInventory();
					System.out.println("\n\n**********-------ORDERS-----**********\n");
					inv.ShowOrders();
					System.out.println("\n**Press Enter to Return**\n");
					String x = in.nextLine();
					if(x.isBlank() || x.isEmpty()) break;
				}
			}
			
			if (X == 6) {
				System.out.println("Thank you for using our program, Exiting Sequence Initiate");
				while(true){
					in.nextLine();
				}
			}
			
			if (X > 6 || X < 1) {
				while(true){
					System.out.println("Please Enter Valid Number");
					System.out.println("\n**Press Enter to Return**\n");
					String x = in.nextLine();
					if(x.isBlank() || x.isEmpty()) break;
				}
			}
		}
	}
}