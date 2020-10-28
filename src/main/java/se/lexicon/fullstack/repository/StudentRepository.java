package se.lexicon.fullstack.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.fullstack.entity.Student;

import javax.swing.text.html.Option;
import java.util.Optional;

/**
 * Created by Mehrdad Javan
 * Date: Oct, 2020
 */
@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

}
