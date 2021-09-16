package gr.publicsoft.springbootcrud.APIControllers;

import gr.publicsoft.springbootcrud.model.Supplier;
import gr.publicsoft.springbootcrud.repository.SupplierRepository;
import gr.publicsoft.springbootcrud.services.vatValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.ParseException;

@RestController

public class APIController {

    @Autowired
    private SupplierRepository supplierRepository;



    @GetMapping(value = "/getSuppliers{vatNum}")
    public ResponseEntity<Supplier> getRequestedSupplier (HttpServletRequest httpServletRequest, @PathVariable String vatNum, @RequestParam(required = false, defaultValue = "") String companyName) throws IOException {
           Supplier supplier=supplierRepository.findByVatNumberOrCompanyName(vatNum,companyName);
           if(supplier==null){
               return new ResponseEntity(HttpStatus.NOT_FOUND);
           }
           return ResponseEntity.ok(supplier);
    }

//    @PostMapping(value="/saveSuppliers")
//    public ResponseEntity<?> giveRequestedSupplier (HttpServletRequest httpServletRequest,  @RequestBody Supplier supplier) throws ParseException ){
//
//        supplierRepository.save(supplier);
//        return ResponseEntity.ok("Supplier saved.");
//    }

    @PostMapping(value="/saveSupplier")
    public String saveSupplier(@RequestBody Supplier supplier){
        supplierRepository.save(supplier);
        return "Supplier saved";
    }

    @PutMapping(value="/updateSupplier{id}")
    public String updateSupplier(@PathVariable long id, @RequestBody Supplier supplier) {
        Supplier updateSupplier = supplierRepository.findById(id).get();
        updateSupplier.setAddress(supplier.getAddress());
        updateSupplier.setCity(supplier.getCity());
        updateSupplier.setCompanyName(supplier.getCompanyName());
        updateSupplier.setCountry(supplier.getCountry());
        updateSupplier.setFirstName(supplier.getFirstName());
        updateSupplier.setIrsOffice(supplier.getIrsOffice());
        updateSupplier.setLastName(supplier.getLastName());
        updateSupplier.setVatNumber(supplier.getVatNumber());
        updateSupplier.setZipCode(supplier.getZipCode());
        supplierRepository.save(updateSupplier);
        return "Updated";
    }

        @DeleteMapping(value="/delete/{id}")
        public String deleteSupplier(@PathVariable long id){
            Supplier deletedSupplier = supplierRepository.findById(id).get();
            supplierRepository.delete(deletedSupplier);
            return "Supplier deleted";
        }






    }








