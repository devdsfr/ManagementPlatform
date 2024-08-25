# ManagementPlatform
Este projeto é uma plataforma web para gestão de projetos, clientes e atividades dentro de um ambiente de desenvolvimento de software
# Funcionalidades
Gestão de Clientes: Adicione, edite e exclua clientes.
Gestão de Projetos: Crie e gerencie projetos, associe-os a clientes e acompanhe seus status.
Acompanhamento de Atividades: Associe atividades a projetos e clientes, gerencie seus cronogramas e acompanhe o progresso.
Interface Responsiva: O front-end é desenvolvido em Angular, oferecendo uma interface de usuário limpa e responsiva.
API RESTful: O back-end é desenvolvido em Java e Spring Boot, expondo uma API RESTful para interação com o front-end.
Integração com Banco de Dados: Armazenamento persistente usando PostgreSQL com Hibernate ORM.
Deploy: Hospedado no Heroku com deploy contínuo a partir do GitHub.

# Endpoints da API
### Clientes
GET /api/clients - Obter a lista de todos os clientes.
![img_1.png](img_1.png)
POST /api/clients - Criar um novo cliente.
![img.png](img.png)
GET /api/clients/{id} - Obter um cliente específico por ID.
![img_9.png](img_9.png)
PUT /api/clients/{id} - Atualizar um cliente por ID.
![img_12.png](img_12.png)
DELETE /api/clients/{id} - Excluir um cliente por ID.
![img_2.png](img_2.png)
### Projetos
GET /api/projects - Obter a lista de todos os projetos.
![img_4.png](img_4.png)
POST /api/projects - Criar um novo projeto.
![img_3.png](img_3.png)
GET /api/projects/{id} - Obter um projeto específico por ID.
![img_11.png](img_11.png)
PUT /api/projects/{id} - Atualizar um projeto por ID.
![img_13.png](img_13.png)
DELETE /api/projects/{id} - Excluir um projeto por ID.
![img_5.png](img_5.png)
### Atividades
GET /api/activities - Obter a lista de todas as atividades.
![img_7.png](img_7.png)
POST /api/activities - Criar uma nova atividade.
![img_6.png](img_6.png)
GET /api/activities/{id} - Obter uma atividade específica por ID.
![img_10.png](img_10.png)
PUT /api/activities/{id} - Atualizar uma atividade por ID.
![img_14.png](img_14.png)
DELETE /api/activities/{id} - Excluir uma atividade por ID.
![img_8.png](img_8.png)
 Link do Postman dos endpoints https://documenter.getpostman.com/view/11387908/2sAXjF9v78