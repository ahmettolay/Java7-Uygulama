import entity.Category;
import entity.Product;
import service.ProductService;

public class Main {
    public static void main(String[] args) {
        ProductService productService = new ProductService();
        //productService.getAllProducts();
        Product product1 = new Product(15, new Category(1, null), "eliaaaaa ", 200, "pilliiii");
        // productService.insert(product1);
        // productService.update(product1);
        productService.productDelete(15);
    }
}