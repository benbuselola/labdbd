package dbd.LAB.crud.services;

import dbd.LAB.crud.models.MedioPago;
import dbd.LAB.crud.repositories.MedioPagoRepository;

import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class MedioPagoService {

    private final MedioPagoRepository medioPagoRepository;

    MedioPagoService(@Lazy MedioPagoRepository medioPagoRepository) {
        this.medioPagoRepository = medioPagoRepository;
    }

    // Crear
    @PostMapping("/MedioPago")
    @ResponseBody
    public MedioPago crear(@RequestBody MedioPago medioPago) {
        MedioPago resultado = medioPagoRepository.crear(medioPago);
        return resultado;
    }

    // Leer todos
    @GetMapping("/MedioPago")
    public List<MedioPago> getAllMedioPagos() {
        return medioPagoRepository.getAll();
    }

    // Leer por ID
    @GetMapping("/MedioPago/{id_medio_pago}")
    public MedioPago getMedioPago(@PathVariable int id_medio_pago) {
        return medioPagoRepository.getMedioPago(id_medio_pago);
    }

    // Actualizar por ID
    @PutMapping("/MedioPago/{id_medio_pago}")
    @ResponseBody
    public MedioPago actualizar(@PathVariable int id_medio_pago, @RequestBody MedioPago medioPago) {
        medioPago.setId_medio_pago(id_medio_pago);
        return medioPagoRepository.actualizar(medioPago);
    }

    // Borrar por ID
    @DeleteMapping("/MedioPago/{id_medio_pago}")
    public void borrar(@PathVariable int id_medio_pago) {
        medioPagoRepository.borrar(id_medio_pago);
    }
}
