# Organizador de Arquivos em Java

Programa de linha de comando que organiza os arquivos de uma pasta, separando-os em subpastas de acordo com a extensão. Antes de mover qualquer coisa, ele mostra uma simulação e pede confirmação.

## Como funciona

1. Pede o caminho da pasta que será organizada.
2. Lê os arquivos da pasta, ignorando subpastas.
3. Ordena os arquivos do maior para o menor.
4. Identifica a extensão de cada arquivo e define sua categoria.
5. Exibe uma **simulação**: para cada arquivo, mostra para qual pasta ele iria.
6. Pede confirmação. Se a resposta for `s`, os arquivos são movidos. Qualquer outra resposta cancela, sem alterar nada.

## Categorias suportadas

| Pasta criada | Extensões |
|---|---|
| Imagem | jpg, jpeg, png |
| PDF | pdf |
| Video | mp4 |
| Audio | mp3, wav |
| Documento | txt |
| Outros | qualquer extensão não listada, ou arquivo sem extensão |

As extensões são reconhecidas sem diferenciar maiúsculas de minúsculas (`.JPG` e `.jpg` são tratados igual).

## Requisitos

- JDK (Java Development Kit) 8 ou superior. Desenvolvido e testado com Java 25.

Para conferir se está instalado:

```
javac -version
java -version
```

## Como rodar

Dentro da pasta onde está o arquivo `Organizador.java`:

```
javac Organizador.java
java Organizador
```

O primeiro comando compila o projeto e o segundo executa o programa.

## Exemplo de uso

```
Digite o caminho absoluto da pasta
C:\videos\Audios
Nome do Arquivo: 192. Unshaken.mp3
Tamanho dos arquivos em MegaBytes: 14,97 MB
==================
Extensão: mp3
=================
Categoria: Audio
========================

arquivo: 192. Unshaken.mp3 será movido para a pasta: Audio
...
Você quer organizar as suas pastas? se sim digite 's'
n
Você escolheu não continuar com o programa.
```

## Segurança

- Nada é movido sem confirmação, e a simulação mostra tudo antes.
- O programa não sobrescreve arquivos: se já existir um arquivo com o mesmo nome na pasta de destino, ele exibe o erro e segue para o próximo.
- Subpastas não são tocadas.

> Recomendação: ao usar pela primeira vez, teste em uma cópia da pasta.

## Limitações conhecidas

- Não organiza subpastas (somente os arquivos do primeiro nível).
- As categorias estão fixas no código.
- Arquivos com nome repetido no destino não são movidos.

## Próximas melhorias

- Tratar nomes repetidos no destino (por exemplo, renomeando o arquivo).
- Permitir categorias personalizadas.
- Opção de desfazer a última organização.

## Autor

Antônio ([ant-mauro-dev](https://github.com/ant-mauro-dev)).