package com.eCommerceWeb.eCommerceWeb.repository;

import com.eCommerceWeb.eCommerceWeb.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {

    User findById(int id);

}
