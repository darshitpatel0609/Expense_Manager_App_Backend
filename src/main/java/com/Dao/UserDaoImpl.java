package com.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.Entity.UserCategoryEntity;
import com.Entity.UserEntity;
import com.Entity.UserSubCategoryEntity;

@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<UserSubCategoryEntity> searchCriteria(Integer id) {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<UserSubCategoryEntity> query = builder.createQuery(UserSubCategoryEntity.class);

		Root<UserEntity> userRoot = query.from(UserEntity.class);
		Join<UserEntity, UserCategoryEntity> categoryJoin = userRoot.join("userCategory");
		Join<UserCategoryEntity, UserSubCategoryEntity> subcategoryJoin = categoryJoin.join("userSubCategory");
		query.multiselect(userRoot, categoryJoin, subcategoryJoin);
		TypedQuery<UserSubCategoryEntity> typedQuery = entityManager.createQuery(query);
		List<UserSubCategoryEntity> results = typedQuery.getResultList();

		return results.subList(2, 2);

	}
}
