package pricing.domain.model;

import java.math.BigDecimal;
import org.jmolecules.ddd.annotation.ValueObject;

/**
 * Value Object: representa un importe monetario.
 */
@ValueObject
public record Money(BigDecimal amount) {
    public Money {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) < 0)
            throw new IllegalArgumentException("Amount no puede ser null o negativo");
    }
}
