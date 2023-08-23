import java.util.Scanner;

public class DiagnosticoDiabetes {

    public static class PresionSanguinea {
        private int sistolica; // Presión sistólica (por encima)
        private int diastolica; // Presión diastólica (por debajo)

        public PresionSanguinea(int sistolica, int diastolica) {
            this.sistolica = sistolica;
            this.diastolica = diastolica;
        }

        public int getSistolica() {
            return sistolica;
        }

        public void setSistolica(int sistolica) {
            this.sistolica = sistolica;
        }

        public int getDiastolica() {
            return diastolica;
        }

        public void setDiastolica(int diastolica) {
            this.diastolica = diastolica;
        }

        public String Presion() {
            if (sistolica < 90 || diastolica < 60) {
                return "Hipotension";
            } else if (sistolica >= 90 && sistolica <= 120 && diastolica >= 60 && diastolica <= 80) {
                return "Presion Normal";
            } else if (sistolica > 120 && sistolica <= 140 && diastolica > 80 && diastolica <= 90) {
                return "Prehipertension";
            } else {
                return "Hipertension";
            }
        }

        @Override
        public String toString() {
            return "Presion Sistolica: " + sistolica + " mmHg, Presión Diastólica: " + diastolica + " mmHg";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Diagnostico de Diabetes");
        System.out.print("Ingrese su presion arterial sistolica: ");
        int sistolica = scanner.nextInt();
        System.out.print("Ingrese su presion arterial diastolica: ");
        int diastolica = scanner.nextInt();
        System.out.println("Tiene antecedentes familiares de diabetes? (S/N):");
        String antecedentes = scanner.next().toLowerCase();

        // Crear una instancia con los valores ingresados por el usuario
        PresionSanguinea presion = new PresionSanguinea(sistolica, diastolica);

        // Interpretar la presión arterial
        String interpretacion = presion.Presion();
        System.out.println("Interpretacion de la Presion Arterial: " + interpretacion);

        // Verificar si el usuario podría ser diabético
        if ("Hipertension".equals(interpretacion)) {
            System.out.println("Tiene presion arterial alta, lo que podría estar relacionado con la diabetes. Consulte a un medico.");
        } else if ("Hipotension".equals(interpretacion)) {
            System.out.println("Tiene presion arterial baja. Esto no está relacionado con la diabetes, pero es importante para su salud.");
        } else {
            System.out.println("No se encontraron indicaciones claras de diabetes basadas unicamente en la presión arterial.");
        }

        // Evaluar antecedentes familiares
        if (antecedentes.equals("N") && "Hipertensión".equals(interpretacion)) {
            System.out.println("Debido a los antecedentes familiares de diabetes y la presión arterial alta, se recomienda encarecidamente consultar a un médico para una evaluación completa.");
        } else if (antecedentes.equals("S")) {
            System.out.println("Tiene antecedentes familiares de diabetes, lo que aumenta el riesgo. Se recomienda un chequeo médico regular.");
        } else {
            System.out.println("No se encontraron antecedentes familiares de diabetes.");
        }
    }
}