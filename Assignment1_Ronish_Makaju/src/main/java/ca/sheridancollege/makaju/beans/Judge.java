package ca.sheridancollege.makaju.beans;


import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Judge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "judges")
    private List<Dog> dogs;
    
    @Override
    public String toString() {
        return "Judge [id=" + id +
                ", name=" + name + "]";
    }
}