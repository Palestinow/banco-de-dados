🎓 TEMA DO TCC:
Sistema Web para Gestão de Adoção de Animais de ONGs Locais

1. INTRODUÇÃO
O abandono de animais tem aumentado de forma alarmante no Brasil, exigindo das organizações não governamentais (ONGs) um esforço constante para acolher e encontrar novos lares para cães e gatos. Muitas dessas instituições atuam de forma voluntária, com recursos limitados e sem ferramentas tecnológicas que facilitem a divulgação, o controle de adoções e o cadastro dos animais. A ausência de um sistema estruturado compromete a eficiência do processo e dificulta o contato com potenciais adotantes.

Este trabalho propõe o desenvolvimento de uma solução tecnológica que permita às ONGs realizar a gestão completa dos animais disponíveis para adoção e facilitar a comunicação com interessados, por meio de uma plataforma web intuitiva e responsiva. O sistema será dividido em módulos para administradores (ONGs) e adotantes.

De acordo com Pressman (2016), soluções tecnológicas são fundamentais para apoiar serviços sociais, promovendo automação, inovação e melhor comunicação entre entidades e a população. Assim, esta proposta busca aliar tecnologia à causa animal, gerando impacto social positivo, com potencial de expansão para outras regiões.

1.1 JUSTIFICATIVA
A alta demanda por adoção, aliada à escassez de recursos tecnológicos nas ONGs, evidencia a necessidade de um sistema informatizado que otimize o processo de adoção de animais. A desorganização e a ausência de controle centralizado podem resultar na perda de dados importantes, falhas na comunicação e redução nas taxas de adoção.

Com uma solução digital, será possível centralizar informações, agilizar atendimentos e aumentar as chances de adoção. Além disso, o sistema poderá gerar relatórios, promover transparência e facilitar parcerias com clínicas veterinárias, pet shops e voluntários. O projeto tem como objetivo transformar uma realidade desorganizada em um fluxo funcional, impactando positivamente a vida de animais e pessoas.

1.2 OBJETIVOS
1.2.1 Objetivo Geral
Desenvolver um sistema web responsivo para auxiliar ONGs no cadastro, gerenciamento e processo de adoção de animais.

1.2.2 Objetivos Específicos
• Criar um painel administrativo para cadastro e gestão de animais pela ONG;
• Desenvolver um portal público para visualização e filtragem dos animais disponíveis;
• Implementar um sistema de contato entre adotantes e ONGs, com notificações e registro de interesse;
• Gerar relatórios com dados sobre adoções realizadas;
• Garantir responsividade do sistema para dispositivos móveis.

2. ESPECIFICAÇÃO TÉCNICA
O projeto será desenvolvido em equipe, com duração estimada de dois meses. Utilizará metodologia ágil, com sprints semanais para entrega de funcionalidades incrementais. A aplicação será baseada em tecnologias web modernas, visando facilidade de manutenção e rápida implementação. Inicialmente, será hospedada em ambiente local, com posterior migração para servidor gratuito ou de baixo custo.

2.1 TECNOLOGIAS
2.1.1 ReactJS
Biblioteca JavaScript para construção de interfaces. Segundo a documentação oficial (Meta, 2024), permite criar interfaces reativas e componentizadas, favorecendo o desenvolvimento ágil e modular. Será usada no front-end.

2.1.2 Node.js + Express
Node.js permite a execução de JavaScript no servidor, enquanto Express é um framework leve para criação de APIs REST. Juntos, serão utilizados no back-end do sistema, garantindo agilidade nas requisições e integração com o banco de dados.

2.1.3 MongoDB
Banco de dados NoSQL que armazena dados em documentos flexíveis. Ideal para aplicações web por sua escalabilidade e facilidade de modelagem. Será utilizado para armazenar dados de usuários, animais e registros de adoção.

2.1.4 Figma
Ferramenta de design colaborativo, usada na criação de protótipos e definição das telas da aplicação antes do desenvolvimento.

2.2 ESPECIFICAÇÃO E MODELAGEM
Nº	Requisito	Descrição
RF01	Cadastro de animais	Permitir à ONG cadastrar nome, espécie, raça, idade e fotos dos animais
RF02	Visualização pública dos animais	Permitir que visitantes filtrem e visualizem animais disponíveis
RF03	Cadastro de interesse	Interessados poderão preencher formulário para manifestar interesse
RF04	Login administrativo	Autenticação restrita para acesso da ONG
RF05	Geração de relatórios	Permitir geração de relatórios de adoções realizadas
RNF01	Interface responsiva	O sistema deverá funcionar bem em celulares e tablets
RNF02	Armazenamento seguro	Garantir segurança e autenticação nos dados armazenados

# Trello
Este é o link do Trello criado para gerenciamento do projeto de desenvolvimento do sistema web para adoção de animais. Através deste quadro, a equipe e o orientador poderão acompanhar o andamento das tarefas, as funcionalidades em desenvolvimento, os testes realizados e o que já foi concluído ao longo das sprints:

https://trello.com/b/E5HhxM0O/sistema-web-para-gestao-de-adocao-de-animais-de-ongs-locais

# Figma
O Figma será utilizado para criar os protótipos das telas do sistema antes do início da programação. É uma ferramenta online e colaborativa que permite criar wireframes e simular a navegação pelo sistema, ajudando na validação das ideias com usuários e facilitando a comunicação visual dentro da equipe:

https://www.figma.com/design/PQET6VBNiYPZNBpOJUhll6/Site-Projeto---Design-de-Software?node-id=2-450&t=aLmXxFOUikFXvzKO-1
