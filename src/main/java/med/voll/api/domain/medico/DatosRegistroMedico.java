package med.voll.api.domain.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import med.voll.api.domain.direccion.DatosDireccion;

public record DatosRegistroMedico(@NotBlank(message = "El Nombre es obligatorio") String nombre,
                                  @NotBlank(message = "El Email es obligatorio") @Email String email,
                                  @NotBlank (message = "El Telefono es obligatorio") @Size(min = 0, max = 15) String telefono,
                                  @NotBlank(message = "El Documento es obligatorio") @Pattern(regexp = "\\d{4,6}")
                                  String documento,
                                  @NotNull(message = "La Especialidad es obligatoria") Especialidad especialidad,
                                  @NotNull (message = "La Direccion es obligatoria") @Valid DatosDireccion direccion) {

}
