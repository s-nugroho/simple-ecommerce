package com.practice.ecommerce;

import com.practice.ecommerce.dao.UserRepository;
import com.practice.ecommerce.entity.BuyDetail;
import com.practice.ecommerce.entity.User;
import com.practice.ecommerce.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class EcommerceApplicationTests {

	@Mock
	User user = new User(1,"user1","user1");

	@Mock
	UserService userService;

	@Autowired
	UserRepository userRepository;

	@Test
	void Save() {
		var service = userService.saveUser(new User(1,"user1","user1"));
//		Assertions.assertSame(service,user1);
		Assertions.assertEquals(service,user);
	}

	@Test
	void save2(){
		var save = userRepository.save(new User(1,"user1","user1"));
		Assertions.assertNotNull(save);
	}

}
