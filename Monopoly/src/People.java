import java.util.ArrayList;

public class People {
	private Integer money;
	//Integer jailCount = 0;
	public People() {
	
		
	}
	
	//public Integer getJailCount() {
		//return jailCount;
	//}
	//public void setJailCount(Integer jailCount) {
		//this.jailCount += jailCount;
		
	//}
	public Integer getMoney() {
		return money;
	}
	public void setMoney(Integer money) {
		this.money += money;
	}
	

}

class player extends People{
	properties propertiesObject = new properties();
	PropertyJsonReader propertyObject = new PropertyJsonReader();
	ArrayList<Square> ownedPropertiesList = new ArrayList();

	public boolean freeParking = false;
	public boolean isFreeParking() {
		return freeParking;
	}





	public void setFreeParking(boolean freeParking) {
		this.freeParking = freeParking;
	}

	public Integer money = 15000;
	public Integer jailCount = 0;
	
	public Integer getJailCount() { //GETTER
		return jailCount;
	}





	public void setJailCount(Integer jailCount) { //SETTER
		this.jailCount += jailCount;
		if(jailCount==0) {
			inJail=false;
		}
	}





	public Integer getMoney() {
		return money;
	}





	public void setMoney(Integer money) {
		this.money += money;
	}

	private Integer currSquare = 1;
    private  String name;
    public boolean inJail = false;
    public Integer turnsInJail = 0;
    
    
    public player(String name){
        this.name = name;
        currSquare = 1;
    }





	public Integer getCurrSquare() {
		return currSquare;
	}


	public String getName() {
		return name;
	}


	public boolean isInJail() {
		if(this.jailCount>0) {
			inJail = true;
		}
		if(this.jailCount == 0) {
			inJail = false;
		}
		return inJail;
	}


	public Integer getTurnsInJail() {
		return turnsInJail;
	}


	public void setCurrSquare(Integer currSquare) {
		this.currSquare += currSquare;
		/*if(this.currSquare > 40) {
			this.currSquare -= 40;
		}*/
	}
	
	public void teleport(Integer a) {
		this.currSquare = a;
	}



	public void setName(String name) {
		this.name = name;
	}



	public void setInJail(boolean inJail) {
		this.inJail = inJail;
		if(this.jailCount>0) {
			inJail = true;
		}
		if(this.jailCount == 0) {
			inJail = false;
		}
	}



	public void setTurnsInJail(Integer turnsInJail) {
		this.turnsInJail = turnsInJail;
	}
	
	
	public void addMoney(People player , int money) {
		player.setMoney(money);
		
	}
	ArrayList <properties> boughtPlaces = new ArrayList<>();
	public void buy(player player, properties property) {
		for (properties p : propertyObject.squares) {
			if(p.getName().equals(property.getName())){
				addMoney(player, -property.getCost());
				ownedPropertiesList.add(property);
				boughtPlaces.add(property);
				propertyObject.squares.remove(property);			
				}	
			
	}
	}
	
	 public int getNumRailroads(){
	        int numRailroads = 0;
	        for(Square p : ownedPropertiesList){
	            if(p instanceof Railroad){
	                numRailroads++;
	            }
	        }

	        return numRailroads;
	    }
	
	
	
	
	
	
}

class banker extends People{
	Integer money = 100000;
	public banker() {
		super();
		
		
	}
	public Integer getMoney() {
		return money;
	}
	public void setMoney(Integer money) {
		this.money += money;
	}
	
}
