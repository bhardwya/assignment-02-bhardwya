package sheridan.bhardwya.assignment2.yashi_02;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

//controller class
@Controller
@RequestMapping(value={"/pets","/"})
public class PetDataController {

    private final PetDataService petService;

    @Autowired
    public PetDataController(PetDataService petService) {

        this.petService = petService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("pets", petService.getAllPets());
        return "petDataLisiting";
    }

    @GetMapping("/new")
    public String create(Model model) {
        model.addAttribute("pet", new PetData());
        return "petDataAdd";
    }

    @PostMapping
    public String save(@ModelAttribute("pet") @Valid PetData pet, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "petDataAdd";
        }

        petService.addPetData(pet);
        return "redirect:/pets";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") long id, Model model) {
        model.addAttribute("pet", petService.getPetData(id));
        return "petDataEditing";
    }

    @PostMapping("/edit/{id}")
    public String update(@PathVariable("id") long id, @ModelAttribute("pet") PetData pet, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            pet.setId(id);
            return "petDataEditing";
        }

        petService.addPetData(pet);
        return "redirect:/pets";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id) {
        petService.deletePetData(id);
        return "redirect:/pets";
    }
}


