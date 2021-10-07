# Sistemas-Distribuidos-java-API
<div style="text-align: justify">API é um conjunto de rotinas e padrões de programação para acesso a um aplicativo de software ou plataforma baseado na Web. A sigla API refere-se ao termo em inglês "Application Programming Interface" que significa em tradução para o português "Interface de Programação de Aplicativos"...</div>

[O que é API? - Canaltech](https://www.google.com/search?q=Api&oq=Api&aqs=chrome..69i57j69i60l3j69i65j5.2482j0j1&sourceid=chrome&ie=UTF-8#:~:text=O%20que%20%C3%A9%20API%3F%20-%20Canaltech)

## Tecnologias utiizadas para o projeto

* javafx 11
* [Spring Boot](https://spring.io/projects/spring-boot)
* [API de previsão do tempo e dados climáticos HG Weather](https://hgbrasil.com/)
* [MySQL Workbench](https://www.mysql.com/products/workbench/)
* [MYZAP](https://github.com/billbarsch/myzap)
## Descrição do projeto

<div style="text-align: justify"> O presente projeto foi desenvolvido como prática e atribuição da terceira nota da disciplica Sistemas distribuidos tendo como foco desenvolver uma API com objetivo de disponibilizar  todo processo de CRUD a presente API tem o objetivo de disponibilizar aos usuario a previsão do tempo sendo a mesma pesquisada por cidade e estado .</div>

## para todas as operações é preciso a url_base:
* http://localhost:8080/api_weatherForecast

## Instruções para Uso como exemplo localhost

## Buscar previsão do tempo, para essa ação não é preciso nenhuma autenticação
* como exemplo logo abaixo depois de cada significado dos valores  do json de resposta será pesquisado a previsão de Caxias Maranhão,
"<strong> url_base/Caxias/Maranhão </strong>"


## significado de cada código


* temp - temperatura atual em ºC
* date - data da consulta
* time - hora da consulta
* condition_code - código da condição de tempo atual 
* description - descrição da condição de tempo atual no idioma escolhido
* currently - retorna se está de dia ou de noite no idioma escolhido
* cid - antigo identificador da cidade, pode não estar presente em alguns casos
* city - nome da cidade seguido por uma vírgula (mantido para as libs antigas)
* humidity - umidade atual em percentual
* wind_speedy - velocidade do vento em km/h
* sunrise - nascer do sol em horário local da cidade
* sunset - pôr do sol em horário local da cidade
* condition_slug - slug da condição de tempo atual veja a lista
* city_name - nome da cidade
* forecast - array com a previsão do tempo para outros dias
* date - data da previsão dd/mm
* weekday - dia da semana abreviado
* max - temperatura máxima em ºC
* min - temperatura mínima em ºC
* description - descrição da previsão
* condition - slug da condição 

![busca_weather](https://user-images.githubusercontent.com/51086466/135611135-3f22cfc1-d344-4db9-9845-1e3168135db6.png)



<div >
  {<br> 
    "results": {<br> 
        "temp": 26,<br> 
        "date": "01/10/2021",<br> 
        "time": "07:52",<br> 
        "condition_code": "28",<br> 
        "description": "Tempo nublado",<br> 
        "currently": "dia",<br> 
        "cid": "",<br> 
        "city": "Caxias, MA",<br> 
        "img_id": "28",<br> 
        "humidity": 77,<br> 
        "wind_speedy": "2.51 km/h",<br> 
        "sunrise": "05:38 am",<br> 
        "sunset": "05:47 pm",<br> 
        "condition_slug": "cloudly_day",<br> 
        "city_name": "Caxias",<br> 
        <br> 
        "forecast": [<br> 
            {
                "date": "01/10",<br> 
                "weekday": "Sex",<br> 
                "max": 35,<br> 
                "min": 22,<br> 
                "description": "Chuvas esparsas",<br> 
                "condition": "rain"<br> 
            },<br> 
            {<br> 
                "date": "02/10",<br> 
                "weekday": "Sáb",<br> 
                "max": 37,<br> 
                "min": 22,<br> 
                "description": "Parcialmente nublado",<br> 
                "condition": "cloudly_day"<br> 
            },<br> 
            {<br> 
                "date": "03/10",<br> 
                "weekday": "Dom",<br> 
                "max": 38,<br> 
                "min": 22,<br> 
                "description": "Tempo limpo",<br> 
                "condition": "clear_day"<br> 
            },<br> 
            {<br> 
                "date": "04/10",<br> 
                "weekday": "Seg",<br> 
                "max": 39,<br> 
                "min": 22,<br> 
                "description": "Parcialmente nublado",<br> 
                "condition": "cloud"<br> 
            },<br> 
            {<br> 
                "date": "05/10",<br> 
                "weekday": "Ter",<br> 
                "max": 40,<br> 
                "min": 23,<br> 
                "description": "Chuvas esparsas",<br> 
                "condition": "rain"<br> 
            },<br> 
            {<br> 
                "date": "06/10",<br> 
                "weekday": "Qua",<br> 
                "max": 40,<br> 
                "min": 24,<br> 
                "description": "Chuvas esparsas",<br> 
                "condition": "rain"<br> 
            },<br> 
            {<br> 
                "date": "07/10",<br> 
                "weekday": "Qui",<br> 
                "max": 39,<br> 
                "min": 23,<br> 
                "description": "Tempo nublado",<br> 
                "condition": "cloudly_day"<br> 
            },<br> 
            {<br> 
                "date": "08/10",<br> 
                "weekday": "Sex",<br> 
                "max": 40,<br> 
                "min": 22,<br> 
                "description": "Parcialmente nublado",<br> 
                "condition": "cloud"<br> 
            },<br> 
            {<br> 
                "date": "09/10",<br> 
                "weekday": "Sáb",<br> 
                "max": 38,<br> 
                "min": 23,<br> 
                "description": "Chuvas esparsas",<br> 
                "condition": "rain"<br> 
            },<br> 
            {<br> 
                "date": "10/10",<br> 
                "weekday": "Dom",<br> 
                "max": 35,<br> 
                "min": 23,<br> 
                "description": "Tempo nublado",<br> 
                "condition": "cloudly_day"<br> 
            }<br> 
        ]<br> 
    }<br> 
}<br> 
</div>

## Operações de cadastrar, lista, atualização e exclusão de usuário
* essa face consiste em registrar um usuario assim como as demais operações para com o mesmo afim de usar a fase de envio de previsão via whatssap
* Essa face será um adicional futuramente ao projeto, sendo o objetivo já foi alcançado com a versão presente
## Adicionar usuário 


* Como requisito url_base+("/add/") e no corpo da mensagem um json com os seguintes dados

![adduser](https://user-images.githubusercontent.com/51086466/135616072-4f8a4c52-95ea-45b2-90f9-cd8faf44c3fd.png)

  
 * numberFone é o  número do telefone no inicio (55)+(ddd)+número(xxxxxxxxx)
 * email é o seu email
 * nameUse é o seu nome de usuario
 * passWord é a sua senha
 
 ## Buscar Usuário
 * como requisto url_base+número de telefone e senha <strong>url_base/55dddxxxxxxxxx/passWord</strong> como retorno o usuário
 ![buscarUser](https://user-images.githubusercontent.com/51086466/135617706-861b93e3-c5b4-4250-80bb-fe2e03d8a3f5.png)

  ##  Atualizar Usuário
  * como requisto url_base+("/update/")+número de telefone e senha <strong>url_base/update/55dddxxxxxxxxx/passWord</strong> adicionando o novo usuário no corpo da requisição como retorno o usuario novo
 * Usuário Atual
  ![usuarioAtual](https://user-images.githubusercontent.com/51086466/135620562-d67390a4-227c-42ad-ac7b-ea9872ab804b.png)

* Atualizado
![atualizado](https://user-images.githubusercontent.com/51086466/135620978-3cbfa387-4383-4e6a-9db7-6a434fbb8cae.png)
  
  ## Excluir Usuário
  * como requisto adicionar url_base+("/delete/")+número de telefone e senha <strong>url_base/delete/55dddxxxxxxxxx/passWord</strong> retorna o usuário excluido para confirmar

 ![delete](https://user-images.githubusercontent.com/51086466/135621696-ef602c5c-53c9-4cb1-985e-4dd1249f3365.png)
## Descrições de Erros
* Error ao tentar cadastrar usuário pode ocorrer po usuário existente ou erro na estrutura json consideração um ou todos os campos do usuário 

![erroadd](https://user-images.githubusercontent.com/51086466/135626268-f657df9c-4159-42ce-9c10-2737721dca5b.png)

* Error ao tentar Excluir um usuário pode ocorrer por usuário não existente ou (número de telefone/senha) errados
![errodelete](https://user-images.githubusercontent.com/51086466/135626829-5052105b-204c-4999-a0b2-d8629018d20d.png)

* Error ao tentar Atualizar usuário pode ocorrer por usuário não existente ou (número de telefone/senha) errados assim como a estrutura json
![erroupdate](https://user-images.githubusercontent.com/51086466/135627348-4a5a7dc4-1c84-492c-beae-146b79dde535.png)

* Error ao buscar usuário pode ocorrer por usuário não existente ou (número de telefone/senha) errados
![buscaerror](https://user-images.githubusercontent.com/51086466/135627904-b08bc426-c7cc-4132-8fb2-9217078e7a1a.png)

## Observações
* KEY_WEATHER representa a chave do usuário da API externa hgbrasil.
* Mzap Api que será usada futuramente para envio de mensagem no momento em testes  no presente projeto
