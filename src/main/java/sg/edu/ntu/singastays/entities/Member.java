package sg.edu.ntu.singastays.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

// import org.hibernate.validator.constraints.Range;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@Entity
@Table(name = "member")
public class Member {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "First name is mandatory")
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Email(message = "Email should be valid")
    @Column(name = "email")
    private String email;

    // [Activity 2 - validation]
    @Digits(fraction = 0, integer = 8, message = "Contact no should be 8 digits")
    @Column(name = "contact_no")
    private String contactNo;

    // @Column(name = "job_title")
    // private String jobTitle;

    // [Activity 2 - validation]
    // @Range(min = 1940, max = 2005, message = "Year Of Birth should be between 1940 and 2005")
    // @Column(name = "year_of_birth")
    // private int yearOfBirth;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Interaction> interactions;

    public Member(){}

    public Member(String firstName, String lastName, String contactNo, String email) {
        this();
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNo = contactNo;
        // this.yearOfBirth = yearOfBirth;
        this.email = email;
    }
}
