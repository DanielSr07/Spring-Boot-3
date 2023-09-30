package med.voll.api.domain.consultas;

import med.voll.api.domain.medico.Especialidad;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.paciente.Paciente;
import med.voll.api.domain.paciente.PacienteRepository;
import med.voll.api.infra.errores.ValidacionDeIntegridad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AgendaDeConsultaService {

    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private PacienteRepository pacienteReporsitory;
    @Autowired
    private MedicoRepository medicoReporsitory;


    public void agendar(DatosAgendarConsulta datos){

        if(pacienteReporsitory.findById(datos.idPaciente()).isPresent()){
            throw new ValidacionDeIntegridad("Este ID de paciente no fue encontrado");
        }

        if(datos.idMedico() != null && medicoReporsitory.existsById(datos.idMedico())){
            throw new ValidacionDeIntegridad("Este ID de medico no fue encontrado");
        }

        var paciente = pacienteReporsitory.findById(datos.idPaciente()).get();
        var medico = seleccionarMedico(datos);

        var consulta = new Consulta(null, medico, paciente, datos.fecha());

        consultaRepository.save(consulta);

    }

    private Medico seleccionarMedico(DatosAgendarConsulta datos) {

        if(datos.idMedico()!=null){
            return medicoReporsitory.getReferenceById(datos.idMedico());
        }

        if(datos.especialidad()==null){
            throw new ValidacionDeIntegridad("Debe seleccionarse una especilidad para el medico");
        }


        return medicoReporsitory.seleccionarMedicoConEspecialidadEnFecha(datos.especialidad(), datos.fecha());
    }

}
