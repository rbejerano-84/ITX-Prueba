package pricing.application.usecase;

import org.jmolecules.ddd.annotation.ValueObject;
import java.time.LocalDateTime;

@ValueObject
public record GetApplicablePriceCommand(
        Long productId,
        Long brandId,
        LocalDateTime applicationDate
) {
    public GetApplicablePriceCommand {
        if (productId == null) throw new IllegalArgumentException("productId no puede ser null");
        if (brandId == null) throw new IllegalArgumentException("brandId no puede ser null");
        if (applicationDate == null) throw new IllegalArgumentException("applicationDate no puede ser null");
    }
}
