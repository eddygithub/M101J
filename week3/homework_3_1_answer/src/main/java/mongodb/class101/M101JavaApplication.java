package mongodb.class101;

import java.util.List;

import mongodb.class101.entity.Score;
import mongodb.class101.entity.Student;
import mongodb.class101.repository.StudentRepository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class M101JavaApplication {

	public static void main(String[] args) {
		ApplicationContext appContext = SpringApplication.run(
				M101JavaApplication.class, args);

		StudentRepository repo = appContext.getBean(StudentRepository.class);
		List<Student> studentList = repo.findAll();
		
		for(Student student : studentList){
			List<Score> scores = student.getScores();
			Score minScore = new Score();
			minScore.setScore(200L);
			for(Score score : scores){
				if(score.getType().equalsIgnoreCase("homework") && score.getScore() < minScore.getScore()){
					minScore = score;
				}
			}
			scores.remove(minScore);
			
			repo.save(student);
		}
	}
}
