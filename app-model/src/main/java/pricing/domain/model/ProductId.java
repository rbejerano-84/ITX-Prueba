package pricing.domain.model;

import org.jmolecules.ddd.annotation.ValueObject;

/**
 * Value Object: identifica un producto de forma única.
 */
@ValueObject
public record ProductId(Long id) {
    public ProductId {
        if (id == null) throw new IllegalArgumentException("ProductId no puede ser null");
    }
}
