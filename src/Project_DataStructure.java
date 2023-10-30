/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.Date;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author user
 */

public class Project_DataStructure {

  static  Menue menue=new Menue();
  static Order order=new Order();
  
  static LinkedQueue<Order> queue_order=new LinkedQueue<>();
  static LinkedStack<Order> stackDrink=new LinkedStack<>();
  static drink_vending_machine Drink_machine=new drink_vending_machine();
  public static void Inventory_Management(Order neworder){
      SinglyLinkedList<Item> orderslist=neworder.getSll();
      SinglyLinkedList<Integer>quan=neworder.getQuantity();
      orderslist.moveToStart();
      quan.moveToStart();
      for(int i=0;i<orderslist.size();i++)
      {
          menue.dicrement(orderslist.getValue().getId(), quan.getValue());
          orderslist.next();
               
          quan.next();
      }
  }
  //
   public static void Machine_Organization(){
     if(stackDrink.size()==0)
     { System.out.println("<<<<No Drink Order>>>>");return;}
     while(!stackDrink.isEmpty()){
         Order order=stackDrink.pop();
           System.out.println("Order No>> "+order.getNum()+" Time: "+order.getTotal_Time());
         order.printDrink();
     }
  }
  public static void Order_Collection() throws InterruptedException{
      if(queue_order.length()==0)
      {
          System.out.println("<<No Order in the Queue>>");return;
      }
      while(queue_order.length()>0){
          Order it=queue_order.dequeue();
        //  Inventory_Management(it);
          System.out.println("Order No>> "+it.getNum()+" Time: "+it.getTotal_Time());
          it.printitem();
          if(it.getDrink().size()>0)
              stackDrink.push(it);
  
      
    }
      System.out.println("ALL Orders Done>>>>>>>>>");
  }
  
  public static void readmenue() throws FileNotFoundException{
      Scanner readitem=new Scanner(new File("Items 3.txt"));
      int i=2;
      TreeNode cat=new TreeNode();
      while(readitem.hasNext()){
          String t=readitem.nextLine();
          String item[]=t.split(" ");
          if(item.length!=5&&i>2){
              menue.addCategory(1, cat);
            
              cat=new TreeNode(i,t);
              i++;
          }else if(item.length!=5){
               cat=new TreeNode(i,t);
              i++;
          }else
          {
             cat.additem(new Item(Integer.parseInt(item[0]), item[1], Integer.parseInt(item[2]),Float.parseFloat(item[3]), Integer.parseInt(item[4])));
          }
      }
      
  }
  // write
   
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        readmenue();
        Drink_machine.readdata();

        Scanner input=new Scanner(System.in);
        int ch,chcat=1,chitem;
        char YN=' ',YND=' ';
       
        do{
            System.out.println("1-Make Order\n2-Order Collection\n3-Vending machine\n4-Exit"
                    + "Select >>>");
        ch=input.nextInt();
        switch(ch){
            
            case 1:
            do{
                chcat=1;
                do{
            System.out.println("<<Please enter your Category number>>");
            menue.printChildCategory(chcat);
            chcat=input.nextInt();
                }while(menue.havechild(chcat));
           if(menue.checkCategory(chcat)==true){
               
            System.out.println("Please enter Item_number");
            menue.printitem(chcat);
            chitem=input.nextInt();
            System.out.println("Enter Quantity:");
            int qu=input.nextInt();
           if(menue.checkQuantity(chitem,qu))
               order.addItem(menue.getItem(chitem), qu);
           else
                System.out.println("Please enter another Quantity");
            System.out.println("Continue Y/N");
            YN=input.next().charAt(0);}else{
               System.out.println("Select Another Category");
           }
            }while(YN !='N'&&YN !='n');
            input.nextLine();
            
            System.out.println("YOu Need Drinks...!(Y/N)");
            YND=input.next().charAt(0);
            if(YND=='Y'||YND=='y'){
                do{
                System.out.println("1-Water 2-Cola 3-Juice 4-Exit");
                chcat=input.nextInt();
                if(chcat==1){
                Drink_machine.printWater();
                   System.out.println("Please enter Item_number");
                   chitem=input.nextInt();
                   
                   
            System.out.println("Enter Quantity:");
            int qu=input.nextInt();
            Item dit=Drink_machine.discountwater(chitem, qu);
            if(dit==null)
                        System.out.println("Enter another Quantity");
            else
                order.addItemDrink(dit, qu);
                
                }else if(chcat==2){
                 Drink_machine.printcola();
                   System.out.println("Please enter Item_number");
                   chitem=input.nextInt();
            System.out.println("Enter Quantity:");
            int qu=input.nextInt();
            Item dit=Drink_machine.discountcola(chitem, qu);
            if(dit==null)
                        System.out.println("Enter another Quantity");
            else
                order.addItemDrink(dit, qu);   
                }else if(chcat==3){
                    Drink_machine.printjuice();
                   System.out.println("Please enter Item_number");
                   chitem=input.nextInt();
            System.out.println("Enter Quantity:");
            int qu=input.nextInt();
            Item dit=Drink_machine.discountjuice(chitem, qu);
            if(dit==null)
                        System.out.println("Enter another Quantity");
            else
                order.addItemDrink(dit, qu);
                }
            }while(chcat!=4);
            
                }
            queue_order.enqueue(order);
            //order.printOrder();
                Inventory_Management(order);
            System.out.println("<<<Order Confirmed>>>");
            order.printOrder();
            order=new Order();
            break;
            case 2:
                 System.out.println("\n\t<<<Order Collection>>>>");
                Order_Collection();break;
            case 3:
                 System.out.println("\n\t<<< Vending Machine>>>");
                Machine_Organization();break;
        }
            
        }while(ch!=4);
  
    }
    
}
