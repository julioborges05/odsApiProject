package main.DTO;

import main.Entity.OdsQuestionEntity;

import java.util.List;

public class OdsQuestionDTO {
    private String question;
    private int odsQuestionNumber;
    private List<OdsSubQuestionDTO> odsSubQuestionDTOList;

    public OdsQuestionDTO() {
    }

    public OdsQuestionDTO(String question, List<OdsSubQuestionDTO> odsSubQuestionDTOList) {
        this.question = question;
        this.odsSubQuestionDTOList = odsSubQuestionDTOList;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getQuestionNumber() {
        return odsQuestionNumber;
    }

    public void setQuestionNumber(int questionNumber) {
        this.odsQuestionNumber = questionNumber;
    }

    public List<OdsSubQuestionDTO> getOdsSubQuestionDTOList() {
        return odsSubQuestionDTOList;
    }

    public void setOdsSubQuestionDTOList(List<OdsSubQuestionDTO> odsSubQuestionDTOList) {
        this.odsSubQuestionDTOList = odsSubQuestionDTOList;
    }

    public static OdsQuestionDTO convert(OdsQuestionEntity odsQuestionEntity) {
        OdsQuestionDTO questionDTO = new OdsQuestionDTO();
        questionDTO.setQuestion(odsQuestionEntity.getOdsQuestion());
        questionDTO.setQuestionNumber(odsQuestionEntity.getQuestionNumber());
        return questionDTO;
    }
}
