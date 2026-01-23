package pricing.domain.service;

import org.springframework.stereotype.Service;
import pricing.domain.model.Price;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * Domain Service: contiene la lógica para seleccionar el precio aplicable según prioridad y validez.
 */
@Service
public class PricePolicy {

    /**
     * Selecciona el precio aplicable de una lista según prioridad y validez.
     *
     * @param prices lista de precios candidatos
     * @param date fecha de consulta
     * @return el precio aplicable, o empty si no hay ninguno válido
     */
    public Optional<Price> selectApplicablePrice(List<Price> prices, LocalDateTime date) {
        return prices.stream()
                .filter(p -> p.isValidFor(date))
                .max(Comparator.comparingInt(Price::priority)); // record getter
    }
}
