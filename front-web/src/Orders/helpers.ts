import { Product } from "./types";

export function chekIsSelected(selectedProducts: Product[], product: Product) {
    return selectedProducts.some(item => item.id === product.id);
}

export function formatPrice(price:number) {
    const formatter = new Intl.NumberFormat("pt-BR", {
        style:"currency", //currency moeda
        currency:"BRL", //qual tipo da moeda
        minimumFractionDigits:2
    });
    
    return formatter.format(price)
}