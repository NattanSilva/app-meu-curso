package br.com.educatech.meucurso

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import br.com.educatech.meucurso.databinding.ActivityDetalhesDisciplinaBinding

/**
 * Tela única e dinâmica que exibe os detalhes de qualquer disciplina.
 *
 * A disciplina exibida é definida pelo nome recebido via extra do [Intent],
 * o que mantém uma única tela para todo o catálogo (sem uma Activity por disciplina).
 */
class DetalhesDisciplinaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetalhesDisciplinaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // ViewBinding: evita o findViewById e dá acesso tipado às Views.
        binding = ActivityDetalhesDisciplinaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        WindowCompat.getInsetsController(window, window.decorView).apply {
            systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_BARS_BY_SWIPE
            hide(WindowInsetsCompat.Type.statusBars())
        }

        // Recupera o nome da disciplina enviado pela DisciplinasActivity via putExtra().
        val nomeDisciplina = intent.getStringExtra(Disciplina.EXTRA_DISCIPLINA)
            ?: return

        // Busca os dados completos no catálogo central a partir do nome recebido.
        val disciplina = Disciplina.porNome(nomeDisciplina)

        if (disciplina == null) {
            Toast.makeText(this, getString(R.string.erro_disciplina), Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        populaTela(disciplina)
        configuraBotoes(disciplina)
    }

    /** Preenche dinamicamente todos os campos da tela com os dados da disciplina. */
    private fun populaTela(disciplina: Disciplina) {
        binding.imgIconeDisciplina.setImageResource(disciplina.icone)
        binding.vwCirculoIcone.backgroundTintList = ContextCompat.getColorStateList(this, disciplina.cor)
        binding.txtNomeDisciplina.text = disciplina.nome
        binding.txtCargaHoraria.text = disciplina.cargaHoraria
        binding.txtModalidade.text = disciplina.modalidade
        binding.txtDescricao.text = disciplina.descricao
        binding.txtProfessor.text = disciplina.professor
        binding.txtNivel.text = disciplina.nivel
        binding.txtSemestre.text = disciplina.semestre
    }

    /** Configura os listeners dos botões da tela. */
    private fun configuraBotoes(disciplina: Disciplina) {
        // Compartilha os detalhes via Intent implícita (ACTION_SEND).
        binding.btnCompartilhar.setOnClickListener {
            compartilharDetalhes(disciplina)
        }

        // Navega diretamente para a HomeActivity, limpando a pilha até ela.
        binding.btnIrHome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP
            }
            startActivity(intent)
        }

        // Encerra esta Activity e retorna à tela anterior (DisciplinasActivity).
        binding.btnVoltar.setOnClickListener {
            finish()
        }
    }

    /** Dispara uma Intent implícita do tipo ACTION_SEND com os dados da disciplina. */
    private fun compartilharDetalhes(disciplina: Disciplina) {
        val texto =
            "${disciplina.nome}\n\n" +
                "Carga Horária: ${disciplina.cargaHoraria}\n" +
                "Modalidade: ${disciplina.modalidade}\n" +
                "Professor: ${disciplina.professor}\n" +
                "Nível: ${disciplina.nivel}\n" +
                "Semestre: ${disciplina.semestre}\n\n" +
                disciplina.descricao

        val intent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_SUBJECT, getString(R.string.share_subject))
            putExtra(Intent.EXTRA_TEXT, texto)
        }
        startActivity(Intent.createChooser(intent, getString(R.string.btn_compartilhar)))
    }
}