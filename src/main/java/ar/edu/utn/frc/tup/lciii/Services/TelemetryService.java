package ar.edu.utn.frc.tup.lciii.Services;

import ar.edu.utn.frc.tup.lciii.dtos.common.TelemetryDto;
import ar.edu.utn.frc.tup.lciii.model.Telemetry;

import java.util.List;

public interface TelemetryService {
    Telemetry PostTelemetry(TelemetryDto telemetry);
    List<Telemetry> GetAllTelemetries(String hostname);

}
