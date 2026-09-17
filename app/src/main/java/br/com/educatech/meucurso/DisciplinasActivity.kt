package br.com.educatech.meucurso

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import br.com.educatech.meucurso.databinding.ActivityDisciplinasBinding

/**
 * Tela que lista as disciplinas do curso como cards clicáveis.
 *
 * Cada card abre a [DetalhesDisciplinaActivity] enviando o nome da disciplina
 * selecionada como extra do [Intent].
 */
class DisciplinasActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDisciplinasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ViewBinding: evita o findViewById e dá acesso tipado às Views.
        binding = ActivityDisciplinasBinding.inflate(layoutInflater)
        setContentView(binding.root)

        WindowCompat.getInsetsController(window, window.decorView).apply {
            systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_BARS_BY_SWIPE
            hide(WindowInsetsCompat.Type.statusBars())
        }

        // Torna cada card clicável e abre os detalhes da disciplina correspondente.
        binding.cardProgramacao.setOnClickListener { abrirDetalhes(Disciplina.catalog[0]) }
        binding.cardBanco.setOnClickListener { abrirDetalhes(Disciplina.catalog[1]) }
        binding.cardEngSoft.setOnClickListener { abrirDetalhes(Disciplina.catalog[2]) }
        binding.cardWeb.setOnClickListener { abrirDetalhes(Disciplina.catalog[3]) }
        binding.cardMobile.setOnClickListener { abrirDetalhes(Disciplina.catalog[4]) }
        binding.cardIa.setOnClickListener { abrirDetalhes(Disciplina.catalog[5]) }

        binding.btnVoltarTela.setOnClickListener {
            finish()
        }
    }

    /**
     * Cria um [Intent] para a [DetalhesDisciplinaActivity] e anexa o nome da
     * disciplina selecionada através do método putExtra().
     */
    private fun abrirDetalhes(disciplina: Disciplina) {
        // 1) Instancia o Intent indicando a Activity de destino.
        val intent = Intent(this, DetalhesDisciplinaActivity::class.java)

        // 2) Anexa os dados ao Intent com putExtra()
        //    (a chave EXTRA_DISCIPLINA é definida no próprio modelo).
        intent.putExtra(Disciplina.EXTRA_DISCIPLINA, disciplina.nome)

        // 3) Inicia a nova Activity.
        startActivity(intent)
    }
}