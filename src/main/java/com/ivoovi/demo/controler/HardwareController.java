package com.ivoovi.demo.controler;

import com.ivoovi.demo.dto.HardwareDTO;
import com.ivoovi.demo.service.HardwareService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/hardware-shop")
public class HardwareController {

    private HardwareService hardwareService;

    @GetMapping
    public List<HardwareDTO> getAllHardware(){
        return hardwareService.getAllHardware().stream().toList();
    }

    @GetMapping("/{sifra}")
    public ResponseEntity<List<HardwareDTO >> filterBySifra(@PathVariable String sifra){
        return ResponseEntity.ok(hardwareService.getHardwareBySifra(sifra).stream().toList());
    }

    @PostMapping("/new")
    public ResponseEntity<?> saveNewHardware(@Valid @RequestBody HardwareDTO hardwareDTO){
        hardwareService.saveNewHardwareDTO(hardwareDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/article{id}")
    public ResponseEntity<HardwareDTO> updateHardware(@Valid @RequestBody HardwareDTO hardwareDTO ,@PathVariable Integer id){
       hardwareService.updateHardware(hardwareDTO,id);

       return ResponseEntity.ok(hardwareDTO);
    }
    @DeleteMapping("/article/{id}")
    public ResponseEntity<?> deleteHardware(Integer id){
        hardwareService.deleteHardware(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
