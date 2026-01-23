package pricing.domain.repository;

import pricing.domain.model.Price;
import pricing.domain.model.ProductId;
import pricing.domain.model.BrandId;

import java.util.List;

/**
 * Repositorio de precios: abstrae la persistencia de Price.
 */
public interface PriceRepository {

    /**
     * Devuelve todos los precios para un producto y marca dados.
     *
     * @param productId id del producto
     * @param brandId id de la marca
     * @return lista de precios
     */
    List<Price> findByProductAndBrand(ProductId productId, BrandId brandId);
}
