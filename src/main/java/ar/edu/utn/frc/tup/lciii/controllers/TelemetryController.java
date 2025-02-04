package ar.edu.utn.frc.tup.lciii.controllers;
import ar.edu.utn.frc.tup.lciii.Services.DeviceServiceImp;
import ar.edu.utn.frc.tup.lciii.Services.TelemetryService;
import ar.edu.utn.frc.tup.lciii.dtos.common.TelemetryDto;
import ar.edu.utn.frc.tup.lciii.model.Telemetry;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TelemetryController {

    @Autowired
    private TelemetryService telemetryService;


    @PostMapping("http://localhost:8080/api/telemetry")
    public ResponseEntity<Telemetry> addTelemetry(@RequestBody TelemetryDto telemetry) {
        Telemetry tel = telemetryService.PostTelemetry(telemetry);
        if(tel == null) {
            ResponseEntity.badRequest();
        }
        return ResponseEntity.status(201).body(tel);
    }
    @GetMapping("http://localhost:8080/api/telemetry{hostname}")
    public ResponseEntity<List<Telemetry>> getTelemetry(@PathVariable String hostname) {
        List<Telemetry> telemetries = telemetryService.GetAllTelemetries(hostname);
        if(telemetries == null) {
            ResponseEntity.badRequest();
        }
        return ResponseEntity.ok(telemetries);
    }
}