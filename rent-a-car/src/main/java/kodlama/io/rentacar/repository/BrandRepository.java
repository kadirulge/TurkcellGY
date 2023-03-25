package kodlama.io.rentacar.repository;

import kodlama.io.rentacar.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//CRUD Operations
public interface BrandRepository extends JpaRepository<Brand, Integer> {
    //Custom Queries
}
