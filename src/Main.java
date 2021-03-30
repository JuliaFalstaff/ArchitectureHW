
class Bicycle {

    private String brand = "" ;
    private String color = "";
    private String type = "";

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setType(String type) {
        this.type = type;
    }
}


abstract class BicycleBuilder
{
    protected Bicycle bicycle;

    public Bicycle getBicycle() {
        return bicycle;
    }

    public void createNewBicycle() {
        bicycle = new Bicycle();
    }

    public abstract void buildBrand();

    public abstract void buildColor();

    public abstract void buildType();
}

// builder мотобайка
class MountainBicycleBuilder extends BicycleBuilder {

    @Override
    public void buildBrand() {
        bicycle.setBrand("Cube");
    }

    @Override
    public void buildColor() {
        bicycle.setColor("red + white");
    }

    @Override
    public void buildType() {
        bicycle.setType("Mountain bike");
    }
}

// builder шоссейника
class RoadBicycleBuilder extends BicycleBuilder {

    @Override
    public void buildBrand() {
        bicycle.setBrand("Cannondale");
    }

    @Override
    public void buildColor() {
        bicycle.setColor("black");
    }

    @Override
    public void buildType() {
        bicycle.setType("Road bike");
    }
}


class Customer {

    private BicycleBuilder bicycleBuilder;

    public void setBicycleBuilder(BicycleBuilder bikeBuilder) {
        bicycleBuilder = bikeBuilder;
    }

    public Bicycle getBicycle() {
        return bicycleBuilder.getBicycle();
    }

    public void constructBicycle() {
        bicycleBuilder.createNewBicycle();
        bicycleBuilder.buildBrand();
        bicycleBuilder.buildColor();
        bicycleBuilder.buildType();
    }


}

class Shop {

    public static void main(String args[]) {

        Customer customer = new Customer();
        BicycleBuilder mountainBicycleBuilder = new MountainBicycleBuilder();
        customer.setBicycleBuilder(mountainBicycleBuilder);
        customer.constructBicycle();

        Bicycle bicycle = customer.getBicycle();
    }
}