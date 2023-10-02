package med.voll.api.domain.consultas;

import java.time.LocalDateTime;

public record DatosDetalleConsulta(Long id, Long idPaceinte, Long idMedico, LocalDateTime fecha) {
    public DatosDetalleConsulta(Consulta consulta) {
        this(consulta.getId(),consulta.getPaciente().getId(),consulta.getMedico().getId(),consulta.getFecha());
    }
}
