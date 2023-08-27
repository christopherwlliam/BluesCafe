import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	Scanner scan = new Scanner(System.in);
	int choose;
	int x;
	int flag;
	String item;
	Double price = 0.0;
	Double tax = 0.0;
	Double service = 0.0;
	
	public class Order{
		Double totalPrice = 0.0;
		ArrayList<String>name = new ArrayList<>();
		int table;
	}
	
	public static void main(String[] args) {
		new Main();
		
	}
	
	public void menu() {
		System.out.println("============================");
		System.out.println("|\t Blues Café        |");
		System.out.println("============================");
		System.out.println("1. Add Order");
		System.out.println("2. Show All Orders");
		System.out.println("3. Remove Order");
		System.out.println("4. Exit");
	}
	
	public Main() {
		ArrayList<Order>data = new ArrayList<>();
		do {
			menu();
			System.out.print("Silahkan masukkan nomor yang diinginkan ");
			choose = scan.nextInt();
			scan.nextLine();
			if(choose == 1) {
				Order order = new Order();
				System.out.print("Masukkan nomor tabel : ");
				x = scan.nextInt();
				scan.nextLine();
				if(data.size() == 0) {
					order.table = x;
					do {
						System.out.print("Silahkan masukkan item (ketik 'no' jika sudah selesai): ");
						item = scan.next();
						scan.nextLine();
						if(item.equals("no")) {
							break;
						}
						System.out.print("Masukkan Harga : ");
						price = scan.nextDouble();
						order.name.add(item);
						order.totalPrice = order.totalPrice + price;
						
						System.out.println("List item yang telah dimasukkan:");
						for(int i=0; i<order.name.size(); i++) {
							System.out.println("- " + order.name.get(i));
						}	
					}while(!item.equals("no"));
					tax =  order.totalPrice * 10 / 100 ;
					service = order.totalPrice * 75 / 1000;
					order.totalPrice = order.totalPrice + tax + service;
					data.add(order);
				}else {
					flag = 0;
					for(int i = 0; i < data.size(); i++) {
						if(data.get(i).table == x) {
							do {
								System.out.print("Silahkan masukkan item (ketik 'no' jika sudah selesai): ");
								item = scan.next();
								scan.nextLine();
								if(item.equals("no")) {
									break;
								}
								System.out.print("Masukkan Harga : ");
								price = scan.nextDouble();
								data.get(i).name.add(item);
								data.get(i).totalPrice = data.get(i).totalPrice + price;
								
								System.out.println("List item yang telah dimasukkan:");
								for(int j=0; j<data.get(i).name.size(); j++) {
									System.out.println("- " + data.get(i).name.get(j));
								}	
							}while(!item.equals("no"));
							tax = data.get(i).totalPrice * 10 / 100;
							service = data.get(i).totalPrice * 75 / 1000;
							data.get(i).totalPrice = data.get(i).totalPrice + tax + service;
							flag = 1;
							break;
						}
						if(flag == 1) {
							break;
						}
					}
					
					if(flag == 0) {
						order.table = x;
						do {
							System.out.print("Silahkan masukkan item (ketik 'no' jika sudah selesai): ");
							item = scan.next();
							scan.nextLine();
							if (item.equals("no")) {
								break;
							}
							System.out.print("Masukkan Harga : ");
							price = scan.nextDouble();
							order.name.add(item);
							order.totalPrice = order.totalPrice + price;

							System.out.println("List item yang telah dimasukkan:");
							for (int j = 0; j < order.name.size(); j++) {
								System.out.println(j + 1 + ". " + order.name.get(j));
							}
						} while (!item.equals("no"));
						tax = order.totalPrice * 10 / 100;
						service = order.totalPrice * 75 / 1000;
						order.totalPrice = order.totalPrice + tax + service;
						data.add(order);
					}
				}
				
				
			}else if(choose == 2) {
				if(data.size() < 1) {
					System.out.println("Tidak ada orderan");
					scan.nextLine();
				}
				for(int i=0; i<data.size(); i++) {
					System.out.println("Order nomor " + (i+1) + " : " + data.get(i).name + " = Rp" + data.get(i).totalPrice);
				}
			}else if(choose == 3) {
				if(data.size() < 1) {
					System.out.println("Tidak ada orderan");
					scan.nextLine();
				}
				for(int i=0; i<data.size(); i++) {
					System.out.println("Order ke " + (i+1) + " : " + data.get(i).name + " = Rp" + data.get(i).totalPrice);
				}
				System.out.print("Masukkan nomor orderan yang ingin dihapus: ");
				choose = scan.nextInt();
				scan.nextLine();
				data.remove(choose - 1);
			}else if(choose < 1 || choose > 4) {
				System.out.println("Pilih angka antara 1 sampai 4");
			}
		}while(choose != 4);
		System.out.println("Have a good day and thank you!");
	}



}
