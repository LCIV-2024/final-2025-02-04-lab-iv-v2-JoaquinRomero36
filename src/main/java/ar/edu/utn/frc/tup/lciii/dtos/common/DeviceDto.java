package ar.edu.utn.frc.tup.lciii.dtos.common;

import ar.edu.utn.frc.tup.lciii.model.Telemetry;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeviceDto {
    private String hostName;
    private LocalDateTime createDate;
    private String os;
    private String macAdress;
    private String type;

}
