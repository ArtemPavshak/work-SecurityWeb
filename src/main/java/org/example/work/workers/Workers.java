/*
  @author   rakel
  @project   work
  @class  Workers
  @version  1.0.0 
  @since 16.03.2025 - 22.37
*/
package org.example.work.workers;/*
  @author   rakel
  @project   work
  @class  Workers
  @version  1.0.0 
  @since 16.03.2025 - 22.37
*/

import lombok.*;
import org.springframework.data.annotation.Id;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Workers {

    @Id
    private String id;
    private String name;
    private String position;
    private Double salary;

    // Constructor for initialization
    public Workers(String name, String position, Double salary) {
        this.name = name;
        this.position = position;
        this.salary = salary;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Workers workers)) return false;
        return getId().equals(workers.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }
}
