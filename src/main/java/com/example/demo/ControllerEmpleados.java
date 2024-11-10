
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
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody Object input) {
       
        return null;
    }
    
    @PostMapping
    public ResponseEntity<Empleado> post(@RequestBody Empleado empleado) {
         Empleado empRes= repositoryEmpleados.save(empleado);
        return new ResponseEntity<Empleado>(empRes, HttpStatus.CREATED);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        return null;
    }
    
}
