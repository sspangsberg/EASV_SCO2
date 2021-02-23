
package funwithsorting;

import java.util.Objects;

/**
 *
 * @author smsj
 */
public class Car implements Comparable<Car>{
    
    private String brand; //BMW, VW, Peugeot, Ferrari
    private String model; //M5, Golf
    private String color; //red, green, blue
    private int topSpeed;

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

    @Override
    public String toString() {
        return "Car{" + "brand=" + brand + ", model=" + model + ", color=" + color + ", topSpeed=" + topSpeed + '}';
    }

    @Override
    public int compareTo(Car other) {
        return this.color.compareTo(other.color);
    }   

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + Objects.hashCode(this.brand);
        hash = 41 * hash + Objects.hashCode(this.model);
        hash = 41 * hash + Objects.hashCode(this.color);
        hash = 41 * hash + this.topSpeed;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Car other = (Car) obj;
        if (this.topSpeed != other.topSpeed) {
            return false;
        }
        if (!Objects.equals(this.brand, other.brand)) {
            return false;
        }
        if (!Objects.equals(this.model, other.model)) {
            return false;
        }
        if (!Objects.equals(this.color, other.color)) {
            return false;
        }
        return true;
    }
    
    
    
}
