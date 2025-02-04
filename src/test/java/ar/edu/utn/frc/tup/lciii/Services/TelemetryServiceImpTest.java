package ar.edu.utn.frc.tup.lciii.Services;

import ar.edu.utn.frc.tup.lciii.Repository.DeviceRepository;
import ar.edu.utn.frc.tup.lciii.Repository.TelemetryRepository;
import ar.edu.utn.frc.tup.lciii.dtos.common.TelemetryDto;
import ar.edu.utn.frc.tup.lciii.model.Device;
import ar.edu.utn.frc.tup.lciii.model.Telemetry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TelemetryServiceImpTest {
    @Mock
    private DeviceRepository deviceRepository;
    @Mock
    private TelemetryRepository telemetryRepository;
    @Mock
    private DeviceServiceImp deviceService;
    @InjectMocks
    private TelemetryServiceImp telemetryService;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Disabled
    @Test
    void postTelemetry() {
        //creando el telemetry
        Telemetry telemetry = new Telemetry();

        telemetry.setIp("asd");
        telemetry.setAudioCaptureAllowed(true);
        telemetry.setMicrophoneState("AA");
        telemetry.setHostname("blabla");
        telemetry.setId(1L);
        telemetry.setCpuUsage(30);
        telemetry.setHostDiskFree(20);
        telemetry.setScreenCaptureAllowed(true);
        telemetry.setDataDate(LocalDateTime.now());

        //creando device para el tlemetry
        Device device = new Device();
        device.setTelemetry(telemetry);
        device.setType("ccc");
        device.setOs("aa");
        device.setHostName("blabla");
        device.setCreateDate(LocalDateTime.now());
        device.setMacAdress("dd");
        telemetry.setDevice(device);

        //creando telDto
        TelemetryDto dto = new TelemetryDto();
        dto.setIp("asd");
        dto.setAudioCaptureAllowed(true);
        dto.setMicrophoneState("AA");
        dto.setHostname("blabla");
        dto.setCpuUsage(30);
        dto.setHostDiskFree(20);
        dto.setScreenCaptureAllowed(true);
        dto.setDataDate(LocalDateTime.now());


        List<String> hostNames = new ArrayList<>();
        hostNames.add("blabla");

        List<Device> devices = new ArrayList<>();
        devices.add(device);
        Mockito.when(deviceRepository.findAll()).thenReturn(devices);
        Mockito.when(deviceService.GetAllHostName()).thenReturn(hostNames);
        Mockito.when(telemetryRepository.save(telemetry)).thenReturn(telemetry);
        Telemetry response = telemetryService.PostTelemetry(dto);
        assertEquals(response.getHostname(), telemetry.getHostname());
    }

    @Test
    void getAllTelemetries() {
    }
}