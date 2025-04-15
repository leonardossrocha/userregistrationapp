# 📱 User Registration App

Aplicativo Android simples desenvolvido em Java com Room Database para cadastro e listagem de usuários.

## ✨ Funcionalidades

- Cadastro de usuário com os seguintes campos:
  - Nome completo
  - CPF
  - E-mail
  - Telefone

- Validação básica de CPF e E-mail
- Listagem de usuários cadastrados
- Navegação entre telas (cadastro e relatório)
- Armazenamento local com **Room Database**
- Interface simples e intuitiva

## 🛠️ Tecnologias e Bibliotecas Utilizadas

- **Java**
- **Android Studio**
- **Room Persistence Library** (para persistência de dados)
- **Componentes do Android Jetpack** (`Room`, `Dao`, `Entity`)
- **Material Design** para UI básica

## 📁 Estrutura de Pastas e Arquivos

```plaintext
├── com.rocha.userregistrationapp/
│   ├── MainActivity.java                 # Tela de cadastro de usuário
│   ├── ReportActivity.java               # Tela de listagem de usuários
│   ├── User.java                         # Classe Entity representando a tabela User
│   ├── UserDao.java                      # Interface com métodos de acesso ao banco
│   ├── UserDatabase.java                 # Classe responsável por instanciar o banco de dados
│
├── res/
│   ├── layout/
│   │   ├── activity_main.xml             # Layout da tela de cadastro
│   │   └── activity_report.xml           # Layout da tela de relatório
│   └── values/
│       └── strings.xml, colors.xml, etc. # Arquivos de recursos

