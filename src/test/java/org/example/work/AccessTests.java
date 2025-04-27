/*
  @author   rakel
  @project   work
  @class  AccessTests
  @version  1.0.0 
  @since 27.04.2025 - 15.01
*/
package org.example.work;/*
  @author   rakel
  @project   work
  @class  AccessTests
  @version  1.0.0 
  @since 27.04.2025 - 15.01
*/

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ActiveProfiles("test")
public class AccessTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeEach
    void beforeAll() {
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(webApplicationContext)
                .apply(springSecurity())
                .build();
    }

    @Test
    @WithAnonymousUser
    public void whenAnonymThenStatusUnautorized() throws Exception {

        mockMvc.perform(get("/api/v1/workers"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = {"ADMIN"})
    void whenAuthenticatedThenStatusOk() throws Exception {
        mockMvc.perform(get("/api/v1/workers/hello/admin"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = {"ADMIN"})
    void whenAuthenticatedThenStatus403() throws Exception {
        mockMvc.perform(get("/api/v1/workers/hello/user"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(username = "user", password = "user", roles = {"USER"})
    void whenUserAccessAdminEndpoint_thenForbidden() throws Exception {
        mockMvc.perform(get("/api/v1/workers/hello/admin"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = {"ADMIN"})
    void whenAdminAccessUserEndpoint_thenForbidden() throws Exception {
        mockMvc.perform(get("/api/v1/workers/hello/user"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(username = "superadmin", password = "superadmin", roles = {"SUPERADMIN"})
    void whenSuperadminAccessAdminEndpoint_thenForbidden() throws Exception {
        mockMvc.perform(get("/api/v1/workers/hello/admin"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(username = "superadmin", password = "superadmin", roles = {"SUPERADMIN"})
    void whenSuperadminAccessSuperadminEndpoint_thenOk() throws Exception {
        mockMvc.perform(get("/api/v1/workers/hello/superadmin"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "user", password = "user", roles = {"USER"})
    void whenUserAccessUserEndpoint_thenOk() throws Exception {
        mockMvc.perform(get("/api/v1/workers/hello/user"))
                .andExpect(status().isOk());
    }

    @Test
    @WithAnonymousUser
    void whenAnonymousAccessSuperadminEndpoint_thenUnauthorized() throws Exception {
        mockMvc.perform(get("/api/v1/workers/hello/superadmin"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @WithMockUser(username = "user", password = "user", roles = {"USER"})
    void whenUserAccessSuperadminEndpoint_thenForbidden() throws Exception {
        mockMvc.perform(get("/api/v1/workers/hello/superadmin"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = {"ADMIN"})
    void whenAdminAccessSuperadminEndpoint_thenForbidden() throws Exception {
        mockMvc.perform(get("/api/v1/workers/hello/superadmin"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = {"ADMIN"})
    void whenAdminAccessNonExistentEndpoint_thenNotFound() throws Exception {
        mockMvc.perform(get("/api/v1/workers/hello/nonexistent"))
                .andExpect(status().isNotFound());
    }

    @Test
    @WithMockUser(username = "superadmin", password = "superadmin", roles = {"SUPERADMIN"})
    void whenSuperadminAccessUserEndpoint_thenForbidden() throws Exception {
        mockMvc.perform(get("/api/v1/workers/hello/user"))
                .andExpect(status().isForbidden());
    }
    
    @Test
    @WithMockUser(username = "admin", password = "admin", roles = {"INVALID_ROLE"})
    void whenInvalidRole_thenForbidden() throws Exception {
        mockMvc.perform(get("/api/v1/workers/hello/admin"))
                .andExpect(status().isForbidden());
    }


}