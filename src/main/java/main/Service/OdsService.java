package main.Service;

import main.DTO.OdsDTO;
import main.Entity.OdsEntity;
import main.Repository.OdsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OdsService {

    @Autowired
    OdsRepository odsRepository;

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
}
