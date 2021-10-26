package main.Entity;

import main.DTO.OdsSubQuestionDTO;

import javax.persistence.*;

@Entity(name = "ods_sub_question")
public class OdsSubQuestionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String odsSubQuestion;
    private Integer odsQuestionNumber;
    private String status;
    private Long odsQuestionId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOdsSubQuestion() {
        return odsSubQuestion;
    }

    public void setOdsSubQuestion(String odsSubQuestion) {
        this.odsSubQuestion = odsSubQuestion;
    }

    public Integer getOdsQuestionNumber() {
        return odsQuestionNumber;
    }

    public void setOdsQuestionNumber(Integer odsQuestionNumber) {
        this.odsQuestionNumber = odsQuestionNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getOdsQuestionId() {
        return odsQuestionId;
    }

    public void setOdsQuestionId(Long odsQuestionId) {
        this.odsQuestionId = odsQuestionId;
    }

    public static OdsSubQuestionEntity convert(OdsSubQuestionDTO questionDTO) {
        OdsSubQuestionEntity odsSubQuestionEntity = new OdsSubQuestionEntity();
        odsSubQuestionEntity.setOdsSubQuestion(questionDTO.getSubQuestion());
        odsSubQuestionEntity.setStatus(questionDTO.getStatus());
        return odsSubQuestionEntity;
    }
}
