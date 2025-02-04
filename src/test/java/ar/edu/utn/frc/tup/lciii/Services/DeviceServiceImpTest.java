package ar.edu.utn.frc.tup.lciii.Services;

import ar.edu.utn.frc.tup.lciii.Repository.DeviceRepository;
import ar.edu.utn.frc.tup.lciii.dtos.common.DeviceDto;
import ar.edu.utn.frc.tup.lciii.model.Device;
import com.sun.source.tree.ModuleTree;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DeviceServiceImpTest {
    @Mock
    private DeviceRepository deviceRepository;
    @InjectMocks
    private DeviceServiceImp deviceService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void postDevice() {
    }
    @Test
    void getAllDeviceByTipe() {

        List<Device> devices = new ArrayList<>();
        Device device = new Device();
        device.setHostName("asd");
        device.setOs("asd");
        device.setType("A");
        device.setMacAdress("adad");
        device.setCreateDate(LocalDateTime.now());
        devices.add(device);
        Mockito.when(deviceRepository.findAll()).thenReturn(devices);

        DeviceDto dto = new DeviceDto();
        dto.setHostName("asd");
        dto.setOs("asd");
        dto.setType("A");
        dto.setMacAdress("adad");
        dto.setCreateDate(LocalDateTime.now());

        List<DeviceDto> dtos = new ArrayList<>();
        dtos.add(dto);
        List<DeviceDto> restponse = deviceService.GetAllDeviceByTipe("A");
        assertNotNull(restponse);
    }

    @Test
    void getAllDevices() {
        List<Device> devices = new ArrayList<>();
        Device device = new Device();
        device.setHostName("asd");
        devices.add(device);
        Mockito.when(deviceRepository.findAll()).thenReturn(devices);
        List<Device> dev = deviceService.GetAllDevices();
        assertNotNull(dev);
        assertEquals(dev.size(), devices.size());
    }

    @Test
    void getAllDeviceByCpuConsume() {
    }

    @Test
    void getAllHostName() {
        List<String> asd = new ArrayList<>();
        asd.add("asd");

        Device device = new Device();
        device.setHostName("asd");
        List<Device> devices = new ArrayList<>();
        devices.add(device);

        Mockito.when(deviceRepository.findAll()).thenReturn(devices);
        List<String> response = deviceService.GetAllHostName();
        assertEquals(asd, response);
    }
}