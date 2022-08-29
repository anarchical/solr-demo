package com.leaf.solrdemo.repository;

import com.leaf.solrdemo.entity.Student;
import org.springframework.data.solr.repository.Query;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author YeYaqiao
 */
@Repository
public interface StudentRepository extends SolrCrudRepository<Student, String> {

    @Query("*:*")
    List<Student> getAll();

    Student findStudentById(String id);
}
