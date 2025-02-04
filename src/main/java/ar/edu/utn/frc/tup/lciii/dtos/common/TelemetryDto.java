package ar.edu.utn.frc.tup.lciii.dtos.common;

import ar.edu.utn.frc.tup.lciii.model.Device;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TelemetryDto {
    private String ip;
    private String hostname;
    private double cpuUsage;
    private double hostDiskFree;
    private String microphoneState;
    private boolean screenCaptureAllowed;
    private boolean audioCaptureAllowed;
    private LocalDateTime dataDate;
    private Device device;
}
