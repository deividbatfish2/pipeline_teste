# language: pt
# encoding: utf-8
Funcionalidade: Realizar a consulta por vagas de trabalho na Autoglass

  Contexto: Acessar o site da Autoglass
    Dado acessei o site da Autoglass

  Cenário: Realizar consulta por vagas.
    Dado que eu clique em Trabalhe na Autoglass
    E clique em oportunidades gerais
    E clique em vagas disponíveis
    Então o sistema deve me retonar links com as vagas disponíveis para o candidato
