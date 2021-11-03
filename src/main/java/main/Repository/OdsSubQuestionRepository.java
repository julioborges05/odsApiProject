package main.Repository;

import main.Entity.OdsSubQuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OdsSubQuestionRepository extends JpaRepository<OdsSubQuestionEntity, Long> {

    @Query(value = " select * from " +
            " ods.ods_sub_question where ods_question_number = :questionNumber ", nativeQuery = true)
    public List<OdsSubQuestionEntity> findByQuestionNumber(@Param("questionNumber") String questionNumber);
}
