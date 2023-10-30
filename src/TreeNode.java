/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class TreeNode {
    private int Id;
private String Name;
SinglyLinkedList<TreeNode> SLL_of_children;
SinglyLinkedList<Item>SLL_of_items;

    public TreeNode() {
        SLL_of_children=new SinglyLinkedList<>();
        SLL_of_items=new SinglyLinkedList<>();
    }

    public TreeNode(int Id, String Name, SinglyLinkedList<TreeNode> SLL_of_children, SinglyLinkedList<Item> SLL_of_items) {
        this.Id = Id;
        this.Name = Name;
        this.SLL_of_children = SLL_of_children;
        this.SLL_of_items = SLL_of_items;
    }

    @Override
    public String toString() {
        String List_of_children="";
        SLL_of_children.moveToStart();
        for(int i=0;i<SLL_of_children.size();i++)
        {
            List_of_children+=SLL_of_children.getValue().getId()+",";
            SLL_of_children.next();
        }
        String List_of_item="";
        SLL_of_items.moveToStart();
        for(int i=0;i<SLL_of_items.size();i++)
        {
            List_of_item+=SLL_of_items.getValue().getId()+",";
            SLL_of_items.next();
        }
        return  "Name=" + Name + "\nNode_Id=" + Id+"\nlist of child=["+List_of_children+"]\nlist of item=["+List_of_item+"]" ;
    }
public void printitems(){
    SLL_of_items.moveToStart();
    for(int i=0;i<SLL_of_items.size();i++)
    {    System.out.println(SLL_of_items.getValue());
    SLL_of_items.next();
    }
    
}
public void printCategory(){
    SLL_of_children.moveToStart();
    for(int i=0;i<SLL_of_children.size();i++){
        System.out.println(SLL_of_children.getValue().getId()+" -> "+SLL_of_children.getValue().getName());
         SLL_of_children.next();
    }
}
    public TreeNode(int Id, String Name) {
        this.Id = Id;
        this.Name = Name;
        this.SLL_of_children = new SinglyLinkedList<>() ;
        this.SLL_of_items = new SinglyLinkedList<>();
    }
    public void addchild(TreeNode n){
       
        SLL_of_children.addLast(n);
    }
    
     public void addchild_to_category(int cat_id,TreeNode n){
        getcategory(cat_id).SLL_of_children.addLast(n);
    }
    public void additem(Item item){
        SLL_of_items.addLast(item);
    }
    public void addItem_toCategory(int cat_id,Item n){
       getcategory(cat_id).SLL_of_items.addLast(n);  
    }
    public Item getitem(int id){
        SLL_of_items.moveToStart();
        for(int i=0;i<SLL_of_items.size();i++){
            if(SLL_of_items.getValue().getId()==id)
                return SLL_of_items.getValue();
        SLL_of_items.next();
        }
        return null;
    }
      public TreeNode getcategory(int id){
        SLL_of_children.moveToStart();
        for(int i=0;i<SLL_of_children.size();i++){
            if(SLL_of_children.getValue().getId()==id)
                return SLL_of_children.getValue();
        SLL_of_items.next();
        }
        return null;
    }
public boolean cheakQuantity(int id,int q){
    SLL_of_items.moveToStart();
        for(int i=0;i<SLL_of_items.size();i++){
            if(SLL_of_items.getValue().getId()==id&&SLL_of_items.getValue().getCount()>=q)
                return true;
        SLL_of_items.next();
        }
        return false;
}
public void decrementcount(int id,int q){
  SLL_of_items.moveToStart();
        for(int i=0;i<SLL_of_items.size();i++){
            if(SLL_of_items.getValue().getId()==id&&SLL_of_items.getValue().getCount()>=q)
            { SLL_of_items.getValue().setCount(SLL_of_items.getValue().getCount()-q);
            return;}
        SLL_of_items.next();
        }
         
}
    /**
     * @return the Id
     */
    public int getId() {
        return Id;
    }

    /**
     * @param Id the Id to set
     */
    public void setId(int Id) {
        this.Id = Id;
    }

    /**
     * @return the Name
     */
    public String getName() {
        return Name;
    }

    /**
     * @param Name the Name to set
     */
    public void setName(String Name) {
        this.Name = Name;
    }

}
