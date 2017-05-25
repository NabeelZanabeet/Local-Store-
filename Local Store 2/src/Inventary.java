import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Inventary  extends JFrame implements ActionListener {
	

	private JLabel l1,l2,l3,l4;
	private JTextField t1,t2,t3,t4;
	private JButton add,find,update,delete,exit;
	private JPanel p1,p2;
	
	ArrayList <Product> arraylist = new ArrayList<Product>();
	
	
	
	public Inventary (){
		
		super("Inventary System");
		
		l1 = new JLabel ("Product ID       ");
		l2 = new JLabel ("Product NAME     ");
		l3 = new JLabel ("Product COST     ");
		l4 = new JLabel ("Product Quantity ");
		
	    add =new JButton("  Add   ");
	    find=new JButton("  Find  ");
	  update=new JButton(" Update ");
	 delete =new JButton(" Delete ");
	   exit =new JButton(" Exit   ");
	   
	   add.addActionListener(this);
	   find.addActionListener(this);
	   update.addActionListener(this);
	   delete.addActionListener(this);
	   exit.addActionListener(this);
	   
	   t1= new JTextField (12);
	   t2= new JTextField (12);
	   t3= new JTextField (12);
	   t4= new JTextField (12);
	   
	   
	  
	   p1= new JPanel(new GridLayout(4,2));
	   p1.add(l1);p1.add(t1);
	   p1.add(l2);p1.add(t2);
	   p1.add(l3);p1.add(t3);
	   p1.add(l4);p1.add(t4);
	   p2=new JPanel();
	   p2.add(add);p2.add(find); p2.add(update);p2.add(delete); p2.add(exit);
	   
	   add(p1,BorderLayout.CENTER);
	   add(p2,BorderLayout.SOUTH);
	   setSize(500,250);
	   setResizable(false);
	   
	}
	
	public void actionPerformed(ActionEvent e)
	{
		
		int id,quantity;
		double cost;
		String name;
		
		
	   if (e.getSource()==add )	
	   {
		    id = Integer.parseInt(t1.getText());
			name = t2.getText();
			cost=Double.parseDouble(t3.getText());
			quantity=Integer.parseInt(t4.getText()); 
			
		    boolean f=true;
			Product p;
			for (int i=0;i < arraylist.size();i++)
			{
				if (arraylist.get(i).get_id()== id)
				{
					f=false;
					
				}
			}
			if (f)
			{
			  if(cost>=0 && quantity >=0){
				p= new Product(id,name,cost,quantity);
				arraylist.add(p);
				
			  }
			  
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Error ..SaME Product id");
			}
		   
	   }
	   else if (e.getSource()==find )
	   {
		   
		   id = Integer.parseInt(t1.getText());
		   for (int i=0;i < arraylist.size();i++)
			{
				if (arraylist.get(i).get_id()== id)
				{
					t2.setText(arraylist.get(i).get_name());
					t3.setText(Double.toString(arraylist.get(i).get_cost()));
					t4.setText(Integer.toString(arraylist.get(i).get_quantity()));
				}
			}
		   
	   }
	   else if (e.getSource()== update)
	   {
		    id = Integer.parseInt(t1.getText());
			name = t2.getText();
			cost=Double.parseDouble(t3.getText());
			quantity=Integer.parseInt(t4.getText());
			
		   for (int i=0;i < arraylist.size();i++)
			{
				if (arraylist.get(i).get_id()== id)
				{
					if (cost>=0 && quantity >=0){
					arraylist.get(i).set_name(name);
					arraylist.get(i).set_cost(cost);
					arraylist.get(i).set_quantity(quantity);
					
					}
					
				}
			}
	   }
	   
	   else if (e.getSource()== delete)
	   {
		   id = Integer.parseInt(t1.getText());
		   int confirm=JOptionPane.showConfirmDialog(Inventary .this, String.format("are you sure that you want to delete the Product ID : %d ?",id),"Deleting!",JOptionPane.YES_NO_OPTION);
		   if(confirm==JOptionPane.YES_OPTION){
			 for (int i=0;i < arraylist.size();i++)
				{
					if (arraylist.get(i).get_id()== id)
					{
						arraylist.remove(i);
						
					}
				}
			}
		   
	   }
	   else if (e.getSource()== exit)
	   {
		   System.exit(0);
	   }
	   
	   
	
	}
	
	public static void main (String args[])
	{
		Inventary Inven =new Inventary();
		Inven.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Inven.setVisible(true);
		
	}
}