package br.com.educatech.meucurso

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes

/**
 * Modelo que representa uma disciplina do curso.
 *
 * Além dos dados exibidos na tela de detalhes, armazena o ícone e a cor
 * associados a cada disciplina, permitindo que a [DetalhesDisciplinaActivity]
 * seja uma tela única e dinâmica para qualquer disciplina do catálogo.
 */
data class Disciplina(
    val nome: String,
    val cargaHoraria: String,
    val modalidade: String,
    val descricao: String,
    val professor: String,
    val nivel: String,
    val semestre: String,
    @DrawableRes val icone: Int,
    @ColorRes val cor: Int
) {

    companion object {

        /**
         * Chave usada no [android.content.Intent.putExtra] / [android.content.Intent.getStringExtra]
         * para enviar e recuperar o nome da disciplina selecionada.
         */
        const val EXTRA_DISCIPLINA = "extra_disciplina"

        /** Catálogo central com todas as disciplinas do curso. */
        val catalog = listOf(
            Disciplina(
                nome = "Programação",
                cargaHoraria = "80 horas",
                modalidade = "Presencial",
                descricao = "Introdução à lógica de programação e aos fundamentos de algoritmos. " +
                    "Os alunos desenvolvem o raciocínio computacional por meio de exercícios " +
                    "práticos de codificação e de resolução de problemas com pseudocódigo e uma " +
                    "linguagem de programação de alto nível.",
                professor = "Profa. Carla Mendes",
                nivel = "Básico",
                semestre = "1º Semestre",
                icone = R.drawable.ic_programacao,
                cor = R.color.card_programacao
            ),
            Disciplina(
                nome = "Banco de Dados",
                cargaHoraria = "64 horas",
                modalidade = "Presencial",
                descricao = "Modelagem e implementação de bancos de dados relacionais. A disciplina " +
                    "cobre modelagem conceitual, lógica e física, normalização de dados, criação de " +
                    "consultas SQL eficientes e a integração do banco de dados com aplicações.",
                professor = "Prof. Ricardo Souza",
                nivel = "Intermediário",
                semestre = "3º Semestre",
                icone = R.drawable.ic_banco_dados,
                cor = R.color.card_banco
            ),
            Disciplina(
                nome = "Engenharia de Software",
                cargaHoraria = "64 horas",
                modalidade = "Presencial",
                descricao = "Processos, métodos e boas práticas para o desenvolvimento profissional " +
                    "de software. São abordados levantamento de requisitos, arquitetura, testes, " +
                    "versionamento de código e gestão de projetos com metodologias ágeis.",
                professor = "Profa. Juliana Alves",
                nivel = "Avançado",
                semestre = "4º Semestre",
                icone = R.drawable.ic_engenharia_software,
                cor = R.color.card_engsoft
            ),
            Disciplina(
                nome = "Desenvolvimento Web",
                cargaHoraria = "80 horas",
                modalidade = "EAD",
                descricao = "Construção de aplicações web modernas com HTML, CSS e JavaScript, " +
                    "incluindo layout responsivo, consumo de APIs REST e boas práticas de " +
                    "usabilidade, performance e acessibilidade na web.",
                professor = "Prof. Marcos Oliveira",
                nivel = "Intermediário",
                semestre = "2º Semestre",
                icone = R.drawable.ic_web,
                cor = R.color.card_web
            ),
            Disciplina(
                nome = "Desenvolvimento Mobile",
                cargaHoraria = "80 horas",
                modalidade = "EAD",
                descricao = "Desenvolvimento de aplicativos para dispositivos móveis com Kotlin e " +
                    "Android, abordando ciclo de vida de activities, interfaces com Material Design, " +
                    "navegação entre telas, persistência de dados e publicação de aplicativos.",
                professor = "Profa. Ana Beatriz Lima",
                nivel = "Intermediário",
                semestre = "3º Semestre",
                icone = R.drawable.ic_mobile,
                cor = R.color.card_mobile
            ),
            Disciplina(
                nome = "Inteligência Artificial",
                cargaHoraria = "80 horas",
                modalidade = "EAD",
                descricao = "Conceitos fundamentais de inteligência artificial, aprendizado de " +
                    "máquina e redes neurais, com aplicações práticas em visão computacional, " +
                    "processamento de linguagem natural e construção de sistemas inteligentes.",
                professor = "Prof. Felipe Rocha",
                nivel = "Avançado",
                semestre = "6º Semestre",
                icone = R.drawable.ic_ia,
                cor = R.color.card_ia
            )
        )

        /**
         * Busca uma disciplina pelo nome no catálogo.
         * Retorna `null` caso o nome informado não exista.
         */
        fun porNome(nome: String): Disciplina? =
            catalog.firstOrNull { it.nome == nome }
    }
}