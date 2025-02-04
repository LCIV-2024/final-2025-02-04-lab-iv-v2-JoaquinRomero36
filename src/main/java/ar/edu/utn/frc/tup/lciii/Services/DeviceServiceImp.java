package ar.edu.utn.frc.tup.lciii.Services;


import ar.edu.utn.frc.tup.lciii.Repository.DeviceRepository;
import ar.edu.utn.frc.tup.lciii.dtos.common.DeviceDto;
import ar.edu.utn.frc.tup.lciii.model.Device;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeviceServiceImp implements DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    @Override
    public Device PostDevice(DeviceDto device) {
        if(device == null){
            return null;
        }
        List<Device> devices = deviceRepository.findAll();
        for(Device d : devices){
            if(d.getHostName().equals(device.getHostName())){
                return null;
            }
        }
        Device newDevice = new Device();
        newDevice.setHostName(device.getHostName());
        newDevice.setOs(device.getOs());
        newDevice.setType(device.getType());
        newDevice.setCreateDate(device.getCreateDate());
        newDevice.setMacAdress(device.getMacAdress());
        return deviceRepository.save(newDevice);
    }

    @Override
    public List<DeviceDto> GetAllDeviceByTipe(String tipe) {
        List<Device> devices = GetAllDevices();
        if(devices == null){
            return null;
        }
        List<DeviceDto> deviceFiltred = new ArrayList<DeviceDto>();
        for(Device d : devices){
            if(d.getHostName().equals(tipe)){
                DeviceDto dev = new DeviceDto();
                dev.setHostName(d.getHostName());
                dev.setOs(d.getOs());
                dev.setType(d.getType());
                dev.setCreateDate(d.getCreateDate());
                dev.setMacAdress(d.getMacAdress());
                dev.setTelemetry(d.getTelemetry());
                deviceFiltred.add(dev);
            }
        }
        return deviceFiltred;
    }

    @Override
    public List<Device> GetAllDevices() {
        List<Device> devices = deviceRepository.findAll();
        if(devices.isEmpty()){
            return null;
        }
        return devices;
    }

    @Override
    public List<DeviceDto> GetAllDeviceByCpuConsume(Double cpuConsume1, Double cpuConsume2) {
        List<Device> devices = GetAllDevices();
        if(devices == null){
            return null;
        }
        List<DeviceDto> deviceFiltred = new ArrayList<DeviceDto>();
        for(Device d : devices){
            if(d.getTelemetry().getCpuUsage() <= cpuConsume1 &&
                    d.getTelemetry().getCpuUsage() >= cpuConsume2){
                DeviceDto dev = new DeviceDto();
                dev.setHostName(d.getHostName());
                dev.setOs(d.getOs());
                dev.setType(d.getType());
                dev.setCreateDate(d.getCreateDate());
                dev.setMacAdress(d.getMacAdress());
                dev.setTelemetry(d.getTelemetry());
                deviceFiltred.add(dev);
            }
        }
        return deviceFiltred;
    }

    @Override
    public List<String> GetAllHostName() {
        return List.of();
    }
}
