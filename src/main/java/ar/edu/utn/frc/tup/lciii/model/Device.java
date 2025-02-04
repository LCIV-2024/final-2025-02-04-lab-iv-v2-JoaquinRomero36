package ar.edu.utn.frc.tup.lciii.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Entity
@Table(name = "DEVICE")
@Getter
@Setter
public class Device {

    @Id
    @Column(name = "HOSTNAME", unique = true)
    private String hostName;

    @OneToOne(mappedBy = "device")
    private Telemetry telemetry;

    private LocalDateTime createDate;

    private String os;

    private String macAdress;

    @Column(name = "TYPE")
   // @Enumerated(EnumType.STRING)
    private String type;

}
