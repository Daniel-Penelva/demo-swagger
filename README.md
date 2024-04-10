# Documentação dos Scripts com Swagger

### 1. **Swagger UI Access:**
   - Acesse o Swagger UI em [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html) para interagir com os endpoints.

### 2. **Dependência no arquivo pom.xml:**
   ```xml
   <dependency>
       <groupId>org.springdoc</groupId>
       <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
       <version>2.0.2</version>
   </dependency>
   ```

### 3. **Classe Employee:**
   - A classe `Employee` define os atributos de um funcionário, como ID, nome, cargo e salário.

### 4. **Classe EmployeeController:**
   - `EmployeeController` contém métodos para manipular os dados dos funcionários.
     - **Buscar todos empregados:**
       - Método: GET
       - Endpoint: `/employees`
       - Descrição: Retorna a lista de todos os funcionários.
     - **Realiza cadastro de empregado:**
       - Método: POST
       - Endpoint: `/employees`
       - Descrição: Adiciona um novo funcionário à lista.
     - **Deleta cadastro de empregado:**
       - Método: DELETE
       - Endpoint: `/{id}`
       - Descrição: Remove um funcionário com base no ID fornecido.

### 5. **Classe DemoSwaggerApplication:**
   - `DemoSwaggerApplication` é a classe principal que inicia a aplicação Spring Boot.
   - **Informações da API:**
     - Título: Employees API
     - Versão: 2.0
     - Descrição: Informações sobre os funcionários.

--- 

# Autor
## Feito por: `Daniel Penelva de Andrade`

