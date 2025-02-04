package ar.edu.utn.frc.tup.lciii.controllers;

import ar.edu.utn.frc.tup.lciii.Repository.DeviceRepository;
import ar.edu.utn.frc.tup.lciii.Services.DeviceService;
import ar.edu.utn.frc.tup.lciii.dtos.common.DeviceDto;
import ar.edu.utn.frc.tup.lciii.model.Device;
import ar.edu.utn.frc.tup.lciii.model.Telemetry;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DeviceController {
    @Autowired
    private DeviceService deviceService;

    @PostMapping("device")
    public ResponseEntity<Device> createDevice(@RequestBody DeviceDto device) {
        Device dev = deviceService.PostDevice(device);
        if(dev == null) {
            ResponseEntity.badRequest().body("asdad");
        }
        return ResponseEntity.status(201).body(dev);
    }
    @GetMapping("device{type}")
    public ResponseEntity<List<DeviceDto>> getDevice(@PathVariable String type) {
        List<DeviceDto> list = deviceService.GetAllDeviceByTipe(type);
        if(list == null) {
            ResponseEntity.badRequest();
        }
        return ResponseEntity.status(200).body(list);
    }
    @GetMapping("device{lowThreshold}&{upThreshold}")
    public ResponseEntity<List<DeviceDto>> getDeviceByLowThreshold(
            @PathVariable double lowThreshold, @PathVariable double upThreshold) {
        if(lowThreshold > upThreshold) {
             ResponseEntity.badRequest().body("el valor upThreshold no puede ser menor a lowThreshold");
        }
        List<DeviceDto> list = deviceService.GetAllDeviceByCpuConsume(lowThreshold,upThreshold);
        if(list == null) {
            ResponseEntity.badRequest();
        }
        return ResponseEntity.status(200).body(list);
    }
}