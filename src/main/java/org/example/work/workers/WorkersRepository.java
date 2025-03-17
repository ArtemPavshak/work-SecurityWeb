/*
  @author   rakel
  @project   work
  @class  WorkersRepository
  @version  1.0.0 
  @since 16.03.2025 - 22.38
*/
package org.example.work.workers;/*
  @author   rakel
  @project   work
  @class  WorkersRepository
  @version  1.0.0 
  @since 16.03.2025 - 22.38
*/

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkersRepository extends MongoRepository<Workers, String> {
}
