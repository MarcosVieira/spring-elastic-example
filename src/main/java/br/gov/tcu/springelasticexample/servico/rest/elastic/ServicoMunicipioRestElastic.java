package br.gov.tcu.springelasticexample.servico.rest.elastic;

import br.gov.tcu.springelasticexample.servico.elastic.service.MunicipioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Slf4j
@Component("servicoMunicipioRestElastic")
@RestController
@RequestMapping("/elastic/pessoas/municipios")
public class ServicoMunicipioRestElastic {

    @Autowired
    private MunicipioService municipioService;

    @RequestMapping(value = "/create", method = GET)
    public ResponseEntity criarMunicipio() {
        municipioService.createMunicipio();
        return new ResponseEntity(HttpStatus.OK);
    }

}
