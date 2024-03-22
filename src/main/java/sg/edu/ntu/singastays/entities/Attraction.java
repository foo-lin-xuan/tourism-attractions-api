package sg.edu.ntu.singastays.entities;

import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "attraction")
public class Attraction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "attraction_name")
    private String attractionName;

    @Column(name = "attraction_category_name")
    private String attractionCategoryName;

    @CreationTimestamp
    @Column(name = "attraction_created_date")
    private Date attractionCreatedDate;

    @UpdateTimestamp
    @Column(name = "attraction_updated_timestamp")
    private Date attractionUpdatedDate;

    // For reference if needed
    // @JsonBackReference
    // @OneToMany(mappedBy = "attraction", cascade = CascadeType.ALL)
    // private List<Favourite> favourites;

    @OneToMany(mappedBy = "attraction", cascade = CascadeType.ALL)
    private List<Interaction> interactions;

    public Attraction(){}

    public Attraction(String attractionName, String attractionCategoryName, Date attractionCreatedDate, Date attractionUpdatedDate) {
        this();
        this.attractionName = attractionName;
        this.attractionCategoryName = attractionCategoryName;
        this.attractionCreatedDate = attractionCreatedDate;
        this.attractionUpdatedDate = attractionUpdatedDate;
    }
}
