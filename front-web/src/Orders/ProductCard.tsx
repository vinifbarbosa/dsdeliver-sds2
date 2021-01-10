import { formatPrice } from "./helpers";
import { Product } from "./types";

type Props = {
    product: Product;
    onSelectProduct:(product:Product) => void; //usada la em product list
    isSelected:boolean;
}

// Colocar o price na moeda real



function ProductCard({ product, onSelectProduct, isSelected}: Props) {
    return(
           <div
            className={`order-card-container ${isSelected ? 'selected' : ''}`}
            onClick={() =>
                onSelectProduct(product)} //esse clique chamou uma função, que é uma prop la em cima
            >
              <h3 className="order-card-title">
                 {product.name}
              </h3>
              <img
               src={product.imageUri}
                className="order-card-image"
                alt={product.name}
                />
              <h3 className="order-card-price">
                 {formatPrice(product.price)}
              </h3>
              <div className="order-card-description">
                  Descrição
                  <p>
                 {product.description}
                  </p>
              </div>
        </div>
    )
}

export default ProductCard;