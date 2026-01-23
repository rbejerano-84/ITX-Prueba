package pricing.domain.model;

import java.time.LocalDateTime;
import org.jmolecules.ddd.annotation.ValueObject;

/**
 * Value Object: rango de fechas en que un precio es válido.
 */
@ValueObject
public record PriceValidity(LocalDateTime startDate, LocalDateTime endDate) {
    public PriceValidity {
        if (startDate == null || endDate == null || startDate.isAfter(endDate))
            throw new IllegalArgumentException("Rango de fechas inválido");
    }

    public boolean isValid(LocalDateTime date) {
        return (date.isEqual(startDate) || date.isAfter(startDate)) &&
                (date.isEqual(endDate) || date.isBefore(endDate));
    }
}
