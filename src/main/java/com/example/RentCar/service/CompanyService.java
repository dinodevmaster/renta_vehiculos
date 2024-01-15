package com.example.RentCar.service;

import com.example.RentCar.model.Company;
import com.example.RentCar.repository.CarRepository;
import com.example.RentCar.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;

    @Autowired
    private CarRepository carRepository;

    public List<Company> getAllCompanies(){
        return companyRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Empresa> ObtenerEmpresa(@PathVariable Long id) {

        Empresa empresa = repositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExceptions("No existe una empresa con el id: " + id));

        return ResponseEntity.ok(empresa);
    }

    // Este método se encarga de obtener los vehiculos de una empresa
    @GetMapping("/obtenerVehiculos/{id}")
    public List<Vehiculo> obtenerVehiculos(@PathVariable Long id) {

        repositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExceptions("No existe una empresa con el id: " + id));

        return repositoriov.findAllByidempresa(id);
    }


    // Este metodo se encarga de registrar una nueva empresa
    @PostMapping("/registrarEmpresa")
    public Empresa CrearEmpresa(@RequestBody Empresa nuevaEmpresa) {
        nuevaEmpresa.setHabilitado(true);
        return repositorio.save(nuevaEmpresa);
    }

    // Este metodo se encarga de actualizar el estado de una empresa
    @PutMapping("/actualizarEmpresa/{id}")
    public ResponseEntity<Empresa> ActualizarEmpresa(@PathVariable Long id, @RequestBody Empresa nuevaEmpresa) {

        Empresa empresa = repositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExceptions("No existe un cliente con el id: " + id));

        empresa.setNombre(nuevaEmpresa.getNombre());
        empresa.setApellido(nuevaEmpresa.getApellido());
        empresa.setRazonsocial(nuevaEmpresa.getRazonsocial());
        empresa.setCuit(nuevaEmpresa.getCuit());
        empresa.setCelular(nuevaEmpresa.getCelular());
        empresa.setHabilitado(nuevaEmpresa.isHabilitado());
        empresa.setCorreo(nuevaEmpresa.getCorreo());
        empresa.setPassword(nuevaEmpresa.getPassword());

        Empresa empresaActualizada = repositorio.save(empresa);

        return ResponseEntity.ok(empresaActualizada);
    }

    //Este metodo se encarga de deshabilitar una empresa
    @PostMapping("/eliminarEmpresa/{id}")
    public ResponseEntity<String> EliminarEmpresa(@PathVariable Long id) {

        Empresa empresa = repositorio.findById(id)
                .orElseThrow(() -> new ResourceNotFoundExceptions("No existe una empresa con el id: " + id));

        empresa.setHabilitado(false);

        repositorio.save(empresa);

        return ResponseEntity.ok("Empresa eliminada");
    }

    // Este metodo se encarga de validar e ingresar en la cuenta de una empresa
    @GetMapping("/loginEmpresa")
    public ResponseEntity<Empresa> LoginEmpresa(String correo, String pass){

        Empresa empresa = repositorio.findByCorreo(correo).orElseThrow(() -> new ResourceNotFoundExceptions("No existe un cliente con el correo ingresado "+ correo));

        if(empresa.getPassword().equals(pass)){
            return ResponseEntity.ok(empresa);
        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
