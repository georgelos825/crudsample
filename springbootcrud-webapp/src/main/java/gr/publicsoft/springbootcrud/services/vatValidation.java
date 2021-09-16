package gr.publicsoft.springbootcrud.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

public class vatValidation {
    public boolean validateVat(String vat){
        int specialnum=0;
        String[] vatarray= null;
        int specialsum=0;
        int a=0;//number used to store the specialsum mod 11
        int b=0;//number used to store a mod 10
        if(vat.length()!=9||!vat.matches("[0-9]+")){
            return false;
        }else{
            vatarray= vat.split("");
            specialnum=Integer.parseInt(vatarray[8]);
            specialsum=Integer.parseInt(vatarray[7])*((int)Math.pow(2,1))+Integer.parseInt(vatarray[6])
                    *((int)Math.pow(2,2))+Integer.parseInt(vatarray[5])*((int)Math.pow(2,3))+Integer.parseInt(vatarray[4])
                    *((int)Math.pow(2,4))+Integer.parseInt(vatarray[3])*((int)Math.pow(2,5))+Integer.parseInt(vatarray[2])
                    *((int)Math.pow(2,6))+Integer.parseInt(vatarray[1])*((int)Math.pow(2,7))+Integer.parseInt(vatarray[0])
                    *((int)Math.pow(2,8));
            a=specialsum%11;
            b=a%10;
            return b == specialnum;
        }

    }
}
