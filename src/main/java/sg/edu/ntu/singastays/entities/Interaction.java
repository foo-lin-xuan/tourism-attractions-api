package sg.edu.ntu.singastays.entities;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "interaction")
@Getter
@Setter
public class Interaction {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @JsonBackReference // This prevents the serializer from infinite recursion
    @ManyToOne
    @JoinColumn(name = "attraction_id")
    private Attraction attraction;

    // [Activity 2 - validation]
    @Size(min = 3, max = 30, message = "Remarks has to be more than 3 characters and less than 30 characters")
    @Column(name = "remarks")
    private String remarks;

    // [Activity 2 - validation]
    @PastOrPresent(message = "Interaction Date must be in the past or present.")
    @Column(name = "interaction_date")
    private LocalDate interactionDate;

    @JsonBackReference
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "member_id", referencedColumnName = "id")
    private Member member;

    // @JsonBackReference
    // @ManyToOne(optional = false, cascade = CascadeType.ALL)
    // @JoinColumn(name = "attraction_id", referencedColumnName = "id")
    // private Attraction attraction;
}
