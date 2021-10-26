package main.Service;

import main.DTO.OdsSubQuestionDTO;
import main.Repository.OdsSubQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OdsSubQuestionService {

    @Autowired
    OdsSubQuestionRepository odsSubQuestionRepository;

    public List<OdsSubQuestionDTO> odsSubQuestionDTOList() {
        return new ArrayList<>();
    }

    public List<OdsSubQuestionDTO> odsSubQuestionDTOListByQuestionNumber(int questionNumber) {
        return odsSubQuestionRepository
                .findByQuestionNumber(questionNumber)
                .stream()
                .map(OdsSubQuestionDTO::convert)
                .collect(Collectors.toList());
    }
}
