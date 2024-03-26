package sg.edu.ntu.singastays.entities;

import org.apache.catalina.User;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
//@NoArgsConstructor
//@RequiredArgsConstructor
@Table(name = "user_favourite")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class UserFavourite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne
    @JoinColumn(name = "attraction_id")
    private Attraction attraction;

    // Constructors (including a no-arg constructor)
    public UserFavourite() {}

    public UserFavourite(Member member, Category category, Attraction attraction) {
        this();
        this.member = member;
        this.category = category;
        this.attraction = attraction;
    }

    // Getters and setters
    // Getters and setters
//     public Long getId() {
//         return id;
//     }

//     public void setId(Long id) {
//         this.id = id;
//     }

//     public Member getMember() {
//         return member;
//     }

//     public void setMember(Member member) {
//         this.member = member;
//     }

//     public Category getCategory() {
//         return category;
//     }

//     public void setCategory(Category category) {
//         this.category = category;
//     }

//     public Attraction getAttraction() {
//         return attraction;
//     }

//     public void setAttraction(Attraction attraction) {
//         this.attraction = attraction;
//     }
// }

}