package es.neesis.annotations.applications;

import org.springframework.stereotype.Component;
import es.neesis.annotations.services.IAhorcado;

@Component
public class ConstructorApplication {

        private final IAhorcado ahorcado;

        public ConstructorApplication(IAhorcado ahorcado) {
            this.ahorcado = ahorcado;
        }

        public void menu() {
            ahorcado.menu();
        }
}
