package it.academy.rent.car.bean;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categorycard")
public class CategoryCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "categorycard")
    private String categoryCard;
    private List<DriveCard> driveCards = new ArrayList<>();
}
