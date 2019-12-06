package wapda.billchecker.taskone;

public class Product {


    int id;
    String name;
    boolean checked;

    public Product(int id,String name)
    {
        this.id =id;
        this.name = name;
        this.checked=false;

    }

    public Product(String name,boolean checked)
    {
        this.name = name;
        this.checked=checked;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
