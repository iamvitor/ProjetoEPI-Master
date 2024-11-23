Definição de requisitos de sistema

RF01 - Recurso para manter cadastro de usuários

O sistema deverá disponibilizar interface web para consulta e listagem de todos os
usuários cadastrados que devem ser exibidos em uma grid.
A tela de listagem deverá possuir um botão que dará acesso a tela de cadastro de um
registro novo.

Para cada item da grid deverá ser possível acessar através de botão “visualizar”
redirecionando para tela de consulta de dados do usuário selecionado.

Para cada item da grid deverá ser possível acessar através de botão “atualizar”
redirecionando para tela de atualização de dados do usuário selecionado.

Para cada item da grid deverá ser possível acessar através de botão “excluir” realizando
confirmação de exclusão do registro e excluindo registro do banco de dados.
Os campos que devem ser adicionados no cadastro de usuário são:

id: Chave primaria autonomeada de identificação do usuário do sistema.
nome: campo descritivo para armazenar o nome do usuário.

e-mail: campo para informar o e-mail do usuário, que deverá ser utilizado para
realizar login no sistema.

senha: campo para armazenar a senha do usuário, que deverá ser utilizado para
realizar login no sistema.

Regras:

1- O sistema não poderá permitir dois usuários cadastrados com o mesmo e-mail.

2- O sistema não poderá permitir cadastrar um usuário com senha em branco.

3- A senha deve ter no mínimo 5 caracteres.

4- O sistema não poderá permitir cadastrar um usuário senha nome.

5- O usuário não poderá permitir cadastrar um usuário sem e-mail.

-------------------------------------------------------------------------------

RF02 - Recurso para manter cadastro de colaboradores

O sistema deverá disponibilizar interface web para consulta e listagem de todos os
colaboradores cadastrados que devem ser exibidos em uma grid.

A tela de listagem deverá possuir um botão que dará acesso a tela de cadastro de um
registro novo.

Para cada item da grid deverá ser possível acessar através de botão “visualizar”
redirecionando para tela de consulta de dados do colaborador selecionado.

Para cada item da grid deverá ser possível acessar através de botão “atualizar”
redirecionando para tela de atualização de dados do colaborador selecionado.

Para cada item da grid deverá ser possível acessar através de botão “excluir” realizando
confirmação de exclusão do registro e excluindo registro do banco de dados.
Os campos que devem ser adicionados no cadastro de colaboradores são:

id: Chave primaria autonomeada de identificação do colaborador do sistema.

nome: campo descritivo para armazenar o nome do colaborador.

e-mail: campo para informar o e-mail do colaborador.

função: campo para armazenar a função do colaborador na empresa.

nascimento: campo para armazenar a data de nascimento do colaborador.

Regras:

1- O sistema não poderá permitir dois colaboradores cadastrados com o mesmo e-mail.

2- O sistema não poderá permitir cadastrar um colaborador função em branco.

3- O sistema não poderá permitir cadastrar um colaborador com data de nascimento que compute idade maior ou igual a 100 anos.


-------------------------------------------------------------------------------

RF03 - Recurso para manter cadastro de Equipamentos (EPI)

O sistema deverá disponibilizar interface web para consulta e listagem de todos os
equipamentos (EPI) cadastrados que devem ser exibidos em uma grid.

A tela de listagem deverá possuir um botão que dará acesso a tela de cadastro de um
registro novo.

Para cada item da grid deverá ser possível acessar através de botão “visualizar”
redirecionando para tela de consulta de dados do equipamento selecionado.

Para cada item da grid deverá ser possível acessar através de botão “atualizar”
redirecionando para tela de atualização de dados do equipamento selecionado.

Para cada item da grid deverá ser possível acessar através de botão “excluir” realizando
confirmação de exclusão do registro e excluindo registro do banco de dados.

Os campos que devem ser adicionados no cadastro de equipamentos EPI são:

id: Chave primaria autonomeada de identificação do equipamento EPI.

descrição: campo descritivo para armazenar o nome do equipamento.

tipo: campo para informar o tipo do equipamento cadastrado. Exe: “Protetorocular”, “Proteção de cabeça”, “Proteção auricular”, etc.

Regras:

1- O sistema não pode permitir o cadastro de equipamento sem uma descrição.

2- O sistema não pode permitir o cadastro de equipamento sem selecionar o tipo de equipamento.


-------------------------------------------------------------------------------

RF04 - Recurso para manter registro de empréstimo

O sistema deverá disponibilizar interface web para consulta e listagem de todos os
empréstimos cadastrados que devem ser exibidos em uma grid.

A tela de listagem deverá possuir um botão que dará acesso a tela de registro de um
empréstimo novo. No preenchimento do formulário de empréstimo deverá solicitar qual
colaborador está solicitando e qual equipamento está sendo requisitado.

Para cada item da listagem deverá ser possível acessar através de botão “visualizar”,
redirecionando para tela de consulta de dados do empréstimo selecionado.

Para cada item da grid deverá ser possível acessar através de botão “devolução”,
redirecionando para tela de devolução do empréstimo selecionado.

Para cada item da grid deverá ser possível acessar através de botão “excluir” realizando
confirmação de exclusão do registro e excluindo registro do banco de dados.

Os campos que devem ser adicionados no registro de empréstimo de equipamentos EPI são:

id: Chave primaria autonomeada de identificação do registro de empréstimo.

colaborador: Identificação do colaborador que realizou o empréstimo.

equipamento: Identificação do equipamento que foi solicitado.

data: campo que indica a data de empréstimo do equipamento.

devolucao: campo que indica a data de devolução do equipamento.

Regras:

1- O campo colaborador deve ser obrigatório.

2- O campo equipamento deve ser obrigatório.

3- O campo data deve ser preenchido automaticamente com a data atual quando for realizar um registro de empréstimo.

4- O campo devolução deve armazenar a data de devolução e não deve ser preenchido ao realizar um registro de empréstimo.

5- O sistema não deve permitir registar um empréstimo para um código de colaborador sem cadastro.

6- O sistema não deve permitir registrar um empréstimo para um código de equipamento sem cadastro.

7- Na tela de devolução o sistema deverá exibir os dados do empréstimo como ‘somente leitura’ e exibir um botão de ‘confirmar devolução’. Quando esta ação foi realizada o sistema irá atualizar o registro de empréstimo com a data atual finalizando o empréstimo.

8- O sistema não deve permitir a atualização de um empréstimo já registrado, apenas

-------------------------------------------------------------------------------
RF05 - Recurso para manter cadastro de tipo de equipamento (EPI)

O sistema deverá disponibilizar interface web para consulta e listagem de todos os
equipamentos cadastrados que devem ser exibidos em uma grid.

A tela de listagem deverá possuir um botão que dará acesso a tela de cadastro de um
registro novo.

Para cada item da grid deverá ser possível acessar através de botão “visualizar”
redirecionando para tela de consulta de dados de tipo de equipamento selecionado.

Para cada item da grid deverá ser possível acessar através de botão “atualizar”
redirecionando para tela de atualização de dados do tipo de equipamento selecionado.

Para cada item da grid deverá ser possível acessar através de botão “excluir” realizando
confirmação de exclusão do registro e excluindo registro do banco de dados.

Os campos que devem ser adicionados no cadastro de colaboradores são:

id: Chave primaria autonomeada de identificação do tipo de equipamento.

descrição: campo descritivo para detalhar o tipo de equipamento.

Regras:

1- O campo descrição deverá ser obrigatório.


-------------------------------------------------------------------------------

RF06 - Recurso de autenticação e controle de login por sessão

O sistema deverá disponibilizar tela de controle de acesso. 

Esta tela de acesso deverá utilizar a sessão para armazenar o usuário logado e assim validar o acesso sem autorização nas telas do sistema

Caso o usuário tente acessar qualquer recurso do sistema e não esteja logado, o sistema deverá redirecionar o usuário automaticamente para tela de login.


-------------------------------------------------------------------------------

RF07 - Modelo de entidade e relacionamento (MER)
O trabalho deverá conter uma apresentação do modelo de entidade e relacionado da estrutura do sistema criado.

------------------------------------------------------------------------------

RF08 - Recurso de inovação no sistema a critério da equipe

O sistema deverá apresentar uma implementação de inovação no sistema.

Algo que possa ser adicionado na operacionalização que não foi especificada na lista
de requisitos.

**Implementação de coleta de feedback na devolução dos equipamentos, contendo "nome do colaborador, data de devolução, data do emprestimo e o feedback"**
      Objetivo da coleta de feedbacks: Armazenar dados de qualidade do equipamento, durabilidade, entre outras informações para agregar a gestão dos materiais.
