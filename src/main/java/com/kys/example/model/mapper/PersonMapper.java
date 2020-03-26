package com.kys.example.model.mapper;

import com.kys.example.model.Person;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import java.util.Optional;

/**
 * Person 매퍼
 * @author kody.kim
 * @since 28/01/2020
 */
@Mapper
public interface PersonMapper {

    @SelectProvider(PersonSqlProvider.class)
    int countById(@Param("id") Long id);

    @SelectProvider(PersonSqlProvider.class)
    Optional<Person> findById(@Param("id") Long id);

    @SelectProvider(PersonSqlProvider.class)
    Optional<Person> findByName(@Param("name") String name);

    @InsertProvider(PersonSqlProvider.class)
    @Options(useGeneratedKeys=true, keyProperty="id")
    Integer insert(Person person);

    @DeleteProvider(PersonSqlProvider.class)
    Integer delete(Person person);

    @UpdateProvider(PersonSqlProvider.class)
    Integer update(Person person);

}
