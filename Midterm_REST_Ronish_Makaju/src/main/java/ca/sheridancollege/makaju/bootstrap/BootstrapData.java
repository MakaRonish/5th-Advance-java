package ca.sheridancollege.makaju.bootstrap;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ca.sheridancollege.makaju.beans.Shirt;
import ca.sheridancollege.makaju.beans.Therapist;
import ca.sheridancollege.makaju.repositories.ShirtRepository;
import ca.sheridancollege.makaju.repositories.TherapistRepository;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class BootstrapData implements CommandLineRunner {

    private ShirtRepository shirtRepo;
    private TherapistRepository therapistRepo;

    @Override
    public void run(String... args) throws Exception {

        
        Therapist t1 = Therapist.builder().name("Ronish").build();
        Therapist t2 = Therapist.builder().name("Priya").build();
        Therapist t3 = Therapist.builder().name("Rey").build();

        therapistRepo.saveAll(List.of(t1, t2, t3));

        Shirt s1 = Shirt.builder().name("full sleeve").price(99).quantity(4).employeeName("Ronish").therapist(t1).build();
        Shirt s2 = Shirt.builder().name("half sleeve").price(79).quantity(8).employeeName("Priya").therapist(t2).build();
        Shirt s3 = Shirt.builder().name("polo shirt").price(89).quantity(6).employeeName("Rey").therapist(t3).build();
        Shirt s4 = Shirt.builder().name("denim shirt").price(120).quantity(40).employeeName("Rey").therapist(t1).build();
        Shirt s5 = Shirt.builder().name("casual shirt").price(69).quantity(90).employeeName("Priya").therapist(t1).build();
        Shirt s6 = Shirt.builder().name("formal shirt").price(110).quantity(50).employeeName("Ronish").therapist(t2).build();
        Shirt s7 = Shirt.builder().name("linen shirt").price(130).quantity(3).employeeName("Rey").therapist(t3).build();
        Shirt s8 = Shirt.builder().name("checked shirt").price(95).quantity(70).employeeName("Priya").therapist(t2).build();
        Shirt s9 = Shirt.builder().name("striped shirt").price(85).quantity(5).employeeName("Ronish").therapist(t2).build();
        Shirt s10 = Shirt.builder().name("flannel shirt").price(105).quantity(4).employeeName("Ronish").therapist(t1).build();

        shirtRepo.saveAll(List.of(s1,s2,s3,s4,s5,s6,s7,s8,s9,s10));

        
        t1.setShirts(List.of(s1,s4,s5,s10));
        t2.setShirts(List.of(s2,s6,s8,s9));
        t3.setShirts(List.of(s3,s7));
        therapistRepo.saveAll(List.of(t1,t2,t3));
    }
}