package br.com.escola.repository;

    import br.com.escola.models.Espaco;
import br.com.escola.models.RecursoEducacional;

import java.util.ArrayList;
import java.util.List;

    public final class BancoMemoria {
        private static final List<Espaco> ESPACOS = new ArrayList<>();
        private static final List<RecursoEducacional> RECURSOS = new ArrayList<>();

        private BancoMemoria() {}

        public static void adicionarEspaco(Espaco espaco) {
            ESPACOS.add(espaco);
        }

        public static boolean existeCodigoEspaco(String codigo) {
            return ESPACOS.stream().anyMatch(e -> e.getCodigo().equalsIgnoreCase(codigo));
        }

        public static List<Espaco> listarEspacos() {
            return List.copyOf(ESPACOS);
        }

        public static void adicionarRecurso(RecursoEducacional recurso) {
            RECURSOS.add(recurso);
        }

        public static boolean existePatrimonio(String patrimonio) {
            return RECURSOS.stream().anyMatch(r -> r.getPatrimonio().equalsIgnoreCase(patrimonio));
        }

        public static List<RecursoEducacional> listarRecursos() {
            return List.copyOf(RECURSOS);
        }
}
