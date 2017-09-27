import java.util.List;

/**
 * Created by Bartuś on 22.09.2017.
 */
public  class  Meal {

    protected String name;
    protected Double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Meal(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public Meal(){}

    @Override
    public String toString() {
        return name + " " + price + "zł";
    }
    }
