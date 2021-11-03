package main.Controller;

import main.DTO.OdsDTO;
import main.Service.OdsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class OdsController {

    @Autowired
    OdsService odsService;

    @GetMapping("/ods")
    public List<OdsDTO> getAllOds() {
        return odsService.getAll();
    }

    @PostMapping("/resetAllOds")
    public List<OdsDTO> resetAllOds() {
        odsService.resetAllOds();
        return new ArrayList<>();
    }
}
