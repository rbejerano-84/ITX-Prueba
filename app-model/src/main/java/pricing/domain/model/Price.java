package pricing.domain.model;

import java.time.LocalDateTime;
import org.jmolecules.ddd.annotation.AggregateRoot;

/**
 * Aggregate Root: representa un precio aplicable a un producto y marca.
 */
@AggregateRoot
public record Price(
        Long id,
        ProductId productId,
        BrandId brandId,
        Money price,
        PriceValidity validity,
        int priority
) {
    public boolean isValidFor(LocalDateTime date) {
        return validity.isValid(date);
    }
}
