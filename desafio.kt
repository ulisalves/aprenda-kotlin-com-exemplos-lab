enum class Nivel { FUNDAMENTAL, MEDIO, SUPERIOR }

data class Usuario (val nome: String, val nivel: Nivel)

data class ConteudoEducacional(val nome: String, val duracao: Int)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos: MutableList<Usuario> = mutableListOf(Usuario("Ulisses Alves",Nivel.SUPERIOR),
                                                          Usuario("Luke Skywalker",Nivel.MEDIO),
                                                          Usuario("Anakin",Nivel.FUNDAMENTAL)
   		                                                 )
        
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }

    fun getInscritos() {
        this.inscritos.forEach {(key, value) -> println("Nome: $key - Nivel: $value") }
    }
    
    operator fun iterator(): Iterator<ConteudoEducacional>{
        return conteudos.iterator()
	}
}

fun main() {
    
    val formacao = Formacao("Frontend Developer",
                            listOf(ConteudoEducacional("HTML", 12), 
                                   ConteudoEducacional("CSS", 10), 
                                   ConteudoEducacional("Javascript", 20)))
    println ("Nome do curso: ${formacao.nome}")
    for (trilha in formacao)
    println ("A trilha ${trilha.nome} tem duração de ${trilha.duracao} h")
    
    val usuario = Usuario("Mestre Yoda",Nivel.SUPERIOR)
	formacao.matricular(usuario)
    
    println("A turma tem os alunos: ")
   formacao.getInscritos()
}