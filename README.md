# Meu Curso - Aplicativo Android

Aplicativo desenvolvido como exercício prático da Aula 5 de Desenvolvimento Android (Kotlin e Android Studio).

## 📋 Sobre o Projeto

Este aplicativo apresenta um curso de uma instituição de ensino, permitindo navegação entre três telas principais.

## 🎯 Objetivo

Desenvolver um aplicativo Android utilizando Kotlin que demonstre:
- Criação de projeto no Android Studio
- Estrutura de projeto Android
- Recursos (drawable, layout, imagens)
- XML para interfaces
- Transição entre telas (Activities)

## 📱 Telas do Aplicativo

### 1. Tela Home (MainActivity)
- Logo/imagem da instituição
- Nome da instituição
- Nome do curso
- Breve descrição do curso
- Botão "Conheça o curso" → navega para Sobre o Curso
- Botão "Disciplinas" → navega para Disciplinas

### 2. Tela Sobre o Curso (SobreCursoActivity)
- Imagem relacionada ao curso
- Nome do curso
- Duração
- Modalidade
- Descrição detalhada
- Botão "Voltar" → retorna à Home
- Botão "Disciplinas" → navega para Disciplinas

### 3. Tela Disciplinas (DisciplinasActivity)
Lista de pelo menos 6 disciplinas:
- Programação
- Banco de Dados
- Engenharia de Software
- Desenvolvimento Web
- Desenvolvimento Mobile
- Inteligência Artificial
- Botão "Voltar" → retorna à tela anterior

## 🛠️ Tecnologias Utilizadas

- **Linguagem:** Kotlin
- **IDE:** Android Studio
- **UI:** XML Layouts
- **Componentes:** TextView, Button, ImageView
- **Recursos:** res/drawable, res/layout, res/values

## 📦 Estrutura do Projeto

```
app/
├── src/main/
│   ├── java/com/example/meucurso/
│   │   ├── MainActivity.kt           # Tela Home
│   │   ├── SobreCursoActivity.kt     # Tela Sobre o Curso
│   │   └── DisciplinasActivity.kt    # Tela Disciplinas
│   ├── res/
│   │   ├── layout/
│   │   │   ├── activity_main.xml
│   │   │   ├── activity_sobre_curso.xml
│   │   │   └── activity_disciplinas.xml
│   │   ├── drawable/                 # Imagens do app
│   │   └── values/
│   │       ├── strings.xml
│   │       ├── colors.xml
│   │       └── themes.xml
│   └── AndroidManifest.xml
```

## 🔄 Fluxo de Navegação

```
HOME
├── Conheça o curso → SOBRE O CURSO
└── Disciplinas → DISCIPLINAS

SOBRE O CURSO
├── Voltar → HOME
└── Disciplinas → DISCIPLINAS

DISCIPLINAS
└── Voltar → tela anterior
```

## ✅ Requisitos Atendidos

- [x] Projeto Android com Kotlin
- [x] Android Studio
- [x] Interfaces em XML
- [x] Componentes: TextView, Button, ImageView
- [x] Recursos em res/drawable
- [x] 3 telas mínimas
- [x] Navegação entre telas (Intents)
- [x] Eventos de clique em Kotlin
- [x] Layouts diferentes entre telas
- [x] Mínimo 2 imagens diferentes
- [x] Aplicativo testado e funcional

## 🚀 Como Executar

1. Abra o projeto no Android Studio
2. Conecte um dispositivo Android ou inicie um emulador
3. Clique em **Run** (▶️) ou pressione `Shift + F10`
4. O aplicativo será instalado e iniciado no dispositivo

## 👨‍🏫 Informações da Atividade

- **Disciplina:** Desenvolvimento Móvel
- **Aula:** 5 - Kotlin e Android Studio
- **Professor:** Leandro Melo
- **Modalidade:** 100% Prática | IA Permitida