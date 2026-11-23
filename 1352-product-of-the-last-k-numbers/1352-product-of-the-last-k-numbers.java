import java.util.ArrayList;
import java.util.List;

class ProductOfNumbers {
    // Class-level variable (state) that persists across all method calls
    private List<Integer> prefixProducts;

    // 1. Constructor: Runs once when LeetCode initializes the object
    public ProductOfNumbers() {
        prefixProducts = new ArrayList<>();
        // Add a dummy '1' at index 0 to make division math clean
        prefixProducts.add(1);
    }
    
    // 2. Method called whenever a new number arrives in the stream
    public void add(int num) {
        if (num == 0) {
            // If 0 arrives, all previous prefix products become useless (since anything * 0 = 0).
            // Reset the list back to the initial state!
            prefixProducts.clear();
            prefixProducts.add(1);
        } else {
            // Multiply the new number with the last stored prefix product
            int lastProduct = prefixProducts.get(prefixProducts.size() - 1);
            prefixProducts.add(lastProduct * num);
        }
    }
    
    // 3. Method called whenever a query asks for the product of the last k numbers
    public int getProduct(int k) {
        int size = prefixProducts.size();
        
        // If k is greater than or equal to size, a '0' occurred within the last k elements
        // (which caused a reset earlier), so the product is guaranteed to be 0.
        if (k >= size) {
            return 0;
        }
        
        // Divide the total running product by the product right before the last k elements
        int totalProduct = prefixProducts.get(size - 1);
        int productBeforeK = prefixProducts.get(size - 1 - k);
        
        return totalProduct / productBeforeK;
    }
}