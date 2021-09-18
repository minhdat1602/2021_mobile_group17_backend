package com.nlu.repository;

import static org.junit.Assert.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
