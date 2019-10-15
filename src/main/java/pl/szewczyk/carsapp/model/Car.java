package pl.szewczyk.carsapp.model;



public class Car {

    long id;
    String mark;
    String model;
    Colour colour;

    public Car() {
    }

    public Car(long id, String mark, String model, Colour colour) {
        this.id = id;
        this.mark = mark;
        this.model = model;
        this.colour = colour;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Colour getColour() {
        return colour;
    }

    public void setColour(Colour colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", mark='" + mark + '\'' +
                ", model='" + model + '\'' +
                ", colour='" + colour + '\'' +
                '}';
    }
}
