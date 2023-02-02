package com.sincon.tdh;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

import com.sincon.p2_presentazione_istanze_v2.SpringAppApplication;
import com.sincon.p2_presentazione_istanze_v2.be.DataAccess.entities.User;
import com.sincon.p2_presentazione_istanze_v2.be.Services.dtos.UserDTO;
import com.sincon.p2_presentazione_istanze_v2.be.DataAccess.repositories.UserRepository;
import com.sincon.p2_presentazione_istanze_v2.be.Services.services.UserService;


@SpringBootTest(classes = SpringAppApplication.class)
class SpringAppApplicationTests {

	private static final Logger log = LoggerFactory.getLogger(SpringAppApplicationTests.class);

	@Autowired
    private UserRepository userRepo;

	@Autowired
    private UserService userService;


	@Test
	void contextLoads() { }


	@Test
	@Profile(value="dev")
	void HubRepository() {

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
	void HubService() throws Exception {

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
