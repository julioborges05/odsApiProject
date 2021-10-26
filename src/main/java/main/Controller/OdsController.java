package main.Controller;

import main.DTO.OdsDTO;
import main.Service.OdsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class OdsController {

    @Autowired
    OdsService odsService;

    @GetMapping("/getOds")
    public List<OdsDTO> getAllOds() {
        return odsService.getAll();
    }
}
