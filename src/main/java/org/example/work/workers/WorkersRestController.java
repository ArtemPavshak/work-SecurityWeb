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
    public Workers getOneWorker(@PathVariable String id) {
        return workersService.getWorkerById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteWorker(@PathVariable String id) {
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

    @GetMapping("/hello/user")
    public String helloUser() {
        return "Hello User!";
    }

    @GetMapping("hello/admin")
    public String helloAdmin() {
        return "Hello Admin!";
    }

    @GetMapping("/hello/superadmin")
    public String helloSuperAdmin() {
        return "Hello SuperAdmin!";
    }

    @GetMapping("/hello/unknown")
    public String helloUnknown() {
        return "Hello Unknown!";
    }

    @GetMapping("/view/profile")
    public String viewProfile() {
        return "This is your profile information. (Access granted for USER, ADMIN, SUPERADMIN)";
    }

    @GetMapping("/view/dashboard")
    public String viewDashboard() {
        return "Welcome to the dashboard. (Access granted for USER, ADMIN)";
    }

    @GetMapping("/view/stats")
    public String viewStats() {
        return "Here are the detailed stats. (Access granted only for SUPERADMIN)";
    }


}
