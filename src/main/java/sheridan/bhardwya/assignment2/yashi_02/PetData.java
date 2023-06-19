package sheridan.bhardwya.assignment2.yashi_02;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class PetData {
    //petclass
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Please fill in Pet Name!")
    private String name;
    private String kind;
    private String sex;
    private Boolean isVaccinated;
    public PetData() {
    }
    public PetData(String name, String kind, String sex, Boolean isVaccinated) {
        this.name = name;
        this.kind = kind;
        this.sex = sex;
        this.isVaccinated = isVaccinated;
    }

    // Getters and Setters

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getKind() {

        return kind;
    }

    public void setKind(String kind) {

        this.kind = kind;
    }

    public String getSex() {

        return sex;
    }

    public void setSex(String sex) {

        this.sex = sex;
    }

    public Boolean getIsVaccinated() {

        return isVaccinated;
    }

    public void setIsVaccinated(Boolean isVaccinated) {

        this.isVaccinated = isVaccinated;
    }
}
