package finki.ukim.mk.agroberza.model;



import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity(name = "naracka")

public class Naracka implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long orderedByUserId;
    private Long orderToUserId;
    private boolean accepted=false;
    private boolean rejected= false;

    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "naracka_product",
//        joinColumns = {@JoinColumn(name = "naracka_id")},
//        inverseJoinColumns = {@JoinColumn(name = "product_id")})
    private List<Product> products = new ArrayList<>();

    public void addProductToOrder(Product product) {
        this.products.add(product);
    }

    public void addProductsToOrder(List<Product> products) {
        for (Product p : products) {
            this.products.add(p);
        }
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setOrderedByUserId(Long orderedByUserId) {
        this.orderedByUserId = orderedByUserId;
    }

    public void setOrderToUserId(Long orderToUserId) {
        this.orderToUserId = orderToUserId;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public void setRejected(boolean rejected) {
        this.rejected = rejected;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Naracka() {
    }

    public Long getId() {
        return id;
    }

    public Long getOrderedByUserId() {
        return orderedByUserId;
    }

    public Long getOrderToUserId() {
        return orderToUserId;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public boolean isRejected() {
        return rejected;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void removeAllProductsFromOrder() {
        this.products.clear();
    }

    public Naracka(Long orderedByUserId, Long orderToUserId) {
        this.orderedByUserId = orderedByUserId;
        this.orderToUserId = orderToUserId;
    }
    public boolean getAccepted(){
        return this.accepted;
    }
    public boolean getRejected(){
        return this.rejected;
    }

}
