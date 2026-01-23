package pricing.domain.model;

import org.jmolecules.ddd.annotation.ValueObject;

/**
 * Value Object: identifica una marca de forma única.
 */
@ValueObject
public record BrandId(Long id) {
    public BrandId {
        if (id == null) throw new IllegalArgumentException("BrandId no puede ser null");
    }
}
