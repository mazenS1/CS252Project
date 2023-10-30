/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class Order {
   static int count=0;
    private SinglyLinkedList<Item>sll=new SinglyLinkedList<>();
     private SinglyLinkedList<Integer>Quantity=new SinglyLinkedList<>();
     private SinglyLinkedList<Item>Drink=new SinglyLinkedList<>();
      private SinglyLinkedList<Integer>DQuantity=new SinglyLinkedList<>();
private int num;
private int total_Time;
private float Total_cost; 
    public Order() {
    count++;
    num=count;
    total_Time=0;
    Total_cost=0;
    }
    public void addItem(Item t,int qu){
       sll.addLast(t);
        Quantity.addLast(qu);
    }
     public void addItemDrink(Item t,int qu){
       Drink.addLast(t);
        DQuantity.addLast(qu);
    }
    public void deleteItem(int itnum){
        getSll().moveToStart();
        for(int i=0;i<getSll().size();i++){
            if(getSll().getValue().getId()==itnum){
                getSll().remove(getSll().CurrPos());
                getQuantity().remove(getSll().CurrPos());
                System.out.println("Item deleted from Order");
                return;
            }
            getSll().next();
        }
        System.out.println("Item not Found in this order");
    }
    public void deleteItemDrink(int itnum){
        getDrink().moveToStart();
        for(int i=0;i<getDrink().size();i++){
            if(getDrink().getValue().getId()==itnum){
                getDrink().remove(getDrink().CurrPos());
                getDQuantity().remove(getDrink().CurrPos());
                System.out.println("Item deleted from Order");
                return;
            }
            getDrink().next();
        }
        System.out.println("Item not Found in this order");
    }
    
    public float ComputeTotal_Cost(){
        Total_cost=0;
         getSll().moveToStart();
         getQuantity().moveToStart();
        for(int i=0;i<getSll().size();i++){
           Total_cost+=getQuantity().getValue()*getSll().getValue().getCost();
            getSll().next();
            getQuantity().next();
        }
        getDrink().moveToStart();
         getDQuantity().moveToStart();
        for(int i=0;i<getDrink().size();i++){
           Total_cost+=getDQuantity().getValue()*getDrink().getValue().getCost();
            getDrink().next();
            getDQuantity().next();
        }
        return getTotal_cost();
    }
    public float ComputeTotal_Time(){
         getSll().moveToStart();
         Quantity.moveToStart();
        total_Time=0;
        for(int i=0;i<getSll().size();i++){
           total_Time+=getQuantity().getValue()*getSll().getValue().getPreperaing_time();
            getSll().next();
            Quantity.next();
            
        }
        return getTotal_Time();
    }

  public void printOrder(){
        getSll().moveToStart();
        getQuantity().moveToStart();
      System.out.println("\nOrder Number :"+getNum());
      System.out.println(" id\t Name\t cost\t Quantity");
      for(int i=0;i<getSll().size();i++){
          System.out.println(getSll().getValue().getId()+"\t"+getSll().getValue().getName()+"\t"+getSll().getValue().getCost()
          +"\t"+getQuantity().getValue());
            getSll().next();
            getQuantity().next();
      }
        getDrink().moveToStart();
        getDQuantity().moveToStart();
      for(int i=0;i<getDrink().size();i++){
          System.out.println(getDrink().getValue().getId()+"\t"+getDrink().getValue().getName()+"\t"+getDrink().getValue().getCost()
          +"\t"+getDQuantity().getValue());
            getDrink().next();
            getDQuantity().next();
      }
      System.out.println("\t Total Cost: "+ComputeTotal_Cost());
      System.out.println("\t Total Time: "+ComputeTotal_Time());
  }

    /**
     * @return the sll
     */
    public SinglyLinkedList<Item> getSll() {
        return sll;
    }

    /**
     * @return the Drink
     */
    public SinglyLinkedList<Item> getDrink() {
        return Drink;
    }

    /**
     * @return the Quantity
     */
    public SinglyLinkedList<Integer> getQuantity() {
        return Quantity;
    }

    /**
     * @return the DQuantity
     */
    public SinglyLinkedList<Integer> getDQuantity() {
        return DQuantity;
    }
 public void printitem(){
     sll.moveToStart();getQuantity().moveToStart();
     for(int i=0;i<sll.size();i++)
     {
         System.out.println(sll.getValue()+" Quantity="+getQuantity().getValue());
         sll.next();getQuantity().next();
     }
 } 
 public void printDrink(){
     Drink.moveToStart();
     DQuantity.moveToStart();
     for(int i=0;i<Drink.size();i++)
     {
         System.out.println(Drink.getValue()+" Quantity="+DQuantity.getValue());
         Drink.next();DQuantity.next();
     }
 } 

    /**
     * @param Quantity the Quantity to set
     */
    public void setQuantity(SinglyLinkedList<Integer> Quantity) {
        this.Quantity = Quantity;
    }

    /**
     * @return the num
     */
    public int getNum() {
        return num;
    }

    /**
     * @return the total_Time
     */
    public int getTotal_Time() {
        return total_Time;
    }

    /**
     * @return the Total_cost
     */
    public float getTotal_cost() {
        return Total_cost;
    }

}
