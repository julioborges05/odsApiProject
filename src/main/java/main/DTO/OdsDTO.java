package main.DTO;

import main.Entity.OdsEntity;

import java.util.List;

public class OdsDTO {
    private Long odsId;
    private String objectiveNumber;
    private String objectiveName;
    private List<OdsQuestionDTO> odsQuestionDTOS;

    public OdsDTO() {
    }

    public Long getOdsId() {
        return odsId;
    }

    public void setOdsId(Long odsId) {
        this.odsId = odsId;
    }

    public String getObjectiveNumber() {
        return objectiveNumber;
    }

    public void setObjectiveNumber(String objectiveNumber) {
        this.objectiveNumber = objectiveNumber;
    }

    public String getObjectiveName() {
        return objectiveName;
    }

    public void setObjectiveName(String objectiveName) {
        this.objectiveName = objectiveName;
    }

    public List<OdsQuestionDTO> getOdsQuestionDTOS() {
        return odsQuestionDTOS;
    }

    public void setOdsQuestionDTOS(List<OdsQuestionDTO> odsQuestionDTOS) {
        this.odsQuestionDTOS = odsQuestionDTOS;
    }

    public static OdsDTO convert(OdsEntity odsEntity) {
        OdsDTO odsDTO = new OdsDTO();
        odsDTO.setOdsId(odsEntity.getId());
        odsDTO.setObjectiveName(odsEntity.getObjectiveName());
        odsDTO.setObjectiveNumber(odsEntity.getObjectiveNumber());
        return odsDTO;
    }
}
