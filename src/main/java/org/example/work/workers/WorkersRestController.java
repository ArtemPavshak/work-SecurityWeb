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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/workers")
public class WorkersRestController {

    private final WorkersService workersService;

    public WorkersRestController(WorkersService workersService) {
        this.workersService = workersService;
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'SUPERADMIN', 'USER')")
    @GetMapping
    public List<Workers> getWorkers() {
        return workersService.getAllWorkers();
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'SUPERADMIN', 'USER')")
    @GetMapping("/{id}")
    public Workers getOneWorker(@PathVariable String id) {
        return workersService.getWorkerById(id);
    }

    @PreAuthorize("hasRole('SUPERADMIN')")
    @DeleteMapping("/{id}")
    public void deleteWorker(@PathVariable String id) {
        workersService.deleteWorkerById(id);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'SUPERADMIN')")
    @PostMapping
    public Workers createWorker(@RequestBody Workers worker) {
        return workersService.createWorker(worker);
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'SUPERADMIN')")
    @PutMapping
    public Workers updateWorker(@RequestBody Workers worker) {
        return workersService.updateWorker(worker);
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("/hello/user")
    public String helloUser() {
        return "Hello User!";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/hello/admin")
    public String helloAdmin() {
        return "Hello Admin!";
    }

    @PreAuthorize("hasRole('SUPERADMIN')")
    @GetMapping("/hello/superadmin")
    public String helloSuperAdmin() {
        return "Hello SuperAdmin!";
    }

    @GetMapping("/hello/unknown")
    public String helloUnknown() {
        return "Hello Unknown!";
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN', 'SUPERADMIN')")
    @GetMapping("/view/profile")
    public String viewProfile() {
        return "This is your profile information.";
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("/view/dashboard")
    public String viewDashboard() {
        return "Welcome to the dashboard.";
    }

    @PreAuthorize("hasRole('SUPERADMIN')")
    @GetMapping("/view/stats")
    public String viewStats() {
        return "Here are the detailed stats.";
    }
}
