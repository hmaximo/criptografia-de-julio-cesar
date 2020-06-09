package challenge;

public class CriptografiaCesariana implements Criptografia {

    @Override
    public String criptografar(String texto) {
        //Retorna erro quando o texto é vazio:
        if (texto.isEmpty()) {
            throw new IllegalArgumentException("Erro");
        }
        //converte o texto em minúsculas;
        String todasMinusculas = texto.toLowerCase(); 

        //seleciona letras e criptografa:   
        char[] letraPorLetra = todasMinusculas.toCharArray();
        for (int i = 0; i < letraPorLetra.length; i++) {
            if (letraPorLetra[i] >= 'a' && letraPorLetra[i] <= 'z') { //seleciona somente letras
                char offset = 0; //variável de deslocamento na tabela ASCII
                if (letraPorLetra[i] > ('z' - 3) && letraPorLetra[i] <= 'z') //estabelece deslocamento para as letras maiores
                    offset = 'z' - 'a';
                letraPorLetra[i] = (char) (letraPorLetra[i] + 3 - offset); //cálculo para criptografar
            }
        }
        return new String(letraPorLetra);
    }

    @Override
    public String descriptografar(String texto) {
        //Retorna erro quando o texto é vazio:
        if (texto.isEmpty()) {
            throw new IllegalArgumentException("Erro");
        }
        //converte o texto em minúsculas:        
        String todasMinusculas = texto.toLowerCase();
        
        //seleciona letras e decriptografa:   
        char[] letraPorLetra = todasMinusculas.toCharArray();
        for (int i = 0; i < letraPorLetra.length; i++) {
            if (letraPorLetra[i] >= 'a' && letraPorLetra[i] <= 'z') { //seleciona somente letras
                char offset = 0; //variável de deslocamento na tabela ASCII
                if (letraPorLetra[i] >= ('a') && letraPorLetra[i] < ('a' + 3)) //estabelece deslocamento para as letras menores 
                    offset = 'z' - 'a';
                letraPorLetra[i] = (char) (letraPorLetra[i] - 3 + offset); //cálculo de descriptografia
            }
        }
        return new String(letraPorLetra);
    }    
}
