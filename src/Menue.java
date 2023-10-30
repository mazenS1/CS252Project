/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Locale;

/**
 *
 * @author user
 */
public class Menue {
    TreeNode root;
     public Menue() {
    root=new TreeNode(1,"Menue");
    }
    //التاكد من وجود اولاد داخل هذا القسم 
    public boolean havechild(int cat){
       return havechild(root,cat);
    }
    
    private boolean havechild(TreeNode t,int cat){
        if(t==null)return false;
        if(t.getId()==cat&&t.SLL_of_children.size()>0)
            return true;
        if(t.getId()==cat)return false;
         t.SLL_of_children.moveToStart();
        for(int i=0;i<t.SLL_of_children.size();i++){
           if( havechild(t.SLL_of_children.getValue(), cat)==true)
               return true;
            t.SLL_of_children.next();
        }
        return false;
        
    }
    // التاكد من وجود قسم معين عن طريق رقم القسم 
    public boolean checkCategory(int cat){
        return checkCategory(root,cat);
    }
    public boolean checkCategory(TreeNode t,int cat){
        if(t==null)return false;
        if(t.getId()==cat)return true;
        t.SLL_of_children.moveToStart();
        for(int i=0;i<t.SLL_of_children.size();i++){
           if( checkCategory(t.SLL_of_children.getValue(), cat)==true)
               return true;
            t.SLL_of_children.next();
        }
        return false;
    }
    //التاكد من كميه المنتج داخل المخازن 
public boolean checkQuantity(int pid,int qu){
    
 return checkQuantity(root, pid, qu);
}
private boolean checkQuantity(TreeNode t, int pid,int qu){
    if(t==null)return false;
    
    if(t.cheakQuantity(pid, qu)==true)
        return true;
    t.SLL_of_children.moveToStart();
    for(int i=0;i<t.SLL_of_children.size();i++){
        if(checkQuantity(t.SLL_of_children.getValue(), pid, qu)==true)
            return true;
        t.SLL_of_children.next();
    }
  return false; 
}

//تنقيص كميه معينه من المخزن لمنتج معين 
public void dicrement(int pid,int qu){
     dicrement(root, pid, qu);
}
private void dicrement(TreeNode t, int pid,int qu){
    if(t==null)return;
    if(t.cheakQuantity(pid, qu)==true)
    { t.decrementcount(pid, qu);return;}
    t.SLL_of_children.moveToStart();
    for(int i=0;i<t.SLL_of_children.size();i++){
        dicrement(t.SLL_of_children.getValue(), pid, qu);
        t.SLL_of_children.next();
    }
}
   // اضافة قسم جديد داخل قسم سابق 
    public void addCategory(int parentid,TreeNode category){
        if(root.getId()==parentid){
            root.SLL_of_children.addLast(category);
            return;
        }
        addcategory(root.SLL_of_children, parentid, category);
    }
    
   public void addcategory(SinglyLinkedList<TreeNode> sl,int id,TreeNode cat) {
       sl.moveToStart();
       for(int i=0;i<sl.size();i++){
           if(sl.getValue().getId()==id){
               sl.getValue().SLL_of_children.addLast(cat);return;
           }
           addcategory(sl.getValue().SLL_of_children, id, cat);
           sl.next();
       }
   }
   // اضافة منتج جديد داخل قسم معين 
   public void additem(int catid,Item t){
       if(root.getId()==catid){
            root.SLL_of_items.addLast(t);
return;
        }
        additem(root.SLL_of_children, catid, t);
    }
    
   public void additem(SinglyLinkedList<TreeNode> sl,int id,Item t) {
       sl.moveToStart();
       for(int i=0;i<sl.size();i++){
           if(sl.getValue().getId()==id){
               sl.getValue().SLL_of_items.addLast(t);
               return;
           }
           additem(sl.getValue().SLL_of_children, id, t);
           sl.next();
       }
   }
   // طباعة كل الاقسام في القائمه 
   public void printMenue(){
       printMenue(root);
   }
   public void printMenue(TreeNode root){
       if(root==null)return;
       System.out.println(root);
       root.SLL_of_children.moveToStart();
       for(int i=0;i<root.SLL_of_children.size();i++){
           printMenue(root.SLL_of_children.getValue());
           root.SLL_of_children.next();
       }
   }
   // استرجاع بيانات منتج معين برقم المنتج من القائمه 
   public Item getItem(int id){
      return getItem(root, id);
   }
   public Item getItem(TreeNode t,int id){
       if(t==null)return null;
       
       if(t.getitem(id)!=null)
               return t.getitem(id);
       t.SLL_of_children.moveToStart();
      // t.SLL_of_children.next();
       for(int i=0;i<t.SLL_of_children.size();i++){
         if(getItem(t.SLL_of_children.getValue(), id)!=null)
             return getItem(t.SLL_of_children.getValue(), id);
           t.SLL_of_children.next();
       }
       return null;
   }
   //طباعة المنتجات الموجوده في قسم معين 
   public void printitem(int catnum){
       printitem(root, catnum);
   }
   private void printitem(TreeNode t,int catnum){
      if(t==null)return;
      if(t.getId()==catnum)
      { t.printitems();return;}
      t.SLL_of_children.moveToStart();
      for(int i=0;i<t.SLL_of_children.size();i++){
          if(t.getId()==catnum)
          {  t.printitems(); return;}
           printitem(t.SLL_of_children.getValue(), catnum);
          t.SLL_of_children.next();
      }
   }
   public void printCategory(){
       root.printCategory();
   }
   //طباعة اقسام داخل قسم معين 
   public void printChildCategory(int cat){
       printChildCategory(root, cat);
   }
   private void printChildCategory(TreeNode t,int cat){
       if(t==null)return;
       if(t.getId()==cat)
       {  t.printCategory();return;}
       t.SLL_of_children.moveToStart();
      for(int i=0;i<t.SLL_of_children.size();i++){
          printChildCategory(t.SLL_of_children.getValue(), cat);
          t.SLL_of_children.next();
      }
       
   }
   // write a method to return the category name give the category id
    public String getCategoryName(int id){
        return getCategoryName(root, id);
    }

    private String getCategoryName(TreeNode t,int id){
         if(t==null)return null;
         if(t.getId()==id)
              return t.getName();
         t.SLL_of_children.moveToStart();
         for(int i=0;i<t.SLL_of_children.size();i++){
              if(getCategoryName(t.SLL_of_children.getValue(), id)!=null)
                return getCategoryName(t.SLL_of_children.getValue(), id);
              t.SLL_of_children.next();
         }
         return null;
    }
}