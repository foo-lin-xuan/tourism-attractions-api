package sg.edu.ntu.singastays.entities;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Listing {
    private String id;
    private String name;
    private String description;
    private double price;

    public Listing() {
        this.id = UUID.randomUUID().toString();
    }

    public Listing(String name, String description, double price) {
        this();
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
