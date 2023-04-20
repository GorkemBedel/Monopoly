import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception{
		
		player player1 = new player("player1");
		player player2 = new player("player2");
		banker banker1 = new banker();
		Cards card = new Cards();
		
		boolean chance1 = false;
		boolean chance2 = false;
		boolean chance3 = false;
		boolean chance4 = false; 
		boolean chance5 = false;
		
		PropertyJsonReader property = new PropertyJsonReader();
		ListJsonReader list = new ListJsonReader();
		
		ArrayList <String> commandList = new ArrayList<String>();
		int chanceCount = 0;
		int communityCount = 0;
		
		int chanceCount2 = 0;
		int communityCount2 = 0;
		boolean jail = false;
		boolean jail2 = false;
		boolean jail31_1 = false;
		boolean jail31_2 = false;
		
		
		
							
		
		File file = new File(args[0]);
		Scanner sc = new Scanner(file);
		while(sc.hasNextLine()) {
			commandList.add(sc.nextLine());			
		}
		
		try (PrintWriter outputStream = new PrintWriter("output.txt")) {
			for (String a : commandList) {
				if(a.startsWith("Player 1;") && (player1.inJail) == false) {
					player1.setCurrSquare(Integer.parseInt(a.substring(9)));
					for(properties s : property.squares) {
						if(s.getID().equals(player1.getCurrSquare())){ // PROPERTY ISE 												
							if(!player1.boughtPlaces.contains(s) && !player2.boughtPlaces.contains(s)) { // SAHIP YOKSA
								if(player1.getMoney() >= s.getCost()) {
									player1.buy(player1, s);
									banker1.setMoney(s.getCost());
									outputStream.println(player1.getName() + "\t" + a.substring(9) + "\t" + player1.getCurrSquare() +"\t" + player1.getMoney()+"\t" + player2.getMoney()+"\t" + "Player 1 bought " + s );
								}else {
									outputStream.println("--------------------------------------------------------------------------------------");
									outputStream.println(player1.getName() + "\t" + player1.getMoney() + "\t" + "have:" + "\t" + player1.boughtPlaces);
									outputStream.println(player2.getName() + "\t" + player2.getMoney() + "\t" + "have:" + "\t" + player2.boughtPlaces);
									if(player1.getMoney() > player2.getMoney()) {
										outputStream.println("Banker "+banker1.getMoney() + "\n" + "Winner Player 1" +"\n" + "--------------------------------------------------------------------------------------\r\n"
												+ "");
									
									}else {
										outputStream.println("Banker "+ banker1.getMoney() +"\n"+ "Winner Player 2"+ "\n" + "--------------------------------------------------------------------------------------\r\n"
												+ "");
										
										
									}
								}
								if(player1.getMoney() == 0) {
									outputStream.println("--------------------------------------------------------------------------------------");
									outputStream.println(player1.getName() + "\t" + player1.getMoney() + "\t" + "have:" + "\t" + player1.boughtPlaces);
									outputStream.println(player2.getName() + "\t" + player2.getMoney() + "\t" + "have:" + "\t" + player2.boughtPlaces);
									if(player1.getMoney() > player2.getMoney()) {
										outputStream.println("Banker "+banker1.getMoney() + "\n" + "Winner Player 1" +"\n" + "--------------------------------------------------------------------------------------\r\n"
												+ "");
										
									}else {
										outputStream.println("Banker "+ banker1.getMoney() +"\n"+ "Winner Player 2"+ "\n" + "--------------------------------------------------------------------------------------\r\n"
												+ "");
										
										
									}
								}
								}
							
							else if(player1.boughtPlaces.contains(s)) {
								outputStream.print("Player 1 has " + s.getName());
							}
							
							if(player2.boughtPlaces.contains(s)) {   //SAHIBI RAKIP ISE
								if(s instanceof Land) {
									if(s.getCost() > 0 && s.getCost() <= 2000) {
										player1.setMoney((int)(-s.getCost()*0.4));
										player2.setMoney((int)(s.getCost()*0.4));
										outputStream.println(player1.getName()+ " paid rent for " + s.getName());

									}
									
									if(s.getCost() > 2000 && s.getCost() <= 3000) {
										player1.setMoney((int)(-s.getCost()*0.3));
										player2.setMoney((int)(s.getCost()*0.3));
										outputStream.println(player1.getName()+ " paid rent for " + s.getName());
									}
									if(s.getCost() > 3000 && s.getCost() <= 4000) {
										player1.setMoney((int)(-s.getCost()*0.35));
										player2.setMoney((int)(s.getCost()*0.35));
										outputStream.println(player1.getName()+ " paid rent for " + s.getName());
									}

									
								}
								if(s instanceof Railroad) {
									int n = 0;

									for (properties railroadnumber : player2.boughtPlaces) {
										if(railroadnumber instanceof Railroad) {
											n ++;									
										}			
									}
									player1.setMoney(-(n*25));
									player2.setMoney(n*25);
									outputStream.println(player1.getName()+ " paid rent for " + s.getName());
								}
								
								
								if(s instanceof Company) {
									player1.setMoney(-4*Integer.parseInt(a.substring(9)));
									player2.setMoney(+4*Integer.parseInt(a.substring(9)));
									outputStream.println(player1.getName()+ " paid rent for " + s.getName());
															
								}
								
								
							}
							
								
							}
							
							}																					
					}				
					if(player1.getCurrSquare() == 1) {
						player1.setMoney(200);
						banker1.setMoney(-200);
					}
					if(player1.getCurrSquare() == 3 || player1.getCurrSquare() == 18 || player1.getCurrSquare() == 34) {	
						switch (communityCount) {
						case 0:
							player1.teleport(1);;
							player1.setMoney(200);
							banker1.setMoney(-200);
							communityCount++;
							outputStream.println(player1.getName() + "\t" + a.substring(9) + "\t" + player1.getCurrSquare() +"\t" + player1.getMoney()+"\t" + player2.getMoney()+"\t" + "Player 1 draw "+ list.communityCardList.get(0));

							break;
						case 1:
							player1.setMoney(75);
							banker1.setMoney(-75);
							communityCount++;
							outputStream.println(player1.getName() + "\t" + a.substring(9) + "\t" + player1.getCurrSquare() +"\t" + player1.getMoney()+"\t" + player2.getMoney()+"\t" + "Player 1 draw " + list.communityCardList.get(1));

							break;
						case 2:
							player1.setMoney(-75);
							banker1.setMoney(75);
							communityCount ++;
							outputStream.println(player1.getName() + "\t" + a.substring(9) + "\t" + player1.getCurrSquare() +"\t" + player1.getMoney()+"\t" + player2.getMoney()+"\t" + "Player 1 draw "+list.communityCardList.get(2));

							break;
						case 3:
							player1.setMoney(10);
							player2.setMoney(-10);
							communityCount++;
							outputStream.println(player1.getName() + "\t" + a.substring(9) + "\t" + player1.getCurrSquare() +"\t" + player1.getMoney()+"\t" + player2.getMoney()+"\t" + "Player 1 draw "+list.communityCardList.get(3));

							break;
						case 4:
							player1.setMoney(50);
							player2.setMoney(-50);
							communityCount++;
							outputStream.println(player1.getName() + "\t" + a.substring(9) + "\t" + player1.getCurrSquare() +"\t" + player1.getMoney()+"\t" + player2.getMoney()+"\t" + "Player 1 draw "+list.communityCardList.get(4));

							break;
						case 5:
							player1.setMoney(20);
							banker1.setMoney(-20);
							communityCount++;
							outputStream.println(player1.getName() + "\t" + a.substring(9) + "\t" + player1.getCurrSquare() +"\t" + player1.getMoney()+"\t" + player2.getMoney()+"\t" + "Player 1 draw " + list.communityCardList.get(5));

							break;
						case 6:
							player1.setMoney(100);
							banker1.setMoney(-100);
							communityCount++;
							outputStream.println(player1.getName() + "\t" + a.substring(9) + "\t" + player1.getCurrSquare() +"\t" + player1.getMoney()+"\t" + player2.getMoney()+"\t" + "Player 1 draw " + list.communityCardList.get(6));

							break;
						case 7:
							player1.setMoney(-100);
							banker1.setMoney(100);
							communityCount++;
							outputStream.println(player1.getName() + "\t" + a.substring(9) + "\t" + player1.getCurrSquare() +"\t" + player1.getMoney()+"\t" + player2.getMoney()+"\t" + "Player 1 draw " + list.communityCardList.get(7));

							break;
						case 8:
							player1.setMoney(-50);
							banker1.setMoney(50);
							communityCount++;
							outputStream.println(player1.getName() + "\t" + a.substring(9) + "\t" + player1.getCurrSquare() +"\t" + player1.getMoney()+"\t" + player2.getMoney()+"\t" + "Player 1 draw " + list.communityCardList.get(8));

							break;
						case 9:
							player1.setMoney(100);
							banker1.setMoney(-100);
							communityCount++;
							outputStream.println(player1.getName() + "\t" + a.substring(9) + "\t" + player1.getCurrSquare() +"\t" + player1.getMoney()+"\t" + player2.getMoney()+"\t" + "Player 1 draw " + list.communityCardList.get(9));

							break;
						case 10:
							player1.setMoney(50);
							banker1.setMoney(-50);
							communityCount++;
							outputStream.println(player1.getName() + "\t" + a.substring(9) + "\t" + player1.getCurrSquare() +"\t" + player1.getMoney()+"\t" + player2.getMoney()+"\t" + "Player 1 draw " + list.communityCardList.get(10));

							break;
								

						default:
							//communityCount = 0;				
						}

					}
					
					if(player1.getCurrSquare() == 5) {
						player1.setMoney(-100);
						banker1.setMoney(100);
						outputStream.println(player1.getName() + "\t" + a.substring(9) + "\t" + player1.getCurrSquare() +"\t" + player1.getMoney()+"\t" + player2.getMoney()+"\t" + "Player 1 paid tax");

					}
					if(player1.getCurrSquare() == 8 || player1.getCurrSquare() == 23 || player1.getCurrSquare() == 37) {
						switch (chanceCount) {
						case 0:
							player1.teleport(1);;
							player1.setMoney(200);
							banker1.setMoney(-200);
							chanceCount++;
							outputStream.println(player1.getName() + "\t" + a.substring(9) + "\t" + player1.getCurrSquare() +"\t" + player1.getMoney()+"\t" + player2.getMoney()+"\t" + "Player 1 draw "+ list.chanceCardList.get(0));

							break;
						case 1:
							player1.teleport(27);
							chanceCount++;
							outputStream.println(player1.getName() + "\t" + a.substring(9) + "\t" + player1.getCurrSquare() +"\t" + player1.getMoney()+"\t" + player2.getMoney()+"\t" + "Player 1 draw " + list.chanceCardList.get(1));

							break;
						case 2:
							player1.setCurrSquare(-3);
							chanceCount ++;
							outputStream.println(player1.getName() + "\t" + a.substring(9) + "\t" + player1.getCurrSquare() +"\t" + player1.getMoney()+"\t" + player2.getMoney()+"\t" + "Player 1 draw "+list.chanceCardList.get(2));

							break;
						case 3:
							player1.setMoney(-15);
							banker1.setMoney(+15);
							chanceCount++;
							outputStream.println(player1.getName() + "\t" + a.substring(9) + "\t" + player1.getCurrSquare() +"\t" + player1.getMoney()+"\t" + player2.getMoney()+"\t" + "Player 1 draw "+list.chanceCardList.get(3));

							break;
						case 4:
							player1.setMoney(150);
							banker1.setMoney(-150);
							chanceCount++;
							outputStream.println(player1.getName() + "\t" + a.substring(9) + "\t" + player1.getCurrSquare() +"\t" + player1.getMoney()+"\t" + player2.getMoney()+"\t" + "Player 1 draw "+list.chanceCardList.get(4));

							break;
						case 5:
							player1.setMoney(100);
							banker1.setMoney(-100);
							chanceCount++;
							outputStream.println(player1.getName() + "\t" + a.substring(9) + "\t" + player1.getCurrSquare() +"\t" + player1.getMoney()+"\t" + player2.getMoney()+"\t" + "Player 1 draw " + list.chanceCardList.get(5));
							break;
							
							

						default:
							chanceCount = 0;				
						}
						
						String action = list.chanceCardList.get(0);										

					}
					
					if(player1.getCurrSquare() == 11) {
						if(jail == false) {
							player1.setJailCount(4);
							player1.setInJail(true);
							outputStream.println(player1.getName() + "\t" + a.substring(9) + "\t" + player1.getCurrSquare() +"\t" + player1.getMoney()+"\t" + player2.getMoney()+"\t" + "Player 1 went to jail");
							jail = true;

						}
						

					}
					
					if(player1.getCurrSquare() == 21) {
						player1.setJailCount(1);
						player1.setFreeParking(true);
						player1.setInJail(true);
					}
					
					if(player1.getCurrSquare() == 31) {
						if(jail == false) {
							player1.setJailCount(4);
							player1.setInJail(true);
							outputStream.println(player1.getName() + "\t" + a.substring(9) + "\t" + "11" +"\t" + player1.getMoney()+"\t" + player2.getMoney()+"\t" + "Player 1 went to jail");
							jail = true;
							player1.teleport(11);

						}
					}
					
					
					if(player1.getCurrSquare() == 39) {
						player1.setMoney(-100);
						banker1.setMoney(100);
					}
					if(player1.getCurrSquare() > 40) {
						player1.setMoney(200);
						player1.teleport(player1.getCurrSquare() % 40);
						if(player1.getCurrSquare() == 11) {
							player1.setJailCount(4);
							player1.setInJail(true);
						}
					}
										
				
				
				if(a.startsWith("Player 1;") && (player1.inJail) == true) {
					if(player1.freeParking == false) {
						player1.setJailCount(-1);
						if(player1.jailCount == 0) {
							player1.inJail = false;
							jail = false;  // GOZDEN GECIR
						}
						if((3-player1.getJailCount()) > 0) {
							outputStream.println(player1.getName() + "\t" + a.substring(9) + "\t" + player1.getCurrSquare() +"\t" + player1.getMoney()+"\t" + player2.getMoney()+"\t" + "Player 1 in jail " + "(count="+ (3-(player1.getJailCount())) + ")" );				
						}
											
					}
					if(player1.freeParking == true) {
						outputStream.println(player1.getName() + "\t" + a.substring(9) + "\t" + player1.getCurrSquare() + "\t" + player1.getMoney() +"\t" + player2.getMoney() + "\t" + "Player 1 is in free parking");
						player1.setFreeParking(false);
						player1.setJailCount(-1);
						if(player1.jailCount == 0) {
							player1.inJail = false;
						}
					}
					
				}
				
								
				
				
				if(a.startsWith("Player 2;") && (player2.inJail) == false) {
					player2.setCurrSquare(Integer.parseInt(a.substring(9)));
					for(properties s : property.squares) {
						if(s.getID().equals(player2.getCurrSquare())) { //PROPERTY ISE
							if(!player1.boughtPlaces.contains(s) && !player2.boughtPlaces.contains(s)) { // SAHIP YOKSA
								if(player2.getMoney() >= s.getCost()) {
									player2.buy(player2, s);
									banker1.setMoney(+s.getCost());
									outputStream.println(player2.getName() + "\t" + a.substring(9) + "\t" + player2.getCurrSquare() +"\t" + player1.getMoney()+"\t" + player2.getMoney()+"\t" + "Player 2 bought " + s );
								}else {
									outputStream.println("Player 2 does not have enough money.");
								}
								if(player2.getMoney() == 0) {
									outputStream.println("--------------------------------------------------------------------------------------");
									outputStream.println(player1.getName() + "\t" + player1.getMoney() + "\t" + "have:" + "\t" + player1.boughtPlaces);
									outputStream.println(player2.getName() + "\t" + player2.getMoney() + "\t" + "have:" + "\t" + player2.boughtPlaces);
									if(player1.getMoney() > player2.getMoney()) {
										outputStream.println("Banker "+banker1.getMoney() + "\n" + "Winner Player 1" +"\n" + "--------------------------------------------------------------------------------------\r\n"
												+ "");
										
									}else {
										outputStream.println("Banker "+ banker1.getMoney() +"\n"+ "Winner Player 2"+ "\n" + "--------------------------------------------------------------------------------------\r\n"
												+ "");
										
										
									}
								}

							}
							
							else if(player2.boughtPlaces.contains(s)) {
								outputStream.print("Player 2 has " + s.getName() );
							}
							
							if(player1.boughtPlaces.contains(s)) {   //SAHIBI RAKIP ISE
								if(s instanceof Land) {
									if(s.getCost() > 0 && s.getCost() <= 2000) {
										player2.setMoney((int)(-s.getCost()*0.4));
										player1.setMoney((int)(s.getCost()*0.4));
										outputStream.println(player2.getName() + " paid rent for " + s.getClass());

									}
									
									if(s.getCost() > 2000 && s.getCost() <= 3000) {
										player2.setMoney((int)(-s.getCost()*0.3));
										player1.setMoney((int)(s.getCost()*0.3));
										outputStream.println(player2.getName() + " paid rent for "+s.getName());
									}
									if(s.getCost() > 3000 && s.getCost() <= 4000) {
										player2.setMoney((int)(-s.getCost()*0.35));
										player1.setMoney((int)(s.getCost()*0.35));
										outputStream.println(player2.getName() + " paid rent for "+ s.getName());
									}

									
								}
								if(s instanceof Railroad) {
									int railroadCount = 0;
									for (properties rail : player2.boughtPlaces) {
										if(rail instanceof Railroad) {
											railroadCount ++;
										}
									}
									player2.setMoney(-(railroadCount * 25));
									player1.setMoney(railroadCount * 25);;
									outputStream.println(player2.getName() + " paid rent for "+ s.getName());
									
								}
								
								
								if(s instanceof Company) {
									player2.setMoney(-4*Integer.parseInt(a.substring(9)));
									player1.setMoney(+4*Integer.parseInt(a.substring(9)));
									outputStream.println(player2.getName() + " paid rent for "+ s.getName());
															
								}
								
								
							}
							
							
											
						}
					}
					if(player2.getCurrSquare() == 1) {
						if(player2.isInJail() == false) {
							player2.setMoney(200);
							banker1.setMoney(-200);

						}
						
					}
					
					if(player2.getCurrSquare() == 3 || player2.getCurrSquare() == 18 || player2.getCurrSquare() == 34) {
						switch (communityCount2) {
						case 0:
							player2.teleport(1);;
							player2.setMoney(200);
							banker1.setMoney(-200);
							communityCount2++;
							outputStream.println(player2.getName() + "\t" + a.substring(9) + "\t" + player2.getCurrSquare() +"\t" + player1.getMoney()+"\t" + player2.getMoney()+"\t" + "Player 2 draw "+ list.communityCardList.get(0));

							break;
						case 1:
							player2.setMoney(75);
							banker1.setMoney(-75);
							communityCount2++;
							outputStream.println(player2.getName() + "\t" + a.substring(9) + "\t" + player2.getCurrSquare() +"\t" + player1.getMoney()+"\t" + player2.getMoney()+"\t" + "Player 2 draw " + list.communityCardList.get(1));

							break;
						case 2:
							player2.setMoney(-75);
							banker1.setMoney(75);
							communityCount2 ++;
							outputStream.println(player2.getName() + "\t" + a.substring(9) + "\t" + player2.getCurrSquare() +"\t" + player1.getMoney()+"\t" + player2.getMoney()+"\t" + "Player 2 draw "+list.communityCardList.get(2));

							break;
						case 3:
							player2.setMoney(10);
							player1.setMoney(-10);
							communityCount2++;
							outputStream.println(player2.getName() + "\t" + a.substring(9) + "\t" + player2.getCurrSquare() +"\t" + player1.getMoney()+"\t" + player2.getMoney()+"\t" + "Player 2 draw "+list.communityCardList.get(3));

							break;
						case 4:
							player2.setMoney(50);
							player1.setMoney(-50);
							communityCount2++;
							outputStream.println(player2.getName() + "\t" + a.substring(9) + "\t" + player2.getCurrSquare() +"\t" + player1.getMoney()+"\t" + player2.getMoney()+"\t" + "Player 2 draw "+list.communityCardList.get(4));

							break;
						case 5:
							player2.setMoney(20);
							banker1.setMoney(-20);
							communityCount2++;
							outputStream.println(player2.getName() + "\t" + a.substring(9) + "\t" + player2.getCurrSquare() +"\t" + player1.getMoney()+"\t" + player2.getMoney()+"\t" + "Player 2 draw " + list.communityCardList.get(5));

							break;
						case 6:
							player2.setMoney(100);
							banker1.setMoney(-100);
							communityCount2++;
							outputStream.println(player2.getName() + "\t" + a.substring(9) + "\t" + player2.getCurrSquare() +"\t" + player1.getMoney()+"\t" + player2.getMoney()+"\t" + "Player 2 draw " + list.communityCardList.get(6));

							break;
						case 7:
							player2.setMoney(-100);
							banker1.setMoney(100);
							communityCount2++;
							outputStream.println(player2.getName() + "\t" + a.substring(9) + "\t" + player2.getCurrSquare() +"\t" + player1.getMoney()+"\t" + player2.getMoney()+"\t" + "Player 2 draw " + list.communityCardList.get(7));

							break;
						case 8:
							player2.setMoney(-50);
							banker1.setMoney(50);
							communityCount2++;
							outputStream.println(player2.getName() + "\t" + a.substring(9) + "\t" + player2.getCurrSquare() +"\t" + player1.getMoney()+"\t" + player2.getMoney()+"\t" + "Player 2 draw " + list.communityCardList.get(8));

							break;
						case 9:
							player2.setMoney(100);
							banker1.setMoney(-100);
							communityCount2++;
							outputStream.println(player2.getName() + "\t" + a.substring(9) + "\t" + player2.getCurrSquare() +"\t" + player1.getMoney()+"\t" + player2.getMoney()+"\t" + "Player 2 draw " + list.communityCardList.get(9));

							break;
						case 10:
							player2.setMoney(50);
							banker1.setMoney(-50);
							communityCount2++;
							outputStream.println(player2.getName() + "\t" + a.substring(9) + "\t" + player2.getCurrSquare() +"\t" + player1.getMoney()+"\t" + player2.getMoney()+"\t" + "Player 2 draw " + list.communityCardList.get(10));

							break;
								

						default:
							communityCount = 0;				
						}
					}
					
					if(player2.getCurrSquare() == 5) {
						player2.setMoney(-100);
						banker1.setMoney(100);
						outputStream.println(player2.getName() + "\t" + a.substring(9) + "\t" + player2.getCurrSquare() +"\t" + player1.getMoney()+"\t" + player2.getMoney()+"\t" + "Player 2 paid tax");

						
					}
					if(player2.getCurrSquare() == 8 || player2.getCurrSquare() == 23 || player2.getCurrSquare() == 37) {
						switch (chanceCount2) {
						case 0:
							player2.teleport(1);;
							player2.setMoney(200);
							banker1.setMoney(-200);
							chanceCount2++;
							outputStream.println(player2.getName() + "\t" + a.substring(9) + "\t" + player2.getCurrSquare() +"\t" + player1.getMoney()+"\t" + player2.getMoney()+"\t" + "Player 2 draw "+ list.chanceCardList.get(0));

							break;
						case 1:
							player2.teleport(27);
							chanceCount2++;
							outputStream.println(player2.getName() + "\t" + a.substring(9) + "\t" + player2.getCurrSquare() +"\t" + player1.getMoney()+"\t" + player2.getMoney()+"\t" + "Player 2 draw " + list.chanceCardList.get(1));

							break;
						case 2:
							player1.setCurrSquare(-3);
							chanceCount2 ++;
							outputStream.println(player2.getName() + "\t" + a.substring(9) + "\t" + player2.getCurrSquare() +"\t" + player1.getMoney()+"\t" + player2.getMoney()+"\t" + "Player 2 draw "+list.chanceCardList.get(2));

							break;
						case 3:
							player1.setMoney(-15);
							banker1.setMoney(+15);
							chanceCount2++;
							outputStream.println(player2.getName() + "\t" + a.substring(9) + "\t" + player2.getCurrSquare() +"\t" + player1.getMoney()+"\t" + player2.getMoney()+"\t" + "Player 2 draw "+list.chanceCardList.get(3));

							break;
						case 4:
							player1.setMoney(150);
							banker1.setMoney(-150);
							chanceCount2++;
							outputStream.println(player2.getName() + "\t" + a.substring(9) + "\t" + player2.getCurrSquare() +"\t" + player1.getMoney()+"\t" + player2.getMoney()+"\t" + "Player 2 draw "+list.chanceCardList.get(4));

							break;
						case 5:
							player1.setMoney(100);
							banker1.setMoney(-100);
							chanceCount2++;
							outputStream.println(player2.getName() + "\t" + a.substring(9) + "\t" + player2.getCurrSquare() +"\t" + player1.getMoney()+"\t" + player2.getMoney()+"\t" + "Player 2 draw " + list.chanceCardList.get(5));

							break;
							
							

						default:
							chanceCount = 0;				
						}
						
						String action = list.chanceCardList.get(0);	

					}
					if(player2.getCurrSquare() == 11) {
						if(jail2 == false) {
							player2.setJailCount(4);
							player2.setInJail(true);
							outputStream.println(player2.getName() + "\t" + a.substring(9) + "\t" + player2.getCurrSquare() +"\t" + player1.getMoney()+"\t" + player2.getMoney()+"\t" + "Player 2 went to jail");
							jail2 = true;
						}
						
					}
					
					if(player2.getCurrSquare() == 21) {
						player2.setJailCount(1);
						player2.setFreeParking(true);
						player2.setInJail(true);
					}
					
					if(player2.getCurrSquare() == 31) {
						if(jail2 == false) {
							player2.setJailCount(4);
							player2.setInJail(true);
							outputStream.println(player2.getName() + "\t" + a.substring(9) + "\t" + "11" +"\t" + player1.getMoney()+"\t" + player2.getMoney()+"\t" + "Player 2 went to jail");
							jail = true;
							player2.teleport(11);

						}
					}
					
					
					if(player2.getCurrSquare() == 39) {
						player2.setMoney(-100);
						banker1.setMoney(100);
					}
					
					if(player2.getCurrSquare() > 40) {
						player2.setMoney(200);
						player2.teleport(player2.getCurrSquare() % 40);

					}
				}
				if(a.startsWith("Player 2;") && (player2.inJail) == true) {
					if(player2.freeParking == false) {
						
						
						player2.setJailCount(-1);
						if(player2.jailCount == 0) {
							player2.inJail = false;
							jail2 = false;
						}
						if((3-player2.getJailCount())>0){
							outputStream.println(player2.getName() + "\t" + a.substring(9) + "\t" + player2.getCurrSquare() +"\t" + player1.getMoney()+"\t" + player2.getMoney()+"\t" + "Player 2 in jail " + "(count="+ (3-player2.getJailCount())+")" );
						}
					}
					if(player2.freeParking == true) {
						outputStream.println(player2.getName() + "\t" + a.substring(9) + "\t" + player2.getCurrSquare() + "\t" + player1.getMoney() +"\t" + player2.getMoney() + "\t" + "Player 2 is in free parking");
						player2.setJailCount(-1);
						player2.setFreeParking(false);
						if(player2.jailCount == 0) {
							player2.inJail = false;
						}

					}
					
				}
				
				
				
				if(a.startsWith("show")) {
					outputStream.println("--------------------------------------------------------------------------------------");
					outputStream.println(player1.getName() + "\t" + player1.getMoney() + "\t" + "have:" + "\t" + player1.boughtPlaces);
					outputStream.println(player2.getName() + "\t" + player2.getMoney() + "\t" + "have:" + "\t" + player2.boughtPlaces);
					if(player1.getMoney() > player2.getMoney()) {
						outputStream.println("Banker "+banker1.getMoney() + "\n" + "Winner Player 1" +"\n" + "--------------------------------------------------------------------------------------\r\n"
								+ "");					
					}else {
						outputStream.println("Banker "+ banker1.getMoney() +"\n"+ "Winner Player 2"+ "\n" + "--------------------------------------------------------------------------------------\r\n"
								+ "");						
						
					}

				}
			}
		outputStream.close();
		}
		
	


					

		






		
		

		

	}

}
	
