package javatraining;
import java.util.*;
public class MinimumCoins {

	     public static void main(String []args){
	         
	         HashMap<String, Integer> h = new HashMap<String, Integer>();
	         Scanner sc=new Scanner(System.in);
	         System.out.println("Enter the number of items you want to buy:");
	         int n=sc.nextInt();
	         sc.nextLine();
	         for(int i=0; i<n;i++)
	         {
	            System.out.println("Enter the name of item "+(i+1)+":");
	            String name= sc.nextLine ();
	            int cost=0;
	            while(cost<=0)
	            {
	            System.out.println("Enter the cost of "+name+":");
	            cost= sc.nextInt();
	            sc.nextLine();
	            if(cost<0)
	            {
	                System.out.println("Cost can't be negative or zero, please enter the correct cost");
	            }
	            }
	            h.put(name,cost);
	            
	         }
	         customerItems(h);
	         
	         int sum=totalPrice(h);
	         System.out.println("The total price of items is:"+sum);
	         int paying=0;
	         
	         while(paying<sum)
	         {
	         System.out.println("How much will you be paying:");
	         paying=sc.nextInt();
	         if(paying<0)
	         {
	             System.out.println("Please enter a valid cost, it cant be negative");
	         }
	         else if(paying<sum)
	         {
	             sum=sum-paying;
	             System.out.println("You need to pay "+sum +" more");
	             paying=0;
	         }
	         }
	         int change=paying-sum;
	         System.out.println("Change to be returned: "+change);
	    
	         
	         denominations(change);
	       
	         
	     }
	     public static void customerItems(HashMap<String, Integer> h) 
	     {   System.out.println();
	         System.out.println("List of items the customer wants:");
	         for(HashMap.Entry<String, Integer> entry :h.entrySet()) {
	            String key = entry.getKey();
	            Integer value = entry.getValue();
	            System.out.println(key + " : " + value);
	     }
	     }
	     public static int totalPrice(HashMap<String, Integer> h)
	     {
	         int sum = 0;
	         for (int value : h.values()) {
	            sum += value;
	         }
	         return sum;
	     }
	     public static void denominations(int change)
	     {
	         int den[]={1,2,5,10,20,50,100,200,500,1000,5000};
	         int c[]= new int[den.length]; 
	         while(change!=0)
	         {
	             for(int i=den.length-1;i>=0;i--)
	             {
	              if(change>=den[i])
	              {
	                  change=change-den[i];
	                  c[i]+=1;
	                  break;
	              }
	             }
	         }
	         int totalCoins=0;
	          System.out.println();
	         for(int i=0;i<c.length;i++)
	         {
	             if(c[i]>0)
	             {
	             System.out.print(c[i]+"*"+den[i]+" coins, ");
	             totalCoins+=c[i];
	             }
	         }
	         System.out.println("Minimum number of coins: "+totalCoins);
	     } 
	     
	}
