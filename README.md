# Interação com a API OpenAI ChatGPT usando Java

Este projeto apresenta um exemplo de interação com a API OpenAI ChatGPT usando Java. O código permite enviar mensagens para o modelo GPT-3.5 da OpenAI e receber respostas automáticas com base nas mensagens de entrada.

## Pré-requisitos

Antes de começar, verifique se você atende aos seguintes pré-requisitos:

- Tenha uma chave de API válida da OpenAI para autenticar suas solicitações. Você pode obter uma chave de API registrando-se no site da OpenAI.

- Certifique-se de ter o Java JDK e o Apache Maven instalados em sua máquina.

## Configuração do Projeto

Siga as etapas abaixo para configurar e executar o projeto:

1. Clone ou faça o download deste repositório em sua máquina local.

2. Importe o projeto para a sua IDE Java preferida.

3. Abra o arquivo `Main.java` localizado no diretório `src/main/java/org/example/`.

4. Substitua a constante `API_KEY` com sua própria chave de API da OpenAI.

5. Certifique-se de incluir a dependência OkHttp em seu arquivo `pom.xml` se ainda não estiver presente:

```xml
<dependency>
    <groupId>com.squareup.okhttp3</groupId>
    <artifactId>okhttp</artifactId>
    <version>4.9.1</version>
</dependency>
