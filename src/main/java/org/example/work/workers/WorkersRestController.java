/*
  @author   rakel
  @project   work
  @class  WorkersRestController
  @version  1.0.0 
  @since 16.03.2025 - 22.39
*/
package org.example.work.workers;/*
  @author   rakel
  @project   work
  @class  WorkersRestController
  @version  1.0.0 
  @since 16.03.2025 - 22.39
*/

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/workers")
@AllArgsConstructor
public class WorkersRestController {

    private final WorkersService workersService;

    @GetMapping
    public List<Workers> getWorkers() {
        return workersService.getAllWorkers();
    }

    @GetMapping("/{id}")
    public Workers getOneWorker(@PathVariable Long id) {
        return workersService.getWorkerById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteWorker(@PathVariable Long id) {
        workersService.deleteWorkerById(id);
    }

    @PostMapping
    public Workers createWorker(@RequestBody Workers worker) {
        return workersService.createWorker(worker);
    }

    @PutMapping
    public Workers updateWorker(@RequestBody Workers worker) {
        return workersService.updateWorker(worker);
    }
}
