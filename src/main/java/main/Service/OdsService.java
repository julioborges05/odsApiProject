package main.Service;

import main.DTO.OdsDTO;
import main.DTO.OdsQuestionDTO;
import main.DTO.OdsSubQuestionDTO;
import main.Entity.OdsEntity;
import main.Entity.OdsQuestionEntity;
import main.Entity.OdsSubQuestionEntity;
import main.Repository.OdsQuestionRepository;
import main.Repository.OdsRepository;
import main.Repository.OdsSubQuestionRepository;
import main.SeleniumComponent.SeleniumGenericConfig;
import main.SeleniumComponent.View.OdsView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OdsService {

    @Autowired
    OdsRepository odsRepository;

    @Autowired
    OdsQuestionRepository odsQuestionRepository;

    @Autowired
    OdsSubQuestionRepository odsSubQuestionRepository;

    @Autowired
    OdsQuestionService odsQuestionService;

    public List<OdsDTO> getAll() {
        List<OdsEntity> odsEntityList = odsRepository.findAll();
        List<OdsDTO> odsDTOList = new ArrayList<>();

        for(OdsEntity odsEntity : odsEntityList) {
            OdsDTO odsDTO = OdsDTO.convert(odsEntity);
            odsDTO.setOdsQuestionDTOS(odsQuestionService.findAllByOdsId(odsDTO.getOdsId()));
            odsDTOList.add(odsDTO);
        }

        return odsDTOList;
    }

    public void resetAllOds() {
        OdsView odsView = new OdsView(new SeleniumGenericConfig().getWebDriver());
        List<OdsDTO> odsDTOS = odsView.findAllOdsFromOdsPage();

        if(ObjectUtils.isEmpty(odsDTOS)) odsRepository.deleteAll();
        for(OdsDTO odsDTO : odsDTOS) {
            odsRepository.save(OdsEntity.convert(odsDTO));
            for(OdsQuestionDTO odsQuestionDTO : odsDTO.getOdsQuestionDTOS()) {
                odsQuestionRepository.save(OdsQuestionEntity.convert(odsQuestionDTO));
                for(OdsSubQuestionDTO odsSubQuestionDTO : odsQuestionDTO.getOdsSubQuestionDTOList()) {
                    odsSubQuestionRepository.save(OdsSubQuestionEntity.convert(odsSubQuestionDTO));
                }
            }
        }
    }
}
