package dbd.LAB.crud.services;

import dbd.LAB.crud.models.Carrito;
import dbd.LAB.crud.repositories.CarritoRepository;

import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class CarritoService {

    private final CarritoRepository carritoRepository;

    CarritoService(@Lazy CarritoRepository carritoRepository) {
        this.carritoRepository = carritoRepository;
    }

    // Crear
    @PostMapping("/Carrito")
    @ResponseBody
    public Carrito crear(@RequestBody Carrito carrito) {
        Carrito resultado = carritoRepository.crear(carrito);
        return resultado;
    }

    // Leer todos
    @GetMapping("/Carrito")
    public List<Carrito> getAllCarritos() {
        return carritoRepository.getAll();
    }

    // Leer por ID
    @GetMapping("/Carrito/{id_carrito}")
    public Carrito getCarrito(@PathVariable int id_carrito) {
        return carritoRepository.getCarrito(id_carrito);
    }

    // Actualizar por ID
    @PutMapping("/Carrito/{id_carrito}")
    @ResponseBody
    public Carrito actualizar(@PathVariable int id_carrito, @RequestBody Carrito carrito) {
        carrito.setId_carrito(id_carrito);
        return carritoRepository.actualizar(carrito);
    }

    // Borrar por ID
    @DeleteMapping("/Carrito/{id_carrito}")
    public void borrar(@PathVariable int id_carrito) {
        carritoRepository.borrar(id_carrito);
    }
}
