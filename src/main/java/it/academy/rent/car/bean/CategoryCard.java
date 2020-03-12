package it.academy.rent.car.bean;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categorycard")
public class CategoryCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "categorycard")
    private String categoryCard;
    @ManyToMany(mappedBy = "townSet")
    private Set<DriveCard> categoryCards = new HashSet<>();

    public CategoryCard() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategoryCard() {
        return categoryCard;
    }

    public void setCategoryCard(String categoryCard) {
        this.categoryCard = categoryCard;
    }

    public Set<DriveCard> getCategoryCards() {
        return categoryCards;
    }

    public void setCategoryCards(Set<DriveCard> categoryCards) {
        this.categoryCards = categoryCards;
    }

    @Override
    public String toString() {
        return "CategoryCard{" +
                "id=" + id +
                ", categoryCard='" + categoryCard + '\'' +
                ", categoryCards=" + categoryCards +
                '}';
    }
}
