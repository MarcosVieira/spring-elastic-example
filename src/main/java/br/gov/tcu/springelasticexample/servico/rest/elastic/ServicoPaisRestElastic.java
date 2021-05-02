package br.gov.tcu.springelasticexample.servico.rest.elastic;

import br.gov.tcu.springelasticexample.servico.elastic.service.PaisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Slf4j
@Component("servicoPaisRestElastic")
@RestController
@RequestMapping("/elastic/pessoas/paises")
public class ServicoPaisRestElastic {

    @Autowired
    private PaisService paisService;

    @RequestMapping(value = "/create", method = GET)
    public ResponseEntity criarPais() {
        paisService.createPais();
        return new ResponseEntity(HttpStatus.OK);
    }

}
