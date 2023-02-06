package it.sincon.p2_presentazione_istanze_v2;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

import it.sincon.p2_presentazione_istanze_v2.DataAccess.entities.User;
import it.sincon.p2_presentazione_istanze_v2.DataAccess.repositories.UserRepository;
import it.sincon.p2_presentazione_istanze_v2.Services.dtos.UserDTO;
import it.sincon.p2_presentazione_istanze_v2.Services.services.UserService;


@SpringBootTest(classes = PresentazioneIstanzeV2Application.class)
class SpringApplicationTests {

	private static final Logger log = LoggerFactory.getLogger(SpringApplicationTests.class);

	@Autowired
    private UserRepository userRepo;

	@Autowired
    private UserService userService;


	@Test
	void contextLoads() { }


	@Test
	@Profile(value="dev")
	void ExecuteRepository() {

		User user = new User();
        user.setName("Alessandro");
        user.setEmail("alessandro.chiloiro@sincon.it");

		// student.setDeletedBy(SecurityUtils.getCurrentUserLogin().get());
		// student.setDeletedDate(new Date());

        userRepo.save(user);
        userRepo.flush();
        
        List<User> listStudents = userRepo.findAll();
        log.info(listStudents.toString());
	}

	@Test
	@Profile(value="dev")
	void ExecuteService() throws Exception {

		Integer id = 1;
		String updateTest = "Marco";

		UserDTO resultGetById = userService.GetById(id);
		UserDTO resultCreate = userService.Create(resultGetById);

		resultCreate.setName(updateTest);
		UserDTO resultUpdate = userService.Update(resultCreate.getId(), resultCreate);

		Integer deleteId = resultUpdate.getId();
		UserDTO resultDelete = userService.Delete(deleteId);

		UserDTO resultDeleted = userService.GetById(deleteId);
		List<UserDTO> resultGetAll = userService.GetAll();

		Assertions.assertNotNull(resultGetById);
		Assertions.assertNotNull(resultCreate);
		Assertions.assertNotNull(resultUpdate);
		Assertions.assertNotNull(resultDelete);
		Assertions.assertNull(resultDeleted);
		Assertions.assertNotNull(resultGetAll);
	}

}
