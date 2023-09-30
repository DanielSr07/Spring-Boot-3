package med.voll.api.domain.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.domain.direccion.DatosDireccion;

public record DatosRegistroMedico(@NotBlank(message = "El Nombre es obligatorio") String nombre,
                                  @NotBlank(message = "El Email es obligatorio") @Email String email,
                                  @NotBlank(message = "El Telefono es obligatorio") String telefono,
                                  @NotBlank(message = "El Documento es obligatorio") @Pattern(regexp = "\\d{4,6}")
                                  String documento,
                                  @NotNull(message = "La Especialidad es obligatoria") Especialidad especialidad,
                                  @NotNull(message = "La Direccion es obligatoria") @Valid DatosDireccion direccion) {

}
