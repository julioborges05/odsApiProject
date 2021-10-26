package main.Service;

import main.DTO.OdsQuestionDTO;
import main.Entity.OdsQuestionEntity;
import main.Repository.OdsQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OdsQuestionService {

    @Autowired
    OdsQuestionRepository odsQuestionRepository;

    @Autowired
    OdsSubQuestionService odsSubQuestionService;

    public List<OdsQuestionDTO> findAll() {
        return new ArrayList<>();
    }

    public List<OdsQuestionDTO> findAllByOdsId(Long id) {
        List<OdsQuestionEntity> odsQuestionEntityList = odsQuestionRepository.findAllByOdsId(id);
        List<OdsQuestionDTO> odsQuestionDTOList = new ArrayList<>();

        for(OdsQuestionEntity odsQuestionEntity : odsQuestionEntityList) {
            OdsQuestionDTO odsQuestion = OdsQuestionDTO.convert(odsQuestionEntity);
            odsQuestion.setOdsSubQuestionDTOList(odsSubQuestionService
                    .odsSubQuestionDTOListByQuestionNumber(odsQuestion.getQuestionNumber()));
            odsQuestionDTOList.add(odsQuestion);
        }

        return odsQuestionDTOList;
    }
}
