/*
  @author   rakel
  @project   work
  @class  WorkersService
  @version  1.0.0 
  @since 16.03.2025 - 22.37
*/
package org.example.work.workers;/*
  @author   rakel
  @project   work
  @class  WorkersService
  @version  1.0.0 
  @since 16.03.2025 - 22.37
*/

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class WorkersService {

    private final WorkersRepository workersRepository;

    private List<Workers> workers;

    @PostConstruct
    void init() {
        if (workersRepository.count() == 0) {
            workers = List.of(
                    new Workers("John Doe", "Manager", 5000.00),
                    new Workers("Jane Smith", "Developer", 4500.00)
            );
            workersRepository.saveAll(workers);
        }
    }

    public List<Workers> getAllWorkers() {
        return workersRepository.findAll();
    }

    public Workers getWorkerById(String id) {
        return workersRepository.findById(id).orElse(null);
    }

    public void deleteWorkerById(String id) {
        workersRepository.deleteById(id);
    }

    public Workers createWorker(Workers worker) {
        return workersRepository.save(worker);
    }

    public Workers updateWorker(Workers worker) {
        return workersRepository.save(worker);
    }
}