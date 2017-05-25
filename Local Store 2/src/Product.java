public class Product{

	private int id;
	private String name ;
	private double cost;
	private int quantity;
	

	Product(int a,String b,double c,int d){
		id=a;
		name=b;
		cost=c;
		quantity=d;
	}


	public void set_id (int a){
		id=a;
	}
	public int get_id (){
	    return id;
	}

	public void set_cost (double a){
		cost=a;
	}
	public double get_cost (){
	    return cost;
	}

	public void set_name (String a){
			name=a;
		}
	public String get_name (){
		    return name;
		}

	public void set_quantity (int a){
			quantity=a;
		}
	public int get_quantity (){
		    return quantity;
		}
	

	
	
	
}

