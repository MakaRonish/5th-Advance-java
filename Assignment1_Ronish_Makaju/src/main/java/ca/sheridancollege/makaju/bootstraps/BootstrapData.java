package ca.sheridancollege.makaju.bootstraps;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ca.sheridancollege.makaju.beans.Dog;
import ca.sheridancollege.makaju.beans.Judge;
import ca.sheridancollege.makaju.beans.Owner;
import ca.sheridancollege.makaju.repositories.DogRepository;
import ca.sheridancollege.makaju.repositories.JudgeRepository;
import ca.sheridancollege.makaju.repositories.OwnerRepository;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class BootstrapData implements CommandLineRunner {

    private OwnerRepository ownerRepo;
    private DogRepository dogRepo;
    private JudgeRepository judgeRepo;

    @Override
    public void run(String... args) throws Exception {

        Owner o1 = Owner.builder().firstName("Ronish").lastName("Makaju").build();
        Owner o2 = Owner.builder().firstName("Priya").lastName("Gurung").build();
        Owner o3 = Owner.builder().firstName("Aarav").lastName("Singh").build();
        Owner o4 = Owner.builder().firstName("Nisha").lastName("Gupta").build();
        Owner o5 = Owner.builder().firstName("Karan").lastName("Mehta").build();
        Owner o6 = Owner.builder().firstName("Sofia").lastName("Brown").build();

        ownerRepo.saveAll(List.of(o1, o2, o3, o4, o5, o6));

        Judge j1 = Judge.builder().name("Judge Wilson").build();
        Judge j2 = Judge.builder().name("Judge Anderson").build();
        Judge j3 = Judge.builder().name("Judge Martinez").build();

        judgeRepo.saveAll(List.of(j1, j2, j3));

        Dog d1  = Dog.builder().name("Max").owner(o1).judges(List.of(j1,j2,j3)).build();
        Dog d2  = Dog.builder().name("Bella").owner(o1).judges(List.of(j1,j2,j3)).build();
        Dog d3  = Dog.builder().name("Charlie").owner(o1).judges(List.of(j1,j2,j3)).build();
        Dog d4  = Dog.builder().name("Rocky").owner(o1).judges(List.of(j1,j2,j3)).build();
        Dog d5  = Dog.builder().name("Luna").owner(o1).judges(List.of(j1,j2,j3)).build();

        Dog d6  = Dog.builder().name("Cooper").owner(o2).judges(List.of(j1,j2,j3)).build();
        Dog d7  = Dog.builder().name("Milo").owner(o2).judges(List.of(j1,j2,j3)).build();
        Dog d8  = Dog.builder().name("Buddy").owner(o2).judges(List.of(j1,j2,j3)).build();
        Dog d9  = Dog.builder().name("Daisy").owner(o2).judges(List.of(j1,j2,j3)).build();
        Dog d10 = Dog.builder().name("Bailey").owner(o2).judges(List.of(j1,j2,j3)).build();

        Dog d11 = Dog.builder().name("Oliver").owner(o3).judges(List.of(j1,j2,j3)).build();
        Dog d12 = Dog.builder().name("Toby").owner(o3).judges(List.of(j1,j2,j3)).build();
        Dog d13 = Dog.builder().name("Simba").owner(o3).judges(List.of(j1,j2,j3)).build();
        Dog d14 = Dog.builder().name("Chloe").owner(o3).judges(List.of(j1,j2,j3)).build();
        Dog d15 = Dog.builder().name("Jack").owner(o3).judges(List.of(j1,j2,j3)).build();

        Dog d16 = Dog.builder().name("Leo").owner(o4).judges(List.of(j1,j2,j3)).build();
        Dog d17 = Dog.builder().name("Zoey").owner(o4).judges(List.of(j1,j2,j3)).build();
        Dog d18 = Dog.builder().name("Oscar").owner(o4).judges(List.of(j1,j2,j3)).build();
        Dog d19 = Dog.builder().name("Ruby").owner(o4).judges(List.of(j1,j2,j3)).build();
        Dog d20 = Dog.builder().name("Finn").owner(o4).judges(List.of(j1,j2,j3)).build();

        Dog d21 = Dog.builder().name("Coco").owner(o5).judges(List.of(j1,j2,j3)).build();
        Dog d22 = Dog.builder().name("Bentley").owner(o5).judges(List.of(j1,j2,j3)).build();
        Dog d23 = Dog.builder().name("Nala").owner(o5).judges(List.of(j1,j2,j3)).build();
        Dog d24 = Dog.builder().name("Shadow").owner(o5).judges(List.of(j1,j2,j3)).build();
        Dog d25 = Dog.builder().name("Zeus").owner(o5).judges(List.of(j1,j2,j3)).build();

        Dog d26 = Dog.builder().name("Mocha").owner(o6).judges(List.of(j1,j2,j3)).build();
        Dog d27 = Dog.builder().name("Bruno").owner(o6).judges(List.of(j1,j2,j3)).build();
        Dog d28 = Dog.builder().name("Rex").owner(o6).judges(List.of(j1,j2,j3)).build();
        Dog d29 = Dog.builder().name("Ginger").owner(o6).judges(List.of(j1,j2,j3)).build();
        Dog d30 = Dog.builder().name("Thor").owner(o6).judges(List.of(j1,j2,j3)).build();

        dogRepo.saveAll(List.of(
                d1,d2,d3,d4,d5,
                d6,d7,d8,d9,d10,
                d11,d12,d13,d14,d15,
                d16,d17,d18,d19,d20,
                d21,d22,d23,d24,d25,
                d26,d27,d28,d29,d30
        ));
    }
}