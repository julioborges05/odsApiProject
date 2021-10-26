package main.Entity;

import main.DTO.OdsQuestionDTO;

import javax.persistence.*;

@Entity(name = "ods_question")
public class OdsQuestionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int odsQuestionNumber;
    private String odsQuestion;
    private Long odsId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuestionNumber() {
        return odsQuestionNumber;
    }

    public void setQuestionNumber(int questionNumber) {
        this.odsQuestionNumber = questionNumber;
    }

    public String getOdsQuestion() {
        return odsQuestion;
    }

    public void setOdsQuestion(String odsQuestion) {
        this.odsQuestion = odsQuestion;
    }

    public int getOdsQuestionNumber() {
        return odsQuestionNumber;
    }

    public void setOdsQuestionNumber(int odsQuestionNumber) {
        this.odsQuestionNumber = odsQuestionNumber;
    }

    public Long getOdsId() {
        return odsId;
    }

    public void setOdsId(Long odsId) {
        this.odsId = odsId;
    }

    public static OdsQuestionEntity convert(OdsQuestionDTO odsQuestionDTO) {
        OdsQuestionEntity odsQuestionEntity = new OdsQuestionEntity();
        odsQuestionEntity.setOdsQuestion(odsQuestionDTO.getQuestion());
        return odsQuestionEntity;
    }
}
