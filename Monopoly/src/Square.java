import java.util.ArrayList;

public class Square implements Comparable<Square>{
    protected Integer ID;
    protected final String name;
    
    
    public Square() {
		this.name = "";
		
	}

	public Integer getID() {
		return ID;
	}

	public void setID(Integer iD) {
		ID = iD;
	}

	public String getName() {
		return (String)name;
	}

	public Square(Integer ID,String name){
    	this.ID = ID;
        this.name = name;
    }
    
    public Square(String name){
        this.name = name;
    }

    public void doAction(player currentPlayer){};

    public String toString(){
        return name;
    }

	@Override
	public int compareTo(Square o) {
		return 0; 
	}
}

	







