/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class Item{
private int id;
private String Name;
private int preperaing_time;
private float cost;
private int count;

    public Item(int id, String Name, int preperaing_time, float cost, int count) {
        this.id = id;
        this.Name = Name;
        this.preperaing_time = preperaing_time;
        this.cost = cost;
        this.count = count;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
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

    /**
     * @return the preperaing_time
     */
    public int getPreperaing_time() {
        return preperaing_time;
    }

    /**
     * @param preperaing_time the preperaing_time to set
     */
    public void setPreperaing_time(int preperaing_time) {
        this.preperaing_time = preperaing_time;
    }

    /**
     * @return the cost
     */
    public float getCost() {
        return cost;
    }

    /**
     * @param cost the cost to set
     */
    public void setCost(float cost) {
        this.cost = cost;
    }

    /**
     * @return the count
     */
    public int getCount() {
        return count;
    }

    /**
     * @param count the count to set
     */
    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Item{" + "id=" + id + ", Name=" + Name + ", preperaing_time=" + preperaing_time + ", cost=" + cost +"Count= "+count+ '}';
    }
    public boolean IsAvailable(int qu){
        return qu<=count;
    }
    public void dicount(int qu){
        if(qu<=count)
            count-=qu;
    }
}
