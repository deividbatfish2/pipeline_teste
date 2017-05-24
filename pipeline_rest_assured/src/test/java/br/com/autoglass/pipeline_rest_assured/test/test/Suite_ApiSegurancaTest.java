package br.com.autoglass.pipeline_rest_assured.test.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import br.com.autoglass.pipeline_rest_assured.test.test.controleDeAcesso.APIAutenticacaoAutenticadoUsuario;
import br.com.autoglass.pipeline_rest_assured.test.test.controleDeAcesso.ApiClientePermissao;
import br.com.autoglass.pipeline_rest_assured.test.test.controleDeAcesso.ApiDispositivoMovel;

@RunWith(Suite.class)
@Suite.SuiteClasses({
  APIAutenticacaoAutenticadoUsuario.class,
  ApiClientePermissao.class,
  ApiDispositivoMovel.class
})

public class Suite_ApiSegurancaTest {

}
