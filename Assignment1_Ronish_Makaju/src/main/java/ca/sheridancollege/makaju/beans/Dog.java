package ca.sheridancollege.makaju.beans;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;


    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @ManyToMany
    @JoinTable(
        name = "dog_judge",
        joinColumns = @JoinColumn(name = "dog_id"),
        inverseJoinColumns = @JoinColumn(name = "judge_id")
    )
    private List<Judge> judges;
    
    @Override
    public String toString() {
        return "Dog [id=" + id +
                ", name=" + name + "]";
    }
    
}
