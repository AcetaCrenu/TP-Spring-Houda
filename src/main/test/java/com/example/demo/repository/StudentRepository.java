package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Student;
public interface StudentRepository extends JpaRepository<Student, Integer> {
	Student findById(int id);
	@Query("select year(s.dateNaissance) as annee, count(*) as nbr from Student s group by year(s.dateNaissance) 
	order by year(s.dateNaissance)")
	Collection<?> findNbrStudentByYear();
}