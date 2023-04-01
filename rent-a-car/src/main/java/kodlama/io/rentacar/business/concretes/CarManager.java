package kodlama.io.rentacar.business.concretes;

import kodlama.io.rentacar.business.abstracts.CarService;
import kodlama.io.rentacar.business.dto.requests.create.car.CreateCarRequest;
import kodlama.io.rentacar.business.dto.requests.update.car.UpdateCarRequest;
import kodlama.io.rentacar.business.dto.responses.create.car.CreateCarResponse;
import kodlama.io.rentacar.business.dto.responses.get.car.GetAllCarsResponse;
import kodlama.io.rentacar.business.dto.responses.get.car.GetCarResponse;
import kodlama.io.rentacar.business.dto.responses.update.car.UpdateCarResponse;
import kodlama.io.rentacar.entities.Car;
import kodlama.io.rentacar.repository.CarRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CarManager implements CarService {

    private final CarRepository repository;
    private final ModelMapper mapper;

    @Override
    public List<GetAllCarsResponse> getAll() {
        List<Car> cars = repository.findAll();
        List<GetAllCarsResponse> response = cars
                .stream()
                .map(car -> mapper.map(car, GetAllCarsResponse.class))
                .toList();
        return response;
    }

    @Override
    public GetCarResponse getById(int id) {
        checkIfCarExistsById(id);
        Car car= repository.findById(id).orElseThrow();
        GetCarResponse response = mapper.map(car, GetCarResponse.class);
        return response;
    }

    @Override
    public CreateCarResponse add(CreateCarRequest request) {
        checkIfCarExistsByPlate(request.getPlate());
        Car car= mapper.map(request, Car.class);
        car.setId(0);
        repository.save(car);
        CreateCarResponse response= mapper.map(car, CreateCarResponse.class);
        return response;
    }

    @Override
    public UpdateCarResponse update(int id, UpdateCarRequest request) {
        checkIfCarExistsById(id);
        Car car= mapper.map(request, Car.class);
        car.setId(id);
        repository.save(car);

        UpdateCarResponse response= mapper.map(car, UpdateCarResponse.class);
        return response;
    }

    @Override
    public void delete(int id) {
        checkIfCarExistsById(id);
        repository.deleteById(id);
    }

    //BUSINESS RULES
    private void checkIfCarExistsById(int id) {
        if (!repository.existsById(id)) throw new IllegalArgumentException("böyle bir araba mevcut değil.");
    }

    private void checkIfCarExistsByPlate(String plate) {
        if (repository.existsByPlateIgnoreCase(plate)) throw new IllegalArgumentException("böyle bir plaka sistemde mevcut.");
    }
}
