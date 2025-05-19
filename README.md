# 🙏 Ekklesia

**Ekklesia** é uma plataforma moderna e extensível para **gestão de membros, visitantes e ministérios de igrejas**, construída com **Kotlin + Spring Boot**, seguindo as melhores práticas de design orientado a domínio (DDD), MVC basicão e escalabilidade.

---

## 🚀 Visão Geral

O **Ekklesia** nasceu com o propósito de facilitar a administração de comunidades cristãs, trazendo controle, organização e insights sobre a vida da igreja, sem abrir mão da simplicidade e clareza.

> “Tudo, porém, seja feito com decência e ordem.” — *1 Coríntios 14:40*

---

## ✨ Funcionalidades

- ✅ Cadastro de **membros** com dados pessoais e cargo ministerial
- ✅ Registro de **visitantes** e propósitos de visita
- ✅ Sistema de **papéis ministeriais** (pastores, diáconos, missionários, etc)
- ✅ Camada de **DTOs** e **services** bem definidas
- ✅ Banco de dados relacional com JPA/Hibernate
- ✅ Seeds automáticas com cargos pré-definidos
- ✅ Estrutura extensível para novos módulos como eventos, cultos, escalas e departamentos

---

## 🛠️ Tecnologias e Arquitetura

| Camada       | Tecnologia                     |
|--------------|--------------------------------|
| Linguagem    | Kotlin                         |
| Framework    | Spring Boot                    |
| ORM          | Hibernate / JPA                |
| Banco        | MySQL                          |
| Testes       | JUnit / Mockito                |
| Build Tool   | Gradle                         |
| Padrões      | DTO, Service, Repository       |

---

## 🧱 Estrutura do Projeto

```
ekklesia/
├── controller/         # Camada REST
├── dto/                # Data Transfer Objects
├── exception/          # Tratamento de erros
├── model/              # Entidades JPA
├── repository/         # Interfaces de persistência
├── service/            # Lógica de negócios (interfaces)
├── service/impl        # Lógica de negócios (implementações)
├── seed/               # Seeders automáticos
└── config/             # Configurações gerais
```

---

## 🌱 Seed inicial

A aplicação inclui um **Seeder automático** que popula a tabela de cargos (`MemberRole`) com:

- Pastor
- Evangelista
- Presbítero
- Missionário
- Líder de Ministério
- Membro

Esses papéis podem ser facilmente referenciados por ID nas telas administrativas.

---

## 🐳 Como rodar localmente

```bash
# 1. Clone o projeto
git clone https://github.com/seu-usuario/ekklesia.git
cd ekklesia

# 2. Suba os containers
sudo docker compose up
```

---

## 🧩 Próximos passos

- [ ] Autenticação e Autorização (Spring Security + JWT)
- [ ] Dashboard com estatísticas
- [ ] Integração com serviços de envio de email e WhatsApp
- [ ] API pública para apps mobile

---

## 🙌 Contribuição

Contribuições são bem-vindas! Basta abrir uma issue ou enviar um pull request com melhorias.

---

## 📜 Licença

Este projeto está licenciado sob a [MIT License](LICENSE).

---

## ✝️ Sobre o nome

> **Ekklesia** é uma palavra grega usada no Novo Testamento que significa “assembleia” ou “igreja”. Representa a comunidade de crentes reunida em nome de Cristo.

---

## 📬 Contato

Desenvolvido com fé por **João Jacinto de Souza Neto**  
📧 joaonetotfm@gmail.com  
🔗 [linkedin.com/in/joaojacintoneto](https://www.linkedin.com/in/joaojacintoneto/)
