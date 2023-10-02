package med.voll.api.domain.consultas;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DatosCancelamientoConsulta(
        @NotNull
        Long idConsulta,
        @NotNull
        Long idPaciente,
        Long idMedico,
        @NotNull @Future
        LocalDateTime fecha,
        MotivoCancelamiento motivo
) {

        public DatosCancelamientoConsulta(Consulta consulta){
                this(consulta.getId(), consulta.getPaciente().getId(), consulta.getMedico().getId(), consulta.getFecha(),consulta.getMotivoCancelamiento());
        }

}
