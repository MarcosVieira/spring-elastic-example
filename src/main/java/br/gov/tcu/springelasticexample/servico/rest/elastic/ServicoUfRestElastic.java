package br.gov.tcu.springelasticexample.servico.rest.elastic;

import br.gov.tcu.springelasticexample.servico.elastic.service.UfService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Slf4j
@Component("servicoUfRestElastic")
@RestController
@RequestMapping("/elastic/pessoas/ufs")
public class ServicoUfRestElastic {

    @Autowired
    private UfService ufService;

    @RequestMapping(value = "/create", method = GET)
    public ResponseEntity criarPais() {
        ufService.createUf();
        return new ResponseEntity(HttpStatus.OK);
    }

}
