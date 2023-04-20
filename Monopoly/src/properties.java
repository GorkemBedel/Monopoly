class properties extends Square {
	private Integer cost;
	private Integer rent;	
	private player owner;
	 
		
	public properties() {
		
	}
	
	public properties(Integer ID,String name, Integer cost) {
		super(ID, name);
		this.cost = cost;
	}


	public Integer getCost() {
		return cost;
	}


	public void setCost(Integer cost) {
		this.cost = cost;
	}


	public Integer getRent() {
		return rent;
	}


	public void setRent(Integer rent) {
		this.rent = rent;
	}


	public player getOwner() {
		return owner;
	}


	public void setOwner(player owner) {
		this.owner = owner;
	}
	
	@Override
	public void doAction(player currentPlayer) {
		if(currentPlayer == owner);
		else if(owner != null) {
			currentPlayer.setMoney(-getRent());
			owner.setMoney(getRent());
		}	
	}
	
	public void bought(player currentPlayer){
        owner = currentPlayer;
        //currentPlayer.buy(this);
    }


	/*@Override
	public Integer getID() {
		return this.ID;
	}

	@Override
	public String getName() {
		return this.name;
	}*/
			
}
