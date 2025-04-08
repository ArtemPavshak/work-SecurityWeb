/*
  @author   rakel
  @project   work
  @class  AuditMetaData
  @version  1.0.0 
  @since 08.04.2025 - 18.12
*/
package org.example.work.workers;/*
  @author   rakel
  @project   work
  @class  AuditMetaData
  @version  1.0.0 
  @since 08.04.2025 - 18.12
*/

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@NoArgsConstructor
@Data
public class AuditMetaData {

    @CreatedDate
    private LocalDateTime createdDate;

    @CreatedBy
    private String createdBy;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    @LastModifiedBy
    private String lastModifiedBy;

}