package com.nlu.repository;

import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.nlu.entity.ProductEntity;
import com.nlu.repository.impl.ProductCustomRepositoryImpl;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = { PersistenceConfig.class })
//@Transactional
//@TransactionConfiguration
public class ProductCustomRepositoryTest {

//	@Autowired(required = true)
//	private ProductCustomRepositoryImpl repo;

//	@Before
//	public void setUp() {
//		repo = new ProductCustomRepositoryImpl();
//	}

	@Test
	void findByName() throws Exception {
		
//		ProductCustomRepositoryImpl repo = new ProductCustomRepositoryImpl();	
		String name = "abc";

//		List<ProductEntity> list = repo.findByName(name);
		assertNull(name);
	}

}
