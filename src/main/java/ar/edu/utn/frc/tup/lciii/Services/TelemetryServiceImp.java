package ar.edu.utn.frc.tup.lciii.Services;

import ar.edu.utn.frc.tup.lciii.Repository.TelemetryRepository;
import ar.edu.utn.frc.tup.lciii.dtos.common.DeviceDto;
import ar.edu.utn.frc.tup.lciii.dtos.common.TelemetryDto;
import ar.edu.utn.frc.tup.lciii.model.Telemetry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TelemetryServiceImp implements TelemetryService {
    @Autowired
    private TelemetryRepository telemetryRepository;
    @Autowired
    private DeviceServiceImp deviceServiceImp;



    @Override
    public Telemetry PostTelemetry(TelemetryDto telemetry) {
        if(telemetry == null){
            return null;
        }
        List<String> hostName = deviceServiceImp.GetAllHostName();
        if(hostName.isEmpty()){
            return null;
        }
        for(String host : hostName){
            if(host.equals(telemetry.getHostname()));{
                Telemetry tel = new Telemetry();
                tel.setHostname(telemetry.getHostname());
                tel.setIp(telemetry.getIp());
                tel.setCpuUsage(telemetry.getCpuUsage());
                tel.setDataDate(telemetry.getDataDate());
                tel.setHostDiskFree(telemetry.getHostDiskFree());
                tel.setMicrophoneState(telemetry.getMicrophoneState());
                tel.setScreenCaptureAllowed(telemetry.isScreenCaptureAllowed());
                tel.setAudioCaptureAllowed(telemetry.isAudioCaptureAllowed());
                return telemetryRepository.save(tel);
            }
        }
        return null;
    }

    @Override
    public List<Telemetry> GetAllTelemetries(String hostname) {
        List<Telemetry> telemetries = telemetryRepository.findAll();
        if(telemetries.isEmpty()){
            return null;
        }
        List<Telemetry> telemetryFilter = new ArrayList<Telemetry>();
        for(Telemetry telemetry : telemetries){
            if(telemetry.getDevice().getHostName().equals(hostname)){
                telemetryFilter.add(telemetry);
            }
        }
        return telemetryFilter;
    }
}
