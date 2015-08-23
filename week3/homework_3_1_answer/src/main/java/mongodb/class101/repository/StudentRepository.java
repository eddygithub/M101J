package mongodb.class101.repository;

import mongodb.class101.entity.Student;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, Long>{

}
