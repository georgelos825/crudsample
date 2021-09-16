package gr.publicsoft.springbootcrud.APIControllers;

import gr.publicsoft.springbootcrud.model.*;
import gr.publicsoft.springbootcrud.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import gr.publicsoft.springbootcrud.repository.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@RestController

public class APIController {

    @Autowired
    private SupplierRepository supplierRepository;

    @GetMapping(value = "/getSuppliers")
    public ResponseEntity<Supplier> getRequestedSupplier (HttpServletRequest httpServletRequest, @PathVariable String id, @RequestParam(required = false, defaultValue = "false") boolean internal) throws IOException {
        return supplierRepository.findByVatNumberOrCompanyName;
    }




}

