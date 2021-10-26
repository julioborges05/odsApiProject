package main.DTO;

import main.Entity.OdsSubQuestionEntity;

public class OdsSubQuestionDTO {
    private String subQuestion;
    private String status;

    public OdsSubQuestionDTO() {
    }

    public OdsSubQuestionDTO(String subQuestion, String status) {
        this.subQuestion = subQuestion;
        this.status = status;
    }

    public String getSubQuestion() {
        return subQuestion;
    }

    public void setSubQuestion(String subQuestion) {
        this.subQuestion = subQuestion;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static OdsSubQuestionDTO convert(OdsSubQuestionEntity odsSubQuestionEntity) {
        OdsSubQuestionDTO odsSubQuestionDTO = new OdsSubQuestionDTO();
        odsSubQuestionDTO.setSubQuestion(odsSubQuestionEntity.getOdsSubQuestion());
        odsSubQuestionDTO.setStatus(odsSubQuestionEntity.getStatus());
        return odsSubQuestionDTO;
    }
}
