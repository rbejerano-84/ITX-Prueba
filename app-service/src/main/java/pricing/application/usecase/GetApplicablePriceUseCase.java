package pricing.application.usecase;

import pricing.domain.model.Price;
import pricing.domain.model.ProductId;
import pricing.domain.model.BrandId;
import pricing.domain.repository.PriceRepository;
import pricing.domain.service.PricePolicy;
import pricing.domain.exception.PriceNotFoundException;

import java.util.List;

/**
 * Application Service: caso de uso para obtener el precio aplicable.
 */
public class GetApplicablePriceUseCase {

    private final PriceRepository priceRepository;
    private final PricePolicy pricePolicy;

    public GetApplicablePriceUseCase(PriceRepository priceRepository, PricePolicy pricePolicy) {
        this.priceRepository = priceRepository;
        this.pricePolicy = pricePolicy;
    }

    /**
     * Ejecuta el caso de uso: obtiene el precio aplicable.
     */
    public Price execute(GetApplicablePriceCommand command) {
        List<Price> prices = priceRepository.findByProductAndBrand(
                new ProductId(command.productId()),
                new BrandId(command.brandId())
        );

        return pricePolicy.selectApplicablePrice(prices, command.applicationDate())
                .orElseThrow(() -> new PriceNotFoundException("No price found for the given criteria"));
    }
}
