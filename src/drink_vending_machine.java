import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class drink_vending_machine {
    LinkedStack<Item> Stack_of_juice;
LinkedStack<Item>Stack_of_cola;
LinkedStack<Item>Stack_of_water;

    public drink_vending_machine() {
        Stack_of_juice=new LinkedStack<>();
         Stack_of_cola=new LinkedStack<>();
          Stack_of_water=new LinkedStack<>();
    }
    // قرائة البياناات المشروبات من الملف
public void readdata() throws FileNotFoundException{
    Scanner input=new Scanner(new File("Drinks.txt"));
    while(input.hasNext()){
        String[]drink=input.nextLine().split(" ");
        if(drink[1].equalsIgnoreCase("Juice")){
            Stack_of_juice.push(new Item(Integer.parseInt(drink[0]),drink[1],0,Float.parseFloat(drink[3]),Integer.parseInt(drink[2])));
        }else  if(drink[1].equalsIgnoreCase("Cola"))
              Stack_of_cola.push(new Item(Integer.parseInt(drink[0]),drink[1],0,Float.parseFloat(drink[3]),Integer.parseInt(drink[2])));
      else  if(drink[1].equalsIgnoreCase("Water"))
              Stack_of_water.push(new Item(Integer.parseInt(drink[0]),drink[1],0,Float.parseFloat(drink[3]),Integer.parseInt(drink[2])));
      
    }
   // Stack_of_water.print();
}
//طباعة المياه فقط
public void printWater(){
    Stack_of_water.print();
}
//طباعة الكولا فقط
public void printcola(){
    Stack_of_cola.print();
}
// طباعة العصير فقط 
public void printjuice(){
    Stack_of_juice.print();
}
//تقلقل كمية منتج معين من المخزون للمياه 
public Item discountwater(int id,int qu){
  LinkedStack<Item> s=new LinkedStack<>();
  Item Available=null; 
  while(!Stack_of_water.isEmpty()){
      Item item=Stack_of_water.pop();
      if(item.getId()==id )
           if(item.getCount()>=qu)
          { item.dicount(qu);
      Available=item;}    
      s.push(item);
  }
  while(!s.isEmpty())
      Stack_of_water.push(s.pop());
  return Available;
}
//تقلقل كمية منتج معين من المخزون العصير 

public Item discountjuice(int id,int qu){
  LinkedStack<Item> s=new LinkedStack<>();
  Item Available=null; 
  while(!Stack_of_juice.isEmpty()){
      Item item=Stack_of_juice.pop();
      if(item.getId()==id )
          if(item.getCount()>=qu)
          { item.setCount(item.getCount()-qu);
      Available=item;}   
      s.push(item);
  }
  while(!s.isEmpty())
      Stack_of_juice.push(s.pop());
  return Available;
}
//تقلقل كمية منتج معين من المخزون الكولا 

public Item discountcola(int id,int qu){
  LinkedStack<Item> s=new LinkedStack<>();
  Item Available=null; 
  while(!Stack_of_cola.isEmpty()){
      Item item=Stack_of_cola.pop();
      if(item.getId()==id )
          if(item.getCount()>=qu)
          { item.setCount(item.getCount()-qu);
          Available=item;
          }
      s.push(item);
  }
  while(!s.isEmpty())
      Stack_of_cola.push(s.pop());
  return Available;
}

    public void addNewItem(Item item){
        if(item.getName().equalsIgnoreCase("Juice"))
            Stack_of_juice.push(item);
        else if(item.getName().equalsIgnoreCase("Cola"))
            Stack_of_cola.push(item);
        else if(item.getName().equalsIgnoreCase("Water"))
            Stack_of_water.push(item);
    }
}
