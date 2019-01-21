
package javapackage;


public class mainclass {
    private int id;
    private String name;
    private float price;
    private String adddate;
    
    public mainclass(int pid,String pname,Float pprice,String padddate)
    {
        this.id= pid;
        this.name= pname;
        this.adddate= pname;
        this.price= pprice;
        }
     public mainclass()
     {
         
     }
   
    public int getId()
    {
        return id; 
    }

    public mainclass(int id, String name, float price, String adddate) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.adddate = adddate;
    }
    public String getName()
    {
        return name;
    }
    public Float getPrice()
    {
        return price;
    }
    public String getAdddate()
    {
        return adddate;
    }
    
}
