
package com.example.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author tony
 */
@RestController
@RequestMapping("/api/empleados")
public class ControllerEmpleados {
    
   @Autowired
    private RepositoryEmpleados repositoryEmpleados;
    
    @GetMapping()
    public List<Empleado> list() {
        return (List<Empleado>) repositoryEmpleados.findAll();
    }
    @GetMapping("/{id}")
    public Object get(@PathVariable String id) {
    Optional<Empleado> res = repositoryEmpleados.findById(Long.valueOf(id));

        return null;
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody Empleado input) {
       Optional<Empleado> res = repositoryEmpleados.findById(Long.valueOf(id));
       if (res.isPresent()) {
        Empleado empleado = res.get();
        
        if (input.getNombre() != null) empleado.setNombre(input.getNombre());
        if (input.getDireccion() != null) empleado.setDireccion(input.getDireccion());
        if (input.getTelefono() != null) empleado.setTelefono(input.getTelefono());
        if (input.getDepto() != null) empleado.setDepto(input.getDepto());
        
        repositoryEmpleados.save(empleado);
        return new ResponseEntity<>(empleado, HttpStatus.OK);
    } else {
        return new ResponseEntity<>("Empleado no encontrado", HttpStatus.NOT_FOUND);
    }
    }
    
    @PostMapping
    public ResponseEntity<Empleado> post(@RequestBody Empleado empleado) {
         Empleado empRes= repositoryEmpleados.save(empleado);
        return new ResponseEntity<Empleado>(empRes, HttpStatus.CREATED);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        Optional<Empleado> res = repositoryEmpleados.findById(Long.valueOf(id));
         repositoryEmpleados.deleteById(Long.valueOf(id));
                     return new ResponseEntity<>("Empleado eliminado", HttpStatus.NO_CONTENT);

         
    }
    
    
}
