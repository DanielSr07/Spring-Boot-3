package med.voll.api.domain.consultas;

import java.time.LocalDateTime;

public record DatosListadoConsulta(Long id, Long medico, Long paciente, LocalDateTime fecha, Boolean activo, String motivoCancelamiento) {

    public DatosListadoConsulta(Consulta consulta){
        this(consulta.getId(), consulta.getMedico().getId(), consulta.getPaciente().getId(), consulta.getFecha(), consulta.getActivo(), String.valueOf(consulta.getMotivoCancelamiento()));
    }

}
