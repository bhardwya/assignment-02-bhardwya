package sheridan.bhardwya.assignment2.yashi_02;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//interface
@Repository
public interface PetRep extends JpaRepository<PetData, Long> {
}
