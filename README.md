# Omnichat

Este repositório contém o código-fonte do Omnichat, uma aplicação de chat que utiliza Java com Spring Boot no backend e React no frontend. A persistência de dados é feita através do MongoDB. O envio de dados para o cliente web é realizado usando Server-Sent Events (SSE), e tailable cursors do MongoDB são utilizados para essa finalidade.

## Estrutura do Repositório

```omnichat/
├── backend/ # Código-fonte do backend em Java com Spring Boot
└── frontend/ # Código-fonte do frontend em React
```

## Pré-requisitos

- Docker: Certifique-se de ter o Docker instalado na sua máquina.

## Como Executar

1. Clone este repositório para a sua máquina:

```bash
git clone https://github.com/rafaelc-teixeira/OmniChat.git
cd omnichat
```

2. Execute o seguinte comando para subir o container do MongoDB:
```bash
docker run -d --name mongodb-container -p 27017:27017 mongo:latest
```

3. No diretório `backend`, execute o seguinte comando para subir a aplicação do backend:
```bash
./gradlew bootRun
```

4. No diretório `frontend`, execute o seguinte comando para subir a aplicação do frontend:
```bash
npm install
npm start
```

5. Acesse a aplicação através do endereço `http://localhost:3000/`.

## Tecnologias Utilizadas
- Backend: Java, Spring Boot, MongoDB, Server-Sent Events
- Frontend: React