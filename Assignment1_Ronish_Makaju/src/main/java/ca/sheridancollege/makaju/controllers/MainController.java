package ca.sheridancollege.makaju.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.makaju.beans.Dog;
import ca.sheridancollege.makaju.beans.Judge;
import ca.sheridancollege.makaju.beans.Owner;
import ca.sheridancollege.makaju.repositories.DogRepository;
import ca.sheridancollege.makaju.repositories.JudgeRepository;
import ca.sheridancollege.makaju.repositories.OwnerRepository;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class MainController {
	private OwnerRepository ownerRepo;
    private DogRepository dogRepo;
    private JudgeRepository judgeRepo;
    
    @GetMapping("/")
    public String goHome() {
    	return "home.html";
    }
    
    @GetMapping("/addOwner")
    public String addOwnerForm(Model model) {
        model.addAttribute("owner", new Owner());
        return "AddOwner";
    }

    @PostMapping("/addOwner")
    public String saveOwner(@ModelAttribute Owner owner) {
        ownerRepo.save(owner);
        return "redirect:/addOwner";
    }
    
    @GetMapping("/addJudge")
    public String addJudgeForm(Model model) {
        model.addAttribute("judge", new Judge());
        return "AddJudge";
    }

    @PostMapping("/addJudge")
    public String saveJudge(@ModelAttribute Judge judge) {
        judgeRepo.save(judge);
        return "redirect:/addJudge";
    }
    @GetMapping("/addDog")
    public String addDogForm(Model model) {
        model.addAttribute("dog", new Dog());
        model.addAttribute("owners", ownerRepo.findAll());
        model.addAttribute("judges", judgeRepo.findAll());
        return "addDog";
    }

    @PostMapping("/addDog")
    public String saveDog(@ModelAttribute Dog dog) {
        dogRepo.save(dog);
        return "redirect:/";
    }
    
    @GetMapping("/assignJudge")
    public String showAssignJudge(Model model) {
        model.addAttribute("dogs", dogRepo.findAll());
        model.addAttribute("judges", judgeRepo.findAll());
        return "assignJudge";
    }
    
    @PostMapping("/assignJudge")
    public String assignJudge(
            @RequestParam Long dogId,
            @RequestParam(value = "judgeIds", required = false) List<Long> judgeIds) {

        Dog dog = dogRepo.findById(dogId).get();

        

        if (judgeIds != null) {
            List<Judge> selectedJudges = judgeRepo.findAllById(judgeIds);
            dog.getJudges().addAll(selectedJudges);
        }

        dogRepo.save(dog);

        return "redirect:/";
    }
    
    @GetMapping("/assignOwner")
    public String showAssignOwner(Model model) {
        model.addAttribute("dogs", dogRepo.findAll());
        model.addAttribute("owners", ownerRepo.findAll());
        return "assignOwner";
    }
    
    @PostMapping("/assignOwner")
    public String assignOwner(@RequestParam Long dogId,
                              @RequestParam Long ownerId) {

        Dog dog = dogRepo.findById(dogId).get();
        Owner owner = ownerRepo.findById(ownerId).get();

        dog.setOwner(owner);

        dogRepo.save(dog);

        return "redirect:/";
    }
    
    @GetMapping("/viewDogs")
    public String viewDogs(@RequestParam(required = false) Long dogId,
                           Model model) {

        List<Dog> dogs;

        if (dogId != null) {
            dogs = new ArrayList<>();
            dogs.add(dogRepo.findById(dogId).get());
        } else {
            dogs = dogRepo.findAll();
        }

        model.addAttribute("dogs", dogs);
        model.addAttribute("allDogs", dogRepo.findAll());

        return "viewDogs";
    }
    
    @GetMapping("/removeJudge")
    public String removeJudge(@RequestParam Long dogId,
                              @RequestParam Long judgeId) {

        Dog dog = dogRepo.findById(dogId).get();
        Judge judge = judgeRepo.findById(judgeId).get();

        dog.getJudges().remove(judge);
        dogRepo.save(dog);

        return "redirect:/viewDogs";
    }
    @GetMapping("/viewOwners")
    public String viewOwners(@RequestParam(required = false) Long ownerId,
                             Model model) {

        List<Owner> owners;

        if (ownerId != null) {
            owners = new ArrayList<>();
            owners.add(ownerRepo.findById(ownerId).get());
        } else {
            owners = ownerRepo.findAll();
        }

        model.addAttribute("owners", owners);
        model.addAttribute("allOwners", ownerRepo.findAll());

        return "viewOwners";
    }
    
    @GetMapping("/viewJudges")
    public String viewJudges(@RequestParam(required = false) Long judgeId,
                             Model model) {

        List<Judge> judges;

        if (judgeId != null) {
            judges = new ArrayList<>();
            judges.add(judgeRepo.findById(judgeId).get());
        } else {
            judges = judgeRepo.findAll();
        }

        model.addAttribute("judges", judges);
        model.addAttribute("allJudges", judgeRepo.findAll());

        return "viewJudges";
    }

}
