package snowballclass.cart.domain;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    private Long lessonId;

    private LocalDate createdAt = LocalDate.now();

    private Boolean deleted = false;

    private LocalDate deletedAt = null;

    public Item(Cart cart, Long lessonId) {
        this.cart = cart;
        this.lessonId = lessonId;
        this.createdAt = LocalDate.now();
        this.deleted = false;
        this.deletedAt = null;
    }

    static public Item create(Cart cart, Long lessonId) {
        return new Item(cart,lessonId);
    }
}
