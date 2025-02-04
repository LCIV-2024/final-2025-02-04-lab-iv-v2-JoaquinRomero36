package ar.edu.utn.frc.tup.lciii.Services;

import ar.edu.utn.frc.tup.lciii.dtos.common.DeviceDto;
import ar.edu.utn.frc.tup.lciii.model.Device;

import java.util.List;

public interface DeviceService {
    Device PostDevice(DeviceDto device);
    List<DeviceDto> GetAllDeviceByTipe(String tipe);
    List<Device> GetAllDevices();
    List<DeviceDto> GetAllDeviceByCpuConsume(Double cpuConsume1, Double cpuConsume2);
    List<String> GetAllHostName();
}
