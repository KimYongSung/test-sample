package com.kys.example.model.mapper;

import com.kys.example.model.Person;
import org.apache.ibatis.builder.annotation.ProviderMethodResolver;
import org.apache.ibatis.jdbc.SQL;

import java.util.Objects;

/**
 * @author kody.kim
 * @since 24/03/2020
 */
public class PersonSqlProvider implements ProviderMethodResolver {

    private static final String PERSON_TABLE = "person";

    public static String countById(){
        return new SQL(){{
            SELECT(" count(id) ");
            FROM(PERSON_TABLE);
            WHERE("id = #{id}");
        }}.toString();
    }

    public static String findById(){
        return new SQL(){{
            SELECT("*");
            FROM(PERSON_TABLE);
            WHERE("id = #{id}");
        }}.toString();
    }

    public static String findByName(){
        return new SQL(){{
            SELECT("*");
            FROM(PERSON_TABLE);
            WHERE("name = #{name}");
        }}.toString();
    }

    public static String findAll(){
        return new SQL(){{
            SELECT("*");
            FROM(PERSON_TABLE);
        }}.toString();
    }

    public static String insert(final Person person){
        return new SQL(){{
            INSERT_INTO(PERSON_TABLE);
            VALUES("name", "#{name}");
            VALUES("address", "#{address}");
            VALUES("age", "#{age}");
        }}.toString();
    }

    public static String update(final Person person){
        return new SQL(){{
            UPDATE(PERSON_TABLE);

            if(Objects.nonNull(person.getAddress())){
                SET("address = #{address}");
            }

            if(Objects.nonNull(person.getAge())){
                SET("age = #{age}");
            }

            WHERE("id = #{id}");

        }}.toString();
    }

    public static String delete(final Person person){
        return new SQL(){{
            DELETE_FROM(PERSON_TABLE);
            WHERE("id = #{id}");
        }}.toString();
    }


}
