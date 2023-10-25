package com.zelwina.springjdbc.repo;

import com.zelwina.springjdbc.entity.MyStuff;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyStuffRepo extends CrudRepository<MyStuff, Long> {
}
