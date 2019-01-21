package javapackage;


 public class Product {
    
    private final int id;
    private final String name;
    private final float price;
    private String addDate; 
  
    
    public Product(int pid, String pname, float pprice, String pAddDate)
    {
        
        this.id = pid;
        this.name = pname;
        this.price = pprice;
        this.addDate = pAddDate;
       
    }

   

 
       

  
    
    public int getId()
    {
        return id;
    }
    
    public String getName()
    {
        return name;
    }
    
    public float getPrice()
    {
        return price;
    }
    
    public String getAddDate()
    {
        return  addDate;
    }
    
    
}