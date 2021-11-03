package main.Repository;

import main.Entity.OdsQuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OdsQuestionRepository extends JpaRepository<OdsQuestionEntity, Long> {

    @Query(value = " select * from ods.ods_question " +
            " where ods_id = :odsId ", nativeQuery = true)
    public List<OdsQuestionEntity> findAllByOdsId(@Param("odsId")Long odsId);

    public OdsQuestionEntity findByOdsQuestion(String odsQuestion);
}
