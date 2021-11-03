package main.Entity;

import main.DTO.OdsDTO;

import javax.persistence.*;

@Entity(name = "ods")
public class OdsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "objective_number")
    private String objectiveNumber;
    @Column(name = "objective_name")
    private String objectiveName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public static OdsEntity convert(OdsDTO odsDTO) {
        OdsEntity odsEntity = new OdsEntity();
        odsEntity.setObjectiveName(odsDTO.getObjectiveName());
        odsEntity.setObjectiveNumber(odsDTO.getObjectiveNumber());
        return odsEntity;
    }
}
