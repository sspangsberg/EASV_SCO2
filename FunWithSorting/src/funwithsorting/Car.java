
package funwithsorting;

import java.util.Comparator;
import java.util.Objects;

/**
 *
 * @author smsj
 */
public class Car implements Comparable<Car> {
    
    private String brand; //BMW, VW, Peugeot, Ferrari
    private String model; //M5, Golf
    private String color; //red, green, blue
    private int topSpeed;

    /**
     * Default constructor to create object
     * @param brand
     * @param model
     * @param color
     * @param topSpeed
     */
    public Car(String brand, String model, String color, int topSpeed) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.topSpeed = topSpeed;
    }
    
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    public void setTopSpeed(int topSpeed) {
        this.topSpeed = topSpeed;
    }

    /**
     * Returns a nicely formatted String representation of a Car.
     * @return
     */
    @Override
    public String toString() {
        return "Car{" + "brand=" + brand + ", model=" + model + ", color=" + color + ", topSpeed=" + topSpeed + '}';
    }

    @Override
    public int compareTo(Car other) {
        return this.model.compareTo(other.model);
    }
}
