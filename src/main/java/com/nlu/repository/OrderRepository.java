package com.nlu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nlu.entity.OrderEntity;

@Repository
public interface OrderRepository extends CrudRepository<OrderEntity, Long> {
	List<OrderEntity> findByOrderByCreatedDateDesc();

	OrderEntity findById(long id);

	<S extends OrderEntity> S save(S entity);

	void delete(OrderEntity orderEntity);

	void deleteById(Long id);

	boolean existsById(Long id);

	@Query(value = "SELECT MONTH(created_date) as month,YEAR(created_date) as year,SUM(total_money) as sales, COUNT(*) as count\r\n"
			+ "FROM orders GROUP BY MONTH(created_date), YEAR(created_date)\r\n"
			+ "ORDER BY YEAR(created_date) desc, MONTH(created_date) desc LIMIT 6", nativeQuery = true)
	List<Object[]> findSalesStatistics();

	@Query(value = "select * from (\r\n"
			+ "	(select COUNT(id) as order_num, SUM(total_money) as sales, SUM(total_money - total_origin_price) as profit\r\n"
			+ "	from orders\r\n" + "	where created_date = CURRENT_DATE ) as A,\r\n"
			+ "	(select COUNT(id) as user_new\r\n" + "	from user\r\n"
			+ "	where created_date = CURRENT_DATE ) as B)", nativeQuery = true)
	List<Object[]> findDayStatistic();
}
