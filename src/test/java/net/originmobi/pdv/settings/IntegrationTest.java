package net.originmobi.pdv.settings;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;

@Rollback
@Transactional
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("dev")
@ExtendWith(SpringExtension.class)
public class IntegrationTest {

  public static final String CODIGO = "codigo";
  @Autowired
  private WebApplicationContext context;
  @PersistenceContext
  private EntityManager entityManager;

  protected MockMvc mockMvc() {
    return MockMvcBuilders
        .webAppContextSetup(context)
        .apply(springSecurity())
        .build();
  }

  protected Long extractCodigoOf(ResultActions actions) {
    final String codigo = String.valueOf(actions.andReturn().getFlashMap().get(CODIGO));
    return Long.valueOf(codigo);
  }

  protected <T> T save(T entity) {
    entityManager.persist(entity);
    return entity;
  }

  protected <T> T saveAndFlush(T entity) {
    entityManager.persist(entity);
    entityManager.flush();
    return entity;
  }

  protected void flush() {
    entityManager.flush();
  }
}
